/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice0316.countingelements;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author Eka
 */
public class Practice0316CountingElements {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        float abc = (2 + 2 + 5 + 1) / 4.0f;
        System.out.println(abc);
        
        int[] array = {0,0,4,2,4,5};
        //已經知道值的範圍是在0~5
        countArray(array, 5);
        
        //不知道值的範圍
        int[] num = new int[2];
        int[] count2 = new int[2];
        int index = 0;
        
        for(int i=0; i<array.length; i++){
            int j;
            for(j=0; j<index; j++){
                if(array[i] == num[j]){
                    count2[j] += 1;
                    break;
                }
            }
            if(j==index){
                    if(index == num.length){
                        num = doubleArray(num);
                        count2 = doubleArray(count2);
                    }
                    
                    num[index] = array[i];
                    count2[index++] = 1;
                }
        }
        
        for(int i=0; i<index; i++){
            System.out.print(num[i] + " ");
        }
        System.out.println();
        for(int i=0; i<index; i++){
            System.out.print(count2[i] + " ");
        }
        
        //不知道值的範圍
        HashMap map = new HashMap();
        for(int i=0; i<array.length; i++){
            int key = array[i];
            if(map.containsKey(key)){
                int value = (Integer) map.get(key) + 1;
                map.replace(key, value);
            } else{
                map.put(array[i], 1);
            }
        }
        
        System.out.println();
        for(Object key: map.keySet()){
            System.out.print(key + " ");
        }
        System.out.println();
        for(Object value: map.values()){
            System.out.print(value + " ");
        }
        
//        int[] a1 = {1,8,5}; //14 -3
//        int[] a2 = {1,2,5}; //8 3
        
        int[] a1 = {7,7}; //6 1
        int[] a2 = {6,6}; //8 -1
        System.out.println(swapTwoArray(a1, a2, 8));
        System.out.println(swapTwoArray(a1, a2));
        
        String a = "123";
        System.out.print(a.substring(0,3));
    }
    
    public static int[] doubleArray(int[] array){
        int n = array.length;
        int[] copy = new int[n*2]; 
        for(int i=0; i<n; i++){
            copy[i] = array[i];
        }
        return copy;
    } 
    
    public static int[] countArray(int[] array, int m){
        int[] count1 = new int[m+1];
//        for(int i=0; i<m; i++){ //可省
//            count1[i] = 0;
//        }
        for(int i=0; i<array.length; i++){
            count1[array[i]] = count1[array[i]]+1;
        }
        for(int i=0; i<m; i++){
            System.out.print(count1[i] + " ");
        }
        System.out.println();
        return count1;
    } 
    
    public static boolean swapTwoArray(int[] array1, int[] array2, int m){
        boolean result = false;
        int total1=0, total2=0;
        for(int i: array1){
            total1+=i;
        }
        for(int i: array2){
            total2+=i;
        }
        
        int total = total1+total2;
        if(total%2==1){
            return result;
        }
        
        int diff = total/2 - total2;
        int[] countArr = countArray(array1, m); 
        for(int i=0; i<array2.length; i++){
            if(array2[i]+diff>=0 && array2[i]+diff<m && countArr[array2[i]+diff]>0){
                result = true;
                break;
            }
        }
        return result;
    }
    
    public static boolean swapTwoArray(int[] array1, int[] array2){
        boolean result = false;
        int total1=0, total2=0;
        HashSet set = new HashSet();
        for(int i: array1){
            total1+=i;
            set.add(i);
        }
        for(int i: array2){
            total2+=i;
        }
        
        int total = total1+total2;
        if(total%2==1){
            return result;
        }        
        
        int diff = total/2-total2;
        for(int i=0; i<array2.length; i++){
            if(set.contains(array2[i]+diff)){
                result = true;
                break;
            }
        }
        return result;
    }
    
    public static int frogRiverOne(int X, int[] A) {
        // write your code in Java SE 11
        
        HashSet set = new HashSet();
        for(int i=1; i<X+1; i++){
            set.add(i);
        }
        
        for(int i=0; i<A.length; i++){
            set.remove(A[i]);
            if(i>=X-1 && set.isEmpty()){
                return i;
            }
        }
        return -1;
    }
    
    public static int[] maxCounters(int N, int[] A) {
        // write your code in Java SE 11
        
        int[] counter = new int[N];
        int max = 0;
        int sum = 0;
        for(int i=0; i<A.length; i++){
            if(A[i]==N+1){
                counter = new int[N];
                sum += max;
                max = 0;
            }else{
                counter[A[i]-1]+=1;
                if(counter[A[i]-1]>max){
                    max = counter[A[i]-1];
                }
            }
        }
        
        for(int i=0; i<N; i++){
            counter[i]+=sum;
        }
        return counter;
    }
    
    public static int[] maxCounters2(int N, int[] A) {
        // write your code in Java SE 11
        
        int[] counter = new int[N];
        int max = 0;
        int last = 0;
        for(int i=0; i<A.length; i++){
            if(A[i]==N+1){
                last = max;
            }else{
                if(counter[A[i]-1]<last){
                    counter[A[i]-1]=last+1;
                }else{
                    counter[A[i]-1]+=1;
                }
                
                if(counter[A[i]-1]>max){
                    max = counter[A[i]-1];
                }
            }
        }
        
        for(int i=0; i<N; i++){
            if(counter[i]<last){
                counter[i] = last;
            }
        }
        return counter;
    }
    
    public static int missingInteger(int[] A) {
        // write your code in Java SE 11
        
        HashSet set = new HashSet();
        int max = -1;
        for(int i=0; i<A.length; i++){
            set.add(A[i]);
            if(A[i]>max){
                max = A[i];
            }
        }
        
        int i=1;
        for(i=1; i<max; i++){
            if(!set.contains(i)){
                return i;
            }
        }
        
        if(max<=0){
            return 1;
        }
        return i+1;
    }
    
    public static int permCheck(int[] A) {
        // write your code in Java SE 11
        
        HashSet set = new HashSet();
        for(int i=0; i<A.length; i++){
            set.add(A[i]);
        }
        
        for(int i=0; i<A.length; i++){
            if(!set.contains(i+1)){
                return 0;
            }
        }
        
        return 1;
    }
    
    public static int[] genomicRangeQuery(String S, int[] P, int[] Q) {
        // write your code in Java SE 11
        
        int[][] location = new int[3][];
        location[0] = new int[S.length() + 1];
        location[1] = new int[S.length() + 1];
        location[2] = new int[S.length() + 1];
        
        for(int i=0; i<S.length(); i++){
            char ch = S.charAt(i);
            int a,c,g;
            a=c=g=0;
            switch(ch){
                case 'A':
                    a = 1;
                    break;
                case 'C':
                    c = 1;
                    break;
                case 'G':
                    g = 1;
            }
            
            location[0][i+1] = location[0][i] + a;
            location[1][i+1] = location[1][i] + c;
            location[2][i+1] = location[2][i] + g;
        }
        
        int[] result = new int[P.length];
        for(int i=0; i<P.length; i++){
            int j;
            for(j=0; j<3; j++){
                int p = P[i];
                int q = Q[i]+1;
                if(location[j][q]-location[j][p]>0){
                    break;
                }
            }
            result[i] = j + 1;
        }
        
        return result;
    }
    
    public static int minAvgTwoSlice(int[] A) {
        // write your code in Java SE 11
        
        int[] sum = new int[A.length+1];
        for(int i=0; i<A.length; i++){
            sum[i+1] = sum[i] + A[i];
        }
        
        float min = 0.0f;
        int index=0;
        for(int i=0; i<A.length-1; i++){
            for(int j=i+1; j<A.length; j++){
                
                float tmp = (sum[j+1] - sum[i])/(float)(j+1-i);
                if(tmp<min || (i==0&&j==1)){
                    min = tmp;
                    index = i;
                    // System.out.print(min + " ");
                    // System.out.print(i + " ");
                    // System.out.println(j);
                }
            }           
        }
        return index;
    }
    
    public static int minAvgTwoSlice2(int[] A) {
        // write your code in Java SE 11
        
        int[] sum = new int[A.length+1];
        for(int i=0; i<A.length; i++){
            sum[i+1] = sum[i] + A[i];
        }
        
        float min = 0.0f;
        int index=0;
        for(int i=0; i<A.length-1; i++){
            float tmp1 = (sum[i+2] - sum[i])/2.0f;
            float tmp2 = 0.0f;
            if(i!=A.length-2){
                tmp2 = (sum[i+3] - sum[i])/3.0f;
            }
            
            
            float tmp = tmp1;
            if(tmp2<tmp && i!=A.length-2){
                tmp = tmp2;
            }
            if(tmp<min || i==0){
                min = tmp;
                index = i;
                // System.out.print(min + " ");
                // System.out.println(i + " ");
            }
        }
        return index;
    }
    
    public static int solution(int[] A) {
        // write your code in Java SE 11
        
        int[] sum = new int[A.length+1];
        for(int i=0; i<A.length; i++){
            sum[i+1] = sum[i] + A[i];
        }
        
        long result = 0;
        for(int i=0; i<A.length-1; i++){
            if(A[i]==0){
                result+=sum[A.length]-sum[i+1];
                if(result>1000000000){
                    return -1;
                }
            }
        }
        return (int)result;
    }
}
