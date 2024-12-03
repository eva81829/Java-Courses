/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;  

/**
 *
 * @author asdfg
 */
public class Global {
    /* 畫布大小 */
    public static final int Frame_SIZE_X = 1280;
    public static final int Frame_SIZE_Y = 720;    
    
    /* 畫面更新率 */
    public static final int UPDATE_TIME_PER_SEC = 60;   
    public static final int MILLERSEC_PER_UPDATE = 1000 / UPDATE_TIME_PER_SEC;   
    /* 畫面最大更新率 */
    public static final int UPDATE_LIMIT = 120;   
    public static final int LIMIT_DELTA_TIME = 1000 / UPDATE_LIMIT; 
    /* 設定物件基礎速度 */
    public static final int ACTION_SPEED = 120 / UPDATE_TIME_PER_SEC; 
    /* 動畫延遲設定 */
    public static final int ANIME_DELAY = UPDATE_TIME_PER_SEC / 30;
    /* 動畫自動轉向頻率 */
    public static final int ANIME_AUTO_DIRECTION = UPDATE_TIME_PER_SEC / 30;
    /* 動畫自動變換角色頻率 */
    public static final int ANIME_AUTO_CHARACTER_CHANGE = UPDATE_TIME_PER_SEC / 30;
    /* 設定圖片大小 */
    public static final int IMG_X_OFFSET = 140;
    public static final int IMG_Y_OFFSET = 140;
    /* 上下左右常數制定 */
    public static final int DOWN = 0;
    public static final int LEFT = 1;
    public static final int RIGHT = 2;
    public static final int UP = 3;
    
    /* 場景常數制定 */
    public static final int FLOOR = 500;
    public static final int LINE = 650;
    public static final int BEAT = LINE - 60;
    
    public class Acceleration {
        public static final int ACCELERATION = 3;
        public static final int G = 1;
    }
}
