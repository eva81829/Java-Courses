/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0911.pkg4;

/**
 *
 * @author Eka
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        AnimalArray animalArray = new AnimalArray();
        
        Dog dog = new Dog("dog1", 50);
        animalArray.addAnimal(dog);
        
        Cat cat = new Cat("cat1", 100);
        animalArray.addAnimal(cat);
        
        Mouse mouse = new Mouse("mouse1", 80);
        animalArray.addAnimal(mouse);
        
        Cat cat2 = new Cat("cat2", 90);
        
        animalArray.addAnimal(cat2,3);
        
        //animalArray.delectAnimal(1);
        //animalArray.delectAnimal(2);
        
        animalArray.sortByName();
        //animalArray.sortByWeight();
        //animalArray.sortByType();
        System.out.print(animalArray);
        
    }
    
}
