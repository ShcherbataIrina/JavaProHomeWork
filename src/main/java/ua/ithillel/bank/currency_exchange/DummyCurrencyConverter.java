package ua.ithillel.bank.currency_exchange;

import java.util.Currency;

public class DummyCurrencyConverter implements CurrencyConverter {
    @Override
    public double convert(Currency from, Currency to, double amount) {
        System.out.println("Getting exchange rate from dummy");
        return amount;
    }

}
