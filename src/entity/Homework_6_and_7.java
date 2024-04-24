package entity;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Homework_6_and_7 {
    public static void main(String[] args) throws IOException {
        promptUser();
    }
    public static void promptUser() throws IOException {
        System.out.println("do you want to load or enter your data?");
        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();
        switch (answer) {
            case "load":
                System.out.println("enter file path to load: ");
                String pathToLoad = in.nextLine();
                System.out.println(Person.loadFrom(new Person(), new File(pathToLoad)));
                break;
            case "enter":
                Person person = createNewPerson();
                System.out.println("enter file path to save");
                String pathToSave = in.nextLine();
                Person.saveTo(new File(pathToSave), person);
        }
        in.close();
    }
    public static Person createNewPerson () {
        Scanner in = new Scanner(System.in);

        System.out.println("enter your id");
        int id = Integer.parseInt(in.nextLine());

        System.out.println("enter your name");
        String name = in.nextLine();

        System.out.println("enter your age");
        int age = Integer.parseInt(in.nextLine());

        System.out.println("enter your underlying disease");
        String underlyingDisease = in.nextLine();

        System.out.println("enter your complaining");
        String complaining = in.nextLine();

        return new Person(id, name, age, underlyingDisease, complaining);
    }
}