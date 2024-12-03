/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1a2b3;

import java.util.Scanner;

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
        int[] ansArr = new int[4];
        int ans;
        
        do {
            System.out.print("Ans:  ");
            ans = scanner.nextInt();
        } while (!checkVaild(ansArr, ans));
        
        int[] ab = {0,0};
        int[][] abArr = new int[20][2];
        int[][] preGuessArray = new int[20][4];
        int[][] base = genBase();
        int loop=1;
        
        for(int seq=0;seq<base.length;seq++){
            
            int[] guessArr = genGuessArray(base, seq);
            if (checkGuessArray(loop, abArr, preGuessArray, guessArr)){
                System.out.print("Ans:  ");
                for(int i=0;i<4;i++){
                    System.out.print(ansArr[i]);
                }
                System.out.println();

                System.out.print("Guess:");       
                for(int i=0;i<4;i++){
                    System.out.print(guessArr[i]);
                }
                System.out.print(" ");
                
                if (Guess(loop++, abArr, preGuessArray, ansArr, guessArr)){
                    break;
                }
            }
        }
        System.out.println("恭喜答對");   
 }
    
    public static boolean checkVaild(int[] ansArr, int ans){
        if (ans>9876||ans<123||!checkDup(ansArr,ans)){
                System.out.println("錯誤");
                return false;
        }
        return true;
    }
    
    public static boolean checkDup(int[] ansArr, int ans){
        for(int i=0;i<4;i++){
            ansArr[3-i] = ans%10;
            for(int j=0;j<i;j++){
                if (ansArr[3-i]==ansArr[3-j]){
                    return false;
                }
            }
            ans = ans/10;
        }
        return true;
    }
    
    public static int[] checkAB(int[] ansArr,int[] guessArr) {
        int[] ab = {0,0};
        for(int i=0;i<4;i++){
            if (ansArr[i]==guessArr[i]){
                ab[0]++;
            }
            else{
                ab[1] += checkB(ansArr, guessArr[i]);
            }
        }
        return ab;
    }
     
     public static int checkB(int[] ansArr, int guess){
        int count=0;
            for(int i=0;i<4;i++){
                if(guess==ansArr[i]){
                    count++;
                    break;
                }
            }
        return count;
    }

    public static int[][] genBase(){
        int[][] base = new int[5040][4];
        int index = 0;
        for(int i=123;i<=9876;i++){
            if(!checkDup(base[index],i)){
                continue;
            }
//            for(int j=0;j<4;j++){
//                System.out.print(base[index][j]);
//            }
//            System.out.println();
            index++;
        }
        return base;
    }
    
    public static int[] genGuessArray(int[][] base, int seq){
        int swap = (int)(Math.random()*(base.length - seq) + seq);
        int[] tmp = base[seq];
        base[seq] = base[swap];
        base[swap] = tmp;
        return base[seq];
    }
        
    public static boolean checkGuessArray(int loop, int[][] abArr ,int[][] preGuessArray,int[] guessArr){
        for(int i=0;i<(loop-1);i++){
            if(abArr[i][0] != checkAB(preGuessArray[i],guessArr)[0] || abArr[i][1] != checkAB(preGuessArray[i],guessArr)[1]){
                return false;
            }
        }
        return true;
    }

    public static boolean Guess(int loop, int[][] abArr ,int[][] preGuessArray,int[] ansArr,int[] guessArr){
        preGuessArray[loop-1] = guessArr;
        
        int[] ab = checkAB(ansArr, guessArr);
        //System.out.print(ab[0]);
        //System.out.println(ab[1]);        
        abArr[loop-1][0] = ab[0];
        abArr[loop-1][1] = ab[1];
        System.out.println(loop + "次 " + abArr[loop-1][0] + "A" + abArr[loop -1][1] + "B");
        
        if (abArr[loop-1][0] == 4){
            return true;
        }
        return false;
    }
 
}
