/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0823.pkg1;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course08231 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        int n, m;
        System.out.println("第一個數:");
        n = scanner.nextInt();
        System.out.println("第二個數:");
        m = scanner.nextInt();
        int tmp = 0;
        if (n>m){
            tmp = m;
            m = n;
            n = tmp;
        }
        
        int gcd = 1;
        for (int i = n; i >= 2; i--){
            if (n%i == 0 && m%i == 0){
                gcd = i;
                break;
            }
        }
        System.out.println(gcd);
    }
    
}
