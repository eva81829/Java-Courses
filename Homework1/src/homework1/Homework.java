/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework1;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Homework {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        int n = input(scanner, "學生個數");
        int[][] student = new int[n][3];
        int count = 0;
        while (count != n){
            student[count][0] = input(scanner, "座號");
            student[count++][1] = input(scanner, "成績");
        }
        
        int opt;
        do{
            opt = input(scanner, "選項(1~4)");
            if (opt<1 || opt>4){
                continue;
            } else if (opt==4){
                break;
            }
            
            switch (opt){
                case 1:
                    sort(student, 0);
                    break;
                case 2:
                    sort(student, 1);
                    break;
                case 3:
                    mess(student);
            }
        } while (true);
    }
    
    public static void sort(int[][] student, int category){
        for (int i=0;i<student.length-1;i++){
            for (int j=0;j<student.length-1-i;j++){
                if (student[j][category] > student[j+1][category]){
                    swap(student, j, j+1);
                }
            }
        }
        print(student);
    }
    
    public static void mess(int[][] student){
        for(int i=0; i<student.length-1; i++){
            int swap = (int)(Math.random()*(student.length-i) + i);
            swap(student, i, swap);
        }
        print(student);
    }
    
    public static void swap(int[][] student, int index, int swap){
        int[] tmp = student[index];
        student[index] = student[swap];
        student[swap] = tmp;
    }
    
    public static void print(int[][] student){
        for (int i=0;i<student.length;i++){
            System.out.println("座號:" + student[i][0] + " 成績:" + student[i][1]);
        }
    }
    
    public static int input(Scanner scanner, String str){
        System.out.print("請輸入" + str + ":");
        return scanner.nextInt();
    }
    
}
