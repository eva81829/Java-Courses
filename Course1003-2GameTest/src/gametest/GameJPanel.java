/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gametest;

import gameobject.Aircraft;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Eka
 */
public class GameJPanel extends JPanel{
    private Aircraft ac;
    private ArrayList<CEnemy> cm;
    private ArrayList<CBoom> cb;
    
    public class CMyListener1 extends MouseAdapter{
        @Override
        public void mouseMoved(MouseEvent e){
            System.out.println(e.getX()); //取得當下滑鼠的座標
            ac.changeDir(e.getX());
        }
        
        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                CBoom boom = new CBoom(ac.getX() + 5, ac.getY() - 10);
                cb.add(boom);
            }
        }
    }
    
    public GameJPanel(){
        ac = new Aircraft();
        cm = new ArrayList<>();
        cb = new ArrayList<>();
        CMyListener1 listener = new CMyListener1();
        this.addMouseListener(listener); //裡面有click
        this.addMouseMotionListener(listener); // 裡面有move, 利用自己實現MouseMotionListener的類別, 使用其中的方法
    }
    
    
    public void update(){
        ac.move();
        
        if(Math.random() > 0.8 && cm.size() <11){ //隨機產生敵人
            CEnemy enemy = new CEnemy ((int)(Math.random()* 600), 0 ,
                                        (int)(Math.random()*10)-5);
            cm.add(enemy); //敵人加入array
        }
        
        for(int i=0; i<cm.size(); i++){ //敵人移動
            if(!cm.get(i).move()){ //如果超出邊界就從arr中移除
                cm.remove(i);
            } else {
                if (ac.checkAttack(cm.get(i))){ //如果敵人活著, 又碰到自己則死(確認碰撞)
                    System.exit(1);
                }
            }
        }
        
        for (int i = 0; i < cb.size(); i++) { //子彈移動
            CBoom boom = cb.get(i);
            if (!boom.move()) {
                cb.remove(i);
            } else {
                for (int j = 0; j < cm.size(); j++) {  //如果子彈活著, 又碰到敵人則敵人消失(確認碰撞)
                    if (boom.checkAttack(cm.get(j))) {
                        cm.remove(j);
                        break;
                    }
                }
            }
        }        
        
    }

//    @Override
//    public void paintComponent(Graphics g){
//        ac.paint(g);
//        //g.drawImage(img, x, y, this);
//        //g.drawImage(img, x, y, 50, 50, this);
//    }
    
    @Override
    public void paint(Graphics g){
        ac.paint(g);
        
        for(int i=0; i<cm.size(); i++){      
            cm.get(i).paint(g);
        }

        for (int i = 0; i < cb.size(); i++) {
            cb.get(i).paint(g);
        }
    }    
}
