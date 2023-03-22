package ua.ithillel.lesson15;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ListProduct {
    private List<Product> products;

    public ListProduct(List<Product> products) {
        this.products = products;
    }

    public List<Product> bookWithPriceMore250() {
        return products.stream()
                .filter(product -> product.getCategory().equals("Book"))
                .filter(product -> product.getPrice() > 250)
                .toList();

    }

    public List<Product> bookWithDiscount() {
        return products.stream()
                .filter(product -> product.getCategory().equals("Book"))
                .filter(product -> product.isDiscount() == true)
                .map(product -> new Product(product.getCategory(), product.getPrice() * 0.9, product.isDiscount(), product.getCreationDate()))
                .collect(Collectors.toList());

    }

    public Product cheapestBook() {
        return products.stream()
                .filter(product -> product.getCategory().equals("Book"))
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new RuntimeException("Did not find the book!"));

    }

    public List<Product> findLatestAddProducts() {
        return products.stream()
                .sorted(Comparator.comparing(Product::getCreationDate).reversed())
                .limit(3)
                .toList();

    }

    public double calculatorPrice() {
        LocalDate currentDate = LocalDate.now();
        return products.stream()
                .filter(product -> product.getCreationDate().getYear() == currentDate.getYear())
                .filter(product -> product.getCategory().equals("Book"))
                .filter(product -> product.getPrice() < 75)
                .mapToDouble(product -> product.getPrice())
                .sum();

    }

    public Map<String, List<Product>> mapProduct() {
        return products.stream()
                .collect(Collectors.toMap(
                        product -> product.getCategory(),
                        product -> List.of(product),
                        (l1, l2) -> {
                            var list = new ArrayList<>(l1);
                            list.addAll(l2);
                            return list;
                        }
                ));
    }

}
