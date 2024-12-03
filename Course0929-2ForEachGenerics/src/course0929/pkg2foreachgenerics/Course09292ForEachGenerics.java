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
public class Course09292ForEachGenerics {

    /**
     * @param args the command line arguments
     */
    
    public static class A<T> implements Iterator.Consumer<T>{
            @Override
            public void function(T data){
                System.out.println(data);
            }
        }
    
    public interface B<T>{
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        B<Integer> c = new B<Integer>(){ //匿名內部類別不支援diamond => <> (裡面要加東西)
        };
        
        A a = new A();
        DD<Integer>.R s = new DD<Integer>().new R(){
            @Override
            public void ii(){
            }
        };
        
        DD<Integer>.R ss = new DD<Integer>().new R(); // 為何不能用<> => 要先定義外部的型態, 再傳入左邊
        //DD<Integer>.F cc = new DD<Integer>().new F();
        //DD<Integer>.F<Integer> cc = new DD<Integer>().new F<>();
        
        

        new DD.A<Integer>();
        //DD<Integer>.f(); 
        //new DD<Integer>.A<Integer>(); 
        
        //DD<Integer>.A ww = new DD<Integer>.A(); => 應改為DD.A ww = new DD.A();
        //DD<Integer> abc = new DD<>();
        //DD<Integer>.R ssss = abc.new R();

        Iterator.Consumer<Integer> b = new A<>();
        Iterator.Consumer<Integer> avd = new A<Integer>(){
        };
        Iterator.Consumer<Integer> action = new Iterator.Consumer<Integer>(){ //匿名內部類別不支援diamond => <> (裡面要加東西)
            @Override
            public void function(Integer data){
                System.out.println(data);
            }
        };
        
        List linklist = new LinkedList<>();
        linklist.add(3);
        linklist.add(4);
        linklist.add("5");
        linklist.add("123");
        
        Iterator.forEach(linklist, b);
    }
    
}
