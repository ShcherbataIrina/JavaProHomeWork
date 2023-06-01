package ua.ithillel.bank.account;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// POST /api/persons/{personId}/accounts/{accountId}

// GET /api/accounts

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/accounts")
    public List<AccountDto> getAllAccounts(Pageable pageable) {
        return accountService.findAllAccounts(pageable);
    }

    @GetMapping("/persons/{person_id}/accounts")
    public List<AccountDto> getAccountsByPerson(@PathVariable("person_id") String personId) {
        return accountService.findAccountByPerson(personId);
    }

    @PostMapping("/persons/{personId}/accounts")
    public AccountDto createAccount(@PathVariable("personId") String personId, @RequestBody AccountDto account) {
        return accountService.create(account, personId);
    }

    @PutMapping("/persons/{person_id}/accounts/{account_id}")
    public AccountDto updateAccount(@PathVariable("account_id") String id, @RequestBody AccountDto account) {
        return accountService.updateAccount(id, account);
    }

    @DeleteMapping("/accounts/{account_id}")
    public void deleteAccount(@PathVariable("account_id") String id) {
        accountService.deleteAccount(id);
    }

}
