/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course0923.pkg4list;

/**
 *
 * @author Eka
 */
public class LinkedList extends List{
    private Node firstNode;
    private Node lastNode;    
    private int count;
    
    private class Node{
        private String add;
        private Node next;
        
        public Node(String add){
            this.add = add;
        }
    }

    public LinkedList(){
        count = 0;
    }
    
    @Override
    public void add(String add){
        if (count == 0){
            firstNode = new Node(add);
            lastNode = firstNode;
            count++;
            return;
        }
        
        lastNode.next = new Node(add);
        lastNode = lastNode.next;
        count++;
    }
    
    public String toString(){
        String str = "";
        lastNode = firstNode;
        for (int i=0; i<count; i++){
            str += lastNode.add + "\n";
            lastNode = lastNode.next;
        }
        return str;
    }
}
