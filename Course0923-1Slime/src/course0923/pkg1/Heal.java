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
public interface Heal extends SlimeSkill{

    /**
     *
     */
    @Override
    public void heal();
    public int getHp();
}
