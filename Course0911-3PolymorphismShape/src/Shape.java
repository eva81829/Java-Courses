

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eka
 */
public class Shape {
    public String type;
    public int number;
    
    public double getArea(){
        return -1;
    }
    
    public double getPerimeter(){
        return -1;
    }
    
    public String compare(Shape shape){
        if (this.getArea() > shape.getArea()){
            return "" + this.number;
        }
        if (this.getArea() < shape.getArea()){
            return "" + shape.number;
        }
        return "Same";
    }    

    public Point mid(){
        return null;
    }
    
    
}
