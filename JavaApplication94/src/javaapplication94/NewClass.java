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
public class NewClass {
    public int abc = 4;
 
    public void bbb(){
        A aaa = new A();
        A aav = NewClass.this.new A();
        A aa = new NewClass.A();
        A b = new NewClass().new A();       
        
        A.BCDD ddd = new A().new BCDD();
        A.BCDD dddd = NewClass.this.new A().new BCDD();
        A.BCDD ddddd = new NewClass.A().new BCDD();
        A.BCDD dd = new NewClass().new A().new BCDD();
        
        int abcdef = aaa.abc;
    }    
        
    
    public static void b(){

    }    
    
    public static class N{ //有靜態方法的內部類別必為靜態
        public static void b(){
            
        }
        
        public void c(){
            
        }        
    }
    
    public class A{
        public int abc = 3;
        public void b(){
            NewClass.this.abc = 5; //NewClass類別中的abc
            abc = 3; //A類別中的abc
        }
        
        public class BCDD{
            public void b(){
                NewClass.this.abc = 10; //NewClass類別中的abc
                NewClass.A.this.abc = 10; //A類別中的abc
//                super.abc = 3; -> 錯誤用法(有繼承關係才能用)
            }
        }
    }
    public class F{    
        public void ff(){
            abc = 5; //NewClass類別中的abc
        }
    }
    
    public class D{        
        public void b(){
            A aaa = new A();
            A aav = NewClass.this.new A();
            A aa = new NewClass.A();
            A b = new NewClass().new A();
            
            A.BCDD dd = new NewClass().new A().new BCDD();
            //其他上面三種寫法不給過
        }
    }    
}
