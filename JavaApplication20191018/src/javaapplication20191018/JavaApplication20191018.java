/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication20191018;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asdfg
 */
public class JavaApplication20191018 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // 例外處理
        // => 使用者輸入中文不能crash要重新輸入
        // => ArrayList 有一些情況 超出範圍 不會crash
        // 檔案處理
        // => 讀txt, 寫txt(字串切割)
        // => 字串切換後儲存成特定型別的ArrayList 排序 找最大最小
        Scanner scanner = new Scanner(System.in);
//        System.out.println(inputNumber(scanner));
//----------------------------------------------------------------------
//        ArrayList<Integer> arrayList = new ArrayList();
//        arrayList.add(60);
//        arrayList.add(91);
//        arrayList.add(82);
//        arrayList.add(43);
//        do{
//            System.out.print("插入在 n: ");
//            try{
//                int n = scanner.nextInt();
//                arrayList.add(n,n);
//                System.out.println(n);
//                break;
//            }catch(IndexOutOfBoundsException ex){
//                System.out.println("輸入超出範圍，請重新輸入，你是不是智障");
//            }catch(InputMismatchException ex){
//                System.out.println("請不要輸入數字以外的東西好不好，滾!");
//                scanner.nextLine();
//            }            
//        }while(true);
//----------------------------------------------------------------------
//        ArrayListMyself arr = new ArrayListMyself();
//        arr.add("我");
//        arr.add("龜");
//        arr.add("龍");
//        arr.add("笨");
//        arr.bubbleSort();
//        for(int i = 0; i < arr.getCount(); i++){
//            System.out.println(arr.get(i));
//        }
//        System.out.print("找最大: ");
//        System.out.println(arr.getMax());
//        System.out.print("找最小: ");
//        System.out.println(arr.getMin());
//----------------------------------------------------------------------
//        try{
//            BufferedWriter bw = new BufferedWriter(new FileWriter("寫檔.txt"));
//            for(int i = 0 ;i < 10; i++){
//                bw.write((int)(Math.random()*50 + 1970)+
//                        "/"+(int)(Math.random()*12 + 1)+
//                        "/"+(int)(Math.random()*30 + 1));
//                bw.newLine();
//            }
//            bw.close();
//        }catch(IOException ex){
//            ex.printStackTrace();
//        }
        
//        try {
//            BufferedReader br = new BufferedReader(new FileReader("寫檔.txt"));
//            String str = "";
//            while(br.ready()){   
//                str = br.readLine();
//                System.out.println(str);
//            } 
//        }catch (FileNotFoundException ex) {
//            Logger.getLogger(JavaApplication20191018.class.getName()).log(Level.SEVERE, null, ex);
//        }catch (IOException ex) {
//            Logger.getLogger(JavaApplication20191018.class.getName()).log(Level.SEVERE, null, ex);
//        }
//------------------------------------------------------------------
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("寫檔.txt"));
            for(int i = 0 ;i < 10; i++){
                bw.write("book"+(int)(Math.random()*30 +1)+
                        "/"+(int)(Math.random()*50 + 1970)+
                        "/"+(int)(Math.random()*12 + 1)+
                        "/"+(int)(Math.random()*30 + 1));
                bw.newLine();
            }
            bw.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        
//        ArrayList<Book> bookArray = new ArrayList<>();
//        bookArray = getBook("寫檔");
//        for(Book book:bookArray){
//            System.out.println(book);
//        }
        BookArrayList bookArray = getBookMyselfArray("寫檔");
        System.out.println(bookArray);
        System.out.println("----------------------------------------");
        bookArray.bubbleSortYear();
        System.out.println(bookArray);
        System.out.println("----------------------------------------");
        System.out.println(bookArray.getMaxYear());
        System.out.println("----------------------------------------");
        System.out.println(bookArray.getMinYear());
        
    }
    
    public static int inputNumber(Scanner scanner){
        int n;
        do{
            try{
                n = scanner.nextInt();
                if(n > 0){
                    break;
                }
            }catch(InputMismatchException ex){
                System.out.println("請不要輸入數字以外的東西好不好");
                scanner.nextLine();
                continue;
            }
            System.out.println("請不要輸入小於零求求你");
        }while(true);
        return n;
    }
    
    public static ArrayList<Book> getBook(String file){
        try {
            BufferedReader br = new BufferedReader(new FileReader(file +".txt"));
            ArrayList<Book> bookArray = new ArrayList<>();
            while(br.ready()){
                String [] bookData = br.readLine().split("/");
                if(bookData.length < 4){
                    continue;
                }
                Book book = new Book(bookData[0],
                Integer.valueOf(bookData[1]),
                Integer.valueOf(bookData[2]),
                Integer.valueOf(bookData[3])
                );
                bookArray.add(book);
            }
            return bookArray;
        } catch (FileNotFoundException ex) {
            System.out.println("找不到檔案");
            Logger.getLogger(JavaApplication20191018.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("寫入失敗");
            Logger.getLogger(JavaApplication20191018.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static BookArrayList getBookMyselfArray(String file){
        try {
            BufferedReader br = new BufferedReader(new FileReader(file +".txt"));
            BookArrayList bookArray = new BookArrayList();
            while(br.ready()){
                String [] bookData = br.readLine().split("/");
                if(bookData.length < 4){
                    continue;
                }
                Book book = new Book(bookData[0],
                Integer.valueOf(bookData[1]),
                Integer.valueOf(bookData[2]),
                Integer.valueOf(bookData[3])
                );
                bookArray.add(book);
            }
            return bookArray;
        } catch (FileNotFoundException ex) {
            System.out.println("找不到檔案");
            Logger.getLogger(JavaApplication20191018.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("寫入失敗");
            Logger.getLogger(JavaApplication20191018.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
