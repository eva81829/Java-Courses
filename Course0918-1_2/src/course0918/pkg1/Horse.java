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
public class Horse extends Creature {
    private static int numer = 0;
    public int[] direction;

    public Horse() {
        setName("Horse" + ++numer);
        setIc('H');
        setLevel(2);
    }

}
