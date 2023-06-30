package ua.ithillel.bank.transaction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ua.ithillel.bank.account.Account;
import ua.ithillel.bank.account.AccountRepository;
import ua.ithillel.bank.person.Person;
import ua.ithillel.bank.person.PersonRepository;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class TransactionControllerIntegrationTest {

    @Autowired
    protected TransactionRepository transactionRepository;

    @Autowired
    protected AccountRepository accountRepository;

    @Autowired
    protected PersonRepository personRepository;

    @Autowired
    protected MockMvc mockMvc;

    private Person person;

    @BeforeEach
    void setUp() {
        person = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name("NameTest")
                .build());

        transactionRepository.deleteAll();
    }

    @Test
    void shouldTransactionBetweenAccounts() throws Exception {

        var account1 = accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .iban("UA9586310000035247896")
                .balance(35476)
                .currency("UAH")
                .person(person)
                .build());

        var account2 = accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .iban("UA320460000095864201")
                .balance(11241)
                .currency("UAH")
                .person(person)
                .build());

        var query = post("/api/transactions")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"from\":\"UA9586310000035247896\",\"to\":\"UA320460000095864201\",\"amount\":{\"value\":10000,\"currency\":\"UAH\"}}");

        mockMvc.perform(query)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.from").value("UA9586310000035247896"))
                .andExpect(jsonPath("$.to").value("UA320460000095864201"))
                .andExpect(jsonPath("$.amount.value").value(10000))
                .andExpect(jsonPath("$.amount.currency").value("UAH"));

        var updatedAccount1 = accountRepository.findByUid(account1.getUid()).orElseThrow();
        var updatedAccount2 = accountRepository.findByUid(account2.getUid()).orElseThrow();

        assertEquals(25476, updatedAccount1.getBalance());
        assertEquals(21241, updatedAccount2.getBalance());
        assertEquals(2, accountRepository.findByPerson(person).size());
        assertEquals(1, transactionRepository.findAll().size());

    }

    @Test
    void shouldGetTransactionByUid() throws Exception {

        Instant createdAt = Instant.parse("2023-06-28T10:30:00Z");

        var transactionTest = transactionRepository.save(Transaction.builder()
                .uid(UUID.randomUUID().toString())
                .fromAccount("UA69583200000210568")
                .toAccount("UA25864700000785912")
                .value(43476)
                .currency("UAH")
                .createdAt(createdAt)
                .build());

        var query = get("/api/transactions/{uid}", transactionTest.getUid());

        mockMvc.perform(query)
                .andExpect(status().isOk());

        assertEquals(43476, transactionTest.getValue());
        assertEquals(1, transactionRepository.findAll().size());

    }
}
