/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
// * and open the template in the editor.
 */
package course0929.pkg2foreachgenerics;

/**
 *
 * @author Eka
 */

public interface List<T> extends Iterable<T>{
    public void add(T data);
    public boolean insert(T data, int index);
    public boolean remove(int index);
    public boolean replace(T data, int index);
}
