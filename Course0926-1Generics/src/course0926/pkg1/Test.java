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
public class Test <T>{
    public T value;
    
    public class inner<T>{
        public T tt;
    }
    
    private class inner2<T>{
        public T ttt;
    }
    
    public T getTTT(){
        inner2<T> tttest = new inner2<T>();
        tttest.ttt = value;
        return tttest.ttt;
    }

    public void test (){
        //this.value = value;
        Test <String> test = new Test<>();
        Test <Integer> test2 = new Test<>();
        Test <T> test3 = new Test<>();
        //test3.value = value;
        //System.out.println(test3.value);
    }
    
    public static Test<String> abc(){
        Test<String> test3 = new Test<>();
        return test3;
    }
    
    public static <T> T e(T value){
        Test<T> test3 = new Test<>();
        test3.value = value;
        return test3.value;
    }
    
    public static <T> Test<T> f(){
        Test<T> test3 = new Test<>();
        return test3;
    }

}
