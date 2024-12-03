/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Course1;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in); 
        double a;
        a = scanner.nextFloat();
        double b;
        b = scanner.nextFloat();
        double c,d,e,f;
        c = (a + b);
        d = (a - b);
        e = (a * b);
        f = (a / b);
        System.out.println((float)c);
        System.out.println((float)d);
        System.out.println((float)e);
        System.out.println((float)f);
        System.out.printf("output=> %.2f %.2f", c, d);
    }
    
}
                                                                                                                            