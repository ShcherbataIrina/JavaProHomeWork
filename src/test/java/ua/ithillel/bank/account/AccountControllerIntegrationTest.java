package ua.ithillel.bank.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ua.ithillel.bank.person.Person;
import ua.ithillel.bank.person.PersonRepository;

import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerIntegrationTest {

    @Autowired
    protected AccountRepository accountRepository;
    @Autowired
    protected PersonRepository personRepository;
    @Autowired
    protected MockMvc mockMvc;
    protected Person person;

    @BeforeEach
    void setup() {
        person = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .build());
    }

    @Test
    void shouldGetAllAccounts() throws Exception {

        accountRepository.deleteAll();

        var account1 = accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .iban("UA2458140000037856932")
                .balance(23651)
                .person(person)
                .build());

        var account2 = accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .iban("UA4258100000144587236")
                .balance(11245)
                .person(person)
                .build());

        var query = get("/api/accounts");

        mockMvc.perform(query)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));

        assertEquals(accountRepository.findByPerson(person).size(), 2);

    }

    @Test
    void shouldGetAccountsByPerson() throws Exception {

        var person2 = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .build());

        var account1 = accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .iban("UA1285496200000320458")
                .balance(25843)
                .person(person)
                .build());

        var account2 = accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .iban("UA96358200000145028635")
                .balance(13859)
                .person(person)
                .build());

        var account3 = accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .iban("UA96358200000145028635")
                .balance(13859)
                .person(person2)
                .build());

        var query = get("/api/persons/{person_id}/accounts", person.getUid());

        mockMvc.perform(query)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));

        assertEquals(accountRepository.findByPerson(person).size(), 2);
        assertEquals(accountRepository.findByPerson(person2).size(), 1);

    }

    @Test
    void shouldCreateAccount() throws Exception {

        var query = post("/api/persons/{person_id}/accounts", person.getUid())
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"iban\":\"UA32567820000042586\",\"balance\":11285}");

        mockMvc.perform(query)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.iban").value("UA32567820000042586"))
                .andExpect(jsonPath("$.balance").value(11285))
                .andExpect(jsonPath("$.personId").isNotEmpty());

        assertEquals(accountRepository.findByPerson(person).size(), 1);
    }


    @Test
    void shouldUpdateAccount() throws Exception {

        var account = accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .iban("UA1285496200000320458")
                .balance(25843)
                .person(person)
                .build());

        var query = put("/api/persons/{person_id}/accounts/{account_id}", String.valueOf(account.getPerson()), account.getUid())
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"balance\":30256}");

        mockMvc.perform(query)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.balance").value(30256))
                .andExpect(jsonPath("$.personId").isNotEmpty());

        assertEquals(accountRepository.findByPerson(person).size(), 1);
    }

    @Test
    void shouldDeleteAccount() throws Exception {

        var account = accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .iban("UA369524700000325438")
                .balance(15742)
                .person(person)
                .build());

        var query = delete("/api/accounts/{account_id}", account.getUid());

        mockMvc.perform(query)
                .andExpect(status().isOk());
    }

}
