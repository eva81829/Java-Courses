/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0827.pkg7card2;

/**
 *
 * @author Eka
 */
public class Course08277Card2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int[] cards = new int[52];
        int cardsNum = 52;
        
        for (int i = 0; i < cardsNum; i++){
            boolean isDup;
            do {
                isDup = false;
                cards[i] = (int)(Math.random() * 52 + 1);
                for (int j = 0; j < i; j++){
                    if (cards[i] == cards[j]){
                        isDup = true;
                        break;
                    }
                }
            
            } while (isDup);
            
            System.out.printf("%d",cards[i]);
            System.out.print(((i+1)%13==0 && i!=1)? "\n":" ");            
        }

    }
}
