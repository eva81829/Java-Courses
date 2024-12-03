/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0909.pkg1;

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

        School school = new School();
        int opt;
        do {
            opt = Classroom.inputInt("選項");
            if (opt == 7){
                break;
            }
            
            switch (opt){
                case 1:
                    school.addClassroom();
                    break;
                case 2:
                    school.assignStudent();
                    break;
                case 3:
                    school.addScore();
                    break;
                case 4:
                    school.search();
                    break;                    
                case 5:
                    Classroom.max = 0;
                    Classroom.min = 1;
                    System.out.print(school);
                    break;
                case 6:
                    do {
                        Classroom.max = Classroom.inputInt("max");
                        Classroom.min = Classroom.inputInt("min");
                    } while(Classroom.max<Classroom.min);
                    System.out.print(school);
                    break;
            }
        } while(true);
        
    }
    
}
