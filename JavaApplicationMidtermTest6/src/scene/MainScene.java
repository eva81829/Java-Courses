/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scene;

import controller.CommandSolver;
import gameobject.Barrier;
import gameobject.background.Background;
import gameobject.background.BackgroundHouse;
import gameobject.systembeat.SystemBeat;
import gameobject.userbeat.UserBeat1;
import gameobject.userbeat.UserBeat;
import gameobjectcharacter.SmallCat;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import temposystem.ActionKey;
import temposystem.TempoController;
import utils.Global;

/**
 *
 * @author asdfg
 */
public class MainScene extends Scene{
    private SystemBeat beat;
    private SmallCat cat;
    private Barrier testwall;
    private Background backgroundHouse;
    private TempoController tempoController;
    private UserBeat userBeat;
    private ActionKey actionKey;
    
    @Override
    public void sceneBegin() {
        cat = new SmallCat(50, 400, 90, 50);
        beat = new SystemBeat (0, Global.BEAT_Y, (int)((Global.FRAME_SIZE_X)/2), Global.BEAT_Y);
        backgroundHouse = new BackgroundHouse(0, 0, 2300, 994);
        userBeat = new UserBeat(550, 450, Global.CAT_X_OFFSET, Global.CAT_Y_OFFSET);
    }

    @Override
    public void sceneUpdate() {
        cat.update();
        beat.update();
        userBeat.update();
    }

    @Override
    public void sceneEnd() {
     
    }

    @Override
    public void paint(Graphics g) {
        backgroundHouse.paint(g);
        cat.paint(g);
        beat.paint(g);
        userBeat.paint(g);
    }
    
    private boolean buttonUp = false;
    private boolean buttonDown = false;
    @Override
    public CommandSolver.KeyCommandListener getKey() {
        return new CommandSolver.KeyCommandListener(){
            @Override
            public void keyPressed(int commandCode, long trigTime) {
                switch(commandCode){
                    case Global.UP:
//                            if (beat.checkOnTempo()){
//                                cat.jump();
//                            }
                            System.out.println(commandCode);
                            //System.out.println(actionKey.ActionKey(commandCode));
                            userBeat.checkOnTemple(beat.checkOnTempo());
                            beat.setisMoveTrue();
                        break;
                    
                    case Global.DOWN:
                            //System.out.println(actionKey.ActionKey(commandCode));
                            userBeat.checkOnTemple(beat.checkOnTempo());
                            beat.setisMoveTrue(); 
                        break;
                    
                    case Global.LEFT:
                            //System.out.println(actionKey.ActionKey(commandCode));
                            userBeat.checkOnTemple(beat.checkOnTempo());
                            beat.setisMoveTrue(); 
                        break;
                    case Global.RIGHT:
                            //System.out.println(actionKey.ActionKey(commandCode));
                            userBeat.checkOnTemple(beat.checkOnTempo());
                            beat.setisMoveTrue();
                        break;
                }
            }
            @Override
            public void keyReleased(int commandCode, long trigTime) {
                userBeat.unPress();
                beat.setisMoveFalse();
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
