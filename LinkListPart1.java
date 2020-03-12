
package linklistpart1;

import java.util.Scanner;
import java.util.Stack;

public class LinkListPart1<T> {
    /**
     * 
     * @param <T> generic!! 
     */
    private class Node<T>{
        T element;
        Node<T> next;
        
      // has only 2 parts: item and pointer
      public Node(T e){ // type and element
        element = e; // load it 
        // next is not designated so it is NULL!!!
    }// self referencing constructor!!
     
    }//node
     ///////////////////////////////////////////
    private int size =0;
    private Node head;  // where it starts
    private Node tail;  // where it ends
    private Node temp;  // use to move through
    private Node front;
    private Node back;
    
    
    
    public LinkListPart1(){
        // basic constructor for the empty list
        head = new Node(null);
        tail = new Node(null);
        size=0;
    }//constructor

    public int getSize(){
        System.out.println("In get size method");
        return size;
    }// size
    
    public <E> void clear(){
        System.out.println("In clear method");
        head= null;
        size = 0;
        tail = null;
    }//clear
    
    public <T> boolean isEmpty(){
        System.out.println("In isEmpty method");
        return (size==0);
    }// is empty
    
    
    
    
    
    
    
    
    
    public <T> void add(T e){
        System.out.println("In add (at the back of the list) method :"+e);
        if (size ==0){
          head = tail = new Node<>(e);
          System.out.println("We loaded the first one!!");
          size++;}//if
        else // add it to the list
          {  
            Node temp = new Node(e); // to add
          
            Node current  = head;
            while(current.next !=null){
                //move down the list
                current = current.next;
            }//while
            // at the end so load it
            current.next = temp;
            tail = temp;//re point the tail
            size++;
        }  //else
    }//add
    
    
    
    
    
    
    
    
     
    /** Override toString() to return elements in the list */
    public String toString() {
        System.out.println("In toString method");
        StringBuilder result = new StringBuilder("[");
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", "); // Separate two elements with a comma
            } else {
                result.append("]"); // Insert the closing ] in the string
            }//else
        }//for
        return result.toString();
    }//to string
      
   
    
    public <T> void show(){
        System.out.println("In show method");
        temp = new Node(null); //need to start here
        temp = head;// start at the beginning
        System.out.print("[ ");
        while (temp.next != null){
            
            System.out.print(temp.element+", ");
            temp = temp.next;
        }//while
        System.out.println(temp.element+" ]");
    }//show
    
    
    
    
    
    
    
    
    
    
    public <A> void addFront(A e){
        System.out.println("In addFront method");
        if (isEmpty()){
          head = new Node<>(e);
          System.out.println("We loaded the first one!!");
          size++;}//if
        else // add it to the list
        {
            temp = new Node(e); // to add
            temp.next = head;// make temp point to the head;
            head = temp; // move the head pointer;
            size++;
            
    }//else
  }//addFront
    
    
    
    
    
    
    
     /*
       2 cases
       empty list - return null
       list with several
    */
    public T delete(){
        System.out.println("Delete method (in the front) ");
        show();
        if (size == 0) {
            System.out.println("The list is empty");
            return null;
          }//if 
        else {
           Node<T> temp = head;
            head = head.next;
            size--;
            if (head == null) {
                System.out.println("The list is NOW empty");
                tail = null;
            }//if
            show();
            return temp.element;
        }//else    
    }//delete
    
    
        
    /*
       3 cases
       empty list - return null
       list with one - return last item
       list with several
    */
    public T deleteLast(){
        System.out.println("Delete the last link  method ");
        //show();
        if (size == 0) {
            System.out.println("The list is empty");
            return null;
          }//if 
        else { //move to the end
            Node<T> temp = head;
            while (temp.next.next != null){ //move down the list
                //System.out.print(temp.element+", ");
                temp = temp.next;
        }//while
            T resp = temp.next.element;// send this back on the return
            temp.next = null;
            tail = temp; 
            size--;
            if (head == null) {
                System.out.println("The list is NOW empty");
                tail = null;
            }//if
            return resp;
        }//else    
    }//delete
    
    
    
    public <T> Node find(T e){
        System.out.println("in find!");
        temp = new Node(null);
        front = new Node(null);
        back = new Node(null);
        front = head;
        temp = head;// start at the beginning
        while (temp.next != null){
            
            if (temp.next.element.equals(e)){
                System.out.println(temp.next.element);
                System.out.println("Found !!!");
                front = temp;
                back = temp.next.next;
            }// if
            temp = temp.next;
        }//while
        
        System.out.println(temp.element);
        return temp;
    }// find
    
   
    
  
    
    
    
      /** Remove the head node and
     *  return the object that is contained in the removed node. */
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            Node<T> temp = head;
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
            return temp.element;
        }
    }
    
    
      public <E> boolean containsAndCount(E e) {
          System.out.println("In contains and Count method");
        Node<E> current = head;
        boolean ans = false;
        int count =0;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(e)) {
                ans = true;
                count++;
                
            }//if
            current = current.next;
        }//for
        
        if ((ans==true)&&(count>1)) System.out.println("There are "+ count 
                +" "+ e+"'s on the list");
        else System.out.println(e+ " is on the list");
                
        return ans;
    }// contains
      
      
      
    public <E> boolean contains(E o){
        System.out.println("In contains method");
        boolean ans = false;
        
        //go through the list
        temp = new Node(null); //need to start here
        temp = head;// start at the beginning
        //System.out.print("[ ");
        while (temp.next != null){ // could be a for 
           // System.out.print(temp.element+", ");
            if(temp.element.equals(o)) return true;
            temp = temp.next;
        }//while
        // System.out.println(temp.element+" ]");
        
        return ans;
    }//contains
    
    
    
    
    Stack<Object> s1 = new Stack<>();
    public <T> void reverseList(){
        System.out.println("Reversed list");
        temp = new Node(null);
        temp = head;
        while(temp != null){
            s1.push(temp.element);
            temp = temp.next;
        }// while
        
        while(!s1.empty()){
            System.out.print(s1.pop()+", ");
        }//while
        System.out.println("");
           
    }//reverse

    public static void main(String[] args) {
        
        LinkListPart1  list = new LinkListPart1();
        list.add("Bob");
        list.add("Anne");
        list.add(89);
        list.add(true);
        list.add("X");
        list.add("X");
        list.add("Edx");
        System.out.println(list);// toString
        System.out.println("================");
        list.show();
      
        System.out.println("Deletion of:"+ list.delete());
        
        list.addFront("Frank");
        list.add("Larry");
        list.addFront("Erin");
        list.add("X");
        list.show();
     
        System.out.println("Delete last: "+list.deleteLast());
       // list.show();
        list.show();
        System.out.println("Size: "+ list.getSize());
        System.out.println("Deleted:"+list.delete());
        list.show();
        list.reverseList();
        list.show();
        System.out.println("\n\nDoes it contain X?\n"
                +list.containsAndCount("X"));
       // list.find("Anne");
       // list.show();
        System.out.println("The front is:"+list.head.element);
        
        System.out.println("empty ?"+ list.isEmpty());
        
        list.clear();
        System.out.println("empty ?"+ list.isEmpty());
    }//main   
}//class
