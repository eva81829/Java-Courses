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
public class Course09231 {

    /**
     * @param args the command line arguments
     */
    public static int[] slimes = {1, 2, 3};
    public static final int slime123 = 2;
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] slimeArr = new int[slime123];
        SlimeSkill[] slime = new SlimeSkill[2];
        for (int i=0; i<2 ; i++){
            Heal slime1 = new Slime();
            slime[i] = slime1;
        }
        
        System.out.println(slime[0].getHp());
        System.out.println(slime[1].getHp());
        
        DoubleAttacked slime2 = new Slime();   
        Attacked slime3 = new Slime();
    }

    public static int[] pickSlime (){
        int[] slimeArr = new int[slime123];
        for (int i=0; i<slime123; i++){
            int swap = Slime.random(0, slimes.length);
            slimeArr[i] = slimes[swap];
        }
        return slimeArr;
    }    
    
}
