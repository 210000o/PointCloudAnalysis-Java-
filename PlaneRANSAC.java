/**
 * Project 1 Part 1
 * Student Name: Chen, Junhong
 * Student Number: 300140321
 */

import java.util.Iterator;

public class PlaneRANSAC {

    private PointCloud pc;
    private double eps;

    //constructor
    public PlaneRANSAC(PointCloud pc){
        this.pc = pc;
    }
    public void setEps(double eps){
        this.eps = eps;
    }
    //get method
    public double getEps(){
        return this.eps;
    }

    //calculate the number of iteration required
    public int getNumberOfIterations(double confidence, double percentageOfPointsOnPlane){
        double result = Math.ceil(Math.log((1 - confidence)) / Math.log(1 - Math.pow(percentageOfPointsOnPlane,3)));
        return (int) result;
    }

    //RANSAC Algorithm
    public void run(int numberOfIterations, String filename){

        PointCloud bestCloud = new PointCloud();
        //step 1
        int bestSupport = 0;
        //step 2 to 6
        for (int i = 0; i < numberOfIterations; i++){
            PointCloud currentCloud = new PointCloud();
            Point3D p1 = pc.getRandomPoint();
            Point3D p2 = pc.getRandomPoint();
            Point3D p3 = pc.getRandomPoint();
            Plane3D pl = new Plane3D(p1,p2,p3);
            int currentSupport = 0;
            Iterator<Point3D> iterator = pc.iterator();
            while (iterator.hasNext()){
                Point3D p =iterator.next();
                if (pl.getDistance(p) <= eps){
                    currentSupport++;
                    currentCloud.addPoint(p);
                }
            }
            if (currentSupport > bestSupport){
                bestSupport = currentSupport;
                bestCloud = currentCloud;
            }

        }
        bestCloud.save(filename);
        //step 7
        bestCloud.removeListFrom(pc);
        pc.save("remain.xyz");
    }

    //main process which choose the files and set eps, confidence, and percentage
    public static void main(String[] args){
        PointCloud pc = new PointCloud("remain.xyz");
        PlaneRANSAC al = new PlaneRANSAC(pc);
        al.setEps(0.01);
        al.run(al.getNumberOfIterations(0.99,0.1), "PointCloud3_p3.xyz");
    }


}
