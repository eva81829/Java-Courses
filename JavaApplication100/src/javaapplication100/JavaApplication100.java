/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication100;

/**
 *
 * @author Eka
 */
public class JavaApplication100 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Array<Integer> array = new Array<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.print();
        array.insert(4,5);
        array.print();
        array.remove(0);
        array.print();
        array.replace(3,3);
        array.print();
    }
    
    
}
