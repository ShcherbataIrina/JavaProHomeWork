package ua.ithillel.bank.lesson38_multithreading_currency;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.ithillel.bank.currency_exchange.CurrencyConverter;

import java.util.Currency;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class PersonOperationsService {

    private final CurrencyConverter currencyConverter;

    public CompletableFuture<Double> convert(Currency from, Currency to, double amount) {
        return CompletableFuture.supplyAsync(() -> currencyConverter.convert(from, to, amount))
                .thenApply(Double::doubleValue);

    }

}
