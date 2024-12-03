/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0911.pkg4;

/**
 *
 * @author Eka
 */
public class Animal {
    private String name;
    private int seq;
    private float weight;
    
    public Animal (String name, float weight){
        this.name = name;
        this.weight = weight;
        seq = name.charAt(0);
    }
    
    public String getName(){
        return name;
    }

    public int getSeq(){
        return seq;
    }

    public float getWeight(){
        return weight;
    }    
    
    public String toString(){
        return name + " " + seq + " " + weight;
    }    
    
}
