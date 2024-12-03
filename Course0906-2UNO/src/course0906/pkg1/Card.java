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
    public static final String COLOR_BLUE = "藍";
    public static final String COLOR_YELLOW = "黃";
    public static final String COLOR_RED = "紅";
    public static final String COLOR_GREEN = "綠";
    
    public String suit;
    public int point;
    
    public Card(String suit, int point){
        this.suit = suit;
        this.point = point;
    }
    
    public String toString(){
        return (suit + point);
    }    
    
    public static String pointToSuit(int point){
        switch (point){
            case 0:
                return COLOR_BLUE;
            case 1:
                return COLOR_YELLOW;
            case 2:
                return COLOR_RED;
            case 3:    
                return COLOR_GREEN;           
        }
       return "";
    }

    public static int suitToPoint(String suit){
        switch (suit){
            case COLOR_BLUE:
                return 0;
            case COLOR_YELLOW:
                return 1;
            case COLOR_RED:
                return 2;
            case COLOR_GREEN:    
                return 3;    
        }
       return -1;
    }

}
