/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0823.pkg2;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course08232 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /*
        Scanner scanner = new Scanner(System.in);
        for(int i = 0;i < 5;i++){
            for(int j = 0;j < i+1;j++){
                System.out.print("*");
            }
            System.out.println();
        } 

        System.out.println();
        for(int i = 0;i < 5;i++){
            for(int j = 0;j < 5 - i;j++){
                System.out.print(" ");
            }
            System.out.print("****");
            System.out.println();
        }

        System.out.println();
        for(int i = 0;i < 5;i++){
            for(int j = 0;j < 4 - i;j++){
                System.out.print(" ");
            }
            for(int j = 0;j < i+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        */
        
        Scanner scanner = new Scanner(System.in);     
        int m ;
        do {
            System.out.print("請輸入行數:");
            m = scanner.nextInt();
        } while(m<=0 && m%2 != 0);
        
        for(int i = 0;i < m;i++){
            for(int j = 0;j < m - i - 1;j++){
                System.out.print(" ");
            }
            for(int j = 0;j < i+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        

        System.out.print("請輸入行數:");
        int n = scanner.nextInt();
        for(int i = 0;i < n;i++){
            if (i<(n/2+1)){
                for(int j = 0;j < n/2 - i;j++){
                System.out.print(" ");
                }
                for(int j = 0;j < 2*i+1;j++){
                    System.out.print("*");
                }
                System.out.println();
            }
            else{
                for(int j = 0;j < i - n/2;j++){
                    System.out.print(" ");
                }
                for(int j = 0;j < 2*n - 2*i - 1;j++){
                    System.out.print("*");
                }
                System.out.println();
            }
        } 
        
        System.out.println();
        for(int i = 0;i < (n/2+1);i++){
            for(int j = 0;j < n / 2 - i;j++){
            System.out.print(" ");
            }
            for(int j = 0;j < 2 * i + 1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = 0;i < n/2;i++){
            for(int j = 0;j < i + 1;j++){
            System.out.print(" ");
            }
            for(int j = 0;j < n - 2 * i - 2;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        
        
        System.out.println();
        for(int i = -n / 2;i < n / 2 + 1;i++){
            for(int j = 0;j < Math.abs(i);j++){
            System.out.print(" ");
            }
            for(int j = 0;j < (n + -2 * Math.abs(i));j++){
                System.out.print("*");
            }
            System.out.println();
        }
        

    }
}
