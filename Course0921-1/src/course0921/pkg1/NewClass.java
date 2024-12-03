/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0921.pkg1;

/**
 *
 * @author Eka
 */
public class NewClass {

    private int b = 2;
    
    public class NewClass1 {
        public int b = 0;
        
        public void ac (){
            b = 3; 
            System.out.println(NewClass.this.b);//呼叫外部類別的參數的用法
        }
        
    }
    
    public static class NewClass2 {
        public void abc (){
            System.out.println(6);
        }
    }
    
    public static void newClass4(){
        System.out.println(88);
    }    
    
    public NewClass1 d = new NewClass1();
    
    public void c (){
        d.ac();
    }
    
}
