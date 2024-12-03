/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gameobject.GameObject;
import gameobject.PhysicalGameObject;
import utils.Global;

/**
 *
 * @author asdfg
 */
public class PhysicalEffect {
    private PhysicalGameObject obj;
    private int maxSpeed;
    
    public PhysicalEffect(PhysicalGameObject obj,int maxSpeed, int acceleration){
        this.obj = obj;
        this.maxSpeed = maxSpeed;
        obj.setAcceleration(acceleration);
    }
    
    public void sprint(){
        if(obj.getHorizontalVelocity() < maxSpeed && obj.getStateVelocity() instanceof PhysicalGameObject.StateAcceleration){
            obj.setHorizontalVelocity(obj.getHorizontalVelocity() + obj.getAcceleration());
        }else if(obj.getHorizontalVelocity() >= maxSpeed){
            obj.setStateVelocity(new PhysicalGameObject.StateDeceleration());
            obj.setHorizontalVelocity(obj.getHorizontalVelocity() - obj.getAcceleration());
        }else if(obj.getHorizontalVelocity() > 4 && obj.getStateVelocity() instanceof PhysicalGameObject.StateDeceleration){
            obj.setHorizontalVelocity(obj.getHorizontalVelocity() - obj.getAcceleration());
        }else if(obj.getHorizontalVelocity() == 4 && obj.getStateVelocity() instanceof PhysicalGameObject.StateDeceleration){
            obj.setStateVelocity(null);
        }
    }
    
    public void drop(){
        if(obj.getY() < Global.FLOOR){
            // 時間 是恆久存在的應該透過 速度和加速度的變化去製造物理效果而不是改變 移動的距離
            obj.setVerticalVelocity(obj.getVerticalVelocity() - Global.Acceleration.G);
            obj.setStateWeightlessness(new PhysicalGameObject.StateInAir());
            obj.setY(obj.getY()-obj.getVerticalVelocity());
        }else{
            obj.setStateWeightlessness(new PhysicalGameObject.StateOnFloor());
            obj.setY(Global.FLOOR);
        }
    }
    
    public void isCollision(GameObject barrier){
        if(obj.isCollision(barrier)){
            obj.setStateMotion(new PhysicalGameObject.StateStop());
            obj.setHorizontalVelocity(0);
        }else{
            obj.setStateMotion(null);
        }
    }
}
