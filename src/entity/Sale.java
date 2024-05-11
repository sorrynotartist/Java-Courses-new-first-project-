package entity;

import java.util.Iterator;
import java.util.Map;

public class Sale implements Iterable<Product> {
    public int id;
    public double amount;
    public Person person;
    public Map<Product, Double> products;

    public Sale(int id, double amount, Person person, Map<Product, Double> products) {
        this.id = id;
        this.amount = amount;
        this.person = person;
        this.products = products;
    }

    public Sale(int nextId) { //и тут тоже самое, без конструктора не работает
    }

    @Override
    public Iterator<Product> iterator() {
        return new ProductIterator();
    }

    public Map<Product, Double> getProducts() {
        return products;
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