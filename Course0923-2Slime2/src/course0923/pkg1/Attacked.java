/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0923.pkg1;

/**
 *
 * @author Eka
 */
public class Attacked implements Skill{
    public void useSkill(Slime myself, Slime enemy){
        int hp = enemy.getHp() - myself.getAtk();
        enemy.setHp(hp);
    }
}
