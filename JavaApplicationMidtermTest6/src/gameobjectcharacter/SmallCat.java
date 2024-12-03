/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobjectcharacter;

import controller.PhysicalEffect;
import controller.*;
import gameobject.GameObject;
import java.awt.Color;
import utils.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


/**
 *
 * @author asdfg
 */
public class SmallCat extends Character{
    
    private int act;
    private PhysicalEffect physicalEffect;

    public SmallCat(int x, int y, int width, int height) {
        super(x, y, width, height);
        ImageResourceController irc = ImageResourceController.getInstance();
        characterHelper = new CharacterHelper(this);
        act = 0;
        direction = 0;
        currentStateDirection = new StateFaceRight();
        currentCharacterState = new StateCat();
        delayCounterAct = new DelayCounter(2);
        physicalEffect = new PhysicalEffect(this, 10, 2);
        characterHelper = new CharacterHelper(this);
        setImageRange(30,20,8,8);
    }
    @Override
    public void update(){
        if(delayCounterAct.update()){
            act = ++act % 5;
        }
        physicalEffect.drop();
        if(currentStateDirection instanceof StateFaceRight && !(currentStateMotion instanceof StateStop)){
            physicalEffect.sprint();
            x += horizontalVelocity;
        }else if(currentStateDirection instanceof StateFaceLeft && !(currentStateMotion instanceof StateStop)){
            physicalEffect.sprint();
            x -= horizontalVelocity;    
        }
    }
    
    public void collision(GameObject obj){
        physicalEffect.isCollision(obj);
    }

    @Override
    public void jump() {
        currentStateWeightlessness.clickUp(this);
    }
    
    @Override
    public void turnRight() {
        currentStateWeightlessness.clickRight(this);
        setCharacterHelper(this);
    }

    @Override
    public void turnLeft() {
        currentStateWeightlessness.clickLeft(this);
        setCharacterHelper(this);
    }
    
    public void slow(){
        currentStateWeightlessness.clickDown(this);
    }

    @Override
    public void paint(Graphics g) {
        if(Global.DEBUGMODE == true){
            DebugMode.debug(this, g);
        }
        characterHelper.paint(g, imageRange.imageX, imageRange.imageY, imageRange.imageWidth, imageRange.imageHeight, act);
        setImagePosition();
    }
}
