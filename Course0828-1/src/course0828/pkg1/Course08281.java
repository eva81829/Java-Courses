/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0828.pkg1;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course08281 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        int arr[] = new int[2];
        int i = 0;
        int n;
        do {
            n = scanner.nextInt();
            if (n == -1){
                break;
            }
            if (i == arr.length){
                int tmpArr[] = new int[arr.length * 2];
                for (int j = 0; j < arr.length; j++){
                    tmpArr[j] = arr[j];
                }
                arr = tmpArr;
            }
            arr[i++] = n;
        } while (true);   
        
        for (int j = 0; j < i; j++){
            System.out.print(arr[j] + " ");
        }
        System.out.println();
    }
}
