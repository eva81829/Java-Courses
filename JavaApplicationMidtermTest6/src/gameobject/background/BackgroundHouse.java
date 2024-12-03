/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject.background;

import controller.ImageResourceController;
import controller.PathBuilder;
import utils.ImagePath;

/**
 *
 * @author Eka
 */
public class BackgroundHouse extends Background{
    public BackgroundHouse(){}
    public BackgroundHouse(int paintX, int paintY, int paintWidth, int paintHeight) {
        super(paintX, paintY, paintWidth, paintHeight);
        ImageResourceController irc = ImageResourceController.getInstance();
        img = irc.tryGetImage(PathBuilder.getImage(ImagePath.Scene.BACKGROUND_HOUSE)); 
    }
}
