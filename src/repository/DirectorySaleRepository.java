package repository;

import entity.Sale;

import java.io.IOException;
import java.util.List;

public class DirectorySaleRepository implements Repository<Sale> {
    @Override
    public void save(Sale obj) throws IOException {

    }

    @Override
    public Sale load(int id) throws IOException {
        return null;
    }

    @Override
    public List<Sale> load(List<Integer> ids) throws IOException {
        return null;
    }
}
