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
public class Student extends Staff{
    private long number;
    private float score;
    
    public Student(String name, int year, int month, int date,int phone, long number, long score){
        super(name, year, month, date, phone);
        this.number = number;
        this.score = score;
    }
    
    @Override
    public String toString(){
        return getName() + " " + getYear() + "/" + getMonth() + "/" + getDate() + getPhone() + " " + number + " " + score;
    }    
    
    
}
