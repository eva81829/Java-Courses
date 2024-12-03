/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0929.pkg1;

import java.util.ArrayList;

/**
 *
 * @author Eka
 */
public class Iterator {
    public static double Iterator(ArrayList<? extends Number> list, Consumer consumer){
        double value = 0;
        for (int i=0; i<list.size(); i++){
            value = consumer.function(list.get(i).doubleValue());
        }
        return value;
    }
}
