package repository;

import entity.Person;
import entity.Product;
import entity.Sale;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HW_12 {
    public static void main(String[] args) throws IOException {
        Map<Product, Double> products = new HashMap<>();
        products.put(new Product(6660, "name", 5.5), 9.5);

        Sale sale = new Sale(
                123,
                15.00,
                new Person(159, "polina"),
                products
        );
        DirectorySaleRepository repo = new DirectorySaleRepository(DirectorySaleRepository.dir);
        repo.save(sale);
    }
}
