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
public class UserBeat extends GameObject{
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
    
    public UserBeat(int x, int y, int width, int height) {
        super(x, y, width, height);
        delayCounterAct = new DelayCounter(2);
        delayCounterUp = new DelayCounter(6);
        delayCounterDown = new DelayCounter(6);
        ImageResourceController irc = ImageResourceController.getInstance();
        rightImg = irc.tryGetImage(PathBuilder.getImage(ImagePath.Character.Cat.SMALL_CAT_HAPPY));
        wrongImg = irc.tryGetImage(PathBuilder.getImage(ImagePath.Character.Cat.SMALL_CAT_STUN));
        AttackImg = irc.tryGetImage(PathBuilder.getImage(ImagePath.Character.Cat.SMALL_CAT_ATTACK));
        act = 0;
        currentKey = new Nothing();
        currentKeyPress = new StateUnPress();
    }
    
    public static abstract class StateKeyPress{
        public abstract void checkOnTemple(UserBeat userBeat, boolean isOnTemple);
        public abstract void checkButton(UserBeat userBeat);
    }
    
    public static class StatePress extends StateKeyPress{
        @Override
        public void checkOnTemple(UserBeat userBeat, boolean isOnTemple) {
        }

        @Override
        public void checkButton(UserBeat userBeat) {
        }
    }
    
    public static class StateUnPress extends StateKeyPress{
        @Override
        public void checkOnTemple(UserBeat userBeat, boolean isOnTemple) {
            if (isOnTemple){
                //System.out.println("!");
                userBeat.currentKey = new Up();
            } else {
                //System.out.println("?");
                userBeat.currentKey = new Down();
            }
        }

        @Override
        public void checkButton(UserBeat userBeat) {
        }    
    }
    
    public static abstract class StateKey{
        public abstract void update(UserBeat userBeat);
        public abstract void paint(Graphics g, UserBeat userBeat);
    }    
    
    public static class Up extends StateKey{
        @Override
        public void update(UserBeat userBeat) {
        }
        @Override
        public void paint(Graphics g, UserBeat userBeat) {
            g.drawImage(userBeat.rightImg, userBeat.x, userBeat.y, null);
        }
    }
    
    public static class Down extends StateKey{
        @Override
        public void update(UserBeat userBeat) {
        }
        @Override
        public void paint(Graphics g, UserBeat userBeat) {
            g.drawImage(userBeat.wrongImg, userBeat.x, userBeat.y, null);
        } 
    }
    
    public static class Nothing extends StateKey{
        @Override
        public void update(UserBeat userBeat) {
            if(userBeat.delayCounterAct.update()){
                userBeat.act = ++userBeat.act % ACT.length;
            }
        }
        @Override
        public void paint(Graphics g, UserBeat userBeat){
            g.drawImage(userBeat.AttackImg, userBeat.x, userBeat.y, userBeat.getRight(), userBeat.getButtom(),
                    0 + Global.CAT_X_OFFSET * ACT[userBeat.act], 0, 
                    Global.CAT_X_OFFSET + Global.CAT_X_OFFSET * ACT[userBeat.act], Global.CAT_Y_OFFSET, null);     
        } 
    }    

    
    @Override
    public void update(){
        if(Global.DEBUGMODE == true){
            currentKey.update(this);
            return;
        }        
        
        if ((currentKey instanceof Up)){    //如果已經按了上了,過多久後恢復原本狀態
            if(delayCounterUp.update()){
                currentKey = new Nothing();
            }
        } else if ((currentKey instanceof Down)){ //如果已經按了下了,過多久後恢復原本狀態
            if(delayCounterDown.update()){
                currentKey = new Nothing();
            }
        }

        currentKey.update(this);
    }
    
    public void checkOnTemple(boolean isOnTemple){
        currentKeyPress.checkOnTemple(this, isOnTemple);
        currentKeyPress = new StatePress();
        //return 
    }
    
    public void checkKeyCorrect(){
    }
    
    public void unPress(){
        currentKeyPress = new StateUnPress();
        if(Global.DEBUGMODE == true){
            currentKey = new Nothing();
            return;
        }        
    }    
    
    @Override
    public void paint(Graphics g) {
        currentKey.paint(g, this);
    }
}
