/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject;

import gametest.CEnemy;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Eka
 */
public abstract class GameObject {
    protected int x, y, width, height;
    
    public GameObject(int x, int y, int width, int height){
       this.x = x;
       this.y = y;
       this.width = width;
       this.height = height;
    }
    
    public boolean isCollison(GameObject gameObject){
        if (getLeft() > gameObject.getRight()){
            return false;
        }
        if (getRight() < gameObject.getLeft()){
            return false;
        }
        if (getTop() > gameObject.getBottom()){
            return false;
        }
        if (getBottom() < gameObject.getTop()){
            return false;
        }
        return true;
    }
    
    //左上x座標
    public int getX(){
        return x;
    }
    
    //左上y座標
    public int getY(){
        return y;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    //圖片最下面的y座標
    public int getBottom(){
        return y + height;
    }
    
    //圖片最上面的y座標
    public int getTop(){
        return y;
    }
    
    //圖片最左邊的x座標
    public int getLeft(){
        return x;
    }
    
    //圖片最右邊的x座標
    public int getRight(){
        return x + width;
    }

    public abstract void move();
    
    public abstract void paint(Graphics g);
    
}
