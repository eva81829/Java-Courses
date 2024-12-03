/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Test09 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        type(scanner);
        
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1,"測試1"));
        students.add(new Student(4,"測試2"));
        students.add(new Student(3,"測試3"));
        students.add(new Student(2,"測試9"));
        
        compare(students, new CompareMax());
//        int index = 0;
//        for (int i=1 ; i<4; i++){
//            index = students.get(i).getSerialNumber() > students.get(index).getSerialNumber() ? i : index;
//        }
//        System.out.println(students.get(index).getSerialNumber() + "," + students.get(index).getName());
        
        write(students);
        students = read();
        
        compare(students, new CompareMin());
//        index = 0;
//        for (int i=1 ; i<4; i++){
//            index = students.get(i).getSerialNumber() < students.get(index).getSerialNumber() ? i : index;
//        }
//        System.out.println(students.get(index).getSerialNumber() + "," + students.get(index).getName());
    }
    
    public static ArrayList<Student> read(){
        ArrayList<Student> students = new ArrayList<>();
        //FileReader fr = ;
        try{
            BufferedReader br = new BufferedReader(new FileReader("src/students.txt"));
            while(br.ready()){
                String[] strs = br.readLine().split(",");
                students.add(new Student(Integer.valueOf(strs[0]), strs[1]));
            }
            br.close();
        } catch (IOException e){
        } 
            //catch (FileNotFoundException ex){
//        }
        return students;
    }

    public static int type(Scanner scanner){
        do {
            try{
                System.out.print("請輸入數字:");
                int typed = scanner.nextInt();
                return typed;
            } catch (InputMismatchException e){
                System.out.println("錯誤");
            }
            scanner.nextLine();
        } while(true);
    }
    
    public static void write(ArrayList<Student> students){
        try{
            int count = 0;
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/students.txt"));
            while(count < students.size()){
                bw.write(students.get(count).getSerialNumber() + "," + students.get(count++).getName() + "\n");
            }
            bw.close();
        } catch (IOException e){
        }
    }
    
    public static void compare(ArrayList<Student> students, CompareAB compareAB){
        int index = 0;
        for (int i=1 ; i<4; i++){
            index = compareAB.getResult(students.get(i).getSerialNumber(), students.get(index).getSerialNumber()) ? i : index;
        }
        System.out.println(students.get(index).getSerialNumber() + "," + students.get(index).getName());        
    }
    
    public interface CompareAB{
        public boolean getResult(int a, int b);
    }
    
    public static class CompareMax implements CompareAB{
        @Override
        public boolean getResult(int a, int b){
            if (a > b){
                return true;
            }
            return false;
        }
    }
    
    public static class CompareMin implements CompareAB{
        @Override
        public boolean getResult(int a, int b){
            if (a < b){
                return true;
            }
            return false;
        }
    }    
   
    
}
