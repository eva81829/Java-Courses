/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationmidtermtest1;

import controller.CommandSolver;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import utils.Global;

/**
 *
 * @author asdfg
 */
public class JavaApplicationMidtermTest1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        final JFrame f = new JFrame();
        f.setSize(Global.Frame_SIZE_X, Global.Frame_SIZE_Y );
        f.setTitle("動作測試");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        
        GameJPanel jp = new GameJPanel();
        f.add(jp);
        
        CommandSolver cs = new CommandSolver.Builder(Global.MILLERSEC_PER_UPDATE, new int[][]{
            {KeyEvent.VK_UP, Global.UP},
            {KeyEvent.VK_LEFT, Global.LEFT},
            {KeyEvent.VK_DOWN, Global.DOWN},
            {KeyEvent.VK_RIGHT, Global.RIGHT},
        })/*.enableMouseTrack(f)*/.gen();
        
        f.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                cs.trig(e.getKeyCode(), true);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                cs.trig(e.getKeyCode(), false);
            }
        });
        f.setFocusable(true);
        
        cs.start();
        
        f.setVisible(true);
        
        long startTime = System.currentTimeMillis();
        long lastRepaintTime = System.currentTimeMillis();
        long passedFrames = 0;
        
        while(true){
            long currentTime = System.currentTimeMillis();
            long totalTime = currentTime - startTime;
            long targetTotalFrame = totalTime / Global.MILLERSEC_PER_UPDATE;
            while(passedFrames < targetTotalFrame){
                jp.update(cs.update());
                passedFrames++;
            }
            if(Global.LIMIT_DELTA_TIME < currentTime - lastRepaintTime){
                lastRepaintTime = currentTime;
                f.repaint();
            }
        }      
    
    }
}
