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
public class SortA implements Sort{
    
    @Override
    public boolean compareSeat(Student student1, Student student2){
        if (student1.getSeat()> student2.getSeat()){
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean compareScore(Student student1, Student student2){
        if (student1.getScore()> student2.getScore()){
            return true;
        }
        
        return false;
    }    
    
}
