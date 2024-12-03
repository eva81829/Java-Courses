/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject.userbeat;

import controller.ImageResourceController;
import controller.PathBuilder;
import gameobject.GameObject;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import utils.Global;
import utils.ImagePath;

/**
 *
 * @author Eka
 */
public class Beat extends GameObject{
        protected BufferedImage rightImg;
        protected BufferedImage wrongImg;        
        public Beat(int x, int y, int width, int height) {
            super(x, y, width, height);
            ImageResourceController irc = ImageResourceController.getInstance();
            rightImg = irc.tryGetImage(PathBuilder.getImage(ImagePath.Character.Cat.SMALL_CAT_HAPPY));
            wrongImg = irc.tryGetImage(PathBuilder.getImage(ImagePath.Character.Cat.SMALL_CAT_STUN));
        }
    
        @Override
    public void paint(Graphics g) {
        g.drawImage(rightImg, x, y, null);
        g.drawImage(wrongImg, Global.Frame_SIZE_X - 140 - x, y, null);
    }        
}
