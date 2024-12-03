/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0828.pkg6;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course08286 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in); 

        int score[][] = new int[2][];
        int i=0;
        do {
            System.out.print("請輸入正整數:");
            int n = scanner.nextInt();
            
            if (n==-1){
                break;
            }
            
            if (n<0){
                    continue;
            }

            if (i==score.length){
                int tmp[][] = new int[score.length*2][];
                for (int j=0;j<score.length;j++){
                    tmp[j] = score[j];
                }
                score = tmp;
            }
            score[i] = new int[2];
            score[i][0] = i+1;
            score[i++][1] = n;
        } while(true);

        int max, min; 
        max = min = 0;
        for(int j=1;j<i;j++){
            if (score[j][1]>score[max][1]){
                max = j;
            } else if(score[j][1]<score[min][1]){
                min = j;
           }
            //System.out.print(score[j][0] + " " + score[j][1]);
            //System.out.println();
        }

        System.out.println(score[max][0] + " " + score[max][1]);
        System.out.println(score[min][0] + " " + score[min][1]);            
        
        do {
            System.out.print("輸入選項:");
            int opt = scanner.nextInt();
            if (opt==3){
                break;
            }
            switch (opt){
                case 1:
                    System.out.print("輸入欲查找的值:");
                    int num = scanner.nextInt();
                    int seat = -1; 
                    for(int j=0;j<i;j++){
                        if (score[j][1]==num){
                            seat = score[j][0];
                            break;
                       }
                    }
                    System.out.println(seat);
                    break;
                    
                case 2:
                    for(int j=0;j<i-1;j++){
                        for(int k=0;k<i-1-j;k++){
                            if(score[k][1]>score[k+1][1]){
                                int tmp2 = score[k][1];
                                    score[k][1] = score[k+1][1];
                                    score[k+1][1] = tmp2;
                            }
                        }                        
                    }
                    
                    for(int j=0;j<i;j++){
                        System.out.print(score[j][0] + " " + score[j][1]);
                        System.out.println();
                    }

                    break;
            }
        } while (true);
        
    }
}
