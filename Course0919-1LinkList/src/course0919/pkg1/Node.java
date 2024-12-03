/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0919.pkg1;

/**
 *
 * @author Eka
 */
public class Node {
    private int data;
    private Node next;
    
    public Node(){
        
    }
    
    public Node(int data){
        this.data = data;
        next = new Node();
    }

    public void setNext(Node node){
        next = node;
    }

    public Node getNext(){
        return next;
    }
    
    public int getData(){
        return data;
    }    
        
}
