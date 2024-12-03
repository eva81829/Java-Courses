/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject;

import java.awt.*;
import utils.Global;

/**
 *
 * @author asdfg
 */
public abstract class GameObject {
    public static final int [] DIRECTION = {Global.RIGHT,Global.LEFT};
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected String name;
    protected int direction;
    
    public GameObject(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public boolean move(){
        return true;
    }
    
    public abstract void paint(Graphics g);
    
    public boolean isCollision(GameObject obj){
        boolean isCollision = true;
        if(getLeft() > obj.getRight()){
            isCollision = false;
        }
        if(getRight() < obj.getLeft()){
            isCollision = false;
        }
        if(getTop() > obj.getButtom()){
            isCollision = false;
        }
        if(getButtom() < obj.getTop()){
            isCollision = false;
        }
        return obj.isCollision(this) && isCollision;
    }
    
    public int getLeft(){
        return x;
    }
    
    public int getRight(){
        return x + width;
    }
    
    public int getTop(){
        return y;
    }
    
    public int getButtom(){
        return y + height;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public String getName(){
        return name;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public int getDirection(){
        return direction;
    }
    
    public void setDirection(int direction){
        this.direction = direction;
    }
    
    public void setName(String name){
        this.name = name;
    }
}