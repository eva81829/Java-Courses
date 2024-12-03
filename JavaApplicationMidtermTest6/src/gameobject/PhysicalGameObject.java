/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject;

import controller.DelayCounter;
import utils.Global;

/**
 *
 * @author asdfg
 */
public abstract class PhysicalGameObject extends MovableGameObject{
    public static abstract class StateWeightlessness{
        public abstract void clickUp(PhysicalGameObject movableGameObject);
        public abstract void clickDown(PhysicalGameObject movableGameObject);
        public abstract void clickLeft(PhysicalGameObject movableGameObject);
        public abstract void clickRight(PhysicalGameObject movableGameObject);
    }
    
    public static class StateOnFloor extends StateWeightlessness{
        @Override
        public void clickUp(PhysicalGameObject movableGameObject) {
            movableGameObject.y -= 1;
            movableGameObject.setVerticalVelocity(20);
        }

        @Override
        public void clickDown(PhysicalGameObject movableGameObject) {
            movableGameObject.currentStateVelocity = new StateSlow();
            movableGameObject.horizontalVelocity = 2;
            movableGameObject.delayCounterAct.setDelay(4);
        }

        @Override
        public void clickLeft(PhysicalGameObject movableGameObject) {
            movableGameObject.currentStateDirection = new StateFaceLeft();
            movableGameObject.currentStateVelocity = new StateAcceleration();
            movableGameObject.delayCounterAct.setDelay(2);
        }

        @Override
        public void clickRight(PhysicalGameObject movableGameObject) {
            movableGameObject.currentStateDirection = new StateFaceRight();
            movableGameObject.currentStateVelocity = new StateAcceleration();
            movableGameObject.delayCounterAct.setDelay(2);
        }
    }
    
    public static class StateInAir extends StateWeightlessness{
        @Override
        public void clickUp(PhysicalGameObject movableGameObject) {
            
        }

        @Override
        public void clickDown(PhysicalGameObject movableGameObject) {
            
        }

        @Override
        public void clickLeft(PhysicalGameObject movableGameObject) {
            movableGameObject.currentStateDirection = new StateFaceLeft();
        }

        @Override
        public void clickRight(PhysicalGameObject movableGameObject) {
            movableGameObject.currentStateDirection = new StateFaceRight();
        }
    }
    
    public static abstract class StateVelocity{
        public abstract void clickRight(PhysicalGameObject movableGameObject);
        public abstract void clickLeft(PhysicalGameObject movableGameObject);
    }
    
    public static class StateAcceleration extends StateVelocity{

        @Override
        public void clickRight(PhysicalGameObject movableGameObject) {
            
        }

        @Override
        public void clickLeft(PhysicalGameObject movableGameObject) {
            
        }
        
    }
    
    public static class StateDeceleration extends StateVelocity{

        @Override
        public void clickRight(PhysicalGameObject movableGameObject) {
            
        }

        @Override
        public void clickLeft(PhysicalGameObject movableGameObject) {
            
        }

    }
    
    public static class StateSlow extends StateVelocity{

        @Override
        public void clickRight(PhysicalGameObject movableGameObject) {
            
        }

        @Override
        public void clickLeft(PhysicalGameObject movableGameObject) {
            
        }
        
    }
    
    public static abstract class StateDirection{
        public abstract void paint(PhysicalGameObject movableGameObject);
    }

    public static class StateFaceRight extends StateDirection{

        @Override
        public void paint(PhysicalGameObject movableGameObject) {
            
        }
        
    }
    
    public static class StateFaceLeft extends StateDirection{
        @Override
        public void paint(PhysicalGameObject movableGameObject) {
            
        }
    }
    
    public static abstract class StateMotion{
        
    }
     
    public static class StateStop extends StateMotion{
        
    }
    
//    public static abstract class StateMonitorObject{}
//    
//    public static abstract class StateCharacter extends StateMonitorObject{}
//    
//    public static abstract class StateMonster extends StateMonitorObject{}
    
    protected int verticalVelocity;
    protected int horizontalVelocity;
    protected int acceleration;
    protected DelayCounter delayCounterAct;
    protected StateWeightlessness currentStateWeightlessness;
    protected StateVelocity currentStateVelocity;
    protected StateDirection currentStateDirection;
    protected StateMotion currentStateMotion;
    
    public PhysicalGameObject(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    
    public int getVerticalVelocity(){
        return verticalVelocity;
    }
    
    public int getHorizontalVelocity(){
        return horizontalVelocity;
    }
    
    public void setVerticalVelocity(int verticalVelocity){
        this.verticalVelocity = verticalVelocity ;
    }
    
    public void setHorizontalVelocity(int horizontalVelocity){
        this.horizontalVelocity = horizontalVelocity ;
    }
    
    public void setAcceleration(int acceleration){
        this.acceleration = acceleration;
    }
    
    public int getAcceleration(){
        return acceleration;
    }
    
    public void setStateWeightlessness(StateWeightlessness currentState){
        this.currentStateWeightlessness = currentState;
    }
    
    public void setStateVelocity(StateVelocity currentState){
        this.currentStateVelocity = currentState;
    }
       
    public void setStateFace(StateDirection currentState){
        this.currentStateDirection = currentState;
    }
    
    public void setStateMotion(StateMotion currentState){
        this.currentStateMotion = currentState;
    }
    
    public StateWeightlessness getStateWeightlessness(){
        return currentStateWeightlessness;
    }
    
    public StateVelocity getStateVelocity(){
        return currentStateVelocity;
    }
    
    public StateDirection getStateDirection(){
        return currentStateDirection;
    }
    
    public StateMotion getStateMotion(){
        return currentStateMotion;
    }
    
}
