package Homework_5;

public class Homework_5 {

    public static void main(String[] args) {
        Name(new String[]
                        {"polina", "ivan", "ilia", "danila"},
                "Ershov", "Saratovskaya oblast");

        System.out.println(DoubleChar("Hello world!"));
    }

    public static void Name(String[] names, String city, String region) {
        for (int i = 0; i < names.length; i++) {
            System.out.println("Hello, " + names[i] + "! " + "Welcome to " + city + ", " + region + "!");
        }
    }

    public static String DoubleChar(String example) {
        String result = "";
        for (int i = 0; i < example.length(); i++) {
            result = result.concat(String.valueOf(example.charAt(i)) + String.valueOf(example.charAt(i)));
        }
        return result;
    }
}