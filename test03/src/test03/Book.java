/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test03;

/**
 *
 * @author Eka
 */
public class Book {
    public String bookName;
    public String category;
    public int bookNumber; //書的編號
    private int year;
    private int month;
    
    public Book(String category, String bookName){
        this.bookName = bookName;
        this.category = category;
        bookNumber = ++Library.bookCount;
        year = 0; 
        month = 0;
    }
    
    public boolean setYear(int year){
        if (year>=1970 && year<=3000){
            this.year = year;
            return true; 
        }
        return false;
    }    

    public boolean setMonth(int month){
        if (month>=1 && month<=12){
            this.month = month;
            return true; 
        }
        return false;
    }

    public String toString(){
        if (year==0 || month==0){
            return bookNumber + " " + bookName + "/" + category + "\n";
        } else{
            return bookNumber + " " + bookName + "/" + category + " " + year + "/" + month + "\n";
        }
        
    }
    
}
