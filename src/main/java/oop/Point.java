package oop;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Point {

    private double x;
    private double y;
    private double z;

    public Point(double first, double second) {
        this.x = first;
        this.y = second;
    }

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distance(Point that) {
        return sqrt(pow((this.x - that.x), 2) + pow((this.y - that.y), 2));
    }

    public double distance3d(Point that) {
        return sqrt(pow((this.x - that.x), 2) + pow((this.y - that.y), 2) + pow((this.z - that.z), 2));
    }

    public static void main(String[] args) {
        Point a = new Point(-2, -5);
        Point b = new Point(-5, -7);
        double dist = a.distance(b);
        System.out.println(dist);
    }
}
