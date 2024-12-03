/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice102002bufferedrw;

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
 * @author billy
 */
public class Practice102002BufferedRW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = reader("1");
        writer("1");
        for (Student student : students) {
            System.out.println(student);
        }
//        System.out.print("type something: ");
//        int n = type(scanner);
//        System.out.println(n);
    }

    public static int type(Scanner scanner) {
        int n;
        do {
            try {
                n = scanner.nextInt();
                if (n > 0) {
                    break;
                }
            } catch (InputMismatchException ex) {
                System.out.print("type again: ");
            }
            scanner.nextLine();
        } while (true);
        return n;
    }

    public static void writer(String name) {
        try {
            System.out.println("!");
            BufferedWriter bw = new BufferedWriter(new FileWriter(name + ".txt", true));
            bw.write("1,2,3,pf");
            bw.newLine();
            bw.write("1,12,3,wo");
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            System.out.println("error");
            ex.printStackTrace();
        }
    }

    public static ArrayList<Student> reader(String name) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(name + ".txt"));
            ArrayList<Student> students = new ArrayList<>();
            while (br.ready()) {
                String[] strs = br.readLine().split(",");
                if (strs.length < 4) {
                    continue;
                }
                Student student = new Student(
                        Integer.valueOf(strs[0]),
                        Integer.valueOf(strs[1]),
                        Integer.valueOf(strs[2]),
                        String.valueOf(strs[3]));
                students.add(student);
            }
            br.close();
            return students;
        } catch (FileNotFoundException ex) {

        } catch (IOException e) {
        }
        return null;
    }

}
