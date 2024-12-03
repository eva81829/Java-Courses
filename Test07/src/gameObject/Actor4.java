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
public class Actor4 extends GameObject{
    private static final int[] ACT = {0,1,2,1};
    private  int act;
    private  int delay;
    private  int direction;
    private  int directionCount;    
    private  int actCount;
    private  int count;    
    private BufferedImage img;
    
    public Actor4(int x, int y, int width, int height){
        super(x, y, width, height);
        img = ResourceController.getInstance().getImage(ImagePath.IMG);
        act = delay = direction = count = 0;
        actCount = 2;
        directionCount = 4;
    }
    
    @Override
    public void move(){
    }
    
    @Override
    public void paint(Graphics g){
        g.drawImage( img, x, y, getRight(), getBottom(),
                Global.ACTOR_X + Global.IMG_X_OFFSET * ACT[act], Global.ACTOR_Y + Global.IMG_Y_OFFSET * direction,
                Global.ACTOR_RIGHT + Global.IMG_X_OFFSET * ACT[act], Global.ACTOR_BOTTOM + Global.IMG_Y_OFFSET * direction, null);
        if (delay < Global.DELAY_LIMIT){
            delay++;
            return;
        }
        act = ++act % ACT.length;
        if (act==0){
            count = ++count % actCount;
            if (count==0){
                direction = ++direction % directionCount; 
            }            
        }
        delay = 0;
    }
    
}
