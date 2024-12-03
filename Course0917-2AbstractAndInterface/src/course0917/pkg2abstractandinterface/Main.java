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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Shape s1 = new Circle();
        System.out.println(s1.getArea());
        //System.out.println(s1.getWidth());
        System.out.println(s1.a);
        
        Rectangle r1 = new Test();
        System.out.println(r1.getWidth());
        
        Rectangle r2 = new Circle();
        System.out.println(r2.getWidth());
        
    }

}