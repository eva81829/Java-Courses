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
public class UNOGame {
    private int people;
    public CardPlayer[] players;
    public Card play;
    public Cards deck;
    public Cards fold;
    
    public UNOGame() {
        deck = new Cards();
        fold = new Cards();
        people = 2;
        players = new CardPlayer[people];
    }
    
    public boolean setPeople(int people){
        if (people<2 || people>8){
            return true;
        }
        this.people = people;
        return false;
    }
    
    public int getPeople(){
        return people;
    }
    
    public void setPlayer(){
        players = new CardPlayer[people];
        for (int i=0; i<people; i++){
            int number = i+1;
            CardPlayer player = new CardPlayer("player" + number, number);
            players[i] = player;
        }
    }
    
    public void start(Scanner scanner, int number){
        initialize();
        
        System.out.println("player" + players[number].number + "手牌: " + players[number].myCards);
        players[number].shout(scanner);
        play = players[number].myCards.chooseCard(scanner, players[number].myCards);
        foldAndCheckShout(players[number++], false);
        
        round(number, scanner);
        
        while(true){
            if (round(0, scanner)){
                break;
            }
        } 
    }
    
    public boolean round(int start, Scanner scanner){
        for (int i=start; i<people; i++){
            System.out.println("player" + players[i].number +"手牌: " + players[i].myCards);
            players[i].shout(scanner);
            Cards candidate = players[i].checkUno(play);
            boolean candidateIsNull = candidate.countFinal == 0;
            if (candidateIsNull){
                System.out.println("沒牌出，抽一張!");
                play = drawAndCheck(i);
                
            } else {
                    System.out.println();
                    play = candidate.chooseCard(scanner, players[i].myCards);
                    if (players[i].myCards.countFinal==0){
                        System.out.println("player" + players[i].number + "贏了!");
                        return true;
                    }
            }
            boolean condition = players[i].checkUnoLength ==2 && !candidateIsNull;
            foldAndCheckShout(players[i], condition);
        }
        return false;
    }
    
    public void foldAndCheckShout(CardPlayer cardPlayer, boolean condition){
        System.out.println("打出: " + play);
        fold.addCard(play);
        
        switch (cardPlayer.shout){
            default:
                punish(cardPlayer, condition);
                break;
            case "Y":
                punish(cardPlayer, !condition);
                break;
        }

        int left = deck.countFinal - deck.count;
        System.out.println("牌庫剩下: " + left);
    }

    private void punish(CardPlayer cardPlayer, boolean condition){
        if (condition){
            System.out.println("罰兩張!");
            for (int i=0; i<2; i++){
                cardPlayer.myCards.addCard(checkAndDeal());
            }   
        }
    }    
    
    public Card drawAndCheck(int i){
        Card draw;
        while(true) {
            draw = checkAndDeal();
            System.out.println(draw);
            
            if (play.point == draw.point || play.suit.equals(draw.suit)){
                break;
            }
            
            players[i].myCards.addCard(draw);
        }
            return draw;
    }
    
    public Card checkAndDeal(){
        if (deck.count == deck.countFinal){
            deck = fold;
            deck.shuffle();
            fold = new Cards();
        }
        return deck.deal();
    }
    
    public void initialize(){
        deck = Cards.genCards();
        for (int i=0; i<people; i++){
            for (int j=0; j<Cards.DEAL_CARD; j++){
                players[i].myCards.cards[j] = deck.deal();
                players[i].myCards.countFinal++;
            }
        }
    }
    
}
