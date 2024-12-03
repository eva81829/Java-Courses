/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameObject;

import java.awt.Graphics;

/**
 *
 * @author Eka
 */
public abstract class GameObject{
    protected int x;
    protected int y;
    protected int width;    
    protected int height;
    
    public GameObject(int x, int y, int width, int height){
        this.x = x;        
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public int getX(){
        return x;
    }    

    public int getY(){
        return y;
    }
    
    public int getTop(){
        return y;
    }    

    public int getBottom(){
        return y + height;
    }
    
    public int getLeft(){
        return x;
    }    

    public int getRight(){
        return x + width;
    }
    
    public abstract void move();
    public abstract void paint(Graphics g);
}