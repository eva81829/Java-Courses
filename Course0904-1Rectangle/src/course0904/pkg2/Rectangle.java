/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0904.pkg2;

/**
 *
 * @author Eka
 */
public class Rectangle {
    
    public int width;
    private int height;

    public Rectangle(){ //多載
        //如果不寫會自動產生,放初始值的地方
        height = 1;
        width = 1;
    }    
    
    public Rectangle(int h, int w){ //多載
        //如果不寫會自動產生,放初始值的地方
        this(); //呼叫自己的其他建構子
        if(!setHeight(h)){
            height =1;
        }
        width = w;
    }
    
    // setter
    public boolean setHeight(int h){
        if (h <= 0){
            return false;
        }
        height = h;
        return true;
    }
    
     // getter
    public int getHeight(){    
        return height;
    }

    public int getArea(){
        int area = width * height;
        return area;
    }    
    
}
