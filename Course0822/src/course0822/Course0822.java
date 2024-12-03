/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0822;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course0822 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        int a = 0;
        while(a < 5){
            System.out.println(a++);
        }
        System.out.println("");
        for(int i = 0;i < 5;i++){
            System.out.println(i++);
        }

        System.out.println("");
        for(int i = 0;i < 5;i++){
            int b = i++;
            System.out.println(i++);
        }
    }
    
}
