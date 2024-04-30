package entity;

public class Product implements Comparable<Product> {

    int id;
    String name;
    double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Product another) {
        return Integer.compare(id, another.id);
    }
}
