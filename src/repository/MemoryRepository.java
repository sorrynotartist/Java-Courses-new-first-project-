package repository;

import entity.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class MemoryRepository<T> implements Repository<T>{

    Map<Integer, T> storage = new HashMap<>();

    abstract int getId(T obj);

    @Override
    public void save(T obj) throws IOException {
        storage.put(getId(obj), obj);
    }

    @Override
    public T load(int id) throws IOException {
        return storage.get(id);
    }

    @Override
    public List<T> load(List<Integer> ids) throws IOException {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < ids.size(); i++) {
            list.add(load(ids.get(i)));
        }
        return list;
    }
}
