/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0906.pkg1;

/**
 *
 * @author Eka
 */
public class Cards {
    public Card[] cards;
    public static int count = 0;
    
    public Cards(){
        cards =  new Card[52];
        for (int i=0; i<52; i++){
            String suit = pointToSuit(i%4);
            int point = i%13 + 1;
            cards[i] = new Card(suit,point);
        }
        shuffle();
    }
    
    public Cards(int n){
        cards =  new Card[n];
    }
    
    public void print(){
        for (int i=0; i<52; i++){
            System.out.print(cards[i] + " ");
            if ((i+1)%13==0){
                System.out.println();
            }
        }
    }

    public void shuffle(){
        for (int i=0; i<51; i++){
            int swap = (int)(Math.random()*(52-i) + i);
            Card card = cards[i];
            cards[i] = cards[swap];
            cards[swap] = card;
        }
    }
    
    public void deal(Cards cards){
        if (count>=51){
            reset();
        }
        Card card1 = cards.cards[count++];
        Card card2 = cards.cards[count++];
        System.out.println(card1 + " " + card2);
        this.cards[0] = card1;
        this.cards[1] = card2;
    }
    
    private void reset(){
        count = 0;
        shuffle();
    }
    
    public static String pointToSuit(int point){
        switch (point){
            case 0:
                return Card.COLOR_CLUB;
            case 1:
                return Card.COLOR_DIAMOND;
            case 2:
                return Card.COLOR_HEART;
            case 3:    
                return Card.COLOR_SPADE;           
        }
       return "";
    }

    public static int suitToPoint(String suit){
        switch (suit){
            case Card.COLOR_CLUB:
                return 0;
            case Card.COLOR_DIAMOND:
                return 1;
            case Card.COLOR_HEART:
                return 2;
            case Card.COLOR_SPADE:    
                return 3;    
        }
       return -1;
    }    
    
}
