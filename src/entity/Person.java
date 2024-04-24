package entity;
import java.io.*;
import java.util.Scanner;

public class Person {
    int id;
    String name;
    int age;
    String underlyingDisease;
    String complaining;
    public Person(int id, String name, int age, String underlyingDisease, String complaining) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.underlyingDisease = underlyingDisease;
        this.complaining = complaining;
    }
    File file = new File("output.txt");

    public Person() {
    }

    public static void saveTo (File file, Person person) throws IOException {
        if (file.exists() && file.isFile()) {
            try (FileOutputStream stream = new FileOutputStream(file)) {
                try (PrintWriter writer = new PrintWriter(stream)) {
                    writer.println(person.id);
                    writer.println(person.name);
                    writer.println(person.age);
                    writer.println(person.underlyingDisease);
                    writer.println(person.complaining);
                }
            }
        }
    }
    public static Person loadFrom(Person person, File file) throws IOException {
        try (FileInputStream stream = new FileInputStream(file)) {
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