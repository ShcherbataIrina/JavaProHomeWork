package ua.ithillel.lesson15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ListProductTest {
    private final List<Product> products = new ArrayList<>();
    private ListProduct actualProducts;

    @BeforeEach
    void setUp() {

        products.add(new Product("Book", 300, true, LocalDate.of(2023, 1, 8)));
        products.add(new Product("Book", 70, false, LocalDate.of(2023, 10, 10)));
        products.add(new Product("Book", 348, false, LocalDate.of(2022, 11, 18)));
        products.add(new Product("Toy", 586, true, LocalDate.of(2023, 2, 13)));
        products.add(new Product("Book", 195, false, LocalDate.of(2021, 8, 20)));
        products.add(new Product("Toy", 247, false, LocalDate.of(2023, 3, 26)));
        products.add(new Product("Toy", 652, true, LocalDate.of(2023, 9, 3)));
        products.add(new Product("Book", 423, true, LocalDate.of(2022, 12, 14)));
        actualProducts = new ListProduct(products);
    }

    @Test
    void shouldBookWithPriceMoreThan250() {

        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(new Product("Book", 300, true, LocalDate.of(2023, 1, 8)));
        expectedProducts.add(new Product("Book", 348, false, LocalDate.of(2022, 11, 18)));
        expectedProducts.add(new Product("Book", 423, true, LocalDate.of(2022, 12, 14)));

        Assertions.assertEquals(expectedProducts, actualProducts.bookWithPriceMore250());

    }

    @Test
    void shouldBookWithDiscount() {
        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(new Product("Book", 300 * 0.9, true, LocalDate.of(2023, 1, 8)));
        expectedProducts.add(new Product("Book", 423 * 0.9, true, LocalDate.of(2022, 12, 14)));

        assertEquals(expectedProducts, actualProducts.bookWithDiscount());
    }

    @Test
    void shouldLatestAddProducts() {
        List<Product> expectProducts = new ArrayList<>();
        expectProducts.add(new Product("Book", 70, false, LocalDate.of(2023, 10, 10)));
        expectProducts.add(new Product("Toy", 652, true, LocalDate.of(2023, 9, 3)));
        expectProducts.add(new Product("Toy", 247, false, LocalDate.of(2023, 3, 26)));

        assertEquals(expectProducts, actualProducts.findLatestAddProducts());
    }

    @Test
    void shouldCheapestBook() {
        Product expectedProduct = new Product("Book", 70, false, LocalDate.of(2023, 10, 10));

        assertEquals(expectedProduct, actualProducts.cheapestBook());
    }


    @Test
    void shouldCalculatorPrice() {
        double expectedSum = 70;
        ListProduct actualSum = new ListProduct(products);
        assertEquals(expectedSum, actualSum.calculatorPrice());
    }

    @Test
    void shouldMapProduct() {
        Map<String, List<Product>> expectMap = Map.of(
                "Book", List.of(
                        new Product("Book", 300, true, LocalDate.of(2023, 1, 8)),
                        new Product("Book", 70, false, LocalDate.of(2023, 10, 10)),
                        new Product("Book", 348, false, LocalDate.of(2022, 11, 18)),
                        new Product("Book", 195, false, LocalDate.of(2021, 8, 20)),
                        new Product("Book", 423, true, LocalDate.of(2022, 12, 14))
                ),
                "Toy", List.of(
                        new Product("Toy", 586, true, LocalDate.of(2023, 2, 13)),
                        new Product("Toy", 247, false, LocalDate.of(2023, 3, 26)),
                        new Product("Toy", 652, true, LocalDate.of(2023, 9, 3))
                )
        );

        assertEquals(expectMap, actualProducts.mapProduct());
    }
}