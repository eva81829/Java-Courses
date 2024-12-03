/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0929.pkg2foreachgenerics;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course09292ForEachGenerics {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Iterator.Consumer<Integer> action = new Iterator.Consumer<Integer>(){
            @Override
            public void function(Integer data){
                System.out.println(data);
            }
        };
        
        List<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(123);
        list.replace(0,7);
        
        Iterator.forEach(list, action);
//        
//        action = new Iterator.Consumer<String>(){
//            @Override
//            public void function(String data){
//                System.out.println(data);
//            }
//        };        
//        
//        list = new LinkedList<String>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//
//        Iterator.forEach(list, action);
        
    }
    
}