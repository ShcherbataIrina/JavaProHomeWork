package ua.ithillel.bank.currency_exchange;

import org.springframework.web.reactive.function.client.WebClient;
import ua.ithillel.bank.config.CurrencyProperties;

import java.util.Currency;
import java.util.Map;

public class CurrencyApiCurrencyConverter implements CurrencyConverter {

    private final WebClient webClient;
    private final CurrencyProperties props;

    public CurrencyApiCurrencyConverter(CurrencyProperties props) {
        this.props = props;
        this.webClient = WebClient.builder()
                .build();
    }

    @Override
    public double convert(Currency from, Currency to, double amount) {

        var result = webClient.get()
                .uri(props.getUrl(), uri -> uri.queryParam("apikey", props.getApiKey())
                        .queryParam("base_currency", from.getCurrencyCode())
                        .queryParam("currencies", to.getCurrencyCode())
                        .build())
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        System.out.println(result);

        if (result != null && result.containsKey("data")) {
            Map<String, Object> data = (Map<String, Object>) result.get("data");

            if (data.containsKey(to.getCurrencyCode())) {
                Map<String, Object> currencyData = (Map<String, Object>) data.get(to.getCurrencyCode());
                double exchangeRate = (double) currencyData.get("value");

                amount *= exchangeRate;

                System.out.println(amount);
            }
        }
        return amount;
    }

//    public static void main(String[] args) {
//
//        var props = new CurrencyProperties(
//                "https://api.currencyapi.com/v3/latest",
//                "uA77nOa4rMww32mGTTIE421i5XK7Hninkozq6y1Y"
//        );
//
//        Currency from = Currency.getInstance("UAH");
//        Currency to = Currency.getInstance("EUR");
//        double amount = 100.0;
//
//        double convertedAmount = new CurrencyApiCurrencyConverter(props).convert(from, to, amount);
//
//        System.out.println(amount + " UAH is equal to " + convertedAmount + " EUR.");
//    }

}
