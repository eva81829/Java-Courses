/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import course0917.pkg1.Cat;

/**
 *
 * @author Eka
 */
public class main {
    Cat cat = new Cat();
       
    public static void main(String[] args) {
        Dog dog = new Dog();
        //dog.test(); //這個main class沒有extends Animal 不是Animal的子類別, 無法呼叫test()function
    }
}
