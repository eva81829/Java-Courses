/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject.beat;

import controller.ImageResourceController;
import controller.PathBuilder;
import gameobject.MovableGameObject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import utils.Global;
import utils.ImagePath;

/**
 *
 * @author Eka
 */
public class Electric2 extends MovableGameObject{
    protected BufferedImage img1;
    protected BufferedImage img2;

    public Electric2(int x, int y, int width, int height, int speed) {
        super(x, y, width, height, speed);
        ImageResourceController irc = ImageResourceController.getInstance();
        img1 = irc.tryGetImage(PathBuilder.getImage(ImagePath.Tempo.TEMPO1));
        img2 = irc.tryGetImage(PathBuilder.getImage(ImagePath.Tempo.TEMPO3));        
    }
    
    @Override
    public boolean move(){    
        x += getSpeed();
        
        int bound = (int)((Global.Frame_SIZE_X)/2);
        if(x > bound){
            x = 0;
            return false;
        }
        return true;
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawImage(img1, x, y, null); //畫左邊的震動圖
        g.drawImage(img2, Global.Frame_SIZE_X - 150 - x, y, null);  //畫右邊的震動圖
    }
}
