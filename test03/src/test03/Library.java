/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test03;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Library {
    public Bookcase[] bookcases;
    public static int bookcaseCount = 0; //書櫃總數
    public static int bookCount = 0; //書的總數
    
    public Library(){
        bookcases = new Bookcase[5];
    }
    
    public void genBookcase(String category){
        if (bookcaseCount == bookcases.length){
            doubleArr();
        }
        bookcases[bookcaseCount] = new Bookcase(category);
    }
    
    public void doubleArr(){
        Bookcase[] bookcases = new Bookcase[this.bookcases.length * 2];
        for (int i=0; i<bookcaseCount ;i++){
            bookcases[i] =  this.bookcases[i];
        }
        this.bookcases = bookcases;
    }
    
    public void genBook(String category, String bookName){
        for (int i=0; i<bookcaseCount; i++){
            if (bookcases[i].category.equals(category) && (bookcases[i].bookAmount < 5)){
                Book book = new Book(category, bookName);
                bookcases[i].books[bookcases[i].bookAmount++] = book;
                return;
            }
        }
        System.out.println("無法新增");
    }
    
    public void addBookDetail(int bookNumber, Scanner scanner){
        for (int i=0; i<bookcaseCount; i++){
            for (int j=0; j<bookcases[i].bookAmount; j++){
                if (bookcases[i].books[j].bookNumber == bookNumber){
                    do {
                        System.out.print("請輸入年份:");
                    } while (!bookcases[i].books[j].setYear(scanner.nextInt()));
                    
                    do {
                        System.out.print("請輸入月份:");
                    } while (!bookcases[i].books[j].setMonth(scanner.nextInt()));
                    return;
                }
            }
        }
        System.out.println("無法新增");
    }
    
    public void searchBook(String bookName){
        for (int i=0; i<bookcaseCount; i++){
            for (int j=0; j<bookcases[i].bookAmount; j++){
                if (bookcases[i].books[j].bookName.equals(bookName)){
                    System.out.print(bookcases[i].books[j]);
                    return;
                }
            }
        }
        System.out.println("查無此書");
    }    
    
    public String toString(){
        String str = "";
        for (int i=0; i<bookcaseCount; i++){
            if(bookcases[i].bookAmount == 0){
                continue;
            } 
            str += "分類:" + bookcases[i].category + " 書櫃:" + bookcases[i].bookcaseNumber + "\n" +  bookcases[i];
        }
        return str;
    }
    
    public String print(String category){
        String str = "";
        for (int i=0; i<bookcaseCount; i++){
            if(bookcases[i].bookAmount == 0 || !bookcases[i].category.equals(category)){
                continue;
            }
            str += "\t書櫃:" + bookcases[i].bookcaseNumber + "\n" +  bookcases[i];
        }
        
        if (str.equals("")){
            return "查無此分類";
        }
        
        return str;
    }    
    
}
