/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0923.pkg4list;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course09234List {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("請輸入選項:");
            int opt = scanner.nextInt();
            scanner.nextLine();
            
            if (opt == 3){
                break;
            } else if (opt == 1){
                List list1 = new ArrayList();
                do {
                    System.out.print("請輸入文字:");
                    String str = scanner.nextLine();
                    if (str.equals("-1")){
                        System.out.print(list1);
                        break;
                    }
                    list1.add(str);
                } while (true);
            } else if (opt == 2){
                List list2 = new LinkedList();
                do {
                    System.out.print("請輸入文字:");
                    String str = scanner.nextLine();
                    if (str.equals("-1")){
                        System.out.print(list2);
                        break;
                    }
                    list2.add(str);
                } while (true); 
            }
        } while (true);
        
    }
    
}
