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
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                if (creatures[i][j] == null){
                    creatures[i][j] = breed(new Grass());
                } else if (creatures[i][j].level == 1){//X
                    creatures[i][j] = creatures[i][j].checkLife();
                } else if (creatures[i][j].moved == false){
                    getKilledAndMove(i, j);
                }
            }
        }
    }

    public static void getKilledAndMove(int row, int column) {
        int[] arr = {0, 1, 2, 3, 5, 6, 7, 8};
        Creature self = creatures[row][column];
        Creature killedCreature;
        
        for (int k = 0; k < 8; k++) {
            int swap = (int) (Math.random() * (8 - k) + k);
            int tmp = arr[k];
            arr[k] = arr[swap];
            arr[swap] = tmp;

            System.out.print(arr[k]);
            int rowNew = row - 1 + arr[k] / 3;
            System.out.print(rowNew);
            int columnNew = column - 1 + arr[k] % 3;
            System.out.print(columnNew + " ");
            if (!checkBound(rowNew, columnNew)) {
                continue;
            }
            
            killedCreature = creatures[rowNew][columnNew];
            Creature replaceCreature = self.move(killedCreature);
            if (replaceCreature == null){ // 判斷新物種是否會被吃掉, 如果新物種會被吃掉，則更新原物種和新物種
                creatures[rowNew][columnNew] = replaceCreature;
                creatures[row][column] = null;
                return;
            } else if (replaceCreature == self){
                creatures[rowNew][columnNew] = replaceCreature;
                creatures[row][column] = breed(new Horse());
                return;
            }
        }
        
        creatures[row][column] = self.checkLife();
    }
    
    public static Creature breed(Creature creature){
        int breed = (int) (Math.random() * 2);
        if (breed == 0){
            return creature;
        } 
            return null;
    }  
    
    public static boolean checkBound(int row, int column){
        if (row == ROW || row < 0 || column == COLUMN || column < 0){
            return false;
        }
        return true;
    }

    public static void resetAndPrint(){
        String str = "";
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                if (creatures[i][j] == null){
                    str += "-";
                } else {
                    creatures[i][j].moved = false;
                    str += creatures[i][j].ic;
                }
            }
            str += "\n";
        }
        System.out.print(str);
    }

    public static void initialize() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                int generate = (int) (Math.random() * SPECIES);
                switch (generate) {
                    case 0:
                        creatures[i][j] = new Horse();
                        break;
                    case 1:
                        creatures[i][j] = new Grass();
                        break;
                    case 2:
                        creatures[i][j] = null;
                }
            }
        }
    }    
}

//    public static void initialize() {
//        for (int i = 0; i < ROW; i++) {
//            for (int j = 0; j < COLUMN; j++) {
//                    creatures[i][j] = null;
//            }
//        }
//        creatures[2][3] = new Horse();
//        creatures[0][3] = new Horse();
//        creatures[1][4] = new Grass();        
//    }


