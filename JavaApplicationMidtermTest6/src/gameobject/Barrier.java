/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject;

import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author asdfg
 */
public class Barrier extends GameObject{
    
    private Graphics2D barrierTest;

    public Barrier(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void paint(Graphics g) {
        g.drawRect(x, y, width, height);
    }
    
}
