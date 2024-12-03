/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication100;

/**
 *
 * @author Eka
 */
public class Array<T> {
    private int length;
    private int count;
    private Object[] arrayList;
    
    public Array(){
        length = 2;
        count = 0;
        arrayList = new Object[length]; //T[]不能new 只能由外面傳入
    }
    
    public boolean add(T data){
        if (count == length){
            arrayList = doubleArr();
        }
        arrayList[count++] = data;
        return true;
    }

    public boolean insert(int index, T data){//index從0開始, 假設index<=count
        if (index<0 || index > count){
            System.out.print("超過長度");
            return false;
        }        
        
        if (count == length){
            arrayList = doubleArr();
        }

        for(int i=count; i>index; i--){
            arrayList[i] = arrayList[i-1];
        }

        arrayList[index] = data;
        count++;
        return true;
    }
    
    public boolean replace(int index, T data){//index從0開始, 假設index<=count
        if (index<0 || index > count){
            System.out.print("超過長度");
            return false;
        }
        
        arrayList[index] = data;
        return true;
    }
    
    public boolean remove(int index){//index從0開始, 假設index<=count
        if (index<0 || index > count){
            System.out.print("超過長度");
            return false;
        }
        
        for(int i=index; i<count-1; i++){
            arrayList[i] = arrayList[i+1];
        }
        count--;
        return true;
    }   
    
    public Object[] doubleArr(){
            length*=2;
            Object[] arrayTmp = new Object[length];
            for(int i=0; i<count; i++){
                arrayTmp[i] = arrayList[i];
            }
        return arrayTmp;
    }
    
    public void print(){
        for(int i=0;i<count;i++){
            System.out.print(arrayList[i] + " ");
        }
        System.out.println();
    }
    
}
