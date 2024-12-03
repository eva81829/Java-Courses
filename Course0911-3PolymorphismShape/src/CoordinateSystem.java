/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eka
 */
public class CoordinateSystem {
    private Shape[] shapes;
    public static int count;
    
    public CoordinateSystem(){
        shapes = new Shape[2];
        count = 0;
    }
    
    public void genCircle(double radius, double x, double y){
        doubleArr();
        shapes[count] = new Circle(radius, x, y);
        //System.out.println(shapes[count++].getArea());
    }
    
    public void genRectangle(double x1, double y1, double x2, double y2){
        doubleArr();
        shapes[count] = new Rectangle(x1, y1, x2, y2);
        //System.out.println(shapes[count++].getArea());
    }
    
    public void doubleArr(){
        if (count==shapes.length){
            Shape[] tmp = new Shape[count*2];
            for (int i=0; i<shapes.length; i++){
                tmp[i] = shapes[i];
            }
            shapes = tmp;            
        }
    }

    public String compare(int a, int b){
        //System.out.println(shapes[a].getArea());
        //System.out.println(shapes[b].getArea());        
        
        if (shapes[a].getArea() > shapes[b].getArea()){
            return "" + a;
        }
        if (shapes[a].getArea() < shapes[b].getArea()){
            return "" + b;
        }
        
        return "Same";
    }

        /*
    public String compare(int a, int b){
        return shapes[a].compare(shapes[b]);
    }
    */    
    
    public double distance(int a, int b){
        double distance;
        double dx = shapes[a].mid().x - shapes[b].mid().x;
        double dy = shapes[a].mid().y - shapes[b].mid().y;
        distance = Math.sqrt(Math.pow(dx,2) + Math.pow(dy,2));
        return distance;
    }
    
}
