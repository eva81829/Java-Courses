/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0902.pkg2;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Course09022 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);
        String[] arr = new String[2];
        int index = 0;
        do{  
            System.out.print("請輸入字串:");
            String str = scanner.nextLine();
            if (str.equals("-1")){
                break;
            }
            
            if (index==arr.length){
                arr = expand(index, arr);
            }
            arr[index++] = str;
            
        } while (true);

        String[] dic = new String[arr.length];
        int[] count =  new int[arr.length];
        int num = 1;
        
        dic[0] = arr[0];
        count[0] = 1;
        for(int i=1;i<index;i++){
            int j;
            for (j=0;j<num;j++){
                if (arr[i].equals(dic[j])){
                    count[j] += 1;
                    break;
                }
            }
            
            if (j == num){
                dic[num] = arr[i];
                count[num++] = 1;
                //System.out.println("dic:" + dic[num]);
                //System.out.println("count:" + count[num++]);                  
            }
  
        }
        
        for(int i=0;i<num;i++){
            System.out.println("字串:\"" + dic[i] + "\" 出現" + count[i] + "次");
        }
    }
    
    public static String[] expand(int index, String[] arr){
        String[] tmp = new String[arr.length*2];
            for(int i=0;i<arr.length;i++){
                tmp[i] = arr[i];
            }
        return tmp;
    }
    
}
