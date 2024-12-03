/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scene;

import controller.CommandSolver;
import gameobject.GameObject;
import gameobject.background.House;
import gameobject.beat.Electric1;
import gameobject.beat.Electric2;
import gameobject.character.SmallCat;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import temposystem.Tempo;
import utils.Global;

/**
 *
 * @author asdfg
 */
public class MainScene extends Scene{
    private Tempo tempo;    
    private SmallCat cat;
    private House house;
    
    @Override
    public void sceneBegin() {
        //electric = new Electric1(0, 0, 150, 106, 10);
        tempo = new Tempo();
        house = new House(0, 0, 2300, 994);        
        cat = new SmallCat(50, 400, 140, 140, 3);         
        
        gameObjects = new ArrayList<>();
        gameObjects.add(house);
        gameObjects.add(cat);
        gameObjects.add(tempo.beat);
    }
    
    @Override
    public void sceneEnd() {
    }
    
//    @Override
//    public void paint(Graphics g){
//        house.paint(g);
//	tempo.paint(g);
//        cat.paint(g);
//        electric.paint(g);
//    }

    @Override
    public CommandSolver.KeyCommandListener getKey() {
        return new CommandSolver.KeyCommandListener(){
            @Override
            public void keyPressed(int commandCode, long trigTime) {
                //System.out.println(commandCode + " " + trigTime);
                switch(commandCode){
                    case Global.UP:
                        cat.jump();
                        break;
                    case Global.DOWN:
                        break;
                    case Global.LEFT:
                        break;
                    case Global.RIGHT:
                        break;
                }
            }

            @Override
            public void keyReleased(int commandCode, long trigTime) {
                
            }
        };
    }

    @Override
    public CommandSolver.MouseCommandListener getMouse() {
        return new CommandSolver.MouseCommandListener() {

            @Override
            public void mouseTrig(MouseEvent e, CommandSolver.MouseState state, long trigTime) {
                if(state != null){
                    System.out.println(e.getButton() + " " + e.getX() + " " + e.getY() + " " + state);
                }
            }
        };
    }
    
}
