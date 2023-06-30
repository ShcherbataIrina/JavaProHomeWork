package ua.ithillel.bank.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TransactionController {
        private final TransactionService transactionService;

        @PostMapping("/transactions")
        public TransactionDto transactionBetweenAccounts(@RequestBody TransactionDto transactionDto) {
            return transactionService.transactionBetweenAccounts(transactionDto);
        }

        @GetMapping("/transactions/{uid}")
        public TransactionDto getTransactionByUid(@PathVariable String uid) {
                return transactionService.getTransactionByUid(uid);
        }
}
