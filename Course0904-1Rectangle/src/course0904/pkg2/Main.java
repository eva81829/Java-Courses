/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0904.pkg2;

import java.util.Scanner;

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
        
        Scanner scanner = new Scanner(System.in);
        Rectangle r1 = new Rectangle(3,4);
        Rectangle r2 = new Rectangle(3,3);
        r1.setHeight(3);
        r1.width = 3;
        r2.setHeight(4);
        r2.width = 3;
        System.out.println(r1.getHeight() + " " + r1.getArea());
        System.out.println(r2.getHeight());
        
    }
    
}
