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
public class School {

    public Classroom[] classrooms;
    public static int classroomCount = 0;

    public School() {
        classrooms = new Classroom[5];
    }

    public void addClassroom() {
        if (classroomCount == classrooms.length) {
            Classroom[] tmp = new Classroom[classrooms.length + 5];
            for (int i=0; i<classrooms.length; i++){
                tmp[i] = classrooms[i];
            }
            classrooms = tmp;
        }
        classrooms[classroomCount++] = Classroom.genClassroom();
    }
    
    public void assignStudent() {
        Student student = new Student();
        student.name = Classroom.inputString("學生名稱");
        int studentGrade = Classroom.inputInt("年級");        
        
        for (int i=0; i<classroomCount; i++){
            if (studentGrade == classrooms[i].grade && classrooms[i].studentCount <4){
                student.seat = classrooms[i].studentCount;
                classrooms[i].students[classrooms[i].studentCount++] = student;
                return;
            }
        }
        
        System.out.println("無法新增");
    }
    
    public void addScore() {
        int studentGrade = Classroom.inputInt("年級");
        String className = Classroom.inputString("班級名稱");
        int seat = Classroom.inputInt("座號");        
        
        for (int i=0; i<classroomCount; i++){            
            if (className.equals(classrooms[i].name) && studentGrade == classrooms[i].grade){
                if (seat <= classrooms[i].studentCount) {
                    classrooms[i].students[seat].score = Classroom.inputInt("成績"); 
                    return;
                }
                break;
            }
        }        

        System.out.println("無法新增");
    }
        
        
    public void search() {
        String name = Classroom.inputString("姓名");

        for (int i=0; i<classroomCount; i++){            
            if (name.equals(classrooms[i].teacher)){
                System.out.println(name + "/帶領 " + classrooms[i].grade + " 年級 " + classrooms[i].name + " 班");
                return;
            }
            
            for (int j=0; j<classrooms[i].studentCount; j++){
                if (name.equals(classrooms[i].students[j].name)){
                    System.out.println(name + "/所屬 " + classrooms[i].grade + " 年級 " + classrooms[i].name + " 班 成績:" + classrooms[i].students[j].score + " 分");
                    return;
                }
            }
        }
    }
    
    public String toString() {
        String str = "";
        for (int i=0; i<classroomCount; i++){
            str += classrooms[i];
        }
        return str;
    }
    
}
