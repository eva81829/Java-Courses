/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0827.pkg1;

/**
 *
 * @author Eka
 */
public class Course08271 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int[] array = {20, 7, 6, 4, 8};
        for (int i=0;i<array.length-1;i++){ //每次確定一個最右邊的值, 做4(n-1)次, 就可確定5個值的大小
            for (int j=0;j<array.length-1-i;j++){ //每次判斷是否交換j,j+1兩個值, 做(n-1-i)次才能確定哪一個是最大的放最右邊
                 int tmp = array[j];
                 if (array[j+1]>array[j]){
                    array[j] = array[j+1];
                    array[j+1] = tmp;                     
                 }
            }  
        }
        for(int i=0;i<array.length;i++){
            System.out.print(array[i] + " ");
        }
        
    }
    
}
