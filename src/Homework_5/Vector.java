package Homework_5;

import java.awt.*;

public class Vector extends Line{
    public Vector(Point pos1, Point pos2) {
        super(pos1, pos2);
    }
    public Vector (Line line) {
        super(line.pos1, line.pos2);
    }
    public Vector startFrom (Point pos1) {
        int x = this.pos2.x - this.pos1.x;
        int y = this.pos2.y - this.pos1.y;
        return new Vector (pos1, new Point(pos1.x + x,pos1.y + y));
    }
    Vector scalarSum (Vector another) {
        Vector result = another.startFrom(pos2);
        return new Vector(new Line(this.pos1, result.pos2));
    }

}
