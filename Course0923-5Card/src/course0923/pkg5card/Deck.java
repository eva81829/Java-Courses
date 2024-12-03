/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0923.pkg5card;

/**
 *
 * @author Eka
 */
public class Deck {
    public static final int TOTAL_CARDS = 52;    
    public Card[] cards;    
    public int count;
    
    public Deck(){
        count = 0;
        cards = new Card[TOTAL_CARDS];
        for(int i=0; i<TOTAL_CARDS; i++){
            String suit = Card.pointToSuit(i/13);
            int point = i%13 + 1;
            cards[i] = new Card(suit , point);
        }
    }
    
    public Card deal(){
        if (count == TOTAL_CARDS){
            count = 0;
        }
        return cards[count++];
    }
    
    public void shuffle(){
        for (int i=0; i< TOTAL_CARDS-1; i++){
            int swap = (int)(Math.random() * (TOTAL_CARDS - i) + i);
            Card tmp = cards[i];
            cards[i] = cards[swap];
            cards[swap] = tmp;
        }
    }

    public String toString(){
        String str = "";
        for (int i=0; i<TOTAL_CARDS; i++){
            str += cards[i] + " ";
        }
        return str;
    }
    
}
