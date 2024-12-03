/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test01.pkg1;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Test03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int x, y, temp;
        Scanner scanner = new Scanner(System.in);
        System.out.print("x:");
        x = scanner.nextInt();
        System.out.print("y:");
        y = scanner.nextInt();
        
//        if(x<y){
//            temp = x;
//            x = y;
//            y = temp;
//        }
        
        do{
            temp = y;
            y = x%y;
            x = temp;
        } while(y!=0);
        
        System.out.println("Ans:" + x);
    }
    
}
