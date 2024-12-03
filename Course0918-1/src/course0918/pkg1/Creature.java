/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0918.pkg1;

/**
 *
 * @author Eka
 */
public abstract class Creature {
    public String name;
    public char ic;    
    public int level;
    public int life;
    public boolean moved;
    
    public Creature(){
        life = 5;
        moved = true;
    }
    
    public abstract Creature move(Creature killedCreature);
    
    public Creature checkLife(){
        if (life == 1){
            return null;
        }
        life--;
        return this;
    }
    
}
