/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0820_2tax;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int age, marriage, salary;
        Scanner scanner = new Scanner(System.in);
        System.out.print("age:");
        age = scanner.nextInt();
        
        System.out.print("marriage:");
        marriage = scanner.nextInt();
        
        System.out.print("salary:");
        salary = scanner.nextInt();
        
        System.out.print("tax:");
        
        salary = salary - 128000;

        if (age < 70){
            salary = salary - 88000;
        }
        else{
            salary = salary - 132000;
        }
        
        if (marriage == 0){
        salary = salary - 90000;
        }
        else if (marriage == 1){
        salary = salary - 180000;
        }
        
        if (salary <= 0){
            System.out.println(0);
        }
        else{
            float tax = 0;
            if (salary <= 540000){
                tax = salary * 0.05f;
            } else if(salary <= 1210000){
                tax = salary * 0.12f - 37800;
            } else if(salary <= 2420000){
                tax = salary * 0.2f - 134600;
            } else if(salary <= 4530000){
                tax = salary * 0.3f - 376600;
            } else if(salary <= 10310000){
                tax = salary * 0.4f - 829600;
            } else if(salary > 10310000){
                tax = salary * 0.45f - 1345100;
            }
          
            if (tax <= 0){
            System.out.println(0);
            }
            else{
                System.out.println(tax);
            }
        }
        }
}
