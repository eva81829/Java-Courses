/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0827.pkg4;

/**
 *
 * @author Eka
 */
public class Course08274 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 3, m = 4;
        int arr[][] = new int[3][];
        
        for (int i = 0; i < arr.length; i++){ //length為[3]這個陣列的長度,也就是3
            arr[i] = new int[i+2]; //創造[][],[][][],[][][][]的陣列
        }
        System.out.println(arr[0].length); //[][]陣列為二
    }
    
}
