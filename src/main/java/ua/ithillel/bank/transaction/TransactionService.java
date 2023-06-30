package ua.ithillel.bank.transaction;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.ithillel.bank.account.Account;
import ua.ithillel.bank.account.AccountRepository;
import ua.ithillel.bank.currency_exchange.CurrencyConverter;

import java.time.Instant;
import java.util.Currency;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private final CurrencyConverter currencyConverter;

    @Transactional
    public TransactionDto transactionBetweenAccounts(TransactionDto transactionDto) {
        String fromIban = transactionDto.getFrom();
        String toIban = transactionDto.getTo();
        AmountDto amount = transactionDto.getAmount();

        Account fromAccount = accountRepository.findByIban(fromIban).orElseThrow(() -> new RuntimeException("Account not found: " + fromIban));
        Account toAccount = accountRepository.findByIban(toIban).orElseThrow(() -> new RuntimeException("Account not found: " + toIban));

        Currency from = Currency.getInstance(fromAccount.getCurrency());
        Currency to = Currency.getInstance(toAccount.getCurrency());
        double convertedAmount = amount.getValue();

        if (!fromAccount.getCurrency().equals(amount.getCurrency())) {
            throw new ValidationException("Currency mismatch!");
        }
        if(fromAccount.getCurrency().equals(amount.getCurrency()) && !toAccount.getCurrency().equals(amount.getCurrency())){
            convertedAmount = currencyConverter.convert(from, to, amount.getValue());
        }

        double transferAmount = amount.getValue();
        if (fromAccount.getBalance() < transferAmount) {
            throw new ValidationException("Insufficient balance!");
        }

        fromAccount.setBalance(fromAccount.getBalance() - transferAmount);
        toAccount.setBalance(toAccount.getBalance() + convertedAmount);

        TransactionDto createdTransaction = createTransaction(fromAccount.getIban(), toAccount.getIban(), transferAmount, amount.getCurrency());

        return createdTransaction;
    }

    public TransactionDto createTransaction(String fromAccount, String toAccount, double amount, String currency) {
        Transaction transaction = Transaction.builder()
                .uid(UUID.randomUUID().toString())
                .fromAccount(fromAccount)
                .toAccount(toAccount)
                .value(amount)
                .currency(currency)
                .createdAt(Instant.now())
                .build();

        Transaction newTransaction = transactionRepository.save(transaction);

        return mapTransactionToDto(newTransaction);
    }

    public TransactionDto mapTransactionToDto(Transaction transaction) {
        return TransactionDto.builder()
                .from(transaction.getFromAccount())
                .to(transaction.getToAccount())
                .amount(AmountDto.builder()
                        .value(transaction.getValue())
                        .currency(transaction.getCurrency())
                        .build())
                .createAt(transaction.getCreatedAt())
                .build();
    }

    public TransactionDto getTransactionByUid(String uid){
        Transaction foundTransaction =  transactionRepository.findByUid(uid)
                .orElseThrow(() -> new RuntimeException("Transaction not found with uid = : " + uid));

        return mapTransactionToDto(foundTransaction);
    }

}
