/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice0311.iterations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Practice0311Iterations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        //n! 迴圈
        System.out.print("請輸入整數:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 1;
        for(int i=1; i<=n ; i++){
            sum = sum * i;
        }
        System.out.println(sum); //只能到30!，因為會超過int的數值範圍
        
        //n! 遞迴
        System.out.print("請輸入數字:");
        Scanner scanner2 = new Scanner(System.in);
        int n2 = scanner2.nextInt();
        System.out.println(recursive(n2));
        
        //星狀圖1
        System.out.print("請輸入數字:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i=0; i<n; i++){
            for(int j=0; j<i+1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        
        //星狀圖2
        System.out.print("請輸入數字:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                System.out.print(" ");
            }        
            for(int j=0; j<2*(n-1-i) + 1; j++){
                System.out.print("*");
            }
         
            System.out.println();
        }
        
        //計算幾位數
        System.out.print("請輸入數字:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result=1;
        while(n>9){
            n/=10;
            result++;
        }
        System.out.println(result);

        
        //Fibonacci numbers: 0, 1, 1, 2, 3, 5...
        System.out.print("請輸入數字:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i=0;
        System.out.print(i+ " ");
        int j=1;
        while(j<=n){
            System.out.print(j+ " ");
            int temp = j;
            j+=i;
            i=temp;
        }      
        
        //印出陣列中的所有值
        //String[] days = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for (int i=0; i< days.length; i++){
            System.out.println(days[i]);
        }
        
        for(String day: days){
            System.out.println(day);
        }
        
        //印出字典中的所有值
        HashMap<String, String> hashmap = new HashMap<>();
        hashmap.put("mon","Monday");
        hashmap.put("tue","Tuesday");
        hashmap.put("wed","Wednesday");
        hashmap.put("thu","Thursday");
        hashmap.put("fri","Friday");
        hashmap.put("sat","Saturday");
        hashmap.put("sun","Sunday");
        
        for(String key: hashmap.keySet()){
            System.out.println(key + " stands for " + hashmap.get(key));
        }
        
        */
    }
    
    public static int recursive(int n){
        if(n==1){
            return 1;
        }
        return n * recursive(--n);
    }
    
    //Binary Gap
    public static int solution(int N) {
        // write your code in Java SE 11
        
        int[] binary = new int[10000];
        int i=0;
        while(N>0){
            binary[i++] = N%2;
            N/=2;
            //System.out.println(binary[i-1]);
        }
        
        boolean start = false;
        int gap = 0;
        int temGap = 0;
        for(i=0; i<binary.length; i++){
           if(binary[i]==1 && !start){
               start = true;
           } else if(binary[i]==1 && start){
               if(temGap>gap){
                   gap = temGap;
               }
               temGap=0;
           } else if(binary[i]==0 && start){
              if(start){
                 temGap++;
              }
           }
        }
        return gap;
    }
    
    //Binary Gap
    public static int solution2(int N) {
        // write your code in Java SE 11
        
        ArrayList<Integer> binary = new ArrayList<>();
        
        int i=0;
        while(N>0){
            binary.add(0, N%2);
            i++;
            N/=2;
            //System.out.println(binary[i-1]);
        }
        
        boolean start = false;
        int gap = 0;
        int temGap = 0;
        for(i=0; i<binary.size(); i++){
           if(binary.get(i)==1 && !start){
               start = true;
           } else if(binary.get(i)==1 && start){
               if(temGap>gap){
                   gap = temGap;
               }
               temGap=0;
           } else if(binary.get(i)==0 && start){
              if(start){
                 temGap++;
              }
           }
        }
        return gap;
    }    
    
}
