package course0905.pkg1;

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
public class CoordinateSystem {

    public Scanner scanner;
    public Rectangle[] rectangles;
    public Circle[] circles;
    public int countR;
    public int countC;

    public CoordinateSystem() {
        scanner = new Scanner(System.in);
        rectangles = new Rectangle[2];
        circles = new Circle[2];
        countR = countC = 0;
    }
    
    public void addRectangle() {
        if (countR == rectangles.length) {
            doubleRArr();
        }

        int x0 = input("x0");
        int y0 = input("y0");
        int x1 = input("x1");
        int y1 = input("y1");

        rectangles[countR++] = new Rectangle(x0, y0, x1, y1);
    }

    public void addCircle() {
        if (countC == circles.length) {
            doubleCArr();
        }

        int x = input("x");
        int y = input("y");
        int r = input("r");

        circles[countC++] = new Circle(x, y, r);
    }

    public void print(int x0, int y0, int x1, int y1) {
        int[] x = {x0, x1}, y= {y0 , y1};
        x = swap(x);
        y =  swap(y);
        
        for (int i = 0; i < countC; i++) {
            if (circles[i].point.x >= x[0] && circles[i].point.x <= x[1] && circles[i].point.y >= y[0] && circles[i].point.y <= y[1]) {
                System.out.println("圓形 " + circles[i].getArea());
            }
        }

        for (int i = 0; i < countR; i++) {
            if (rectangles[i].midX >= x[0] && rectangles[i].midX <= x[1] && rectangles[i].midY >= y[0] && rectangles[i].midY <= y[1]) {
                System.out.println("長方形 " + rectangles[i].getArea());
            }
        }
    }
    
    public int[] swap(int[] coordinate){
        if (coordinate[0]>coordinate[1]){
            int tmp;
            tmp = coordinate[1];
            coordinate[0] = coordinate[1];
            coordinate[1] = tmp;
        }
        return coordinate;
    }

    public void print() {
        for (int i = 0; i < countC; i++) {
            System.out.println("圓形 " + circles[i].getArea());
        }

        for (int i = 0; i < countR; i++) {
            System.out.println("長方形 " + rectangles[i].getArea());
        }
    }

    private void doubleRArr() {
        Rectangle[] rectangles = new Rectangle[this.rectangles.length * 2];
        for (int i = 0; i < countR; i++) {
            rectangles[i] = this.rectangles[i];
        }
        this.rectangles = rectangles;
    }

    private void doubleCArr() {
        Circle[] circles = new Circle[this.circles.length * 2];
        for (int i = 0; i < countC; i++) {
            circles[i] = this.circles[i];
        }
        this.circles = circles;
    }

    public int input(String str) {
        System.out.print("請輸入" + str + ":");
        return scanner.nextInt();
    }
}
