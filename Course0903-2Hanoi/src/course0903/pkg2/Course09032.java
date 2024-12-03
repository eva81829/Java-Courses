/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0903.pkg2;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course09032 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.print("請輸入層數:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char from = 'a';
        char space = 'b';
        char to = 'c';
        hanoi(n,from, space, to);
    }
    
    public static void hanoi(int n, char from, char space, char to){
        if (n == 1){
            System.out.println(from + " -> " + to);

        } else{
            hanoi(n-1, from, to, space);
            hanoi(1, from, space, to);
            hanoi(n-1, space, from, to);
        }
    }
    
}
