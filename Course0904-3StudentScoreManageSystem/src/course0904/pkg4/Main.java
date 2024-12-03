/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0904.pkg4;

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
        
        Class class1 = new Class();

        int opt;
        do{
            opt = class1.inputInt("選項");
            
            switch (opt){
                case 1:
                    class1.addStudent();
                    break;
                case 2:
                    class1.addScore();
                    break;
                case 3:
                    class1.print();
                    break;
                case 4:
                    class1.sortScore();
                    break;
                case 5:
                    class1.sortSeat();
                    break;                    
            }        
        }
        while(opt!=6);
    
    }
}
