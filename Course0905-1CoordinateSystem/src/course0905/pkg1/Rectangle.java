/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0905.pkg1;

/**
 *
 * @author Eka
 */
public class Rectangle {
    
    private Point[] point;
    public float midX;
    public float midY;
    
    public Rectangle(int x0, int y0, int x1, int y1){
        point = new Point[2];
        point[0] = new Point(x0, y0);
        point[1] = new Point(x1, y1);
        midX = (float)((x1 + x0)/2);
        midY = (float)((y1 + y0)/2);
    }
    
    public Rectangle(Point point1, Point point2){
        point = new Point[2];
        point[0] = point1;
        point[1] = point2;
        midX = (float)((point1.x + point2.x)/2);
        midY = (float)((point1.y + point2.y)/2);        
    }
    
    public int getHeight(){ //長
        return Math.abs(point[1].x - point[0].x);
    }
    
    public int getWidth(){ //寬
        return Math.abs(point[1].y - point[0].y);
    }
    
    public int getArea(){ //面積
        return this.getHeight() * this.getWidth();
    }
    
    public int compare(Rectangle rectangle){
        int compare = this.getArea() - rectangle.getArea();
        return compare;    
    
    
/*    
    public int compare(Rectangle rectangle){
        int compare = this.getArea() - rectangle.getArea();
        
        if (compare>0){
            return 1;
        } else if (compare==0){
            return 0;
        }
        return -1;
    }
*/

    }    

}
