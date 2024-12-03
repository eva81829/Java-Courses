/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0828.pkg5;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course08285 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int score[][] = new int[2][];
        int i=0;
        do {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            if (n==-1){
                break;
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
        
        int max = 0;
        int min = 0;
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
    }
}
