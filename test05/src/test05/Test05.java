/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test05;

/**
 *
 * @author Eka
 */
public class Test05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList linkedList= new LinkedList();
        
        for (int i=0; i<4 ; i++){
            int number = i+1;
            int year = (int)(Math.random() * 50 + 1970);
            int month = (int)(Math.random() * 12 + 1);
            int day = (int)(Math.random() * 28 + 1);
            linkedList.add("book" + number, "author" + number, year, month, day);            
        }
        
//        linkedList.print();
//        linkedList.remove(2);
//        linkedList.print(2);
//
//        linkedList.modify(1, 1, "John");        
//        linkedList.modify(0, 2, 2000);
//        
//        linkedList.print(0);   
//        linkedList.print(1);
    }
    
}
