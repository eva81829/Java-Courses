/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0921.pkg2;

/**
 *
 * @author Eka
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        LinkedList linkedList = new LinkedList();
        linkedList.addStudent("1", "1", 100);
        System.out.print(linkedList);
        linkedList.addStudent("2", "2", 80);
        System.out.print(linkedList);        
        
    }
    
}
