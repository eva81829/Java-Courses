/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication20191018;

/**
 *
 * @author asdfg
 */
public class ArrayListMyself {
    
    private String [] arr;
    private int count ;
    
    public ArrayListMyself(){
        arr = new String[2];
        count = 0;
    }
    
    public String[] doubleArray(String[] arr){
        String [] tmp =  new String[arr.length * 2];
        for(int i = 0; i < arr.length; i++){
            tmp[i] = arr[i];
        }
       return tmp;
    }
    
    public void add(String data){
        if(count ==  arr.length){
            arr = doubleArray(arr);
        }
        arr[count] = data;
        count++;
    }
    
    public String get(int index){
        return arr[index];
    }
    
    public int getCount(){
        return count;
    }
    
    public void bubbleSort() {
        for (int i = 1; i < count; i++) {
            for (int j = 0; j < count - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) >= 0) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
    
    public void swap(String []arr, int index1,int index2){
        String tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
    
    public String getMax(){
        String max = "";
        for(String str : arr){
            if(str.compareTo(max) > 0){
                max = str;
            }
        }
        return max;
    }
    public String getMin(){
        String min = "龘";
        for(String str : arr){
            if(str.compareTo(min) < 0){
                min = str;
            }
        }
        return min;
    }
}
