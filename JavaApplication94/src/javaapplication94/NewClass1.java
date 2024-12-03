/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication94;

/**
 *
 * @author Eka
 */
public class NewClass1 extends NewClass{
    public NewClass1(){
        //父類別的內部類別之型別: (父類別.)父類別之內部類別.parameter
        A abcde = new A();
        NewClass.A abcdef = new A();
        NewClass.A abcdefg = new NewClass(). new A();
        NewClass.A abcdefgh = new NewClass.A();
        
        N nnn = new N();
        NewClass.N nnnn = new NewClass.N();
//        NewClass.N nnnnn = new NewClass(). new N(); //=> 錯誤
    }
}
