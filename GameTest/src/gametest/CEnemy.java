/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametest;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Eka
 */
public class CEnemy {
    private static BufferedImage img;
    private int x, y;
    private int d;    
    
    public CEnemy(int x, int y, int d){
        this.x = x; //x座標
        this.y = y; //y座標
        this.d = d; //x座標每次移動的位移量
        try{
            img = ImageIO.read(getClass().getResource("/resources/enemy1.png"));
        } catch (IOException ex){
        }  
    }
    public void paint(Graphics g){
        g.drawImage(img, x, y, null); // g.drawImage(img, x, y, 50, 50, this);
    }    

    public boolean move(){
        this.y += 16;        
        this.x += d;

        if(this.y > 650){
            return false;
        }
        return true;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }    
    
}
