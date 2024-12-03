/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0906.pkg1;

import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入玩家1金額:");
        int player1Money = scanner.nextInt();
        System.out.print("請輸入玩家2金額:");
        int player2Money = scanner.nextInt();
        System.out.print("請輸入完幾輪:");
        int round = scanner.nextInt();        
        
        CardPlayer player1 = new CardPlayer("player1", player1Money);
        CardPlayer player2 = new CardPlayer("player2", player2Money);
        
        CardGame cardgame1 = new CardGame();
        cardgame1.setPlayer(player1, player2);
        cardgame1.start(round);
    }
    
}
