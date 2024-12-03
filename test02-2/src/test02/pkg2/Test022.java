/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test02.pkg2;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Test022 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opt;
        do{
            System.out.print("輸入選項:");
            Scanner scanner = new Scanner(System.in);
            opt = scanner.nextInt();
            
            if(opt<1 || opt>3){
                System.out.println("輸入錯誤");
                continue;
            }
            
            if(opt==3){
                break;
            }
            
            System.out.print("輸入n:");
            int n = scanner.nextInt();
            switch (opt){
                case 1:
                    System.out.println(prime(n)? "n是質數" :"n不是質數");
                    break;
                    
                case 2:
                    triangle(n);
            }
        } while (true);
    }
    
    public static boolean prime(int n){
        int m = (int)Math.sqrt(n);
        
        if (n<=1){
            return false;
        }
        for (int i=n-1; i>=m && i>1; i--){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }
    
    public static void triangle(int n){
        if(n<5 || !prime(n)){
            return;
        }
        
        for (int i=0;i<n/2+1;i++){
            for (int j=0;j<n/2-i;j++){
                System.out.print(" ");
            }
            for (int j=0;j<2*i+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }   
    }
    
}
