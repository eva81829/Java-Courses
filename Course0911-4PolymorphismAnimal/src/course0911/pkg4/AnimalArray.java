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
public class AnimalArray {
    public Animal[] animals;
    public int count;
    
    public AnimalArray(){
        animals = new Animal[2];
        count = 0;
    }
    
    public void addAnimal(Animal animal){
        doubleArr();
        animals[count++] = animal;
    }
    
    
    public void addAnimal(Animal animal, int index){
        doubleArr();
        for (int i=count; i>index; i--){
            animals[i] = animals[i-1];
        }
        animals[index] = animal;
        count++;
    }

    public void delectAnimal(int index){
        for (int i=index; i<count-1; i++){
            animals[i] = animals[i+1];
        }
        count--;
    }
    
    public void sortByName(){
        for (int i=0; i<count-1; i++){
            for (int j=0; j<count-1-i; j++){
                if (animals[j].getName().compareTo(animals[j+1].getName())>0){
                    Animal tmp = animals[j];
                    animals[j] = animals[j+1];
                    animals[j+1] = tmp;
                }
            }
        }
    }    
    
/*    
    public void sortByName(){
        for (int i=0; i<count-1; i++){
            for (int j=0; j<count-1-i; j++){
                if (animals[j].getSeq() > animals[j+1].getSeq()){
                    Animal tmp = animals[j];
                    animals[j] = animals[j+1];
                    animals[j+1] = tmp;
                }
            }
        }
    }
*/
    public void sortByWeight(){
        for (int i=0; i<count-1; i++){
            for (int j=0; j<count-1-i; j++){
                if (animals[j].getWeight() > animals[j+1].getWeight()){
                    Animal tmp = animals[j];
                    animals[j] = animals[j+1];
                    animals[j+1] = tmp;
                }
            }
        }
    }
    
    public void sortByType(){
        for (int i=0; i<count-1; i++){
            for (int j=0; j<count-1-i; j++){
                if (checkType(animals[j]) > checkType(animals[j+1])){
                    Animal tmp = animals[j];
                    animals[j] = animals[j+1];
                    animals[j+1] = tmp;
                }
            }
        }
    }
    
    public int checkType(Animal animal){
        int type = 1;
        if (animal instanceof Dog) {
            type = 2;
        }  else if (animal instanceof Mouse) {
            type = 3;
        }        
        return type;
    }
    
     public String toString(){
        String str = "";
        for (int i=0; i<count; i++){
            str += animals[i] + "\n";
        }
        return str;
    }   
    
    
    public void doubleArr(){
        if (count == animals.length){
            Animal[] tmp = new Animal[count*2];
            for(int i=0; i<count; i++){
                tmp[i] = animals[i];
            }
            animals = tmp;
        }
    }

}
