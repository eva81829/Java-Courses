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
public class Circle extends Shape{
    public static final double pi = 3.14159;
    private double radius;
    
    public Circle (double radius){
        super();
        this.radius = radius;
    }  
    
    @Override
    public double getArea(){
        return radius * radius * pi;
    }
    
    @Override
    public double getPerimeter(){
        return radius *2 * pi;
    }    
    
}
