/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0904.pkg4;

/**
 *
 * @author Eka
 */

public class Student {    
    public int seat;
    public String name;
    private int score = 0;
    
    public void setScore(int score){
        if (score<0 || score>100){
            this.score = 0;
        } else{
            this.score = score;
        }
    }
    
    public int getScore(){
        return score;
    }
    
}
