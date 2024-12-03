/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImageResourceController;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author user1
 */
// 單例模式 Singleton
public class ImageResourceController {
    // 單例
    private static ImageResourceController irc;

    private ImageResourceController(){ //設為private, 無法在外面呼叫
        imgPairs = new ArrayList<>();
    }       
    
    public static ImageResourceController getInstance(){ //只有第一次被呼叫會new出ImageResourceController實體, 才會產生唯一的irc屬性, 之後任何人都是取到相同的irc
        if(irc == null){
            irc = new ImageResourceController();
        }
        return irc;
    }
    
    
    
    private static class KeyPair{
        private String path;
        private BufferedImage img; 
        
        public KeyPair(String path, BufferedImage img){
            this.path = path;
            this.img = img;
        }
    }

    // 存放圖和path的arraylist
    private ArrayList<KeyPair> imgPairs;
    


    public BufferedImage tryGetImage(String path){ //若path存在則回傳對應的圖, 不存在則匯入這張圖後回傳該圖
        KeyPair pair = findKeyPair(path);
        if(pair == null){
            return addImage(path);
        }
        return pair.img;
    }
    
    private BufferedImage addImage(String path){ //把圖匯入圖庫list
        try{
            BufferedImage img = ImageIO.read(getClass().getResource(path));
            imgPairs.add(new KeyPair(path, img));
            return img;
        }catch(IOException e){
        }
        return null;
    }
    
    private KeyPair findKeyPair(String path){ //查詢path是否已存在KeyPair中, 存在代表之前已經匯入這張圖過了
        for(int i=0;i<imgPairs.size();i++){
            KeyPair pair = imgPairs.get(i);
            if(pair.path.equals(path)){
                return pair;
            }
        }
        return null;
    }
}
