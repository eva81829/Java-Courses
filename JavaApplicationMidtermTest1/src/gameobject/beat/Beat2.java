/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject.beat;

import controller.ImageResourceController;
import controller.PathBuilder;
import gameobject.MovableGameObject;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import utils.Global;
import utils.ImagePath;

/**
 *
 * @author Eka
 */
public class Beat2 extends MovableGameObject{
    protected int[] tempo;    
    protected BufferedImage img1;
    protected BufferedImage img2;
    protected int dy;
    protected int shakeCount;
    protected int lineX;
    protected int lineY;
    protected int SpeedCount;    

    public Beat2(int x, int y, int width, int height, int[] tempo) {
        super(x, y, width, height, tempo[0]);
        ImageResourceController irc = ImageResourceController.getInstance();
        img1 = irc.tryGetImage(PathBuilder.getImage(ImagePath.Tempo.TEMPO1));
        img2 = irc.tryGetImage(PathBuilder.getImage(ImagePath.Tempo.TEMPO3));
        lineY = Global.LINE;
        dy = shakeCount = lineX = SpeedCount = 0;
        this.tempo = tempo;
    }
    
    @Override
    public boolean move(){
        if(x > (int)((Global.Frame_SIZE_X)/2)){
            setSpeed(tempo[++SpeedCount%tempo.length]);
            x = 0;
            return false;
        }        
        
        x += getSpeed();
        updateLine();
        return true;
    }
    
    private void updateLine(){
        if (lineY > Global.LINE || lineY < Global.LINE){
            lineY = Global.LINE;
            return;
        } 
        dy = (int)(Math.random() * 3);
        
        if (shakeCount == 0){
            lineY += dy;
            shakeCount = 1;
            return;
        }
        lineY -= dy;
        shakeCount = 0;
        return;        
    }
    
    @Override
    public void paint(Graphics g) {

    }
    
    public void setPenWidthAndColor(Graphics g) {    
        int width = 5;        
        ((Graphics2D)g).setStroke(new BasicStroke(width));
        Color color= new Color(1.0F, 1.0F, 1.0F, 0.5F);
        g.setColor(color);
    }
}
