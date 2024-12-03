/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0919.pkg2;

import java.util.ArrayList;

/**
 *
 * @author Eka
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static class Fun3 implements Function{
        public void function(int data){
            System.out.println("666");
        }
        
        public static class Fun5 implements Function{
            public void function(int data){
                System.out.println("abcdefg");
            }
        }
    }    
    
    
    public static void main(String[] args){
        // TODO code application logic here
        new Fun3();
        
        List linklist = new LinkList();
        linklist.add(1);
        linklist.add(2);
        linklist.add(4);
        linklist.add(5); 
        
        Function fun1 = new Fun1();
        Function fun2 = new Fun2();
        ForEach.forEach(linklist, fun1);
        ForEach.forEach(linklist, fun2);
        ForEach.forEach(linklist, new Fun3());
        ForEach.forEach(linklist, new Fun3.Fun5());
    }
 
}
