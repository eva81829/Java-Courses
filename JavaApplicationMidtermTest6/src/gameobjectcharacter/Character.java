/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobjectcharacter;

import controller.CharacterHelper;
import gameobject.PhysicalGameObject;

/**
 *
 * @author asdfg
 */
public abstract class Character extends PhysicalGameObject{
    public abstract static class StateCharacter{
    
    }
    public static class StateCat extends StateCharacter{
        
    }
    
    public static class StateBoy extends StateCharacter{
       
    }
    
    protected int hp;
    protected StateCharacter currentCharacterState;
    protected CharacterHelper characterHelper;
    
    public Character(int x, int y, int width, int height) {
        super(x, y, width, height);
        
    }
    
    public StateCharacter getCharacterState(){
        return currentCharacterState;
    }
    
    public void setCharacterState(StateCharacter currentCharacterState){
        this.currentCharacterState = currentCharacterState;
    }
    
    public void setCharacterHelper(Character character){
        characterHelper = new CharacterHelper(character);
    }
    
    public abstract void jump();
    
    public abstract void turnRight();
    
    public abstract void turnLeft();
    
}
