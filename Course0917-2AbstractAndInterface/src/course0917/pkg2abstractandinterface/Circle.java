/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0917.pkg2abstractandinterface;

/**
 *
 * @author Eka
 */
public class Circle extends Shape implements Rectangle{ 
    
    public int b;

    @Override
    public int getArea(){
        a = 5;
        return a;
    }
    
    @Override
    public int getWidth(){
        a = 20;
        return a;
    }
    
}
