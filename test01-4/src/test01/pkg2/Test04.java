/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test01.pkg2;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Test04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);
        
        int n;
        do{
            System.out.print("n:");
            n = scanner.nextInt();
        } while(n%2 != 1 || n<3);
        
        for (int i=-n/2;i<n/2+1;i++){
            //if (Math.abs(i)<n/2){
                for (int j=0;j<n/2-Math.abs(i);j++){
                    System.out.print(" ");
                }
            //}
            
            for (int j=0;j<2*Math.abs(i)+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
