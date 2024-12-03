/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject.character;

import controller.DelayCounter;
import controller.ImageResourceController;
import controller.PathBuilder;
import java.awt.Graphics;
import utils.Global;
import utils.ImagePath;

/**
 *
 * @author asdfg
 */
public class SmallCat extends Character{
    private static final int[] ACT = {0, 1, 2, 3, 1};
    private int act;
    private int time;
    private int time2;
    private DelayCounter delayCounter;

    public SmallCat(int x, int y, int width, int height, int speed) {
        super(x, y, width, height, speed);
        ImageResourceController irc = ImageResourceController.getInstance();
        img = irc.tryGetImage(PathBuilder.getImage(ImagePath.Character.Cat.SMALL_CAT_ACT));
        act = 0;
        time = 0;
        time2 = 0;
        delayCounter = new DelayCounter(2);
    }
    
    @Override
    public boolean move(){
        if(delayCounter.update()){
            act = ++act % 5;
            x += getSpeed();
        }
        if( y < Global.FLOOR){
            y += Global.Acceleration.G * (++time^2);
        }else{
            y = Global.FLOOR;
            time = 0;
        }
        return true;
    }
    
    @Override
    public void jump() {
        y += getSpeed();
        
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, x, y,x + width,y + height, 
                0 + ACT[act] * Global.IMG_X_OFFSET, 0,
                140 + ACT[act] * Global.IMG_X_OFFSET, 140, null);
    }


}
