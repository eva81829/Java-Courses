/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0904.pkg3;

import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        IntegerArray a = new IntegerArray();
        int n;
        do{
            n = scanner.nextInt();
            if(n == -1){
                break;
            }
            a.add(n);
        }while(true);
        System.out.println(a);        
        
        
    }
    
}
