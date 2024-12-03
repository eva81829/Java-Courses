/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Eka
 */
public class IRC {
    private static IRC irc;
    private ArrayList<KeyPair> KeyPairs;
    
    private IRC(){
        KeyPairs = new ArrayList<>();
    }
    
    public static IRC getInstance(){
        if (irc == null){
            irc = new IRC();
        }
        return irc;
    }
    
    private class KeyPair{ // 也可以寫成static, 不依賴IRC就能創建, 非static則不會馬上被創建, 也有好處
        private BufferedImage image;
        private String path;
        
        private KeyPair(BufferedImage image, String path){
            this.image = image;
            this.path = path;
        }    
    }
    
    public BufferedImage getImage(String path){
        BufferedImage img = findKeyPair(path);
        if (img == null){
            return addImage(path);
        } 
        return img;
    }
    
    private BufferedImage addImage(String path){
        try{
            BufferedImage img = ImageIO.read(getClass().getResource(path));
            KeyPairs.add(new KeyPair(img, path));
            return img;
        } catch (IOException e){
        }
        return null;
    }
    
    private BufferedImage findKeyPair(String path){    
        for(int i=0; i<KeyPairs.size(); i++){
            KeyPair keyPair = KeyPairs.get(i);
            if (path.equals(keyPair.path)){
                return keyPair.image;
            }
        }
        return null;        
    }
    
}
