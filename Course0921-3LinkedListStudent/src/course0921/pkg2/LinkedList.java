/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0921.pkg2;

/**
 *
 * @author Eka
 */
public class LinkedList {
    private class Student {
        private String name;
        private String number;
        private int score;
        private Student next;
        
        public Student(String name, String number, int score){
            this.name = name;
            this.number = number;
            this.score = score;
        }
    }
    
    private Student firstStudent;
    private Student lastStudent;
    private int count;
    
    public LinkedList(){
        count = 0;
    }
    
    public void addStudent(String name, String number, int score){
        if (count == 0){
            initialize(name, number, score);
            return;
        }
        
        lastStudent.next = new Student(name, number, score);
        lastStudent = lastStudent.next;
        count++;
    }
    
    public void insertStudent(String name, String number, int score, int index){
        if (index < 0 || index > count){
            System.out.println("index out of bound");
            return;
        } else if (index == count){
            addStudent(name, number, score);
            return;
        } else if (index == 0){
            Student student = new Student(name, number, score);
            student.next = firstStudent;
            firstStudent = student;
            count++;
            return;
        }
        
        Student studentNew = new Student(name, number, score);
        Student previous = getStudentByIndex(index - 1);
        studentNew.next = previous.next;
        previous.next = studentNew;
        count++;
    }
    
    public void modifyStudent(String name, String number, int score, int index){
        if (index < 0 || index >= count){
            System.out.println("index out of bound");
            return;
        }
        
        Student student = getStudentByIndex(index);
        student.name = name;
        student.number = number;
        student.score = score;
    }

    public void modifyScore(String number, int score){
        Student student = getStudentByNumber(number);
        if (student == null){
            System.out.println("number out of bound");
            return;
        }
        
        student.score = score;
    }
    
    public void removeScore(String number){
        Student student = getStudentByNumber(number);
        if (student == null){
            System.out.println("number out of bound");
            return;
        }
        
        student.score = -1;
    }    
    
    
    public void removeStudent(int index){
        if (index < 0 || index >= count){
            System.out.println("index out of bound");
            return;
        } else if (index == 0){
            firstStudent = firstStudent.next;
            count--;
            return;
        }
        
        Student student = getStudentByIndex(index - 1);
        student = student.next.next;
        count--;
    }
    
    private boolean checkStudentNumber(String number){
        if (firstStudent == null){
            return true;
        }
        
        Student student = firstStudent;
        for(int i=0; i<count; i++){
            if (number.equals(student.number)){
                System.out.println("number is duplicated");
                return false;
            }
            student = student.next;
        }
        return true;
    }
    
    private Student getStudentByNumber(String number){
        Student student = firstStudent;
        for(int i=0; i<count; i++){
            if (number.equals(student.number)){
                return student;
            }
            student = student.next;
        }
        return null;
    }
    
    private Student getStudentByIndex(int index){
        Student student = firstStudent;
        for(int i=0; i<index; i++){
            student = student.next;
        }
        return student;
    }
    
    public void initialize(String name, String number, int score){
        firstStudent = new Student(name, number, score);
        lastStudent = firstStudent;
        count++;
    }    
    
    public String toString(){
        String str = "";
        Student student = firstStudent;
        for(int i=0; i<count; i++){
            str += student.name + " " + student.number + " " + student.score + "\n";
            student = student.next;
        }
        return str;
    }
    
}
