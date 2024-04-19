package Homework_5;

import java.awt.*;

public class Circle extends Shape{
    Point center;
    double r;
    public Circle(int color, Point center, double r) {
        super(color);
        this.center = center;
        this.r = r;
    }
    public double getPerimeter() {
        return 2 * Math.PI * this.r;
    }
    public double getSquare() {
        return Math.PI * Math.pow(this.r, 3);
    }
}
