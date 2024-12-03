/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication90;

/**
 *
 * @author Eka
 */
public class JavaApplication90 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] a = new int[2];
        int b, c;
        b = 2;
        c = 3;
        a[0] = b;
        a[1] = c;        
        
        int[][] abc = new int[1][];
        abc[0] = a;
        abc[0][1] -= 1;
        
        System.out.println(abc[0][1]);
        System.out.println(a[1]);        
    }
    
}
