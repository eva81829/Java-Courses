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
public class Slime implements Heal, DoubleAttacked, Attacked{
    public static final int restoreMin = 40;
    public static final int restoreMax = 80;
    public static final int attackMin = 40;
    public static final int attackMax = 80;    
    public static final int hpMin = 50;
    public static final int hpMax = 200;     
    public int hp;
    public int atk;
    
    public Slime(){
        this.hp = random(hpMin, hpMax);
        this.atk = random(attackMin, attackMax);
    }

    @Override
    public int getHp(){
        return hp;
    }   
    
    @Override
    public void heal(){
        hp += random(restoreMin, restoreMax);
    }
    @Override
    public void attacked(){
        hp -= random(attackMin, attackMax);
    }
    @Override
    public void doubleAttacked(){
        hp -= 1.5 * random(attackMin, attackMax);
    }
    
    public static int random(int min, int max){
        return (int)(Math.random() * (max - min + 1) + min);
    }
    
}
