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
    public static Slime[] slimes;     
    
    public static void main(String[] args) {
        // TODO code application logic here
        slimes = new Slime[2];
        slimes[0] = new Slime();
        slimes[1] = new Slime();
        
        System.out.println("slimesA:" + slimes[0].getHp());
        System.out.println("slimesB:" + slimes[1].getHp());        
        
        while (slimes[0].getHp() > 0 && slimes[1].getHp() > 0){
            slimes[0].getRandomSkills().useSkill(slimes[0],slimes[1]);
            System.out.println("slimesA:" + slimes[0].getHp());
            System.out.println("slimesB:" + slimes[1].getHp());
            
            if (slimes[0].getHp() <= 0 || slimes[1].getHp() <= 0){
                break;
            }
            slimes[1].getRandomSkills().useSkill(slimes[1],slimes[0]);
            System.out.println("slimesA:" + slimes[0].getHp());
            System.out.println("slimesB:" + slimes[1].getHp());          
        }
        
    }
    
}
