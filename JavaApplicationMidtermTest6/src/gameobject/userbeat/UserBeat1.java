/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject.userbeat;

import controller.DelayCounter;
import controller.ImageResourceController;
import controller.PathBuilder;
import gameobject.GameObject;
import gameobject.PhysicalGameObject;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import utils.Global;
import utils.ImagePath;

/**
 *
 * @author Eka
 */
public class UserBeat1 extends GameObject{
    private static final int[] ACT = { 3, 2, 1, 0, 1, 0, 2};
    private int act;
    protected DelayCounter delayCounterAct;
    protected DelayCounter delayCounterUp;
    protected DelayCounter delayCounterDown;    
    protected BufferedImage rightImg;
    protected BufferedImage wrongImg;
    protected BufferedImage AttackImg;
    private StateKeyPress currentKeyPress;
    private StateKey currentKey;
    
    public UserBeat1(int x, int y, int width, int height) {
        super(x, y, width, height);
        delayCounterAct = new DelayCounter(2);
        delayCounterUp = new DelayCounter(5);
        delayCounterDown = new DelayCounter(5);
        ImageResourceController irc = ImageResourceController.getInstance();
        rightImg = irc.tryGetImage(PathBuilder.getImage(ImagePath.Character.Cat.SMALL_CAT_HAPPY));
        wrongImg = irc.tryGetImage(PathBuilder.getImage(ImagePath.Character.Cat.SMALL_CAT_STUN));
        AttackImg = irc.tryGetImage(PathBuilder.getImage(ImagePath.Character.Cat.SMALL_CAT_ATTACK));
        act = 0;
        currentKey = new Nothing();
        currentKeyPress = new StateUnPress();
    }
    
    public static abstract class StateKeyPress{
        public abstract void isOnTemple(UserBeat1 userBeat);
        public abstract void isNotOnTemple(UserBeat1 userBeat);
        public abstract void unClickUp(UserBeat1 userBeat);
        public abstract void unClickDown(UserBeat1 userBeat);           
    }
    
    public static class StatePress extends StateKeyPress{
        @Override
        public void isOnTemple(UserBeat1 userBeat) {
            if(userBeat.delayCounterUp.update()){
                userBeat.currentKey = new Nothing();
            }
        }

        @Override
        public void isNotOnTemple(UserBeat1 userBeat) {
            if(userBeat.delayCounterDown.update()){
                userBeat.currentKey = new Nothing();
            }
        }
        
        @Override
        public void unClickUp(UserBeat1 userBeat) {
//            if(userBeat.delayCounterUp.update()){
                userBeat.currentKey = new Nothing();
//            }
        }
        
        @Override
        public void unClickDown(UserBeat1 userBeat) {
//            if(userBeat.delayCounterDown.update()){
                userBeat.currentKey = new Nothing();
//            }
        }        
    }
    
    public static class StateUnPress extends StateKeyPress{
        @Override
        public void isOnTemple(UserBeat1 userBeat) {
            userBeat.currentKey = new Up();
        }

        @Override
        public void isNotOnTemple(UserBeat1 userBeat) {
            userBeat.currentKey = new Down();
        }
        
        @Override
        public void unClickUp(UserBeat1 userBeat) {
        }
        
        @Override
        public void unClickDown(UserBeat1 userBeat) {
        }                
    }
    
    public static abstract class StateKey{
        public abstract void update(UserBeat1 userBeat);
        public abstract void paint(Graphics g, UserBeat1 userBeat);
    }    
    
    public static class Up extends StateKey{
        @Override
        public void update(UserBeat1 userBeat) {
        }
        @Override
        public void paint(Graphics g, UserBeat1 userBeat) {
            g.drawImage(userBeat.rightImg, userBeat.x, userBeat.y, null);
        }
    }
    
    public static class Down extends StateKey{
        @Override
        public void update(UserBeat1 userBeat) {
        }
        @Override
        public void paint(Graphics g, UserBeat1 userBeat) {
            g.drawImage(userBeat.wrongImg, userBeat.x, userBeat.y, null);
        } 
    }
    
    public static class Nothing extends StateKey{
        @Override
        public void update(UserBeat1 userBeat) {
            if(userBeat.delayCounterAct.update()){
                userBeat.act = ++userBeat.act % ACT.length;
            }
        }
        @Override
        public void paint(Graphics g, UserBeat1 userBeat){
            g.drawImage(userBeat.AttackImg, userBeat.x, userBeat.y, userBeat.getRight(), userBeat.getButtom(),
                    0 + Global.CAT_X_OFFSET * ACT[userBeat.act], 0, 
                    Global.CAT_X_OFFSET + Global.CAT_X_OFFSET * ACT[userBeat.act], Global.CAT_Y_OFFSET, null);     
        } 
    }    

    
    @Override
    public void update(){
        currentKey.update(this);
    }
    
    public void isOnTemple(){
//        if (currentKeyPress instanceof StateUnPress){
//            currentKeyPress.isOnTemple(this);
//            currentKeyPress = new StatePress();
//        }
        currentKeyPress.isOnTemple(this);
        currentKeyPress = new StatePress();
    }
    
    public void isNotOnTemple(){
        currentKeyPress.isNotOnTemple(this);
        currentKeyPress = new StatePress();    
    }
    
    public void unClickUp(){
        currentKeyPress.unClickUp(this);
        currentKeyPress = new StateUnPress();
    }

    public void unClickDown(){
        currentKeyPress.unClickDown(this);
        currentKeyPress = new StateUnPress();        
    }
    
    @Override
    public void paint(Graphics g) {
        currentKey.paint(g, this);
    }
}
