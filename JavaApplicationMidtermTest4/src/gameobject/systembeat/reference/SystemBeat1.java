/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject.systembeat.reference;

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
public class SystemBeat1 {
//extends MovableGameObject{
//    private TempoController tempoController;    
//    private BufferedImage img1;
//    private BufferedImage img2;
//    private int linedy;
//    private int shakeCount;
//    private int lineX;
//    private int lineY;
//    private int beatStartX; // 節拍開始的X位置  
//    private int beatStartY; // 節拍開始的Y位置
//    private int beatEndX; // 節拍結束(被正確打擊)的Y位置
//    private int beatEndY; // 節拍結束(被正確打擊)的Y位置
//    private long onTempleTimeStart; // 正確節奏的最早打擊時間點
//    private long onTempleTimeEnd; // 正確節奏的最晚打擊時間點
//    private long OnTempoRange; //可容忍打擊的正負誤差範圍
//    
//    public SystemBeat1(int beatStartX, int beatStartY, int beatEndX,  int beatEndY) {
//        super(beatStartX, beatStartY, Global.BEAT1_WIDTH, Global.BEAT1_HEIGHT); // 設定節拍移動中的X位置, 節拍移動中的Y位置, 節拍圖片尺寸
//        this.beatStartX = beatStartX;
//        this.beatStartY = beatStartY;
//        this.beatEndX = beatEndX;
//        this.beatEndY = beatEndY;        
//        ImageResourceController irc = ImageResourceController.getInstance();
//        img1 = irc.tryGetImage(PathBuilder.getImage(ImagePath.Tempo.TEMPO1));
//        img2 = irc.tryGetImage(PathBuilder.getImage(ImagePath.Tempo.TEMPO3));
//        lineY = Global.LINE_Y;
//        linedy = shakeCount = lineX = 0;
//        tempoController = new TempoController();
//        setSpeed(tempoController.getTempo());
//        calculateOnTempleTime();
//        setImageRange(0,0,0,0);
//    }    
//    
//    public long getOnTempleTimeStart(){
//        return onTempleTimeStart; 
//    }
//    
//    public long getOnTempleTimeEnd(){
//        return onTempleTimeEnd; 
//    }   
//    
//    
//    @Override
//    public void update(){
//        move();
//    }
//    
//    public void move(){
//        if(x > beatEndX){
//            setSpeed(tempoController.getTempo());
//            calculateOnTempleTime();
//            x = beatStartX;
//            return;
//        }
//        x += getSpeed();
//        updateLine();
//    }
//    
//    private void calculateOnTempoRange(){
//        // 計算可容忍打擊的正負誤差範圍
//        OnTempoRange = (long)(beatEndX - beatStartX)/(long)getSpeed()/tempoController.getParameter(); // 總距離/總速度 = 總時間, 總時間/容忍係數 = 容忍範圍
//    }
//    
//    private void calculateOnTempleTime(){
//        // 計算正確節奏的最晚/最早打擊時間點
//        //onTempleTimeEnd = System.currentTimeMillis() + (long)(beatEndX - beatStartX)/(long)getSpeed();
//        //calculateOnTempoRange();
//        //onTempleTimeStart = onTempleTimeEnd - OnTempoRange;
//        onTempleTimeStart = System.currentTimeMillis();
//        onTempleTimeEnd = onTempleTimeStart + (long)(beatEndX - beatStartX)/(long)getSpeed();
//        System.out.println();
//        System.out.println((long)(beatEndX - beatStartX)/(long)getSpeed());
//        System.out.println(onTempleTimeStart);
//        System.out.println(onTempleTimeEnd);
//    }
//    
//    private void updateLine(){
//        if (lineY > Global.LINE_Y || lineY < Global.LINE_Y){
//            lineY = Global.LINE_Y;
//            return;
//        } 
//        linedy = (int)(Math.random() * 3);
//        
//        if (shakeCount == 0){
//            lineY += linedy;
//            shakeCount = 1;
//            return;
//        }
//        lineY -= linedy;
//        shakeCount = 0;
//        return;        
//    }
//        
//    @Override
//    public void paint(Graphics g) {
//        if(Global.DEBUGMODE == true){
//            DebugMode.debug(this, g);
//        }
//        setPenWidthAndColor(g);
//        g.drawImage(img1, x - 75, y, null); //畫左邊的震動圖
//        g.drawImage(img2, Global.FRAME_SIZE_X - 150 - (x - 75), y, null);  //畫右邊的震動圖
//        g.drawLine(lineX, lineY, x, lineY); //畫左邊的線
//        g.drawLine(Global.FRAME_SIZE_X - lineX, lineY, Global.FRAME_SIZE_X - x, lineY); //畫右邊的線      
//    }
//    
//    public void setPenWidthAndColor(Graphics g) {    
//        if(Global.DEBUGMODE == true){
//            DebugMode.debug(this, g);
//        }
//        int width = 5;        
//        ((Graphics2D)g).setStroke(new BasicStroke(width));
//        Color color= new Color(1.0F, 1.0F, 1.0F, 0.5F);
//        g.setColor(color);
//    }
}
