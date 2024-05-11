package factory;

import entity.Product;

public class ProductEntityFactory<T> extends SimpleEntityFactory<Product> {
    @Override
    public Product create() {
        return new Product(getNextId());
    }
}
