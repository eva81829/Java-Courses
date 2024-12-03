/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test03;

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
        Library library1 = new Library();
        int opt;
        do{
            System.out.print("請輸入選項:");
            opt = scanner.nextInt();
            scanner.nextLine();
            switch(opt){
                case 1:
                    System.out.print("請輸入分類:");
                    library1.genBookcase(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("請輸入分類:");
                    String str1 = scanner.nextLine();
                    System.out.print("請輸入書名:");
                    String str2 = scanner.nextLine();
                    library1.genBook(str1, str2);
                    break;
                case 3:
                    System.out.print("請輸入書籍編號:");
                    library1.addBookDetail(scanner.nextInt(), scanner);
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.print("請輸入書名:");
                    library1.searchBook(scanner.nextLine());
                    break;
                case 5:
                    System.out.print(library1);
                    break;
                case 6:
                    System.out.print("請輸入分類:");
                    System.out.print(library1.print(scanner.nextLine()));
                    break;
            }
        } while(true);
        
        
        
        
        /*
        
        String strA = "A"; 
        String strB = "B"; 
        String strC = "C";
        String strD = "D"; 
        
        Library library1 = new Library();
        library1.genBookcase(strA);
        library1.genBookcase(strB);
        
        library1.genBook(strA, strC);
        library1.genBook(strB, strD);

        //library1.addBookDetail(1 , scanner);
        library1.searchBook("");
        
        System.out.print(library1);
        System.out.println(library1.print("B"));
        */
        
    }
    
    
    
    
}
