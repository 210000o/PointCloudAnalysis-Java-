/**
 * Project 1 Part 1
 * Student Name: Chen, Junhong
 * Student Number: 300140321
 */

public class Plane3D {
    private double a;
    private double b;
    private double c;
    private double d;
    private Point3D e;

    //constructor
    public Plane3D(Point3D p1, Point3D p2, Point3D p3){
        Point3D f = p2.minus(p1);
        Point3D g = p3.minus(p1);
        e = f.times(g);
        a = e.getX();
        b = e.getY();
        c = e.getZ();
        d = a * p1.getX() + b * p1.getY() + c * p1.getZ();
    }

    //constructor
    public Plane3D(double a, double b, double c, double d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        e = new Point3D(a,b,c);
    }

    //calculate distance between point and the plane
    public double getDistance(Point3D pt){
        Point3D p = new Point3D(0,0,d/c);
        Point3D h = pt.minus(p);
        Point3D project = h.projection(e);
        double length = project.getLength();
        return length;
    }
}
