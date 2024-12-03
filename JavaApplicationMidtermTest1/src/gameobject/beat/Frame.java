/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject.beat;

import controller.DelayCounter;
import gameobject.GameObject;
import java.awt.Color;
import java.awt.Graphics;
import utils.Global;

/**
 *
 * @author Eka
 */
public class Frame extends GameObject{
    private DelayCounter delayCounter;    
    
    public Frame (int x, int y, int width, int height) {
        super(x, y, width, height);
        delayCounter = new DelayCounter(8);
    }
    
    @Override
    public void paint(Graphics g){
        if (delayCounter.update()){
            g.drawRect(50, 50, 1180, 560);
        }
    }  
}
