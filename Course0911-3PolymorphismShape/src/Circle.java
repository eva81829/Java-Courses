/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eka
 */
public class Circle extends Shape{
    public static final double pi = 3.14;
    private double radius;
    public Point point;
    
    public Circle(double radius, double x, double y){
        this.radius = radius;
        this.point = new Point(x, y);
        type = "Circle";
        number = CoordinateSystem.count++;
    }
    
    @Override
    public double getArea(){
        return radius * radius * pi;
    }
    
    @Override
    public double getPerimeter(){
        return radius * 2 * pi;
    }    
    
    @Override
    public Point mid(){
        return point;
    }
    
}
