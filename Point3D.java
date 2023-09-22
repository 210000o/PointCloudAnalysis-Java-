/**
 * Project 1 Part 1
 * Student Name: Chen, Junhong
 * Student Number: 300140321
 */

public class Point3D {
    private double x;
    private double y;
    private double z;

    //constructor
    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //get and set methods
    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getZ(){
        return z;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public void setZ(double z){
        this.z = z;
    }

    //supports function point - point
    public Point3D minus(Point3D point){
        Point3D result = new Point3D(x- point.x,y- point.y,z- point.z);
        return result;
    }

    //supports function point x point
    public Point3D times(Point3D point){
        Point3D result = new Point3D(y * point.z - z * point.y, z * point.x - x * point.z, x * point.y - y * point.x);
        return result;
    }

    //support function point * point
    public double dot(Point3D point){
        double result = x * point.x + y * point.y + z * point.z;
        return result;
    }

    //calculate length of the vector
    public double getLength(){
        double result = Math.sqrt(Math.pow(x,2) + Math.pow(y,2) + Math.pow(z,2));
        return result;
    }

    //calculate length of the projection
    public Point3D projection(Point3D point){
        double k = dot(point) / Math.pow(point.getLength(),2);
        return point.scale(k);
    }

    //calculate length of the compare line
    public Point3D scale(double k){
        Point3D result = new Point3D(k * x, k * y, k * z);
        return result;
    }
}
