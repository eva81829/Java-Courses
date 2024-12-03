/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import gameobject.MovableGameObject;

/**
 *
 * @author asdfg
 */
public class PhysicalEffect {
    private MovableGameObject obj;
    private int maxSpeed;
    
    public PhysicalEffect(MovableGameObject obj,int maxSpeed ,int speed, int acceleration){
        this.obj = obj;
        this.maxSpeed = maxSpeed;
        obj.setAcceleration(acceleration);
        obj.setSpeed(speed);
    }
    
    public void sprint(){
        if(obj.getHorizontalVelocity() < maxSpeed && obj.getStateVelocity() instanceof MovableGameObject.StateAcceleration){
            obj.setHorizontalVelocity(obj.getHorizontalVelocity() + obj.getAcceleration());
        }else if(obj.getHorizontalVelocity() >= maxSpeed){
            obj.setStateVelocity(new MovableGameObject.StateDeceleration());
            obj.setHorizontalVelocity(obj.getHorizontalVelocity() - obj.getAcceleration());
        }else if(obj.getHorizontalVelocity() > 0 && obj.getStateVelocity() instanceof MovableGameObject.StateDeceleration){
            obj.setHorizontalVelocity(obj.getHorizontalVelocity() - obj.getAcceleration());
        }else if(obj.getHorizontalVelocity() == 0 && obj.getStateVelocity() instanceof MovableGameObject.StateDeceleration){
            obj.setStateVelocity(null);
        }
    }
    
    public void drop(){
        if(obj.getY() < Global.FLOOR){
            // 時間 是恆久存在的應該透過 速度和加速度的變化去製造物理效果而不是改變 移動的距離
            obj.setVerticalVelocity(obj.getVerticalVelocity() - Global.Acceleration.G);
            obj.setStateWeightlessness(new MovableGameObject.StateInAir());
            obj.setY(obj.getY()-obj.getVerticalVelocity());
        }else{
            obj.setStateWeightlessness(new MovableGameObject.StateOnFloor());
            obj.setY(Global.FLOOR);
        }
    }
}
