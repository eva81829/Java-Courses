/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Eka
 */
public class ResourceController {
    private static ResourceController rc;
    private ArrayList<KeyPair> keypairs;
    
    private ResourceController(){
        keypairs = new ArrayList<>();
    }
    
    public static ResourceController getInstance(){
        if (rc == null){
            rc = new ResourceController();
        }
        return rc;
    }
    
    private class KeyPair{
        private BufferedImage img;   
        private String path;
        
        public KeyPair(BufferedImage img, String path){
            this.img = img;
            this.path = path;
        }
    }
    
    public BufferedImage getImage(String path){
        BufferedImage img = findImage(path);
        if (img == null){
            return addImage(path);
        }
        return img;
    }
    
    private BufferedImage addImage(String path){
        try{
            BufferedImage img = ImageIO.read(getClass().getResource(path));
            keypairs.add(new KeyPair(img, path));
            return img;
        } catch(IOException e){
        }
        return null;
    }
    
    private BufferedImage findImage(String path){
        for(int i=0; i<keypairs.size(); i++){
            KeyPair keyPair = keypairs.get(i);
            if(path.equals(keyPair.path)){
                return keyPair.img;
            }
        }
        return null;
    }
    
}
