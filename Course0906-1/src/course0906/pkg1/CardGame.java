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
public class CardGame {
    public Scanner scanner;
    public Cards cards;
    public CardPlayer[] players;
    public int bet;
    public int round;
    
    public CardGame() {
        scanner = new Scanner(System.in);
        cards = new Cards();
        players = new CardPlayer[2];
        bet = 0;
    }
    
    public void setPlayer(CardPlayer cardplayer1, CardPlayer cardplayer2){
        players[0] = cardplayer1;
        players[1] = cardplayer2;
    }
    
    public void start(int round){
        for (int i=0; i<round; i++){
            Cards cardsForPlayer = new Cards(2);
            inputBet(players[0]);
            inputBet(players[1]);
            cardsForPlayer.deal(cards);
            compareCard(cardsForPlayer.cards[0], cardsForPlayer.cards[1]).money += bet;
            System.out.println(players[0].name + "剩下:" + players[0].money);
            System.out.println(players[1].name + "剩下:" + players[1].money);
            
            if (players[0].money == 0 || players[1].money == 0){
                break;
            }
            bet = 0;
        }
        compareWin(players[0],players[1]);
    }

    public void inputBet(CardPlayer player){
        int money;
        do{
            System.out.print(player.name + "請輸入金額:");
            money = scanner.nextInt();
        } while (player.bet(money) == -1);
        bet+=money;
        player.money -= money;
        System.out.println(player.name + "剩下:" + player.money);
    }
    
    public CardPlayer compareCard(Card cardPlay1, Card cardPlay2){
        int suitPlay1 = Cards.suitToPoint(cardPlay1.suit);
        int suitPlay2 = Cards.suitToPoint(cardPlay2.suit);
        if (suitPlay1 > suitPlay2){
            return players[0];
        }
        
        if(suitPlay1 == suitPlay2){
            if (cardPlay1.point > cardPlay2.point){
                return players[0];
            }
        }
        
        return players[1];
    }
    
    public void compareWin(CardPlayer player1, CardPlayer player2){
        if(player1.money > player2.money){
            System.out.println(player1.name + "贏得比賽遊戲");
        } else if (player1.money < player2.money){
            System.out.println(player2.name + "贏得比賽遊戲");
        }
        else {
            System.out.println("平手");
        }
    }
}
