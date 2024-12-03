/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0923.pkg2builder;

/**
 *
 * @author Eka
 */
public class Student {
    private String name;
    private String birth;
    private String phone;
    private String lineId;
    private int score1;
    private int score2;
    private int score3;
    
    private Student(String name, String birth, String phone){
        this.name = name;
        this.birth = birth;
        this.phone = phone;
    }
    
    public static class Builder{
        private Student student;
        public Builder(String name, String birth, String phone){
            student = new Student(name, birth, phone);
        }
        public Builder setLineId(String lineId){
            student.lineId = lineId;
            return this;
        } 
        public Builder setScore1(int score1){
            student.score1 = score1;
            return this;
        }
        public Builder setScore2(int score2){
            student.score2 = score2;
            return this;
        }      
        public Builder setScore3(int score3){
            student.score3 = score3;
            return this;
        }
        public Student gen(){
            Student tmp = student;
            student = null;
            return tmp;
        }        
    } 
    
    
}
