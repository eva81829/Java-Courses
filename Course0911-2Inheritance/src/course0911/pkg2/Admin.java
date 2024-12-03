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
public class Admin extends Staff{
    private String jobContent;
    
    public Admin(String name, int year, int month, int date,int phone, String jobContent){
        super(name, year, month, date, phone);
        this.jobContent = jobContent;
    }
    
    @Override
    public String toString(){
        return getName() + " " + getYear() + "/" + getMonth() + "/" + getDate() + getPhone() + " " + jobContent;
    }
    
}
