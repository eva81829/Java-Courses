/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test02.pkg3;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Test023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opt;
        int[][] score = new int[2][];
        int count = 0;
        do{
            System.out.print("輸入選項:");
            Scanner scanner = new Scanner(System.in);
            opt = scanner.nextInt();
            
            if(opt<1 || opt>3){
                System.out.println("輸入錯誤");
                continue;
            }
            
            switch (opt){
                case 1:
                    if (count<=30){
                        if (count==score.length){
                            score = expand(score);
                        }         
                        input(count++, score, scanner);
                    } else {
                        System.out.println("額滿");
                    }
                    break;
                    
                case 2:
                    checkScore(count, score, scanner);
                    break;
                    
                case 3:
                    int max = checkRange(0,100, "最大成績",scanner);
                    int min = checkRange(0,100, "最小成績",scanner);
                    checkRangeScore(max,min,count,score);
            }
        } while (true);
    }

    public static void checkScore(int count, int[][] score, Scanner scanner){
        int n = checkRange(0,count-1, "座號",scanner);
        System.out.println("班級:" + score[n][2] + " 座號:" + score[n][0] + " 成績:" + score[n][1]);
    }    

    public static void checkRangeScore(int max, int min, int count, int[][] score){
        for (int i=0; i<count; i++ ){
            if (score[i][1]<=max && score[i][1]>=min){
                System.out.println("班級:" + score[i][2] + " 座號:" + score[i][0] + " 成績:" + score[i][1]);
            }
        }
    }
    
    public static void input(int count, int[][] score, Scanner scanner){
        score[count] = new int[3];
        score[count][0] = count;
        score[count][1] = checkRange(0,100, "成績",scanner);
        score[count][2] = checkRange(0,20, "班級",scanner);
//        for (int i=0; i<3; i++){
//            System.out.println(score[count][i]);
//        }
    }
    
    public static int checkRange(int min, int max, String category, Scanner scanner){
        int n;
        do{
            System.out.print("輸入" + category + ":");
             n = scanner.nextInt();
        } while (n>max || n<min);
        return n;
    }

    public static int[][] expand(int[][] score){
        int[][] tmp = new int[score.length*2][];
        //System.out.println(score.length);
        for(int i=0; i<score.length; i++){
            tmp[i] = score[i];
        }
        return tmp;
    }    

}
