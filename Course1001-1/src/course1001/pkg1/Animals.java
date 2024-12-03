/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course1001.pkg1;

/**
 *
 * @author Eka
 */
public class Animals {
    private Animal animals[] = new Animal[3];
    
    public Animal getAnimal(int index){
        return animals[index];
    }
    
    public void setAnimal(int index){
        animals[index] = new Animal();
    }    
    
}
