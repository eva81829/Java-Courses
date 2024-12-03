/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameObject;

import controllers.ResourceController;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import values.Global;
import values.ImagePath;

/**
 *
 * @author Eka
 */
public class Actor2 extends GameObject{
    private static final int[] ACT = {0,1,2,1};
    private  int act;
    private  int delay;    
    private BufferedImage img;
    
    public Actor2(int x, int y, int width, int height){
        super(x, y, width, height);
        img = ResourceController.getInstance().getImage(ImagePath.IMG);
        act = delay = 0;
    }
    
    @Override
    public void move(){
    }
    
    @Override
    public void paint(Graphics g){
        g.drawImage( img, x, y, getRight(), getBottom(),
                Global.ACTOR_X + Global.IMG_X_OFFSET * ACT[act], Global.ACTOR_Y,
                Global.ACTOR_RIGHT + Global.IMG_X_OFFSET * ACT[act], Global.ACTOR_BOTTOM, null);
        if(delay < Global.DELAY_LIMIT){
            delay++;
            return;
        }  
        act = ++act%4;
        delay = 0;
    }
    
}
