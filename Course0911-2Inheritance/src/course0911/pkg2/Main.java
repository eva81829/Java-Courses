/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0911.pkg2;

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
        Staff staff = new Staff("A", 2000, 9, 11, 0123);
        Admin admin = new Admin("B", 1992, 8, 29, 0124, "工程師");
        Teacher teacher = new Teacher("C", 1999, 1, 1, 0125, "數學");
        Student student = new Student("D", 1990, 12, 12, 0126, 6350547, 100);
        
        int opt;
        do{
            System.out.print("請輸入選項:");
            Scanner scanner = new Scanner(System.in);
            opt = scanner.nextInt();
            
            if(opt==3){
                break;
            }
            
            switch (opt){
                case 1:
                    staff = new Staff("A", 2000, 9, 11, 0123);
                    admin = new Admin("B", 1992, 8, 29, 0124, "工程師");
                    teacher = new Teacher("C", 1999, 1, 1, 0125, "數學");
                    student = new Student("D", 1990, 12, 12, 0126, 6350547, 100);                    
                    break;
                case 2:
                    System.out.println(staff);
                    System.out.println(admin);
                    System.out.println(teacher);
                    System.out.println(student);                    
            }
        } while(true);
        
        
    }
    
    
    
}
