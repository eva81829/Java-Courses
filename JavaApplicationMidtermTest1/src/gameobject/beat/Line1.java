/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject.beat;

import controller.ImageResourceController;
import controller.PathBuilder;
import gameobject.GameObject;
import gameobject.MovableGameObject;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import utils.Global;
import utils.ImagePath;

/**
 *
 * @author Eka
 */
public class Line1 extends GameObject{
    protected int dy;
    protected int shakeCount;
    
    public Line1 () {
        super(0, Global.LINE, 0, 0);
        dy = shakeCount = 0;        
    }
    
    @Override
    public boolean move(){
        if (y > Global.LINE || y < Global.LINE){
            y = Global.LINE;
            return true;
        } 
        dy = (int)(Math.random() * 3);
        
        if (shakeCount == 0){
            y += dy;
            shakeCount = 1;
            return true;
        }
        y -= dy;
        shakeCount = 0;
        return true;
    }
    
    @Override
    public void paint(Graphics g) {

        int width = 5;
        ((Graphics2D)g).setStroke(new BasicStroke(width));        
        
        Color color= new Color(1.0F, 1.0F, 1.0F, 0.5F);
        g.setColor(color);        
        
        //g.setColor(Color.WHITE.darker());
        g.drawLine(0, y, Global.Frame_SIZE_X, y);
    }
    
}
