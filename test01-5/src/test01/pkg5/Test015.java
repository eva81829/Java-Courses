/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test01.pkg5;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Test015 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
                
        for(int i=0;i<(n+1)/2;i++){
            for(int j=0;j<n/2-i;j++){
                System.out.print(" ");
                }             
            for(int j=0;j<2*i+1;j++){
            System.out.print("*");
            }        
            System.out.println();
        }
        for(int i=0;i<n/2-1;i++){
            System.out.print(" ");
        }        
        for(int i=0;i<3;i++){
            System.out.print("*");
        }
        System.out.println();

        
        System.out.println();
        for(int i=0;i<(n+1)/2;i++){
            for(int j=0;j<n/2+i+1;j++){
                System.out.print((j<n/2-i)? " ": "*");
            }
            System.out.println();
        }   
        for(int i=0;i<n/2+2;i++){
            System.out.print((i<n/2-1)? " ": "*");
        }
        System.out.println();   
        
    }
}
