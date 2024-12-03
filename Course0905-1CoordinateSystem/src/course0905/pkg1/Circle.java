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
public class Circle {
    Point point;
    int radius;
    public static float pi;
    
    public Circle (int x, int y, int r){
        point = new Point(x, y);
        radius = r;
        pi = (float)3.14159;
    }
    
    public Circle(Point point, int r){
        this.point = point;
        radius = r;
        pi = (float)3.14159;
    }
    
    public float getArea() {
        return radius * radius * pi;
    }
    
    public float compare(Circle circle) {
        float compare = this.getArea() - circle.getArea();
        return compare;
    }

}
