/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0828.pkg7;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course08287 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in); 

        int score[][] = new int[2][];
        int i=0;
        int chinese;
        int english;
        do {
            
            System.out.print("輸入國文:");
            chinese = scanner.nextInt();                
            if (chinese==-1){
                break;
            }
            if (chinese<0 || chinese>100){
                continue;
            }

            System.out.print("輸入英文:");
            english = scanner.nextInt();
            if (english<0 || english>100){
                continue;
            }    
                
            if (i==score.length){
                int tmp[][] = new int[score.length*2][];
                for (int j=0;j<score.length;j++){
                    tmp[j] = score[j];
                }
                score = tmp;
            }
            score[i] = new int[5];
            score[i][0] = i+1;
            score[i][1] = chinese;
            score[i][2] = english;
            score[i][3] = chinese + english;
            score[i++][4] = 0;
        } while(true);
       

        do {
            System.out.print("輸入選項:");
            int opt = scanner.nextInt();
            if (opt==3){
                break;
            }
            switch (opt){
                case 2:
                    System.out.println("位/國/英/總");
                    for(int j=0;j<i-1;j++){
                        for(int k=0;k<i-1-j;k++){
                            if(score[k][0]>score[k+1][0]){
                                int tmp2[] = score[k];
                                    score[k] = score[k+1];
                                    score[k+1] = tmp2;
                            }
                        }
                    }
                    for(int j=0;j<i;j++){
                        System.out.print(score[j][0] + " " + score[j][1] + " " + score[j][2] + " " + score[j][3]);
                        System.out.println();
                    }
                    break;
                    
                case 1:
                    System.out.println("位/國/英/總/名");
                    
                    for(int j=0;j<i-1;j++){
                        for(int k=0;k<i-1-j;k++){
                            if(score[k][3]<score[k+1][3]){
                                int tmp2[] = score[k];
                                    score[k] = score[k+1];
                                    score[k+1] = tmp2;
                            }
                        }
                    }
                    
                    int rank = 1;
                    for(int j=0;j<i;j++){
                        if (j==0 || score[j][3]==score[j-1][3]){
                            score[j][4] = rank;
                        } else{
                            score[j][4] = ++rank;
                        }
                        System.out.print(score[j][0] + " " + score[j][1] + " " + score[j][2] + " " + score[j][3] + " " + score[j][4]);
                        System.out.println();
                    }
                    break;
            }
        } while (true);     

    }
}
