/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0917.pkg3;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course09173 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);
        
        Student[] students = new Student[2];
        int count = 0;
        
        do{
            System.out.print("請輸入成績:");
            int score = scanner.nextInt();
            if (score == -1){
                break; 
            } else if (score > 100 || score < 0){
                continue;   
            } else if (count == students.length){
                students = doubleArr(students,count);
            }
            students[count] = new Student(score, ++count);
        }
        while(true);
        
        int opt;
        do{
            System.out.print("請輸入選項:");
            opt = scanner.nextInt();
            
            if(opt == 4){
                break;
            } else if (opt > 4 || opt < 1 ){
                continue;
            }
            
            switch (opt){
                case 1:
                    SortSeat(students, count, new SortA());
                    print(students, count);
                    break;
                case 2:
                    SortScore(students, count, new SortB());
                    print(students, count);
                    break;
                case 3:
                    random(students, count);
                    print(students, count);
            }
        }  while(true);
    }
    
    public static Student[] doubleArr(Student[] students, int count){
        Student[] tmp = new Student[count*2];
        for (int i = 0; i < count; i++){
            tmp[i] = students[i];
        }
        return tmp;
    }

    public static void SortSeat(Student[] students, int count, Sort sort){
        for (int i=0; i<count-1; i++){
            for (int j=0; j<count-1-i; j++){
                if (sort.compareSeat(students[j], students[j+1])){
                    Student tmp = students[j];
                    students[j] = students[j+1];
                    students[j+1] = tmp;
                }
            }
        }
    }    
    
    public static void SortScore(Student[] students, int count, Sort sort){
        for (int i=0; i<count-1; i++){
            for (int j=0; j<count-1-i; j++){
                if (sort.compareScore(students[j], students[j+1])){
                    Student tmp = students[j];
                    students[j] = students[j+1];
                    students[j+1] = tmp;
                }
            }
        }
    }
    
    public static void random(Student[] students, int count){
        for (int i=0; i<count-1; i++){
            int swap = (int)(Math.random()*(count-i) + i);
            Student tmp = students[i];
            students[i] = students[swap];
            students[swap] = tmp;
        }
    }    
    
    public static void print(Student[] students, int count){
        for (int i=0; i<count; i++){
            System.out.print(students[i].getSeat() + " " + students[i].getScore());
            System.out.println();            
        }
    }
    
}
