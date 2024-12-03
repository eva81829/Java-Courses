/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test19;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Test19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.print("請輸入:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        for(int i=0; i<=n/2+1; i++){
            if(i==n/2+1){
                for(int j=0; j<n/2-1; j++){
                    System.out.print(" ");
                }
                for(int j=0; j<3; j++){
                    System.out.print("*");
                }
                break;
            }
            
            for(int j=0; j<n/2-i; j++){
                System.out.print(" ");
            }
            for(int j=0; j<2*(i+1)-1; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
