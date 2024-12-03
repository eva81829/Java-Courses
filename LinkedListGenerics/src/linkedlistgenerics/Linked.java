/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistgenerics;

/**
 *
 * @author Eka
 */
public class Linked<T> {
    private Node root;
    private Node last;
    private int count;
    
    private class Node{
        public Node next;
        public T currentData;
        public Node(){
        }
        
        public Node(T data){
            next = new Node();
            currentData = data;
        }
    }
    
    public Linked(){
        root = new Node();
        last = root;
        count = 0;
    }
    
    public boolean add(T data){
        last.currentData = data;
        last.next = new Node();
        last = last.next;
        count++;
        return true;        
    }
     
    public boolean insert(int index, T data){ //index從0開始, 假設index<=count
        if (index<0 || index > count){
            System.out.print("超過長度");
            return false;
        }
        
        Node tmp = new Node(data);
        if(index == 0){
            tmp.next = root;
            root = tmp;
            count++;
            return true;
        }
        
        Node previous = getNode(index-1);
        tmp.next = previous.next;
        previous.next = tmp;
        if(index == count){
            last = tmp;
        }
        count++;
        return true;        
    }
 
    public boolean remove(int index){ //index從0開始, 假設index<=count
        if (index<0 || index > count){
            System.out.print("超過長度");
            return false;
        }        
        
        if(index == 0){
            root = root.next;
            count--;
            return true;
        }
        
        Node previous = getNode(index-1);
        previous.next = previous.next.next;
        if(index == count){
            last = getNode(count-1);
        }
        count--;
        return true;        
    }
    
    public boolean replace(int index, T data){ //index從0開始, 假設index<=count
        if (index<0 || index > count){
            System.out.print("超過長度");
            return false;
        }        
        getNode(index).currentData = data;
        return true;
    }       
    
    public Node getNode(int index){
        Node tmp = root;
        
        for(int i=0;i<index;i++){
            tmp = tmp.next;
        }
        
        return tmp;
    }    
     
     
    public void print(){
        Node tmp = root;
        
        for(int i=0;i<count;i++){
            System.out.print(tmp.currentData + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }     
    
    
}
