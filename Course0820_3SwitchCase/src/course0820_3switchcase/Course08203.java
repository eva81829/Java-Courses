/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0820_3switchcase;

/**
 *
 * @author Eka
 */
public class Course08203 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
        123
        */
        
        int a = 99;
        switch (a){
            case 1:
                System.out.println("1");
                break;
            case 99:
                System.out.println("99");
                break;
            default://前面都不符合才會進入default
                System.out.println("default");
                break;           
        }
        
        int b = 9;
        b = b + b++ ;
        System.out.println(b);
        }
    }
}
