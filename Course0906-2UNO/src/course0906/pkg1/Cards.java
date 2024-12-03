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
public class Cards {
    public Card[] cards;
    public static final int TOTAL_CARD = 76;
    public static final int DEAL_CARD = 7;
    public int count; //將要發cards Arr中的第幾張牌
    public int countFinal; //cards Arr中, 牌的總數
    
    public Cards(){
        cards =  new Card[DEAL_CARD];
        count = 0;
        countFinal = 0;
    }
    
    public static Cards genCards(){
        Cards uno = new Cards();
        uno.cards = new Card[TOTAL_CARD];
        for (int i=0; i<4; i++){
            for (int j=-9; j<=9; j++){
                String suit = Card.pointToSuit(i%4);
                int point = Math.abs(j)%10;
                uno.cards[uno.countFinal++] = new Card(suit,point);
            }
        }
        uno.shuffle();
        return uno;
    }
    
    public void shuffle(){
        for (int i=0; i<countFinal-1; i++){
            int swap = (int)(Math.random()*(countFinal-i) + i);
            Card card = cards[i];
            cards[i] = cards[swap];
            cards[swap] = card;
            //System.out.print(cards[i] + " ");
        }
    }    
    
    public void addCard(Card card){
        doubleArr();
        cards[countFinal++] = card;
    }
    
    private void doubleArr(){
        if (countFinal == cards.length){
            Card[] tmp =  new Card[cards.length * 2];
            for (int i=0; i<cards.length; i++){
                tmp[i] = cards[i];
            }
            cards = tmp;
        }   
    }    
    
    public Card deal(){
        return cards[count++];
    }
    
    public Card chooseCard(Scanner scanner, Cards cards){
        int number;
        do {
            System.out.print("請選擇一張牌: ");
            number = scanner.nextInt();
        } while (number>=countFinal || number<0);
        scanner.nextLine();
        
        Card play = this.cards[number];
        cards.draw(play);
        return play;
    }
    
    public void draw(Card card){
        boolean start = false;
        for (int i=0; i<countFinal; i++){
            if (start == true){
                cards[i-1] = cards[i];
            } else if (cards[i].point == card.point && cards[i].suit == card.suit){
                start = true;
                continue;
            }
        }
       if(start == true){
           countFinal--;
       }
    }
    
    public boolean checkDup(Card card){
        for (int i=0; i<countFinal; i++){
            if (card.point == cards[i].point && card.suit.equals(cards[i].suit)){
                return true;
            }
        }
        return false;
    }    
    
    
    public String toString(){
        String str = "";
        for (int i=0; i<countFinal; i++){
            str += cards[i] + " ";
        }
        return str;
    }
    
}
