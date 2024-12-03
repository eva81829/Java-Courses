/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice102002bufferedrw;

/**
 *
 * @author billy
 */
public class Student {

    private int grade;
    private int score;
    private int seat;
    private String name;

    public Student(int grade, int seat, int score, String name) {
        this.grade = grade;
        this.score = score;
        this.name = name;
        this.seat = seat;
    }

    public String toString() {
        return grade + " grade " + "No." + seat + " " + name + " is " + score;
    }
}
