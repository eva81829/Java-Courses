/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test09;

/**
 *
 * @author Eka
 */
public class Student {
    private int serialNumber;
    private String Name;
    
    public Student(int serialNumber, String Name){
        this.serialNumber = serialNumber;
        this.Name = Name;
    }
    
    public int getSerialNumber(){
        return serialNumber;
    }
    public String getName(){
        return Name;
    }    
}
