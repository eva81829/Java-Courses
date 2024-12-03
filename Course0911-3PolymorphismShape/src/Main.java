
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eka
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        //System.out.print("請輸入選項:");
        //int opt = scanner.nextInt();
        //scanner.nextLine();
        
        CoordinateSystem coordinateSystem = new CoordinateSystem();
        coordinateSystem.genCircle(30, 10, 10);
        coordinateSystem.genCircle(20, 0, 0);
        coordinateSystem.genRectangle(-5, -5, 15, 100);
        System.out.println(coordinateSystem.compare(1, 2));
        System.out.println(coordinateSystem.distance(1, 0));

    }
    
}
