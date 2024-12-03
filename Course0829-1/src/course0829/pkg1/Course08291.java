/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0829.pkg1;

/**
 *
 * @author Eka
 */
public class Course08291 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    f(5);    
    f(4);
    int b = f1(5);
    System.out.println("b" + b);
    
    }
    
    public static void f(int x){
        if (x<1){
            return;
        }
        System.out.println(x);
    }
   
    public static int f1(int x){
        if(x>1){
        System.out.println(x);
           return 1;
        } else {
           return 0;
        }
    }      
    
}
