/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0929.pkg1;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Eka
 */
public class Course09291 {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        
        Consumer consumer = new Consumer(){
            public double sum = 0;
            @Override
            public double function(double data){
                sum += data;
                return sum;
            }
        };        
        System.out.println(Iterator.Iterator(a, consumer));
        
        consumer = new Consumer(){
            public double Max = 0;
            public boolean Initial = true;
            @Override
            public double function(double data){
                if (data>Max || Initial){
                    Max = data;
                    Initial = false;
                }
                return Max;
            }
        };
        System.out.println(Iterator.Iterator(a, consumer));
        
        consumer = new Consumer(){
            public double Min = 0;
            public boolean Initial = true;
            @Override
            public double function(double data){
                if (data<Min || Initial){
                    Min = data;
                    Initial = false;
                }
                return Min;
            }
        };        
        System.out.println(Iterator.Iterator(a, consumer));        
        
        consumer = new MaxMin(new Competitor(){
            @Override
            public boolean competitor(double data, double value){
                if (data>value){
                    return true;
                }
                return false;
            }
        });
        System.out.println(Iterator.Iterator(a, consumer));

        consumer = new MaxMin(new Competitor(){
            @Override
            public boolean competitor(double data, double value){
                if (data<value){
                    return true;
                }
                return false;
            }
        });
        System.out.println(Iterator.Iterator(a, consumer));        
        
    }
}
