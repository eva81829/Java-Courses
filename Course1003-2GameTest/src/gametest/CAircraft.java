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
public class CAircraft {
    private static BufferedImage img;
    private static final int SPEED = 10; 
    private int x, y;
    private int dir;
    
    public CAircraft(){
        try{
            img = ImageIO.read(getClass().getResource("/resources/airplane1.png"));
        } catch (IOException ex){
        }
        x = 30;
        y = 600;
        dir = 0;        
    }    

    public void move(){
        //x += (dir ==0 ? 16 : -16);
        if (dir == 0){
            x += SPEED; //越小越滑順
            
        } else{
            x += -SPEED;
        }
    }
    
    public void changeDir(int x){
        //x += (dir ==0 ? 16 : -16);
        if (this.x > x){
            dir = 1;
        } else{
            dir = 0;
        }
    }
    
    public boolean checkAttack(CEnemy e){
        int left = this.x;
        int eLeft = e.getX();
        int right = this.x + 77;
        int eRight = e.getX() + 48;      
        int top = this.y;
        int eTop = e.getY();
        int bottom = this.y + 45;
        int eBottom = e.getY() + 44;
        
        if (left > eRight){
            return false;
        }
        if (right < eLeft){
            return false;
        }        
        if (top > eBottom){
            return false;
        }
        if (bottom < eTop){
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
    
    public void paint(Graphics g){
        g.drawImage(img, x, y, null); // g.drawImage(img, x, y, 50, 50, this);
    }
    
    
}
