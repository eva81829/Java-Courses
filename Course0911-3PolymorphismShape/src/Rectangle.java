/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eka
 */
public class Rectangle extends Shape{
    public Point[] points;
    private double height;
    private double width;
    
    public Rectangle(double x1, double y1, double x2, double y2){
        type = "Rectangle";
        this.points = new Point[2];
        this.points[0] = new Point(x1, y1);
        this.points[1] = new Point(x2, y2);
        height = Math.abs(x1 - x2);
        width = Math.abs(y1 - y2);
        number = CoordinateSystem.count++;
    }
    
    @Override
    public double getArea(){
        return  height * width;
    }
 
    @Override
    public double getPerimeter(){
        return (height + width) * 2;
    }
    
    @Override
    public Point mid(){
        Point point = new Point();
        point.x = (this.points[0].x + this.points[1].x)/2;
        point.y = (this.points[0].y + this.points[1].y)/2;
        return point;
    }
    
    
}
