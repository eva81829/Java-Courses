/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gameobject.PhysicalGameObject;
import gameobject.PhysicalGameObject.*;
import java.awt.image.BufferedImage;
import gameobjectcharacter.Character;
import java.awt.Graphics;
import utils.Global;
import utils.ImagePath;

/**
 * 
 *
 * @author asdfg
 */
public class CharacterHelper {
    private static final int[] ACT = {0, 1, 2, 3, 1};
    private static final int[] ACTDIV = {3, 2, 1, 0, 2};
    private static final int[] ACTSLOW = {0, 1, 2, 1};
    private static int[] actExcute;
    private BufferedImage img;
    
    public CharacterHelper(Character character){
        img = getCharacter(character);
    }
    
    private BufferedImage getCharacter(Character character){
        if(character.getCharacterState() instanceof Character.StateCat){
            ImageResourceController irc = ImageResourceController.getInstance();
            if(character.getStateDirection() instanceof PhysicalGameObject.StateFaceRight){
                actExcute = ACT;
                return irc.tryGetImage(PathBuilder.getImage(ImagePath.Character.Cat.SMALL_CAT_ACT));
            }else if(character.getStateDirection() instanceof PhysicalGameObject.StateFaceLeft){
                actExcute = ACTDIV;
                return irc.tryGetImage(PathBuilder.getImage(ImagePath.Character.Cat.SMALL_CAT_ACTDIV));
            }
        }
        return null;
    }
    
    public void paint(Graphics g,int x,int y,int width, int height, int act){
        if(img == null){
            return;
        }
        g.drawImage(img, x, y, x+width, y+height, 
                0 + actExcute[act] * Global.CAT_X_OFFSET, 0,
                140+ actExcute[act] * Global.CAT_X_OFFSET, 140 , null);
    }
}
