/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import gameobject.GameObject;
import gameobject.systembeat.SystemBeat;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author asdfg
 */
public class DebugMode {
    public static void debug(GameObject obj,Graphics g){
        g.setColor(Color.red);
        g.drawRect(obj.getX(), obj.getY(), obj.getWidth(), obj.getHeight());
        g.setColor(Color.blue);
        g.drawRect(obj.getImageRange().imageX, obj.getImageRange().imageY, obj.getImageRange().getImageWidth(), obj.getImageRange().getImageHeight());
    }
    
    public static void debug(SystemBeat beat,Graphics g){
        g.setColor(Color.yellow);
        g.drawRect(beat.getRightOnTempleRange(), Global.BEAT_Y, beat.getOnTempleRange(), Global.BEAT1_HEIGHT);
        g.drawRect(beat.getBeatEndX(), Global.BEAT_Y, beat.getOnTempleRange(), Global.BEAT1_HEIGHT);
        g.drawRect(beat.getBeatStartX(), Global.BEAT_Y, beat.getOnTempleRange(), Global.BEAT1_HEIGHT);    
        g.drawRect(Global.FRAME_SIZE_X - beat.getOnTempleRange(), Global.BEAT_Y, Global.FRAME_SIZE_X, Global.BEAT1_HEIGHT);        
    }
    
}
