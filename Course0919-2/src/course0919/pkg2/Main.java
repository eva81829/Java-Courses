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
    public static void main(String[] args){
        // TODO code application logic here
        
        LinkList linklist = new LinkList();
        linklist.add(1);
        linklist.add(2);
        linklist.add(4);
        linklist.add(5); 
        
        ForEach.forEach(linklist);
        //System.out.println(data);
    }
    

    
    

}
