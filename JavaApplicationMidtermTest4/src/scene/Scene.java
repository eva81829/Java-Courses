/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scene;

import controller.CommandSolver.*;
import gameobject.GameObject;
import gameobject.character.SmallCat;
import java.awt.*;
import java.util.ArrayList;
import temposystem.Tempo;
import utils.Global;

/**
 *
 * @author asdfg
 */
public abstract class Scene{
    protected ArrayList<GameObject> gameObjects;
    
    public abstract void sceneBegin();
    
    public void sceneUpdate(){
        for (int i=0;i<gameObjects.size();i++){
            gameObjects.get(i).move();
        }
    }
    
    public abstract void sceneEnd();
    
    public void paint(Graphics g){
        for (int i=0;i<gameObjects.size();i++){
            gameObjects.get(i).paint(g);
        } 
    }
    
    public abstract KeyCommandListener getKey();
    public abstract MouseCommandListener getMouse();
}
