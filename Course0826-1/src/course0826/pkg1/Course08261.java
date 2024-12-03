/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0826.pkg1;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course08261 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
        {
        // TODO code application logic here
        //Scanner scanner = new Scanner(System.in);
        //int f = scanner.nextInt();
        
        Scanner[] scanners = new Scanner[5];
        scanners[0] = new Scanner(System.in);
        int e = scanners[0].nextInt();
        
        int[] g = new int[5];
        Scanner scanner = new Scanner(System.in);
        g[0] = scanner.nextInt();
        
        
                
        int n = scanner.nextInt();
        int[] a, b;//stack
        int c[], d;
        
        a = new int[n];
        a[0] = 5;
        a[1] = 3;
        a[4] = 1;
        System.out.println(a[0] + " " + a[2]);
        
        for(int i=0;i<a.length;i++){
            a[i] = i+1;
        }
        
        int studentNum = scanner.nextInt();
        int[] scores;
        
        scores = new int[studentNum];
        for(int i=0;i<scores.length;i++){
            do{
                System.out.print("請輸入 " + (i+1) + " 號學生的成績:");
                scores[i] = scanner.nextInt();
            }while(scores[i] < 0 || scores[i]>100);
            
        }
        System.out.print("--------------------------------");

    }
    
}
