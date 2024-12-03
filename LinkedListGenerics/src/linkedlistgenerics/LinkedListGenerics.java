/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistgenerics;

/**
 *
 * @author Eka
 */
public class LinkedListGenerics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Linked<Integer> array = new Linked<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.print();        
        array.insert(3,5);       
        array.print();
        array.insert(2,6);
        array.print();
        array.add(8);
        array.print();
        array.remove(6);
        array.print();
        array.replace(5,9);
        array.print();        
    }
    
}
