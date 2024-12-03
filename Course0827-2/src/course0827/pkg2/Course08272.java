/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0827.pkg2;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course08272 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        int option, num;
        int[] score = null;
        int[] index = null;
        
        System.out.print("請輸入學生個數:"); 
        num = scanner.nextInt();
        score = new int[num];
        index = new int[num];

        for(int i=0;i<num;i++){        
            do{
                System.out.printf("第%d位成績:",i+1); 
                score[i] = scanner.nextInt();
            } while(score[i]<0 || score[i]>100);         
        }
        
        for(int i=0;i<num;i++){        
            index[i] = i+1;
        }     
        
        do{
            System.out.print("請輸入選項:");            
            option = scanner.nextInt();
            
            switch(option){
                case 1:
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
                    for(int i=0;i<score.length;i++){
                        System.out.printf("第%d位成績:%d",index[i],score[i]); 
                        System.out.println(); 
                    }                    
                    
                    break;
                
                case 2:
                    for(int i=0;i<score.length;i++){
                        System.out.printf("第%d位成績:%d",i+1,score[i]); 
                        System.out.println(); 
                    }
                    break;
            }
        } while (option!=3);     

    }
}
