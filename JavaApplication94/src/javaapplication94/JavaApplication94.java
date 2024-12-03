/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication94;

/**
 *
 * @author Eka
 */
public class JavaApplication94 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        int[] myarr = null;
//        System.out.print(myarr[0]);
        
        //內部類別呼叫外部類別的參數的方式(重名時必定得用這種方式, 未重名則可直接呼叫參數名稱)： 外部類別名稱.this(取得外部類別實體).parameter
        //外部類別呼叫內部類別的參數的方式: 內部類別實體.parameter(同一般情況, 內部類別的private變數也取得到)
        //匿名內部類別呼叫外部類別的變數(區域變數), 變數必須為final(除非是全域變數 -> 不管是父或祖父類別的全域變數都可直接使用, 而重名時必須遵照上面的方式呼叫父變數)
        //匿名內部類別一定是介面/類別的子類別, 用法: new 介面/父類別(){}
        
        NewClass.b();
        NewClass d = new NewClass();
        d.b();
        
        //NewClass.N.c();
        NewClass.N.b();
        NewClass.N a = new NewClass.N();
        NewClass.N.b();
        a.b();
        a.c();
        
//        NewClass.A aa = new NewClass.A();
        NewClass.A b = new NewClass().new A();
    }
    
}
