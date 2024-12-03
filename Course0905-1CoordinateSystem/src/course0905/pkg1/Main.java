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
public class Main {

    /**
     * @param args the command line arguments
     */
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        
    CoordinateSystem coordinateSystem = new CoordinateSystem();

    int opt;
    do {
        opt = coordinateSystem.input("選項");
        switch (opt){
            case 1:
                coordinateSystem.addRectangle();
                break;
            case 2:    
                coordinateSystem.addCircle();
                break;
            case 3:
                coordinateSystem.print();
                break;
            case 4:
                //x0 = 左, y0 = 下, x1 = 右, y1 = 上
                coordinateSystem.print(-100, -100, 100, 100);                    
        }

    } while(opt!=5);    

    
        /*
        //int x0, int y0, int x1, int y1
        Point p1 = new Point();
        Point p2 = new Point(10, 10);
        
        Rectangle r1 = new Rectangle(p1, p2); 
        Rectangle r2 = new Rectangle(0, 0, 10, 10);
        
        System.out.println("r1:" + r1.getArea());
        System.out.println("r2:" + r2.getArea());
        System.out.println(r1.compare(r2));
        
        Circle c1 = new Circle(10,10,30);
        Circle c2 = new Circle(p1,20);
        
        System.out.println(c1.compare(c2));

        */
    }
}
