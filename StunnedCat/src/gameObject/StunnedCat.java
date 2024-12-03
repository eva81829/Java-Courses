/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameObject;

import controllers.IRC;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import values.Global;
import values.ImagePath;

/**
 *
 * @author Eka
 */
public class StunnedCat extends GameObject{
    private static final int[] ACT = { 3, 2, 1, 0, 1, 0, 2};
    private int act;
    private int delay;    
    public BufferedImage img;
    
    public StunnedCat(int x, int y, int width, int height){
        super(x, y, width, height);
        
        img = IRC.getInstance().getImage(ImagePath.CAT_ATTACK);
        act = delay = 0;

    }
    
    @Override
    public void move(){
        
    }
    
    @Override
    public void paint(Graphics g){
//        g.drawImage(img, x, y, getRight(), getBottom(), 
//                0, 0, Global.CAT_X_OFFSET, Global.CAT_Y_OFFSET, null);
        g.drawImage(img, x, y, getRight(), getBottom(),
                0 + Global.CAT_X_OFFSET * ACT[act], 0, 
                Global.CAT_X_OFFSET + Global.CAT_X_OFFSET * ACT[act], Global.CAT_Y_OFFSET, null);
        
//        g.drawImage(img, 0, 0, 140, 140, 
//                0 + Global.CAT_X_OFFSET * ACT[act], 0, 
//                140 + Global.CAT_X_OFFSET * ACT[act], 140, null);
        
        
        if (delay++ < Global.DELAY_LIMIT){
            return;
        }
        act = ++act % 7;
        delay = 0;
    }
}
