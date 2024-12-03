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
public class BookArrayList {
        
    private Book [] bookArr;
    private int count ;
    
    public BookArrayList(){
        bookArr = new Book[2];
        count = 0;
    }
    
    public Book[] doubleArray(Book[] arr){
        Book [] tmp =  new Book[arr.length * 2];
        for(int i = 0; i < arr.length; i++){
            tmp[i] = arr[i];
        }
       return tmp;
    }
    
    public void add(Book data){
        if(count ==  bookArr.length){
            bookArr = doubleArray(bookArr);
        }
        bookArr[count] = data;
        count++;
    }
    
    public Book get(int index){
        return bookArr[index];
    }
    
    public int getCount(){
        return count;
    }
    
    public void bubbleSortName() {
        for (int i = 1; i < count; i++) {
            for (int j = 0; j < count - i; j++) {
                if (bookArr[j].getName().compareTo(bookArr[j + 1].getName()) >= 0) {
                    swap(bookArr, j, j + 1);
                }
            }
        }
    }
    
    public void bubbleSortYear() {
        for (int i = 1; i < count; i++) {
            for (int j = 0; j < count - i; j++) {
                if (bookArr[j].getYear() > bookArr[j+1].getYear()) {
                    swap(bookArr, j, j + 1);
                }
            }
        }
    }
    
    public void swap(Book []arr, int index1,int index2){
        Book tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
    
    public Book getMax(){
        Book max = null;
        for(Book book : bookArr){
            if(book.getName().compareTo(max.getName()) > 0){
                max = book;
            }
        }
        return max;
    }
    public Book getMin(){
        Book min = null;
        for(Book book : bookArr){
            if(book.getName().compareTo(min.getName()) < 0){
                min = book;
            }
        }
        return min;
    }
    
    public int getMaxYear(){
        Book max = null;
        for(int i = 0; i < count;i++){
            if(i == 0){
                max = bookArr[0];
            }
            if(bookArr[i].getYear() > max.getYear()){
                max = bookArr[i];
            }
        }
        return max.getYear();
    }
    
    public int getMinYear(){
        Book min = null;
        for(int i = 0; i < count;i++){
            if(i == 0){
                min = bookArr[0];
            }
            if(bookArr[i].getYear() < min.getYear()){
                min = bookArr[i];
            }
        }
        return min.getYear();
    }
    
    public String toString(){
        String str = "";
        for(int i = 0; i < count; i++){
            str += bookArr[i] + "\n";
        }
//        return str.substring(0, str.length()-1);
        return str;
    }
}
