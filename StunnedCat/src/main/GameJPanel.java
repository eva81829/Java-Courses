/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import gameObject.StunnedCat;
import java.awt.Graphics;
import javax.swing.JPanel;
import values.Global;

/**
 *
 * @author Eka
 */
public class GameJPanel extends JPanel{
    private StunnedCat cat;
            
    public GameJPanel(){
        cat = new StunnedCat(Global.CAT_X, Global.CAT_Y, Global.CAT_X_OFFSET, Global.CAT_Y_OFFSET);
    }
    
    public void update(){
        cat.move();
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.drawImage(cat.img, 0, 0, null);
        
        //cat.paint(g);
    }
}
