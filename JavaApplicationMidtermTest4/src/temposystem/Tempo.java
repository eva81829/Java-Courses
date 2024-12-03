/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temposystem;

import controller.DelayCounter;
import gameobject.GameObject;
import gameobject.systembeat.Beat1;
import gameobject.systembeat.Electric1;
import gameobject.systembeat.Electric2;
import gameobject.systembeat.Electric3;
import gameobject.systembeat.Line1;
import gameobject.systembeat.Line2;
import gameobject.systembeat.Line3;
import java.awt.Color;
import java.awt.Graphics;
import utils.Global;

/**
 *
 * @author Eka
 */
public class Tempo {
    private static final int[]  tempo = {10, 5, 5};
    public GameObject beat;
    
    public Tempo(){
        beat = new Line3 (10);
        //beat = new Line1 (0, Global.BEAT, 150, 106, tempo);
    }
    
}