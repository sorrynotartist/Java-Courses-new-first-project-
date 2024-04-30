package repository;

import entity.Product;

import java.io.IOException;
import java.util.List;

public class DirectoryProductRepository implements Repository<Product> {
    @Override
    public void save(Product obj) throws IOException {

    }

    @Override
    public Product load(int id) throws IOException {
        return null;
    }

    @Override
    public List<Product> load(List<Integer> ids) throws IOException {
        return null;
    }
}
