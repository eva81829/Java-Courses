/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0903.pkg1;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course09031 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("陣列個數:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            System.out.print("請輸入陣列第" + (i+1) + "值:");
            arr[i] = scanner.nextInt();
        }
        System.out.print("請輸入欲查找的值:");
        int key = scanner.nextInt();

        int ans = binarySearch (arr, 0, n-1, key);
        System.out.println(ans);
    }
    
    public static int binarySearch(int[] arr, int left, int right, int key){        
        int mid = (left + right)/2;
        if (key==arr[mid]){
            return mid;
        } 
        
        if (left>=right){
            return -1;
        }
        
        if(key>arr[mid]){
            return (binarySearch(arr, mid+1, right, key));
        } else {
            return (binarySearch(arr, left, mid-1, key));
        }
        
    }
    
}
