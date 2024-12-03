/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0909.pkg1;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Classroom {
    public String name;
    public int grade;
    public String teacher;
    public Student[] students;
    public int studentCount;
    public static int max;
    public static int min;

    public static Classroom genClassroom(){
        Classroom classroom = new Classroom();
        classroom.name = inputString("班級名稱");
        classroom.grade = inputInt("年級");
        classroom.teacher = inputString("教師名稱");
        classroom.students = new Student[5];
        classroom.studentCount = 0;
        return classroom;
    }
    
     
    public static String inputString(String string){
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入"+ string + ":");
        return scanner.nextLine();
    }
    
    public static int inputInt(String string){
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入"+ string + ":");
        return scanner.nextInt();
    }
    
    public String toString() {
        String str = "";
        
        if (max<min){
            for (int i=0; i<studentCount; i++){
                str += "\t" + students[i].seat + "號:" + students[i].name + " 成績:" + students[i].score + " 分" + "\n";
            }            
        } else{
            for (int i=0; i<studentCount; i++){
                if (students[i].score>= min && students[i].score<=max){
                    str += "\t" + students[i].seat + "號:" + students[i].name + " 成績:" + students[i].score + " 分" + "\n";
                }
            }
        }

        if(!str.equals("")){
            str = grade + " 年級 " + name + " 班 授課老師:" + teacher + "\n" + str;
        }        
        return str;
    }

    
}
