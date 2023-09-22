/**
 * Project 1 Part 1
 * Student Name: Chen, Junhong
 * Student Number: 300140321
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PointCloud {

    public List<Point3D> cloud;

    //read the PointCloud from xyz file
    PointCloud(String filename){
        cloud = new LinkedList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = "";
            String title = reader.readLine();
            while ((line = reader.readLine()) != null){
                String[] words = line.split("\\s");
                double x = Double.parseDouble(words[0]);
                double y = Double.parseDouble(words[1]);
                double z = Double.parseDouble(words[2]);
                cloud.add(new Point3D(x,y,z));
            }
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //constructor
    public PointCloud(){
        cloud = new LinkedList<>();
    }

    //add point to the cloud
    public void addPoint(Point3D pt){
        cloud.add(pt);
    }

    //get point from the cloud by index
    public Point3D getIndexPoint(int index){
        return cloud.get(index);
    }

    //get random point from the cloud
    public Point3D getRandomPoint(){
        Random random = new Random();
        int r = random.nextInt(cloud.size());
        return cloud.get(r);
    }

    //remove point from the cloud
    public void removePoint(Point3D point){
        cloud.remove(point);
    }

    //remove a list of points from PointCloud remover
    public PointCloud removeListFrom(PointCloud remover){
        for (Point3D p : cloud){
            remover.removePoint(p);
        }
        return remover;
    }

    //save point cloud into a xyz file
    public void save(String filename){
        FileWriter fr = null;
        BufferedWriter br = null;
        try {
            fr = new FileWriter(filename);
            br = new BufferedWriter(fr);
            for (Point3D p : cloud){
                //System.out.println(p);
                br.write(p.getX()+" "+ p.getY()+" "+p.getZ()+"\n");
            }
            br.close();
            fr.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //make cloud iterate
    public Iterator<Point3D> iterator(){
        return cloud.iterator();
    }
}
