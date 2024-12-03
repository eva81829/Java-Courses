/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject.systembeat;

import controller.ImageResourceController;
import controller.PathBuilder;
import gameobject.MovableGameObject;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import temposystem.TempoController;
import utils.DebugMode;
import utils.Global;
import utils.ImagePath;

/**
 *
 * @author Eka
 */
public class SystemBeat extends MovableGameObject{
    private TempoController tempoController;    
    private BufferedImage img1;
    private BufferedImage img2;
    private int linedy;
    private int shakeCount;
    private int lineX;
    private int lineY;
    private int beatStartX; // 節拍開始的X位置  
    private int beatStartY; // 節拍開始的Y位置
    private int beatEndX; // 節拍結束(被正確打擊)的Y位置
    private int beatEndY; // 節拍結束(被正確打擊)的Y位置
    private int onTempleRange; // 可容忍打擊的正負誤差範圍
    private int rightOnTempleRange; //最右邊可容忍打擊的範圍;
    private int leftOnTempleRange; //最左邊可容忍打擊的範圍;
    private boolean isMove;
    
    public SystemBeat(int beatStartX, int beatStartY, int beatEndX,  int beatEndY) {
        super(beatStartX, beatStartY, Global.BEAT1_WIDTH, Global.BEAT1_HEIGHT); // 設定節拍移動中的X位置, 節拍移動中的Y位置, 節拍圖片尺寸
        this.beatStartX = beatStartX;
        this.beatStartY = beatStartY;
        this.beatEndX = beatEndX;
        this.beatEndY = beatEndY;        
        ImageResourceController irc = ImageResourceController.getInstance();
        img1 = irc.tryGetImage(PathBuilder.getImage(ImagePath.Tempo.TEMPO1));
        img2 = irc.tryGetImage(PathBuilder.getImage(ImagePath.Tempo.TEMPO3));
        lineY = Global.LINE_Y;
        linedy = shakeCount = lineX = 0;
        tempoController = new TempoController();
        setSpeed(tempoController.getTempo());
        setImageRange(0,0,0,0);
        onTempleRange = (beatEndX - beatStartX)/tempoController.getParameter();
        rightOnTempleRange = beatEndX - onTempleRange;
        leftOnTempleRange = beatStartX + onTempleRange;
        isMove = false;
    } 
    
    public void setisMoveTrue(){
        isMove = true;
    }
    
    public void setisMoveFalse(){
        isMove = false;
    }    
    
    public int getOnTempleRange(){
        return onTempleRange; 
    }
    
    public int getBeatEndX(){
        return beatEndX; 
    }
    
    public int getBeatStartX(){
        return beatStartX; 
    }    
    
    public int getRightOnTempleRange(){
        return rightOnTempleRange; 
    }
    
    public int getLeftOnTempleRange(){
        return leftOnTempleRange; 
    }    
    
    @Override
    public void update(){
        move();
    }
    
    public void move(){
        if(Global.DEBUGMODE == true  && isMove == true){
            return;
        }
        
        if(x > beatEndX){
            setSpeed(tempoController.getTempo());
            x = beatStartX;
            return;
        }

        x += getSpeed();
        updateLine();
    }
    
    public boolean checkOnTempo(){
        if (x < rightOnTempleRange && x > leftOnTempleRange){
            return false;
        }
        return true;
    }
    
    
    private void updateLine(){
        if(Global.DEBUGMODE == true  && isMove == true){
            return;
        }        
        
        if (lineY > Global.LINE_Y || lineY < Global.LINE_Y){
            lineY = Global.LINE_Y;
            return;
        } 
        linedy = (int)(Math.random() * 3);
        
        if (shakeCount == 0){
            lineY += linedy;
            shakeCount = 1;
            return;
        }
        lineY -= linedy;
        shakeCount = 0;
        return;        
    }
        
    @Override
    public void paint(Graphics g) {
        if(Global.DEBUGMODE == true){
            DebugMode.debug(this, g);
        }
        setPenWidthAndColor(g);
        g.drawImage(img1, x - Global.BEAT1_WIDTH/2, y, null); //畫左邊的震動圖
        g.drawImage(img2, Global.FRAME_SIZE_X - Global.BEAT1_WIDTH - (x - Global.BEAT1_WIDTH/2), y, null);  //畫右邊的震動圖
        g.drawLine(lineX, lineY, x, lineY); //畫左邊的線
        g.drawLine(Global.FRAME_SIZE_X - lineX, lineY, Global.FRAME_SIZE_X - x, lineY); //畫右邊的線      
    }
    
    public void setPenWidthAndColor(Graphics g) {    
        if(Global.DEBUGMODE == true){
            DebugMode.debug(this, g);
        }
        int width = 5;        
        ((Graphics2D)g).setStroke(new BasicStroke(width));
        Color color= new Color(1.0F, 1.0F, 1.0F, 0.5F);
        g.setColor(color);
    }
}
