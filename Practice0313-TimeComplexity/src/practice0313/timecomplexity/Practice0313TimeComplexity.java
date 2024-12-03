/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice0313.timecomplexity;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Practice0313TimeComplexity {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //1+2+...n
        System.out.print("請輸入數字:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = (1+n)*n/2;
        System.out.println("Sum:"+sum);
        
    }
    
    public static int frogJmp(int X, int Y, int D) {
        // write your code in Java SE 11
        
        if((Y-X)%D==0){
            return (Y-X)/D;
        }
        return (Y-X)/D+1;
    }
    
    public static int permMissingElem(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for(int i: A){
            set.add(i);
        }
        
        for(int i=A.length+1; i>0; i--){
            if(!set.contains(i)){
                return i;
            }
        }
        return -1;
    }    
    
    public static int TapeEquilibrium(int[] A) {
        // write your code in Java SE 11
        
        int sum=-1;
        for(int P=1; P<A.length; P++){
            int a,b,temp;
            a=b=temp=0;
            
            for(int i=0; i<A.length; i++){
                if(i<P){
                    a+=A[i]; 
                }else{
                    b+=A[i];
                }
            }
            
            temp = Math.abs(a-b);
            if(sum==-1 ||temp<sum){
                sum = temp;
            }
            //System.out.println(temp);
        }
        return sum;
    }    

    public static int TapeEquilibrium2(int[] A) {
        // write your code in Java SE 11
        int total=0;
        for(int i:A){
            total+=i;
        }
        
        int sum=-1;
        int a=0;
        for(int P=1;P<A.length;P++){
            a+=A[P-1];
            int temp = Math.abs(a - (total - a));
            if(sum==-1 || temp<sum){
                sum = temp;
            }
        }
        return sum;        
    }       
    
}
