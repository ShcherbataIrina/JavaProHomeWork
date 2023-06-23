package ua.ithillel.bank.account;

import lombok.Builder;

@Builder
public record AccountDto(
        String id,
        String iban,
        double balance,
        String currency,
        Long personId

) {
}
