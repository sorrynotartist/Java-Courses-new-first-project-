package repository;

import entity.Person;

import java.io.*;
import java.util.Scanner;

public class DirectoryPersonRepository {
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

    static void save(Person person) throws IOException {
        String nameOfFile;
        nameOfFile = Integer.toString(person.id);
        File fileId = new File(dir.getPath() + "/" + nameOfFile + ".txt");
        try (FileOutputStream stream = new FileOutputStream(dir)) {
            try (PrintWriter writer = new PrintWriter(stream)) {
                writer.println(person.id);
                writer.println(person.name);
                writer.println(person.age);
                writer.println(person.underlyingDisease);
                writer.println(person.complaining);
            }
        }
    }

    static Person load (int id) throws IOException {
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
}
