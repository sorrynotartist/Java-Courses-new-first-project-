package Homework_5;

public class Rectangle extends Shape {
    double a, b;
    public Rectangle(int color, double a, double b) {
        super(ShapeType.Rectangle, color);
        this.a = a;
        this.b = b;
    }
    double getPerimeter() {
        return a * 2 + b * 2;
    }
    double getSquare () {
        return a * b;
    }
}
