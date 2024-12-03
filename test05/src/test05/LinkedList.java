/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test05;

/**
 *
 * @author Eka
 */
public class LinkedList {
    private class Book {
        private String name;
        private String author;
        private int year;
        private int month;
        private int day;    

        public Book(String name, String author, int year, int month, int day){
            this.name = name;
            this.author = author;
            this.year = year;
            this.month = month;
            this.day = day;
        }
        
        public void printBook(int number){
            String m = "" + month;
            String d = "" + day;
            if (month<10){
                m = "0" + month;
            }
            if (day<10){
                d = "0" + day;
            }
            System.out.printf("%d.\t書名: %s 出版日: %4d/%s/%s 作者: %s", number, name, year, m, d, author);
            System.out.println();
        }
    }
    
    private class Node{
        private Book book;
        private Node next;
        
        public Node(Book book){
            this.book = book;
        }
    }
    
    private Node firstNode;
    private Node lastNode;
    private int count;
    
    public LinkedList(){
        count = 0;
    }
    
    public boolean add(String name, String author, int year, int month, int day){
        if (year>2019 || year<1970 || month>12 ||month<1 || day>28 || day<1){
            System.out.println("Date out of bound");
            return false;
        }
        
        Book book = new Book(name, author, year, month, day);
        
        if (count == 0){
            firstNode = new Node(book);
            lastNode = firstNode;
            count++;
            return true;
        }
        
        lastNode.next = new Node(book);
        lastNode = lastNode.next;
        count++;
        return true;
    }
    
    private Node get(int index){
        Node node = firstNode;
        
        for(int i=0; i<index; i++){
            node = node.next;
        }
        return node;
    }    
    
    public void remove(int index){
        if (index < 0 || index >= count){
            System.out.println("Index out of bound");
            return;
        } else if (index == 0){
            firstNode = firstNode.next;
            count--;   
            return;
        }
        
        Node previous = get(index - 1);
        previous.next = previous.next.next;
        count--;
    }
    
    public boolean modify(int index, int column, String str){
        if (index < 0 || index >= count){
            System.out.println("Index out of bound");
            return false;
        } else if (column < 0 || column >=2){
            System.out.println("Input wrong column");
            return false;
        }
        
        Node node = get(index);
        if (column == 0){
            node.book.name = str;
        } else if (column == 1){
            node.book.author = str;
        }
        return true;
    }
    
    public boolean modify(int index, int column, int value){
        if (index < 0 || index >= count){
            System.out.println("Index out of bound");
            return false;
        } else if (column < 2 || column >=5){
            System.out.println("Input wrong column");
            return false;
        }
        
        Node node = get(index);
        if (column == 2){
            if (value>2019 || value<1970){
                System.out.println("Date out of bound");
                return false;
            }            
            node.book.year = value;
        } else if (column == 3){
            if (value>12 ||value<1){
                System.out.println("Date out of bound");
                return false;
            }              
            node.book.month = value;
        } else if (column == 4){
            if (value>28 || value<1){
                System.out.println("Date out of bound");
                return false;
            }
            node.book.day = value;
        }
        return true;
    }
    
    public void print(int index){
        if (index < 0 || index >= count){
            System.out.println("Index out of bound");
            return;
        }
        get(index).book.printBook(1);
        System.out.println();
    }
    
    public void print(){
        Node node = firstNode;
        
        for(int i=0; i<count; i++){
            node.book.printBook(i+1);
            node = node.next;
        }
        System.out.println();
    }
}
