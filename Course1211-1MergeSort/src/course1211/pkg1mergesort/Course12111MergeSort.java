/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course1211.pkg1mergesort;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course12111MergeSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        System.out.print("請輸入一數列(用空白分隔):"); //如果第一個為空格, 則split後第一個值為null
//        Scanner scanner = new Scanner(System.in);
//        String[] stringArray = scanner.nextLine().split(" ");
//        int[] intArray = new int[stringArray.length];
//        for(int i=0; i<stringArray.length; i++){
//            intArray[i] = Integer.valueOf(stringArray[i]);
//        }
        
        int[] intArray = {25,38,11,5,22,77,3,9,20,92,6,33,15,38,11,5,21,77,3,9,20,92};
        new MergeSort(intArray);
        MergeSort.print("sorted", intArray);
    }
    
}
