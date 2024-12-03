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

    protected int hp;

    
    
    public Character(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    
    public abstract void jump();
    
    public abstract void turnRight();
    public abstract void turnLeft();
}
