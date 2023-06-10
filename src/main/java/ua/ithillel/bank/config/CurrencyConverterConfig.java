package ua.ithillel.bank.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.ithillel.bank.currency_exchange.CurrencyApiCurrencyConverter;
import ua.ithillel.bank.currency_exchange.CurrencyConverter;
import ua.ithillel.bank.currency_exchange.DummyCurrencyConverter;

@Configuration
public class CurrencyConverterConfig {

    @Configuration
    @ConditionalOnProperty(name = "currency.converter.provider", havingValue = "currecyapi")
    public static class CurrecyapiCurrencyConverterConfiguration {
        @Bean
        public CurrencyConverter currencyConverter(CurrencyProperties currencyProperties) {
            return new CurrencyApiCurrencyConverter(currencyProperties);
        }
    }

    @Configuration
    @ConditionalOnProperty(name = "currency.converter.provider", havingValue = "dummy")
    public static class DummyCurrencyConverterConfiguration {
        @Bean
        public CurrencyConverter currencyConverter() {
            return new DummyCurrencyConverter();
        }
    }

}
