package Homework_5;

public class Triangle extends Shape{
    double a, b, c;
    public Triangle(int color, double a, double b, double c) {
        super(color);
        this.a = a;
        this.b = b;
        this.c = c;
    }
    double getPerimeter() {
        return a + b + c;
    }
    double getSquare () {
        double p = getPerimeter()/ 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
