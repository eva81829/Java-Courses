/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test07;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Eka
 */
public class Test07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final JFrame j = new JFrame();
        j.setTitle("Stunned Cat");
        j.setSize(800,700);
        
        GameJPanel jp = new GameJPanel();
        j.add(jp);
        
        Timer timer = new Timer(15, new ActionListener(){
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