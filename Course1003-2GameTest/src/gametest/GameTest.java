/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Eka
 */
public class GameTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final JFrame j = new JFrame();
        j.setTitle("飛機射擊遊戲");
        j.setSize(800,700);
        //j.setBounds(0,0,400,300);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GameJPanel jp = new GameJPanel();
        j.add(jp);
        //FPS(frame_per_sec) = 一秒跑幾禎 = 1000/Millisec_per_frame
        Timer timer = new Timer(50, new ActionListener(){ //多少毫秒更新一次(Millisec_per_frame畫一禎需要多少毫秒), 週期, 越小更新速度越快
           @Override
           public void actionPerformed(ActionEvent e){
               jp.update();
               j.repaint();
           }
        });
        timer.start();
        
        j.setVisible(true);
    }
}
