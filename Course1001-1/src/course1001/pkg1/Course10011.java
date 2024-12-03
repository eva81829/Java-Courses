/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course1001.pkg1;

/**
 *
 * @author Eka
 */
public class Course10011 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Animals animals = new Animals();
        animals.setAnimal(0);
        System.out.println(animals.getAnimal(0).getLife());
        animals.getAnimal(0).setLife(3);
        System.out.println(animals.getAnimal(0).getLife());
    }
    
}
