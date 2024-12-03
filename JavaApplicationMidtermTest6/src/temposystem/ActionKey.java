/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temposystem;

import java.util.ArrayList;

/**
 *
 * @author Eka
 */
public class ActionKey {
    private static final String ATTACK_KEY = "3012";
    private static final String  DEFENSE_KEY = "0101";
    private static final int ATTACK_EVENT = 0;
    private static final int DEFENSE_EVENT = 1;
    private static final int NO_EVENT = -1;    
    private String press;    
    
    public ActionKey(){
        press = "";
    }
    
    public int ActionKey(int command){
        press += command;
        //如果目前總按的按鍵等同於其中一個規定的按鍵順序, 則回傳觸發的事件代碼
        if (press.indexOf(ATTACK_KEY)>=0){ 
            press = "";
            return ATTACK_EVENT;
        }
        if (press.indexOf(DEFENSE_KEY)>=0){ 
            press = "";
            return DEFENSE_EVENT;     
        }
        return NO_EVENT;        
    }
    
}