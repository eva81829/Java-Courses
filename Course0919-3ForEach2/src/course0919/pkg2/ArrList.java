/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0919.pkg2;

/**
 *
 * @author Eka
 */
public class ArrList extends List{
    private int[] arr;
    private int count;
    private int foreachCount;
    
    public ArrList(){
        int foreachCount = 0;
        arr = new int[2];
        count = 0;
    }
    
    public int getCount(){
        return count;
    }
    
    public int[] getArray(){
        return arr;
    }    
    
    @Override
    public void add(int data){
        if (count==arr.length){
            doubleArr();
        }
        arr[count++] = data;
    }
    
    public void doubleArr(){
        int[] tmp = new int[count*2];
        
        for (int i = 0; i<count; i++){
            tmp[i] =  arr[i];
        }
        arr = tmp;
    }    
    

    
    @Override
    public int getData(){
        int value = arr[foreachCount++];
        if (foreachCount==arr.length){
            foreachCount = 0;
        }
        return(value);
    } 
    
    @Override
    public int getLength(){
        return count;
    }
    
}
