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
public class Bookcase {
    public Book[] books;
    public String category;
    public int bookcaseNumber; //書櫃編號
    public int bookAmount; //一個書櫃書的數量
    
    public Bookcase(String category){
        books = new Book[5];
        this.category = category;
        bookcaseNumber = ++Library.bookcaseCount;
        bookAmount = 0;
    }
    
    public String toString(){
        String str = "";
        for (int i=0; i<bookAmount ; i++){           
            str += "\t" + "\t" + books[i];
        }
        return str;
    }    
}
