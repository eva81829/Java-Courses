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
public class Card {
    public static final String COLOR_SPADE = "黑桃";
    public static final String COLOR_HEART = "愛心";
    public static final String COLOR_DIAMOND = "方塊";
    public static final String COLOR_CLUB = "梅花";
    
    public String suit;
    public int point;
    
    public Card(String suit, int point){
        this.suit = suit;
        this.point = point;
    }
    
    public String toString(){
        return (suit + point);
    }    
    
}
