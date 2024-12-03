/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice0319.sorting;

/**
 *
 * @author Eka
 */
public class Practice0319Sorting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int[] a = {1,5,0,8,2,2,9};
        bubbleSort(a);
        selectionSort(a);
        countingSort(a, 9);
    }
    
    public static void bubbleSort(int[] arr){
        for(int i=arr.length-1; i>0; i--){ //每一輪交換數列範圍
            for(int j=0; j<i; j++){ //j最多到i-1個
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void selectionSort(int[] arr){
        for(int i=0; i<arr.length-1; i++){ //每一輪被交換的值
            int min = i;
            for(int j=i; j<arr.length; j++){ //從i開始
                if(arr[j]<arr[min]){
                      min = j;
                }
            }

            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
        
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void countingSort(int[] arr, int max){
        int[] arrCount = new int[max+1];
        int[] result = new int[arr.length];
        for(int i=0; i<arr.length; i++){ //計算max之內每個數值出現幾次
            arrCount[arr[i]]+=1;
        }
        
        int last = arrCount[0];
        arrCount[0] = 0;
        for(int i=0; i<max; i++){ //計算Prefix Sum: 每個值代表前面累積了多少個數, 也就是該值插入的位置
            int tmp = arrCount[i+1];
            arrCount[i+1] = arrCount[i] + last;
            last = tmp;
        }
//        for(int i=0; i<max+1; i++){
//            System.out.print(arrCount[i] + " ");
//        }
//        System.out.println();
        
        for(int i=0; i<arr.length; i++){  //數值插入的位置即為Prefix Sum的值, 插入新的array後, Prefix Sum+1
            int index = arrCount[arr[i]]++;
            result[index] = arr[i];
        }
        
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();        
    }    
    
    public static void mergeSort(int[] arr){
        int n = arr.length;
        if(n>1){
            int[] sortedArr = new int[n];
            for(int s=1; s<n; s*=2){
//                for(int i=0; i<)
            }
        }

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();             
    }
    
    public static void merge(int[] arr, int[] sortedArr, int s1, int s2){
        
        
    }    
}
