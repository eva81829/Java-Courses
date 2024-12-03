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
public class Square extends Shape{

    private int width;
    
    public Square (int width){
        super();
        this.width = width;
    }

    @Override
    public double getArea(){
        return width * width;
    }

    @Override
    public double getPerimeter(){
        return width * 4;
    }
    
}
