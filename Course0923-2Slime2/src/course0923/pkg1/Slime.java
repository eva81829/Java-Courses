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
public class Slime{
    public static final int healMin = 40;
    public static final int healMax = 80;
    public static final int attackMin = 40;
    public static final int attackMax = 80;    
    public static final int hpMin = 50;
    public static final int hpMax = 200;
    private static final int skillsCount = 2;
    private static final Skill[] skillsCatagory = {new Attacked(), new DoubleAttacked(), new Heal()};
    private Skill[] skills;
    private int hp;
    private int atk;

    public Slime(){
        hp = random(hpMin, hpMax);
        atk = random(attackMin, attackMax);
        skills = new Skill[skillsCount];
        genSkill();
    }
    
    public int getHp(){
        return hp;
    }
    
    public void setHp(int hp){
        this.hp = hp;
    }
    
    public int getAtk(){
        return atk;
    }
    
    public Skill getRandomSkills(){
        int random = random(0, 1);
        return skills[random];
    }
    
    private void genSkill(){
        for (int i=0; i<skillsCount; i++){
            int swap = random(i, skillsCount);
            Skill tmp = skillsCatagory[i];
            skillsCatagory[i] = skillsCatagory[swap];
            skillsCatagory[swap] = tmp;
            
            skills[i] = skillsCatagory[i];
        }
    }
    
    public static int random(int min, int max){
        return (int)(Math.random() * (max - min + 1) + min);
    }
    
}
