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
public class SortB implements Sort{
    
    @Override
    public boolean compareSeat(Student student1, Student student2){
        if (student2.getSeat()> student1.getSeat()){
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean compareScore(Student student1, Student student2){
        if (student2.getScore()> student1.getScore()){
            return true;
        }
        
        return false;
    }    
    
}
