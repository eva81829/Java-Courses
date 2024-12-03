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
public class CBoom {
    private BufferedImage img;
    private BufferedImage img1;
    private int x, y;
    private int state;
    
    public CBoom (int x, int y){
        this.x = x;
        this.y = y;
        try{
            img = ImageIO.read(getClass().getResource("/resources/boom.png"));
            img1 = ImageIO.read(getClass().getResource("/resources/boom2.png"));
        } catch (IOException ex){
        }
    }
    
    public boolean checkAttack(CEnemy e){
        int left = this.x;
        int eLeft = e.getX();
        int right = this.x + 34;
        int eRight = e.getX() + 48;
        int top = this.y;
        int eTop = e.getY();
        int bottom = this.y + 40;
        int eBottom = e.getY() + 44;
        
        if(left > eRight){
            return false;
        }
        if(right < eLeft){
            return false;
        }
        if(top > eBottom){
            return false;
        }
        if(bottom < eTop){
            return false;
        }
        state = 1; //撞到東西state變成1
        return true;
    }    
    
    
    public boolean move(){
        if(state == 0){
            y -= 18;
            if(y <= 0){
                return false; //沒射到東西但超過邊界則消失
            }
        }else{ //撞到東西state不等於0, 視覺暫留效果直到state > 12
            state++; 
            if(state > 12){
                return false; //射到東西效果結束也消失
            }
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
        g.drawImage((state == 0 ? img: img1), x, y, null); //撞到東西state不為0後改畫img1
    }    
    
}
