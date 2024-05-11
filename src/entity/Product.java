package entity;

public class Product implements Comparable<Product> {

    public int id;
    public String name;
    public double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(int nextId) { //этот конструктор сам создался, без него не работает;
                                //и я не очень понимаю, как это все работает
    }

    @Override
    public int compareTo(Product another) {
        return Integer.compare(id, another.id);
    }

    public int id() {
        return id;
    }

    public String name() {
        return name;
    }

    public double price() {
        return price;
    }
}
