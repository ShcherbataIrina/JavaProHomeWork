package ua.ithillel.bank.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import ua.ithillel.bank.person.PersonRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final PersonRepository personRepository;

    public List<AccountDto> findAllAccounts(Pageable pageable) {
        return accountRepository.findAll(pageable).stream()
                .map(this::mapAccountToDto)
                .toList();
    }

    public List<AccountDto> findAccountByPerson(String personId) {
     var person =   personRepository.findByUid(personId).orElseThrow();
        return accountRepository.findByPerson(person).stream()
                .map(this::mapAccountToDto)
                .toList();
    }

    public void deleteAccount(String uid) {
        var account = accountRepository.findByUid(uid).orElseThrow();
        accountRepository.delete(account);
    }

    public AccountDto updateAccount(String id, AccountDto account) {
        var accountToUpdate = accountRepository.findByUid(id).orElseThrow();
        accountToUpdate.setBalance(account.balance());
        return mapAccountToDto(accountRepository.save(accountToUpdate));
    }

    public AccountDto create(AccountDto account, String  personId) {
        var person = personRepository.findByUid(personId).orElseThrow();

        var newAccount = accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .iban(account.iban())
                .balance(account.balance())
                .person(person)
                .build());
        return mapAccountToDto(newAccount);
    }

    public AccountDto mapAccountToDto(Account account) {
        return AccountDto.builder()
                .id(account.getUid())
                .iban(account.getIban())
                .balance(account.getBalance())
                .personId(account.getPerson().getId())
                .build();
    }

}
