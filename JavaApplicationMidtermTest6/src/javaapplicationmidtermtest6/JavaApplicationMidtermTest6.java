/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationmidtermtest6;
import controller.CommandSolver;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import utils.Global;

/**
 *
 * @author asdfg
 */
public class JavaApplicationMidtermTest6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//         if ("1234".indexOf("23")<0){
//             System.out.println("不在");
//         } else {
//             System.out.println("1234".indexOf("23")+"在");
//         }
        
        final JFrame f = new JFrame();
        f.setSize(Global.FRAME_SIZE_X, Global.FRAME_SIZE_Y);
        f.setTitle("動作測試");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GameJPanel jp = new GameJPanel();
        f.add(jp);
        
        CommandSolver cs = new CommandSolver.Builder(Global.MILLERSEC_PER_UPDATE, new int[][]{
            {KeyEvent.VK_DOWN, Global.DOWN},
            {KeyEvent.VK_UP, Global.UP},
            {KeyEvent.VK_LEFT, Global.LEFT},
//            {KeyEvent.VK_DOWN, Global.DOWN},
            {KeyEvent.VK_RIGHT, Global.RIGHT},
        })/*.enableMouseTrack(f)*/.keyCleanMode().gen();
        
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
