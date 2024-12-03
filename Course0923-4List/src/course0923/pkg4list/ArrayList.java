/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0923.pkg4list;

/**
 *
 * @author Eka
 */
public class ArrayList extends List{
    private String[] arr;   
    private int count;
    
    public ArrayList(){
        arr = new String[2];
        count = 0;
    }

    @Override
    public void add(String add){
        if (count == arr.length){
            doubleArr();
        }
        arr[count++] = add;
    }

    public void doubleArr(){
        String[] tmp = new String[arr.length*2];
        for (int i=0; i<count ; i++){
            tmp[i] = arr[i];
        }
        arr = tmp;
    }
    
    public String toString(){
        String str = "";
        for (int i=0; i<count; i++){
            str += arr[i] + "\n";
        }
        return str;
    }

}
