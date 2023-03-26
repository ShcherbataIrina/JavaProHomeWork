package ua.ithillel.lesson15;

import java.time.LocalDate;

public record Product(String category, double price, boolean discount, LocalDate creationDate) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && discount == product.discount && category.equals(product.category) && creationDate.equals(product.creationDate);
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
