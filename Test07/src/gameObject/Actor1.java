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
public class Actor1 extends GameObject{
    private static final int[] ACT = {0,1,2,3};
    private BufferedImage img;
    
    public Actor1(int x, int y, int width, int height){
        super(x, y, width, height);
        img = ResourceController.getInstance().getImage(ImagePath.IMG);
    }
    
    @Override
    public void move(){
    }
    
    @Override
    public void paint(Graphics g){
        g.drawImage( img, x, y, getRight(), getBottom(),
                Global.ACTOR_X, Global.ACTOR_Y,
                Global.ACTOR_RIGHT, Global.ACTOR_BOTTOM, null);
    }
    
}
