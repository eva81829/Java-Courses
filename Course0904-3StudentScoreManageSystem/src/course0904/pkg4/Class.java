/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0904.pkg4;

import java.util.Scanner;

/**
 *
 * @author Eka
 */
public class Class {
    private Scanner scanner = new Scanner(System.in);
    private Student[] studentArr = new Student[2];
    private int count = 0;
      
    public void addStudent(){
        int seat = inputSeat();
        
        if (checkSeat(inputSeat()) == null){
            if (count==studentArr.length){
                doubleArr();
            }
            
            studentArr[count] = new Student(); //新增學生物件, 存入studentArr
            studentArr[count].seat = seat;
            studentArr[count++].name = inputStr("姓名"); //將新增的學生物件加入姓名, 最後count+1
        } else{
            System.out.println("座號重複");
        }
    }
    
    public void addScore(){
        Student student = checkSeat(inputSeat()); //輸入座位, 並檢查座位是否存在(取得該座位的學生物件代表座位存在, 取得null代表座位不存在)
        if (student == null){ 
            System.out.println("座號不存在");
        } else{
            student.setScore(inputInt("成績")); //輸入成績存入該座位的學生物件
        }
    }    
        
    public void print(){
        for (int i=0; i<count; i++){
            System.out.print("第" + i + "個學生");
            System.out.print(" 座號:" + studentArr[i].seat);
            System.out.print(" 姓名:" + studentArr[i].name);
            System.out.print(" 成績:" + studentArr[i].getScore());
            System.out.println();
        }
    }

    public void sortScore(){
        for (int i=0; i<count-1; i++){
            for (int j=0; j<count-1-i; j++){
                if (studentArr[j].getScore() > studentArr[j+1].getScore()){
                    Student tmp = studentArr[j];                  
                    studentArr[j] = studentArr[j+1];
                    studentArr[j+1] = tmp;
                }
            }
        }
    }
    
    public void sortSeat(){
        for (int i=0; i<count-1; i++){
            for (int j=0; j<count-1-i; j++){
                if (studentArr[j].seat > studentArr[j+1].seat){
                    Student tmp = studentArr[j];                  
                    studentArr[j] = studentArr[j+1];
                    studentArr[j+1] = tmp;
                }                
            }
        }
    }     
    
    private void doubleArr(){
         Student[] studentArr = new Student[this.studentArr.length*2]; //產生一個新的local變數studentArr, 空間為global studentArr的2倍
         for (int i=0; i<count; i++){
             studentArr[i] = this.studentArr[i];
         } 
         this.studentArr = studentArr;
    }
    
    private Student checkSeat(int seat){ //確定座位是否重複, 如果重複則回傳null, 否則新增學生 
        for (int i=0; i<count; i++){
            if (studentArr[i].seat==seat){
                return studentArr[i];
            }
        }
        return null;
    }
    
    private int inputSeat(){
        int n;
        do{
            n = inputInt("座號");
        } while(n<0);
        return n;
    }
         
    public int inputInt(String catagory){
        System.out.print("請輸入" + catagory + ":");
        int n = scanner.nextInt();
        scanner.nextLine();
        return n;
    } 
    
    public String inputStr(String catagory){
        System.out.print("請輸入" + catagory + ":");
        String str = scanner.nextLine();
        return str;
    }
    
}
