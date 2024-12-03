/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0826.pkg2;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course08262 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here  
        
        int option, num;
        int[] score = null;
        do{
            System.out.print("請輸入選項:");            
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
            
            if (option==1){
                System.out.print("請輸入學生個數:"); 
                num = scanner.nextInt();
                score = new int[num];
                
                for(int i=0;i<num;i++){        
                    do{
                        System.out.printf("第%d位成績:",i+1); 
                        score[i] = scanner.nextInt();
                    } while(score[i]<0 || score[i]>100);         
                } 
            } else if (option==2){
                for(int i=0;i<score.length;i++){
                    System.out.println(score[i]); 
                }
            }
        } while (option!=3);
        
        do{
            System.out.print("請輸入選項:");            
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
            
            switch(option){
                case 1:
                    System.out.print("請輸入學生個數:"); 
                    num = scanner.nextInt();
                    score = new int[num];

                    for(int i=0;i<num;i++){        
                        do{
                            System.out.printf("第%d位成績:",i+1); 
                            score[i] = scanner.nextInt();
                        } while(score[i]<0 || score[i]>100);         
                    }
                    break;
                
                case 2:
                    for(int i=0;i<score.length;i++){
                        System.out.println(score[i]); 
                    }
                    break;
            }
        } while (option!=3);        
        
    }
}
