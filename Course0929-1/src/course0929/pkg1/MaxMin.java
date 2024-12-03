/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0929.pkg1;

/**
 *
 * @author Eka
 */
public class MaxMin implements Consumer{
    public double value = 0;
    public boolean Initial = true;
    public Competitor competitor;
    
     public MaxMin(Competitor competitor){
        this.competitor = competitor;
    }       
    
    @Override
    public double function(double data){
        if (competitor.competitor(data, value) || Initial){
            value = data;
            Initial = false;
        }
        return value;
    }
    
}
