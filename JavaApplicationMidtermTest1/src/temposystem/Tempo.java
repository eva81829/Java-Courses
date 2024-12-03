/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temposystem;

import controller.DelayCounter;
import gameobject.GameObject;
import gameobject.beat.Beat1;
import gameobject.beat.Electric1;
import gameobject.beat.Electric2;
import gameobject.beat.Electric3;
import gameobject.beat.Line1;
import gameobject.beat.Line2;
import gameobject.beat.Line3;
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
        beat = new Beat1 (0, Global.BEAT, 150, 106, tempo);
    }
    
}