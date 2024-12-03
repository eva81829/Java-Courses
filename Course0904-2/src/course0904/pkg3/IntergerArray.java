/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0904.pkg3;

/**
 *
 * @author Eka
 */
public class IntegerArray {
    private int[] arr;
    private int count;
    
    public IntegerArray(){
        arr = new int[2];
        count = 0;
    }
    
    private int[] doubleArr(int[] arr){
        
    }
    
    public void add(int n){
        //把 n 加入 arr中
    }
    public int get(int index){
        //取出 arr[index] 的值
        //如果index < 0 或 >= count 回傳-1
    }
    public boolean remove(int index){
        //刪除對應位置的值
        //無法刪除時回傳false 刪除成功回傳true
    }
    
    public int length(){
        return count;
    }
}
