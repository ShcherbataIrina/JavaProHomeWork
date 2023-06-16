package ua.ithillel.bank.currency_exchange;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Currency;
import java.util.Map;

@RestController
@RequestMapping("/currencies")
@RequiredArgsConstructor
public class ApiCurrencyController {

    private final CurrencyConverter currencyConverter;

    @GetMapping("/convert")
    public Object convertCurrency(@RequestParam("from") String fromCurrency,
                                  @RequestParam("to") String toCurrency,
                                  @RequestParam("amount") double amount) {
        Currency from = Currency.getInstance(fromCurrency);
        Currency to = Currency.getInstance(toCurrency);

        return Map.of("value", currencyConverter.convert(from, to, amount));

    }

}