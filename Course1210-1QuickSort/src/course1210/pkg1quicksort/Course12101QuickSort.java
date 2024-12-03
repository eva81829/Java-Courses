/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course1210.pkg1quicksort;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course12101QuickSort {
    static int count = 0;
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
        
        int[] intArray = {1,3,5,4,2};
        
        quickSort(intArray, 0, intArray.length - 1);
        print(intArray, 0, intArray.length - 1, -1);
    }
    
    public static void quickSort(int[] intArray, int start, int end){ //start, end 代表要排序的起始值, 到最後一個值的範圍
        int pivotIndex = start;
        int maxIndex = start+1; //欲找的最大值max, 從pivotIndex+1開始找
        int minIndex = end; //欲找的最小值min, 從end開始找
        if(end-start>=1){
//            System.out.println("start:"+ start);
//            System.out.println("end:"+ end);
            System.out.println("count:" + ++count);
            print(intArray, start, end, pivotIndex);
            
            while(true){
                while(!(intArray[maxIndex] > intArray[pivotIndex] || maxIndex == minIndex)){ //如果不符合條件就繼續找(條件:找到>於||max=min)
                    maxIndex++;
                }
//                System.out.println("maxIndex:"+ maxIndex);
                
                while(!(intArray[minIndex] < intArray[pivotIndex] || maxIndex == minIndex)){
                    minIndex--; 
                }
//                System.out.println("minIndex:"+ minIndex);

                
                if(maxIndex == minIndex){
                    if(end-start==1){
                        swap(intArray, pivotIndex, minIndex);
                        break;
                    }
                    minIndex--;
                    swap(intArray, pivotIndex, minIndex);
//                    print(intArray, start, end, minIndex);
                    break;
                }
                swap(intArray, minIndex, maxIndex);

            }
            print(intArray, start, end, minIndex);
            quickSort(intArray, start, minIndex-1);
            quickSort(intArray, maxIndex, end);
        }
    }

    public static void print(int[] intArray, int start, int end, int pivot){
        for(int i=start; i<=end; i++){
            if(i==pivot){
                System.out.print("\u001B[31m" + intArray[i] + (i!=end? " ": "\n" ) + "\u001B[0m");
            }else{
                System.out.print(intArray[i] + (i!=end? " ": "\n" ));
            }
        }
    }
    
    public static void swap(int[] intArray, int a, int b){
        int tmp = intArray[a];
        intArray[a] = intArray[b];
        intArray[b] = tmp;       
    }

}