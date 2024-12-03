/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0929.pkg2foreachgenerics;

/**
 *
 * @author Eka
 */
public class Iterator {
    public interface Consumer<T> {
        public void function(T data);
    }
    
    public static void forEach(Iterable iterable, Consumer consumer){
        for (int i=0; i<iterable.getLength();i++){
            consumer.function(iterable.getPointerData());
        }
    }
}
