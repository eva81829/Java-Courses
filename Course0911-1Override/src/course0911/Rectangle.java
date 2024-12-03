/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0911;

/**
 *
 * @author Eka
 */
public class Rectangle extends Shape{
    
    private double height;
    private double width;
    
    public Rectangle(double height, double width){
        super();
        this.height = height;
        this.width = width;
    }
    
    @Override
    public double getArea(){
        return height * width;
    }
    
    @Override
    public double getPerimeter(){
        return (height + width)*2;
    }
    
    
}
