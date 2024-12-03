/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0828.pkg8;

/**
 *
 * @author Eka
 */
public class Course08288 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int[] card_array = new int[52];
        String[] suit = {"黑桃","紅心","方塊", "梅花"};
        
        for (int i=0;i<52;i++){
            card_array[i] = i+1;
            //System.out.print(card_array[i]);
            //System.out.println();
        }
        
        for (int i=0;i<52;i++){
            int tmp,swap;
            swap = (int)(Math.random()*(52-i) + i);
            tmp = card_array[i];
            card_array[i] = card_array[swap];
            card_array[swap] = tmp;
            
            //System.out.printf("%2d",card_array[i]);
            //System.out.print(((i+1)%13==0 && i!=1)? "\n":" ");
            
            System.out.printf("%s%2d",suit[(card_array[i]-1)/13],(card_array[i]-1)%13+1);     
            System.out.print(((i+1)%13==0 && i!=1)? "\n":" ");
        }
        
        
    }
    
}
