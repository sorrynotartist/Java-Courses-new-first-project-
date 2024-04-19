package Homework_5;

import java.awt.*;

public class Line {
    Point pos1, pos2;
    public Line(Point pos1, Point pos2) {
        this.pos1 = pos1;
        this.pos2 = pos2;
    }
    double length() {
        return Math.sqrt(Math.pow((this.pos1.x - this.pos2.x), 2) +
                Math.pow((this.pos1.y - this.pos2.y), 2));
    }
}
