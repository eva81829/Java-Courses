/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0829.pkg2;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course08292 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner (System.in);
        int[] score_array = input(scanner);
//        for(int i=0;i<score_array.length;i++){
//            System.out.println(score_array[i]);
//        }
        
        do {
            System.out.print("請輸入選項:");
            int opt = scanner.nextInt();
            if (opt ==4){
                break;
            }
            
            switch (opt) {
                case 1:
                    System.out.println("排序");
                    sort_array(score_array);
                    break;
                case 2:
                    for(int i=0;i<score_array.length;i++){
                        System.out.print(score_array[i] + " ");
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("打亂");
                    mess_array(score_array);
                    break;
           }
        } while(true);

    }
    
    public static int[] input(Scanner scanner){
        int score_array[] = new int[2];
        int score_index = 0;
        
        do{
            System.out.print("請輸入數字:");
            int n = scanner.nextInt();

            if (score_index==score_array.length){
                int[] tmp_array = new int[score_array.length*2];                   
                score_array = adj_array(score_array, tmp_array, score_index);
            }
            
            if(n==-1){
                int[] tmp_array = new int[score_index];
                score_array = adj_array(score_array, tmp_array, score_index);
                break;
            }            

            score_array[score_index++] = n;
        } while(true);
        
        return score_array;
    }
    
    public static int[] adj_array(int[] array, int[] tmp_array, int index){
        for(int i=0;i<index;i++){
            tmp_array[i] = array[i];
        }
        return tmp_array;
    }
    
    
    public static void sort_array(int[] array){
        for (int i=0; i<array.length-1 ;i++){
            for (int j=0; j<array.length-1-i ;j++){
                if (array[j]>array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                } 
            }        
        }
        //return array;
    }

    public static void mess_array(int[] array){
        for (int i=0; i<array.length-1 ;i++){
            int swap = (int)(Math.random()*(array.length-i) + i);
            int tmp = array[i];
            array[i] = array[swap];
            array[swap] = tmp;
        }
    } 

}
