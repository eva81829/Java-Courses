/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject;

import utils.Global;

/**
 *
 * @author asdfg
 */
public abstract class MovableGameObject extends GameObject{
    public static abstract class State{
        public abstract void clickUp();
    }
    
    public static class StateOnFloor extends State{
        @Override
        public void clickUp() {
            
        }
    }
    
    public static class StateInAir extends State{
        @Override
        public void clickUp() {
            
        }
    }
    
    public static class StateAcceleration extends State{

        @Override
        public void clickUp() {
          
        }
    }
    
    public static class StateDeceleration extends State{

        @Override
        public void clickUp() {
          
        }
    }
    
    public static class StateFaceRight extends State{

        @Override
        public void clickUp() {
           
        }
    }
    
    public static class StateFaceLeft extends State{

        @Override
        public void clickUp() {
           
        }
    }
    
    protected int verticalVelocity;
    protected int horizontalVelocity;
    protected int speed;
    protected int acceleration;
    protected State currentStateWeightlessness;
    protected State currentStateVelocity;
    protected State currentStateFace;
    
    public MovableGameObject(int x, int y, int width, int height,int speed) {
        super(x, y, width, height);
        setSpeed(speed);
    }
    
    public MovableGameObject(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    
    public void setSpeed(int speed){
        this.speed = speed * Global.ACTION_SPEED;
    }
    
    public int getSpeed(){
        return speed;
    }
    
    public void setAcceleration(int acceleration){
        this.acceleration = acceleration;
    }
    
    public int getAcceleration(){
        return acceleration;
    }
    
    public void setStateWeightlessness(State currentState){
        this.currentStateWeightlessness = currentState;
    }
    
    public void setStateVelocity(State currentState){
        this.currentStateVelocity = currentState;
    }
       
    public void setStateFace(State currentState){
        this.currentStateFace = currentState;
    }
    
    public State getStateWeightlessness(){
        return currentStateWeightlessness;
    }
    
    public State getStateVelocity(){
        return currentStateVelocity;
    }
    
    public State getStateFace(){
        return currentStateFace;
    }
    
    public int getVerticalVelocity(){
        return verticalVelocity;
    }
    
    public int getHorizontalVelocity(){
        return horizontalVelocity;
    }
    
    public void setVerticalVelocity(int verticalVelocity){
        this.verticalVelocity = verticalVelocity;
    }
    
    public void setHorizontalVelocity(int horizontalVelocity){
        this.horizontalVelocity = horizontalVelocity;
    }

    

    
}
