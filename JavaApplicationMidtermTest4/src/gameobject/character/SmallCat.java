/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject.character;

import controller.*;
import utils.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


/**
 *
 * @author asdfg
 */
public class SmallCat extends Character{
    
    private static final int[] ACT = {0, 1, 2, 3, 1};
    private static final int[] ACTDIV = {3, 2, 1, 0, 2};
    private static final int[] ACTSLOW = {0, 1, 2, 1};
    private int act;
    private DelayCounter delayCounterAct;
    private DelayCounter delayCounterDrop;
    PhysicalEffect physicalEffect;
    protected BufferedImage img;
    protected BufferedImage imgdiv;

    public SmallCat(int x, int y, int width, int height) {
        super(x, y, width, height);
        ImageResourceController irc = ImageResourceController.getInstance();
        img = irc.tryGetImage(PathBuilder.getImage(ImagePath.Character.Cat.SMALL_CAT_ACT));
        imgdiv = irc.tryGetImage(PathBuilder.getImage(ImagePath.Character.Cat.SMALL_CAT_ACTDIV));
        
        act = 0;
        direction = 0;
        currentStateFace = new StateFaceRight();
        delayCounterAct = new DelayCounter(4);
        physicalEffect = new PhysicalEffect(this, 16, 2, 2);
    }
    @Override
    public boolean move(){
        if(delayCounterAct.update()){
            act = ++act % 5;
        }
        physicalEffect.drop();
        if(currentStateFace instanceof StateFaceRight){
            physicalEffect.sprint();
            x += horizontalVelocity + getSpeed();    
        }else if(currentStateFace instanceof StateFaceLeft){
            physicalEffect.sprint();
            x -= horizontalVelocity + getSpeed();    
        }
        return true;
    }

    @Override
    public void jump() {
        if(currentStateWeightlessness instanceof StateOnFloor){
            y -= 1;
            verticalVelocity = 25;
        }
    }
    
    @Override
    public void turnRight() {
        currentStateFace = new StateFaceRight();
        if(currentStateWeightlessness instanceof StateOnFloor){
            currentStateVelocity = new StateAcceleration();
        }
    }

    @Override
    public void turnLeft() {
        currentStateFace = new StateFaceLeft();
        if(currentStateWeightlessness instanceof StateOnFloor){
            currentStateVelocity = new StateAcceleration();
        }
    }
    
    public void slow(){
        if(currentStateWeightlessness instanceof StateOnFloor){
            horizontalVelocity = -3;
        }
    }

    @Override
    public void paint(Graphics g) {
        if(currentStateFace instanceof StateFaceRight){
            g.drawImage(img, x, y, x + width, y + height, 
            0 + ACT[act] * Global.IMG_X_OFFSET, 0,
            140 + ACT[act] * Global.IMG_X_OFFSET, 140, null);
        }
        if(currentStateFace instanceof StateFaceLeft){
            g.drawImage(imgdiv, x, y, x + width, y + height, 
            0 + ACTDIV[act] * Global.IMG_X_OFFSET, 0,
            140 + ACTDIV[act] * Global.IMG_X_OFFSET, 140, null);
        }
    }
}
