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
public class CardPlayer {
    public String name;
    public int money;
    
    public CardPlayer(String name, int money){
        this.name = name;
        this.money = money;
    }
    
    public int bet(int money){
        if (money > this.money){
            return -1;
        }
        return 0;
    }
    
    public void addMoney(int money){
        this.money += money;
    }
    
}
