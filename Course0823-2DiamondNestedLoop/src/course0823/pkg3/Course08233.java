/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0823.pkg3;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course08233 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);     
        int n = scanner.nextInt();
             
        System.out.println("*");
        for (int i = 0;i < n-2;i++){
             System.out.print("*");
             if (i != 0){
                    for (int j = 0;j < i; j++){
                    System.out.print(" ");
                }
             }
             System.out.print("*");
             System.out.println();
         }
         for (int i =0; i<n; i++){
             System.out.print("*");
         }
        System.out.println();
         
        
        System.out.println();
        for(int i = -n / 2;i < n / 2 + 1;i++){
            for(int j = 0;j < Math.abs(i);j++){
            System.out.print(" ");
            }
            System.out.print("*");
            for(int j = 0;j < (n + -2 * Math.abs(i))-2;j++){
                System.out.print(" ");
            }
            if (Math.abs(i) != n / 2){
               System.out.print("*");
            }
            System.out.println();
        }
        
        
        System.out.println();
        for(int i = 0;i < (n/2+1);i++){
            for(int j = 0;j < n / 2 - i;j++){
            System.out.print(" ");
            }
            System.out.print("*");
            for(int j = 0;j < 2 * i - 1;j++){
                System.out.print(" ");
            }
            if (i != 0){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = 0;i < n/2;i++){
            for(int j = 0;j < i + 1;j++){
            System.out.print(" ");
            }
            System.out.print("*");
            for(int j = 0;j < n - 2 * i - 4;j++){
                System.out.print(" ");
            }
            
            if (i != n/2-1){
                System.out.print("*");
            }
            System.out.println();
        }    
        
        
    }
}
