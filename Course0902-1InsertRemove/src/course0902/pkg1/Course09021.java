/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0902.pkg1;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course09021 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[2];
        int index = 0;
        do{
            int n = check(scanner);
            if (n==-1){
                break;
            }
            if (index==arr.length){
                arr = expand(index, arr);
            }
            arr[index++] = n;
        } while (true);
         
        do {
            System.out.print("請輸入選項:");
            int opt = scanner.nextInt();
            int n;            
            
            switch (opt){
                case 1:
                    for(int i=0;i<index;i++){
                        System.out.print(arr[i]);
                        System.out.print(" ");
                    }
                    System.out.println();
                    break;

                case 2:
                    n = check(scanner);
                    if (index==arr.length){
                        arr = expand(index, arr);
                    }
                    arr[index++] = n;
                    break;

                case 3:
                    System.out.print("請輸入編號:");
                    n = scanner.nextInt();

                    for(int i=n;i<arr.length-1;i++){
                        arr[i] = arr[i+1];
                    }
                    index--;
            }
        } while (true);
    }
    
    public static int check(Scanner scanner){
        int n;
        do {
            System.out.print("請輸入正整數:");
            n = scanner.nextInt();
            if (n>=-1){
                break;
            } else{
                System.out.println("錯誤");
            }
        } while (true);
        return n;
    }
    
    public static int[] expand(int index, int[] arr){
        int[] tmp = new int[arr.length*2];
            for(int i=0;i<arr.length;i++){
                tmp[i] = arr[i];
            }
        return tmp;
    }
    
}
