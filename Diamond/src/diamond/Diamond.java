/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diamond;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Diamond {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("請輸入:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        for(int i=0; i<n; i++){
            if(i<n/2){
                for(int j=0; j<n/2-i; j++){
                    System.out.print(" ");
                }
                
                System.out.print("*");
                for(int j=0; j<2*i-1; j++){
                    System.out.print(" ");
                }
                if(i!=0){
                    System.out.println("*");
                }else{
                    System.out.println("");
                }
            }else{
                for(int j=0; j<i-n/2; j++){
                   System.out.print(" ");
                }
//                
                System.out.print("*");                  
                for(int j=0; j<2*(n-i-1)-1; j++){
                   System.out.print(" ");
                }
                if(i!=n-1){
                    System.out.println("*");
                }else{
                    System.out.println("");
                }
            }
        }
    }
    
}
