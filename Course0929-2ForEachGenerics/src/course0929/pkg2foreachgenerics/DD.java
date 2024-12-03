/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0929.pkg2foreachgenerics;

/**
 *
 * @author Eka
 * @param <T>
 */
public class DD<T> {
    public interface B<T>{
    }
    
    public class F implements B<T>{
    }
    
    public class R{
        public void ii(){
        }
    }
    
    public static class A<T>{ 
    }
    
//    public static void f(T data){ // => static function不能包含外部<T>
//    }
    
    public static void f(){ // => static function不能包含外部<T>, static 函式比外面還早存在
    }
    
}
