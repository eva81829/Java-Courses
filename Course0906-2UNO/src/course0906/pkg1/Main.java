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
        UNOGame cardgame = new UNOGame();
        
        int people;
        do {
            System.out.print("請輸入幾位玩家(2~8):");        
            people = scanner.nextInt();
            scanner.nextLine();
        } while (cardgame.setPeople(people)); 
        cardgame.setPlayer();
        
        System.out.print("請選擇起始玩家編號: "); 
        int number = scanner.nextInt() - 1;
        scanner.nextLine();
        cardgame.start(scanner, number);
    }
    
}
