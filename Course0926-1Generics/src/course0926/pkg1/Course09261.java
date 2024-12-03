/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0926.pkg1;

/**
 *
 * @author Eka
 */
public class Course09261 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here 
        Test3<Test> test1 = new Test3<>();
        Test3<Test2> test2 = new Test3<>();
        
        Integer b = 4;
        String c = "abc";
        test(b);
        System.out.println(b);
        
        Test <Integer> test = new Test<>();
        test.test();
        
        int a = Test.e(3);
        System.out.println(a);
        String s = Test.e("66");
        System.out.println(s);
        
        Test <Integer> tttesttt = new Test<>();
        tttesttt.value = 123456;
        System.out.println(tttesttt.getTTT());
        Course09261.test1(5);
    }
    
    public static void test(int a){
        a = 5;
    }
    
    public static <T> void test1(T value){
        System.out.println(value);
    }        
    
}
