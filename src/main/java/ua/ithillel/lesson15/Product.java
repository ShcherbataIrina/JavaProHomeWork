package ua.ithillel.lesson15;

import java.time.LocalDate;
import java.util.Objects;

public class Product {
    private String category;
    private double price;
    private boolean discount;
    private LocalDate creationDate;

    public Product(String category, double price, boolean discount, LocalDate creationDate) {
        this.category = category;
        this.price = price;
        this.discount = discount;
        this.creationDate = creationDate;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && discount == product.discount && category.equals(product.category) && creationDate.equals(product.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, price, discount, creationDate);
    }

    @Override
    public String toString() {
        return "Product{" +
                "category='" + category + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", creationDate=" + creationDate +
                '}';
    }
}
