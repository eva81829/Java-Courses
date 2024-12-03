/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0830.pkg2;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course08302 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);
        int[] ans_arr = new int[4];
        boolean error = false;
        
        do {
            error = false;
            System.out.print("Ans:  ");
            
            int ans = scanner.nextInt();  
            
            if (ans>9876||ans<123){
                error = true;
                System.out.println("錯誤");
                continue;
            }
            
            for(int i=0;i<4;i++){
                ans_arr[3-i] = ans%10;
                for(int j=0;j<i;j++){
                    if (ans_arr[3-i]==ans_arr[3-j]){
                        //System.out.print(isDup);
                        error = true;
                        break;
                    }
                }
                if (error){
                    break;
                }
                ans = ans/10;
            }
        } while(error);
        
        int[] guess_range = {0,1,2,3,4,5,6,7,8,9};

        int a=0;
        int b;
        int loop=1;
        while(a!=4 && !error){
            a=0;
            b=0;

            System.out.print("Ans:  ");
            for(int i=0;i<4;i++){
                System.out.print(ans_arr[i]);
            }
            System.out.println();
            
            System.out.print("Guess:");
            int[] guess_arr = guess(guess_range);
            
            for(int i=0;i<4;i++){
                System.out.print(guess_arr[i]);
            }
            System.out.print(" ");       

            for(int i=0;i<4;i++){
                if (ans_arr[i]==guess_arr[i]){
                    a++;
                    int tmp[] = {i};
                }
                else{
                    b += count_b(ans_arr, guess_arr[i]);
                }
            }
            
            System.out.println(loop++ + "次 " + a + "A" + b + "B");
            
            for(int i=0;i<guess_range.length;i++){
                System.out.print(guess_range[i]);
            }
            System.out.print(" ");                   
            
            if(a+b==4){
            guess_range = guess_arr;
            } else if (a==0 && b==0){
            guess_range = adj_guess_range(guess_range);
            }
            
        }
        System.out.println("恭喜答對"); 
    }
    
    
    
   
    public static int[] adj_guess_range(int[] guess_range){
        int[] tmp = new int[guess_range.length-4];
        for (int i=0; i<tmp.length; i++){
            tmp[i] = guess_range[i+4];
        }
        return tmp;
    }
    
    public static int[] guess(int[] guess_range){
        int[] ans_arr = new int[4];
        
        for(int i=0;i<4;i++){
            int swap = (int)(Math.random()*(guess_range.length - i) + i);
            int tmp = guess_range[i];
            ans_arr[i] = guess_range[i] = guess_range[swap];
            guess_range[swap] = tmp;
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
