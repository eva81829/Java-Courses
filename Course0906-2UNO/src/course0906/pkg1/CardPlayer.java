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
public class CardPlayer {
    public String name;
    public int number;
    public Cards myCards;
    public String shout;
    public int checkUnoLength;
    
    public CardPlayer(String name, int number){
        this.number = number;
        this.name = name;
        myCards = new Cards();
    }
    
    public void shout(Scanner scanner){
        System.out.print("請選擇是否喊UNO(Y, N): "); 
        shout = scanner.nextLine();
        checkUnoLength = myCards.countFinal;
    }    

    public Cards checkUno(Card lastCard){
        Cards candidate =  new Cards();
        System.out.print("可以出的牌: ");
        for (int i=0; i<myCards.countFinal; i++){
            if (lastCard.point == myCards.cards[i].point || lastCard.suit.equals(myCards.cards[i].suit)){
                if(!candidate.checkDup(myCards.cards[i])){
                    candidate.addCard(myCards.cards[i]);
                    System.out.print(myCards.cards[i] + " ");                
                }
            }
        }
        return candidate;
    }
}
