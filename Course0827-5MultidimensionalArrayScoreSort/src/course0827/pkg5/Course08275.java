/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0827.pkg5;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course08275 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        System.out.print("幾個學生:");
        int n = scanner.nextInt();
        int[][] score = new int[n][5];
        
        System.out.println("位/國/英/數/總");
        for (int i=0;i<n;i++){
            int sum = 0;
            for (int j=0;j<5;j++){
                if (j==0){
                    score[i][j] = i+1;
                } else if (j>0 && j<4){
                    score[i][j] = (int)(Math.random()*61+40);
                    sum += score[i][j];
                } else{
                    score[i][j] = sum;
                }     
                System.out.print(score[i][j]);
                System.out.print(" "); 
            }
            System.out.println();
        }
        
        /*
        int seat = 1;        
        System.out.println("位/國/英/數/總");
        for (int i=0;i<n;i++){
            int sum = 0;
            for (int j=0;j<5;j++){
                if (j==0){
                    score[i][j] = seat++;
                } else if (j>0 && j<4){
                    score[i][j] = (int)(Math.random()*61+40);
                    sum += score[i][j];
                } else{
                    score[i][j] = sum;
                }     
                System.out.print(score[i][j]);
                System.out.print(" "); 
            }
            System.out.println();
        }
        */
        
        System.out.println(); 
        for (int i=0;i<n-1;i++){
            for (int j=0;j<n-1-i;j++){
                if (score[j][4]<score[j+1][4]){
                    int[] tep = score[j]; //交換一維陣列, [][]為交換二維陣列
                    score[j] = score[j+1];
                    score[j+1] = tep;
                }
            }
        }
        
        for (int i=0;i<n;i++){
            System.out.printf("座位: %d, 總分: %d(%d/%d/%d), 名次: %d", score[i][0], score[i][4],score[i][1],score[i][2],score[i][3], i+1);
            System.out.println();
        }

    }  
}
