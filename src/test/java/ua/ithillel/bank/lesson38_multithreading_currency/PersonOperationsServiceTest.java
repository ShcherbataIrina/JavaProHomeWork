package ua.ithillel.bank.lesson38_multithreading_currency;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import ua.ithillel.bank.currency_exchange.CurrencyConverter;

import java.util.Currency;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class PersonOperationsServiceTest {
    private PersonOperationsService personOperationsService;
    @Mock
    private CurrencyConverter mockCurrencyConverter;

    @BeforeEach
    void setUp() {
        mockCurrencyConverter = Mockito.mock(CurrencyConverter.class);
        personOperationsService = new PersonOperationsService(mockCurrencyConverter);
    }

    @Test
    public void shouldConvertSupplyAsyncPersonOperationService() {
        Currency from = Currency.getInstance("USD");
        Currency to = Currency.getInstance("EUR");
        double amount = 100.0;
        double convertRate = 0.25;
        double expectedAmount = amount * convertRate;

        Mockito.when(mockCurrencyConverter.convert(from, to, amount)).thenReturn(expectedAmount);

        log.info("Зробили Mockito для currencyConverter, який при виклику повертає значення expectedAmount:{}", expectedAmount);

        Double actualAmount = null;
        try {
            actualAmount = personOperationsService.convert(from, to, amount).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        log.info("Викликали personOperationsService та зробили try-catch для перевірки на виникнення помилок.");
        log.info("Перевіряємо чи expectedAmount:{} дорівнює actualAmount:{}",expectedAmount, actualAmount);

        assertEquals(expectedAmount, actualAmount);
    }

}
