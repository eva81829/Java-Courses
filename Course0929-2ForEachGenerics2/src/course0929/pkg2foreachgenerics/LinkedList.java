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
public class LinkedList<T> implements List<T>{
    private int count;
    private Node root; 
    private Node pointer;
    
    public LinkedList(){
        count = 0;
        root = pointer = new Node(null);
    }
    
    private class Node{
        public T data;
        public Node next;  
        
        public Node(T data){
            this.data = data;
        }
    }
    
    @Override
    public void add(T data){
        insert(count, data);
    }
    
    @Override
    public boolean insert(int index, T data){
        if (index<0 || index>count){
            return false;
        } 
        
        Node tmp = new Node(data);
        Node previous = getNode(index-1);
        tmp.next = previous.next;
        previous.next = tmp;
        count++;
        return true;
    }
     
    @Override
     public boolean remove(int index){
        if (index<0 || index>=count){
            return false;
        }
        
        Node previous = getNode(index-1);
        previous.next = previous.next.next;
        count--;
        return true;
    }

    @Override
    public boolean replace(int index, T data){
        if (index<0 || index>=count){
            return false;
        }
        
        getNode(index).data = data;
        return true;
    }
     
    private Node getNode(int index){
        Node tmp = root;
        for(int i=0; i<=index; i++){
            tmp = tmp.next;
        }
        return tmp;
    }

    @Override
    public T getPointerData(){
        Node tmp = pointer = pointer.next;
        if (pointer.next == null){
            pointer = root;
        }        
        return tmp.data;
    }

    @Override
    public int getLength(){
        return count;
    }

}
