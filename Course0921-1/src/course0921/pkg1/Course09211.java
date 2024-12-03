/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0921.pkg1;

/**
 *
 * @author Eka
 */
public class Course09211 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        NewClass n = new NewClass();
        n.c();
        
        n.new NewClass1().ac();
        new NewClass().new NewClass1().ac();
        new NewClass.NewClass2().abc();
        NewClass.newClass4();
        
        
        
        NewClass.NewClass2 n4 = new NewClass.NewClass2();        
    }
    
}
