/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice0312.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Eka
 */
public class Practice0312Arrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String[] days2 = {new String("Monday"), "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        System.out.println(days==days2); // days, days2是不同的array 有不同的位址, 但裡面直接用""宣告的字串都存在String pool
        System.out.println(days[0]==days2[0]); //days2[0] => new String("Monday") 是另外開一個空間, 不是存在String pool
        System.out.println(days[1]==days2[1]); //皆在String pool
        
        String[] days3; 
        days3 = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}; //宣告的結果等同於days, 只是用 new String[]可以在第二行宣告
        System.out.println(days[0]==days3[0]); //皆在String pool
        
        String[] days4 = new String[2];
        days4[0] = "Monday";
        System.out.println(days[0]==days4[0]); //皆在String pool
        days4[0] = new String("Monday");
        System.out.println(days2[0]==days4[0]); //皆不在String pool
        days4[1] = new String("Tuesday");
        System.out.println(days[1]==days4[1]); //days4[1]不在String pool
        
        String str1 = "ABC";
        String str2 = new String("ABC");
        System.out.println(str1==str2); //str2的ABC不在String pool
        str2 = str2.intern();
        System.out.println(str1==str2); //str2.intern() => 將原本str2的ABC在String pool中創出來並回傳, 把str2指向String pool的ABC
        
        int[] array = {1,2,3,5,7,4};
        reverse(array);
        for(int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
        
        int[] a = {1,2,3};
        LinkedList<Integer> c = new LinkedList<>(Arrays.asList(1,2,3));
       
    }
    
    public static void reverse(int[] array){
        int n = array.length;
        for(int i=0; i<n/2; i++){
            int temp = array[i];
            array[i] = array[n - 1 - i];
            array[n - 1 - i] = temp;
        }
    }
    
    public static int[] solution1(int[] A, int K) {
    // write your code in Java SE 11

    int n = A.length;
    if (n==0){
        return A;
    }

    for(int i=0; i<K; i++){
        int j = A[n - 1];
        for(int k=n-1; k>0; k--){
            A[k] = A[k-1];
        }
        A[0] = j;
    }

    return A;
    }
    
    public static int solution2(int[] A) {
        // write your code in Java SE 11
        
        List<Integer> list = new LinkedList<>();
        for(int i: A){
            list.add(i);
        }
        
        for(int i=0; i<list.size(); i++){
            int a = list.get(i);
            if(i==list.size()-1){
                return a;
            }
            
            for(int j=i+1; j<list.size(); j++){
                int b = list.get(j);
                if(a == b){
                    list.remove(j);
                    break;
                } else if(j == list.size()-1){
                    return a;
                }
            }
        }
        
        return -1;
    }
    
    public static int solution3(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<A.length; i++){
            if(set.contains(A[i])){
                set.remove(A[i]);
            } else{
                set.add(A[i]);
            }
        }
        return Integer.valueOf(set.toString());
    }
    
    public static int solution4(int[] A) {   
            HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<A.length; i++){
            if(set.contains(A[i])){
                set.remove(A[i]);
            } else{
                set.add(A[i]);
            }
        }
        
        Iterator it = set.iterator();
        return (Integer) it.next();
    }
}
