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
public class Book {
    private String name;
    private int year;
    private int month;
    private int day;
    
    public Book(String name, int year, int month, int day){
        this.name = name;
        this.year= year;
        this.month = month;
        this.day = day;
    }
    
    public String getName(){
        return name;
    }
    
    public int getYear(){
        return year;
    }
    
    @Override
    public String toString(){
        return "書名: " + name + " 出版日期" + "(" 
                + year + "/" 
                + (month >= 10 ? month : ("0" + month)) + "/" 
                + (day >= 10 ? day : ("0" + day)) + ")";
    }
}
