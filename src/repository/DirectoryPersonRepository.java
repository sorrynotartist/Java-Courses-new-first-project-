package repository;

import entity.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DirectoryPersonRepository implements Repository<Person>{
    static File dir = new File("file.txt");

    public DirectoryPersonRepository(File dir) {
        DirectoryPersonRepository.dir = dir;
        if (!dir.exists()) {
            try {
                dir.mkdir();
            }
            catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    @Override
    public void save(Person obj) throws IOException {
        String nameOfFile;
        nameOfFile = Integer.toString(obj.id);
        File fileId = new File(dir.getPath() + "/" + nameOfFile + ".txt");
        try (FileOutputStream stream = new FileOutputStream(dir)) {
            try (PrintWriter writer = new PrintWriter(stream)) {
                writer.println(obj.id);
                writer.println(obj.name);
                writer.println(obj.age);
                writer.println(obj.underlyingDisease);
                writer.println(obj.complaining);
            }
        }
    }

    @Override
    public Person load(int id) throws IOException {
        File file = new File(dir.getPath() + "/" + id);
        try (FileInputStream stream = new FileInputStream(dir)) {
            try (Scanner scanner = new Scanner(stream)) {
                return new Person(
                        new Integer(scanner.nextLine()),
                        scanner.nextLine(),
                        new Integer(scanner.nextLine()),
                        scanner.nextLine(),
                        scanner.nextLine()
                );
            }
        }
    }

    @Override
    public List<Person> load(List<Integer> ids) throws IOException {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < ids.size(); i++) {
            list.add(load(ids.get(i)));
        }
        return list;
    }
}
