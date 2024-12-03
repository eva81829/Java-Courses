/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temposystem;

import utils.Global;


/**
 *
 * @author Eka
 */
public class TempoController {
    private static final int[]  TEMPO = {4};
    private static final int ON_TEMPO_PARAMETER = 5; // 可容忍打擊的正負誤差範圍係數(總移動距離的多少分之幾)    
    private int count;
    
    public TempoController(){
        count = 0;
    }
    
    public int getTempo(){
        return TEMPO[count++ % TEMPO.length]; //取得index為count的節奏
    }
    
    public int getParameter(){
        return ON_TEMPO_PARAMETER; 
    }
    
}