/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject.systembeat.reference;

import controller.ImageResourceController;
import controller.PathBuilder;
import gameobject.MovableGameObject;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import utils.Global;
import utils.ImagePath;

/**
 *
 * @author Eka
 */
//public class Electric1 extends MovableGameObject{
//    protected BufferedImage img;
//    
//    public Electric1(int x, int y, int width, int height, int speed) {
//        super(x, y, width, height, speed);
//        ImageResourceController irc = ImageResourceController.getInstance();
//        img = irc.tryGetImage(PathBuilder.getImage(ImagePath.Tempo.TEMPO1));
//    }
//    
//    
//    @Override
//    public boolean move(){
//        x += getSpeed();
//        
//        if(x > Global.Frame_SIZE_X){
//            x = 0;
//            return false;
//        }      
//        return true;
//    }
//    
//    @Override
//    public void paint(Graphics g) {
//        g.drawImage(img, x, y, null);
//    }
//    
//}
