/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice0317.prefixsums;

/**
 *
 * @author Eka
 */
public class Practice0317PrefixSums {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int[] a = {2,3,4,62,2,6,2,5};
        int total = sum(a, 6, 7);
        System.out.println(total);
 
        int[] b = {2,3,6};
        total = mushroom(b, 1, 6);
        System.out.println(total);
    }
    
    public static int perfix(int[] a, int p) {
        // TODO code application logic here
       
        int sum = 0;
        for(int i=0; i<p; i++){
            sum+=a[i];
        }
        return sum;
    }
    
    public static int sum(int[] a, int i, int j) { //i左邊, j右邊
        // TODO code application logic here
        return perfix(a, j+1) - perfix(a, i);
    }
    
    public static int mushroom(int[] a, int k, int m) {
        // TODO code application logic here
        
        int max=0;
        for(int i=k-m; i<=k;i++){
            if(i<0){
                continue;
            }
            
            int iDiff = k-i;
            int left = m - iDiff;
            
            int d1 = m - 2 * iDiff;
            int d2 = left/2;
            int jDiff = d1;
            if(d2>d1){
                jDiff = d2;
            }
            int j = k + jDiff;
            if(j>=a.length){
                j=a.length-1;
            }
            
            int sum = sum(a, i, j);
            if(sum>max){
                max = sum;
            }
        }
        
        return max; 
    }
    
    public static int countDiv(int A, int B, int K) {
        if(A==B){
            if(A%K==0){
                return 1;   
            }
            return 0;
        }
        
        int count = (B-A+1)/K;
        int left = (B-A+1)%K;
        
        if(left!=0){
            int i = A;
            int j = A+left-1;
            
            if(i%K==0 || j%K==0 || j/K-i/K==1){
                count++;
            }
        }
        return count;
    }    
    
}
