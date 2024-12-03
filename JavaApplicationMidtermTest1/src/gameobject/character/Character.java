/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject.character;

import gameobject.MovableGameObject;
import java.awt.image.*;

/**
 *
 * @author asdfg
 */
public abstract class Character extends MovableGameObject{
    protected BufferedImage img;    
    protected int hp;
    
    public Character(int x, int y, int width, int height, int speed) {
        super(x, y, width, height, speed);
    }
    
    public abstract void jump();
    
}
