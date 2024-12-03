/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0822.pkg3;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course08223 {

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
        int hcf = 0, max = 0, min = 0;
        if (n==m){
            hcf = n;
        }else if (n>m){
            max = n;
            min = m;
        }else if (n<m){
            max = m;
            min = n;
        }
        
        while(hcf==0){
            int cf = 0;
            cf = max % min;
            if (cf==0){
                hcf = min;
                break;
            }
            max = min;
            min = cf;
        }
        System.out.println(hcf);
 

        //Scanner scanner = new Scanner(System.in);
        int p, y1, y2, y;
        double s1, s2, i;
        System.out.println("本金:");
        p = scanner.nextInt();
        System.out.println("利息:");
        i = scanner.nextDouble();
        System.out.println("存入年份:");
        y1 = scanner.nextInt();
        System.out.println("取出年份:");
        y2 = scanner.nextInt();
        y = y2 - y1;
        s1 = p * Math.pow((1 + i), y);
        System.out.println("拿回金額:"+s1);
        
        s2 = p;
        while(y>0){
            s2 = s2*(1 + i);
            y--;
        }
        System.out.println("拿回金額:"+s2);
        
    }
}
