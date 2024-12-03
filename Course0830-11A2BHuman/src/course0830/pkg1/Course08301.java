/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0830.pkg1;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course08301 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);

        int[] ans_arr = ans();
        int a;
        int b;
        int loop=1;
        do{
            a=0;
            b=0;

            System.out.print("Ans  :");
            for(int i=0;i<4;i++){
                System.out.print(ans_arr[i]);
            }
            System.out.println(); 
            
            System.out.print("Guess:");
            int guess = scanner.nextInt();
            int guess_arr[] = new int[4];
            boolean isDup = false;
            
            if (guess>9876||guess<123){
                System.out.println("錯誤");
                continue;
            }
            
            for(int i=0;i<4;i++){
                guess_arr[3-i] = guess%10;
                for(int j=0;j<i;j++){
                    if (guess_arr[3-i]==guess_arr[3-j]){
                        //System.out.print(isDup);
                        isDup = true;
                        break;
                    }
                }
                if (isDup){
                    break;
                }
                guess = guess/10;
            }
            
            if (isDup){
                System.out.println("錯誤");
                continue;
            }
            
//            System.out.print("Guess:");
//            for(int i=0;i<4;i++){
//                System.out.print(guess_arr[i]);
//            }
//            System.out.println();        
            
            for(int i=0;i<4;i++){
                if (ans_arr[i]==guess_arr[i]){
                    a++;
                }
                else{
                    b += count_b(ans_arr, guess_arr[i]);
                }
            } 

            System.out.println(loop++ + "次 " + a + "A" + b + "B");   
        } while(a!=4);
       
       System.out.println("恭喜答對"); 
       
    }
    
    
    public static int[] ans(){
        int[] num_arr = {0,1,2,3,4,5,6,7,8,9};
        int[] ans_arr = new int[4];
        
        for(int i=0;i<4;i++){
            int swap = (int)(Math.random()*(10 - i) + i);
            int tmp = num_arr[i];
            ans_arr[i] = num_arr[i] = num_arr[swap];
            num_arr[swap] = tmp;
        }
        
        return ans_arr;
    }
    
    public static int count_b(int[] ans_arr, int guess){
        int count=0;
            for(int i=0;i<4;i++){
                if(guess==ans_arr[i]){
                    count++;
                    break;
                }
            }

        return count;
    }
    
}
