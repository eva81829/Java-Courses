/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import course0917.pkg1.Animal;

/**
 *
 * @author Eka
 */
public class Dog extends Animal{
    protected int b;

    public Dog(){
        System.out.println("?????");
        test(); //這個class是Animal的子類別, 而test() 是protected, 即使不同package, 只要有import Animal pkg就可用, 相同package則能直接呼叫, 如同public
        a = 3;
    }

}
