package repository;

import entity.Person;

public interface PersonRepository {

    static void save(Person person) {
    }

    static Person load(int id) {
        return new Person();
    }
}
