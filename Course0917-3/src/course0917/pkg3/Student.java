/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0917.pkg3;

/**
 *
 * @author Eka
 */
public class Student {
    private int seat;
    private int score;
    
    public Student(int score, int seat){
        this.seat = seat;
        this.score = score;
    }
    
    public int getSeat(){
        return seat;
    }
    
    public int getScore(){
        return score;
    }

}
