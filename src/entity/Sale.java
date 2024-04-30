package entity;

import java.util.Iterator;
import java.util.Map;

public class Sale implements Iterable<Product> {

    int id;
    double amount;
    Person person;
    Map<Product, Double> products;

    public Sale(int id, double amount, Person person, Map<Product, Double> products) {
        this.id = id;
        this.amount = amount;
        this.person = person;
        this.products = products;
    }

    @Override
    public Iterator<Product> iterator() {
        return new ProductIterator();
    }

    private static class ProductIterator implements Iterator<Product> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Product next() {
            return null;
        }
    }
}