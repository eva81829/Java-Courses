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
public class Card {
    public static final String SPADE = "黑桃";
    public static final String HEART = "紅心";
    public static final String DIAMOND = "方塊";
    public static final String CLUB = "梅花";
    
    private String suit;
    private int point;
    
    public Card(String suit, int point){
        this.suit = suit;
        this.point = point;
    }
    
    public static int suitToPoint(String suit){
        switch (suit){
            case CLUB:
                return 0;       
            case DIAMOND:
                return 1;    
            case HEART:
                return 2;
            case SPADE:
                return 3;        
        }
        return -1;
    }

    public static String pointToSuit(int point){
        switch (point){
            case 0:
                return CLUB;       
            case 1:
                return DIAMOND;    
            case 2:
                return HEART;
            case 3:
                return SPADE;        
        }
        return null;
    }    

    @Override
    public String toString(){
        return suit + point;
    }

}
