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
public class LinkList {
    private int count;
    private Node firstNode;
    private Node lastNode;
    
    public LinkList(){
        count = 0;
    }
    
    private void initialize(int firstData){
        firstNode = new Node(firstData);
        lastNode = firstNode;
        count++;
    }
    
    public void add(int data){
        if (count==0){
            initialize(data);
            return;
        }
        
        lastNode.setNext(new Node(data));
        lastNode = lastNode.getNext();
        count++;
    }
    
    public void insert(int data, int index){
        if (index<0 || index>= count){
            System.out.print("超過長度");
            return;
        }
        
        Node newNode = new Node(data);
        count++;
        if (index==0){
            newNode.setNext(firstNode);
            firstNode = newNode;
            return;
        }
        Node previous = getNode(index - 1);
        newNode.setNext(previous.getNext());
        previous.setNext(newNode);
    }
    
    public void remove(int index){
        if (index<0 || index>= count){
            System.out.print("超過長度");
            return;
        }        
        
        count--;
        if (index==0){
            firstNode = firstNode.getNext();
            return;
        }
        
        Node previous = getNode(index - 1);
        previous = getNode(index - 1);
        previous.setNext(previous.getNext().getNext()); 
    }

    public String toString(){
        String str = "";
        Node node = firstNode;
        for (int i=0; i<count; i++){
            str += node.getData() + " ";
            node = node.getNext();
        }
        return str;
    }
    
    public Node getNode(int index){
        if (index<0 || index>= count){
            System.out.print("超過長度");
            return null;
        }        
        
        Node node = firstNode;
        for (int i=0; i<index; i++){
            node = node.getNext();
        }
        return node;
    }
    
}
