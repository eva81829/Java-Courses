/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0827.pkg3;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course08273 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);        
        int num;
        System.out.print("幾個數字:");    
        num = scanner.nextInt();
        int[] score = new int[num];
        int[] index = new int[num];
        
        for(int i=0;i<num;i++){        
            do{
                System.out.printf("第%d位數字:",i+1); 
                score[i] = scanner.nextInt();
            } while(score[i]<0 || score[i]>2147482648);
        }
        
        for(int i=0;i<num;i++){        
            index[i] = i+1;
        }
        
        for (int i=0;i<2;i++){
            for (int j=0;j<score.length-1-i;j++){
                int m,n;
                int tmp_s = score[j];
                int tmp_i = index[j];            

                if(i==0){
                    m = score[j];
                    n = score[j+1];
                }
                else{
                    m = score[j+1];
                    n = score[j];                    
                }

                if (m>=n){
                   score[j] = score[j+1];
                   score[j+1] = tmp_s;
                   index[j] = index[j+1];
                   index[j+1] = tmp_i;
                }
            }            
        }
        
        System.out.printf("座位%d的值%d為最大值",index[num-1],score[num-1]);
        System.out.println();
        System.out.printf("座位%d的值%d為最小值",index[num-2],score[num-2]);
        System.out.println();               
        
        
        /*
        for (int i=0;i<score.length-1;i++){ //每次確定一個最右邊的值, 做4(n-1)次, 就可確定5個值的大小
            for (int j=0;j<score.length-1-i;j++){ //每次判斷是否交換j,j+1兩個值, 做(n-1-i)次才能確定哪一個是最大的放最右邊
                 int tmp_s = score[j];
                 int tmp_i = index[j];
                 if (score[j]>score[j+1]){
                    score[j] = score[j+1];
                    score[j+1] = tmp_s;
                    index[j] = index[j+1];
                    index[j+1] = tmp_i;    
                 }
            }  
        }
        
        System.out.printf("座位%d的值%d為最大值",index[num-1],score[num-1]);
        System.out.println();
        System.out.printf("座位%d的值%d為最小值",index[0],score[0]); 
        System.out.println();  
        */
    }
}
