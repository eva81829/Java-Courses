/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject.background;
import gameobject.GameObject;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import utils.Global;

/**
 *
 * @author Eka
 */
public abstract class Background extends GameObject{
    protected BufferedImage img;
    private int paintX; 
    private int paintY;
    private int paintWidth;
    private int paintHeight;

    public Background () {
        super(0, 0, Global.Frame_SIZE_X, Global.Frame_SIZE_Y);
        paintX = 0;
        paintY = 0;
        paintWidth = Global.Frame_SIZE_X;
        paintHeight = Global.Frame_SIZE_Y;
    }    
    
    public Background (int paintX, int paintY, int paintWidth, int paintHeight) {
        super(0, 0, Global.Frame_SIZE_X, Global.Frame_SIZE_Y);
        this.paintX = paintX;
        this.paintY = paintY;
        this.paintWidth = paintWidth;
        this.paintHeight = paintHeight;
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, Global.Frame_SIZE_X, Global.Frame_SIZE_Y, //實際畫出的背景大小
                paintX , paintY, paintX + paintWidth, paintY + paintHeight, null); //使用背景的範圍
    }
    
}
