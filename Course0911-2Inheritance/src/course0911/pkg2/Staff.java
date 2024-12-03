/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0911.pkg2;

/**
 *
 * @author Eka
 */
public class Staff {
    private String name;
    private int year;
    private int month;
    private int date;
    private int phone;
    
    public Staff(String name, int year, int month, int date, int phone){
        this.name = name;
        this.year = year;
        this.month = month;
        this.date = date;
        this.phone = phone;
    }
    
    @Override
    public String toString(){
        return name + " " + year + "/" + month + "/" + date + " " + phone;
    }
    
    public int getYear(){
        return year;
    }
    
    public int getMonth(){
        return month;
    }
    
    public int getDate(){
        return date;
    }
    
    public String getName(){
        return name;
    }
    
    public int getPhone(){
        return phone;
    }        
    
}
