/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0822.pkg2;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course08222 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        int n;
        n = scanner.nextInt();
        int i = 0, sum = 0;
        while(i<=n){
            sum = sum + i;
            i++;
        }
        System.out.println("總和:" + sum);
        
        i=n-1;
        int result;
        String ans="Yes";
        while(i>Math.sqrt(n)){
            result = n%i--;
            if (result == 0){
                ans = "No";
            }
        }
        System.out.println("是否為質數:" + ans);
        
        Boolean isPrime = false;
        if (ans=="Yes"){
            isPrime=true;
        }
            
    //三元運算子 (condition)?/成立後得到的值:不成立後得到的值
        System.out.println((ans=="Yes")?"是質數":"不是質數");
        System.out.println((isPrime)?"是質數":"不是質數");
        
    int a=0;
    do{
        System.out.println(a);
        a++;
    }while(a<10);        
    
    
    }
}
