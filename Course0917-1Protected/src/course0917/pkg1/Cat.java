/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0917.pkg1;

/**
 *
 * @author Eka
 */
public class Cat extends Animal{
    public int a;
    public Cat(){
        a = 3;
        super.a = 567;
    }
    
    public int getter(){
        c = a;
        return a;
    }
    
    public int getterA(){
        return super.a;
    }    

    protected void testA(){
        System.out.println("???");
    }    
}
