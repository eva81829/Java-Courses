/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scene;

import controller.CommandSolver.*;
import java.awt.*;

/**
 *
 * @author asdfg
 */
    public abstract class Scene{
    public abstract void sceneBegin();
    public abstract void sceneUpdate();
    public abstract void sceneEnd();
    public abstract void paint(Graphics g);  
    public abstract KeyCommandListener getKey();
    public abstract MouseCommandListener getMouse();
}
