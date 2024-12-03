/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test07;

import gameObject.Actor1;
import gameObject.Actor2;
import gameObject.Actor3;
import gameObject.Actor4;
import java.awt.Graphics;
import javax.swing.JPanel;
import values.Global;

/**
 *
 * @author Eka
 */
public class GameJPanel extends JPanel{
    private Actor1 actor1;
    private Actor2 actor2;
    private Actor3 actor3;
    private Actor4 actor4;    
    public GameJPanel(){
        actor1 = new Actor1(0, 0, 32, 32);
        actor2 = new Actor2(32, 0, 32, 32);
        actor3 = new Actor3(96, 0, 128, 128);
        actor4 = new Actor4(64, 0, 32, 32);
    }
    
    public void update(){
    }
    
    @Override
    public void paintComponent(Graphics g){
        actor1.paint(g);
        actor2.paint(g);
        actor3.paint(g);
        actor4.paint(g);        
    }
    
}
