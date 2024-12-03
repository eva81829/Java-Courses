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
public class Grass extends Creature{
    private static int numer = 0;
    
    public Grass(){
        name = "Grass" + ++numer;
        ic = 'g';
        level = 1;
    }

    @Override
    public Creature move(Creature killedCreature) {
        return null;
    }
    
}
