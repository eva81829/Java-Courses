/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationmidtermtest1;

import controller.CommandSolver.CommandWrapper;
import controller.SceneController;
import scene.MainScene;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author asdfg
 */
public class GameJPanel extends JPanel{
    private SceneController sceneController;
    
    public GameJPanel(){
        sceneController = new SceneController();
        sceneController.changeScene(new MainScene());
    }
    
    public void update(CommandWrapper commands){
        sceneController.sceneUpdate(commands);
    }
    
    @Override
    public void paintComponent(Graphics g){
        sceneController.paint(g);
    }
}
