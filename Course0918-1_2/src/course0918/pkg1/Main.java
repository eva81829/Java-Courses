/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0918.pkg1;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static final int ROW = 5;
    public static final int COLUMN = 7;
    public static final int SPECIES = 3;
    public static Creature[][] creatures = new Creature[ROW][COLUMN];
    public static Creature self;
    public static Creature killedCreature;
    public static int row;
    public static int column;
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);

        initialize();
        resetAndPrint();
        while (true) {
            scanner.nextLine();
            round();
            System.out.println();
            resetAndPrint();
        }
    }

    public static void round() {
        for (row = 0; row < ROW; row++) {
            for (column = 0; column < COLUMN; column++) {
                if (creatures[row][column] == null){
                    creatures[row][column] = checkBreed(new Grass()); //檢查是否能生小草
                } else if (creatures[row][column].getLevel()== 1){
                    creatures[row][column] = checkLife(creatures[row][column]);
                } else if (creatures[row][column].getMoved() == false){
                    getKilledAndMove();
                }
            }
        }
    }

    public static void getKilledAndMove() {
        self = creatures[row][column];
        int killed;
        
        for (int i = 0; i < 7; i++){
            int diretion = self.move(i);
            System.out.print(diretion);
            int rowNew = row - 1 + diretion / 3;
            System.out.print(rowNew);
            int columnNew = column - 1 + diretion % 3;
            System.out.print(columnNew + " ");

            if (!checkBound(rowNew, columnNew)) {
                continue;
            }            

            killedCreature = creatures[rowNew][columnNew];
            killed = self.eat(killedCreature);
        
            if (killed == 0){ // 新物種不存在
                self.setMoved(true);
                creatures[rowNew][columnNew] = checkLife(self);
                creatures[row][column] = null;
                return;
            } else if (killed == 1){ //新物種level比較低
                self.setMoved(true);
                self.increaseLife();
                creatures[rowNew][columnNew] = self;
                creatures[row][column] = checkBreed(new Horse()); //檢查是否能生小馬
                return;
            }
        }
        creatures[row][column] = checkLife(self);
    } 
    
    public static boolean checkBound(int rowNew, int columnNew){
        if (rowNew == ROW || rowNew < 0 || columnNew == COLUMN || columnNew < 0){
            return false;
        }
        return true;
    }

    public static Creature checkBreed(Creature creature){
        int breed = (int) (Math.random() * 2); 
        if (breed == 0){
            return creature;
        }
            return null;
    }
    
    public static Creature checkLife(Creature creature){
        if (creature.getLife() == 1){
            return null;
        }
        creature.decreaseLife();
        return creature;
    }

    public static void resetAndPrint(){
        String str = "";
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                if (creatures[i][j] == null){
                    str += "-";
                } else {
                    creatures[i][j].setMoved(false);
                    str += creatures[i][j].getIc();
                }
            }
            str += "\n";
        }
        System.out.print(str);
    }
    
    public static void initialize() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                    creatures[i][j] = null;
            }
        }
        creatures[2][3] = new Horse();
        creatures[0][3] = new Horse();
        creatures[1][4] = new Grass();        
    }
}    
//    
//    public static void initialize() {
//        for (int i = 0; i < ROW; i++) {
//            for (int j = 0; j < COLUMN; j++) {
//                int generate = (int) (Math.random() * SPECIES);
//                switch (generate) {
//                    case 0:
//                        creatures[i][j] = new Horse();
//                        break;
//                    case 1:
//                        creatures[i][j] = new Grass();
//                        break;
//                    case 2:
//                        creatures[i][j] = null;
//                }
//            }
//        }
//    }    
//}




