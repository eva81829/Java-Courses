/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0919.pkg1;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course09191 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner (System.in);
        LinkList linklist = new LinkList();
        int data;
        int index;
        
        do{
            System.out.print("請輸入選項:");
            int opt = scanner.nextInt();
            
            switch (opt) {
                case 1:
                    System.out.print("請輸入值:");
                    data = scanner.nextInt();
                    linklist.add(data);
                    break;
                case 2:
                    System.out.print("請輸入位址:");
                    index = scanner.nextInt();
                    System.out.print("請輸入值:");
                    data = scanner.nextInt();
                    linklist.insert(data, index);
                    break;
                case 3:
                    System.out.print("請輸入位址:");
                    index = scanner.nextInt();
                    linklist.remove(index);
                    break;
                case 4:
                    System.out.print("請輸入位址:");
                    index = scanner.nextInt();
                    System.out.println(linklist.getNode(index).getData());
                    break;
                case 5:
                    System.out.println(linklist);
            }
        } while (true);
    }

}
