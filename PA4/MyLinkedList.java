/**
 * Name: Jianrui Zhang
 * ID: A16878087
 * Email: Jiz145@ucsd.edu
 * Sources used: None
 * 
 * MyLinkedList class and two protected class, Node and MyListIterator.
 * Two protected class work for MyLinkedList class
 */

import java.util.AbstractList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * constructor to declare MyLinkedList
 * instance variables and the method of accessing and manipulating 
 * variables.
 */
public class MyLinkedList<E> extends AbstractList<E> {

    // class instances
    int size;
    Node head;
    Node tail;

   /**
     * A Node class that holds data and references to previous and next Nodes.
     */
    protected class Node {
        E data;
        Node next;
        Node prev;

        /** 
         * Constructor to create singleton Node 
         * @param element Element to add, can be null	
         */
        public Node(E element) {
            // Initialize the instance variables
            this.data = element;
            this.next = null;
            this.prev = null;
        }

        /** 
         * Set the parameter prev as the previous node
         * @param prev - new previous node
         */
        public void setPrev(Node prev) {
            this.prev = prev;		
        }

        /** 
         * Set the parameter next as the next node
         * @param next - new next node
         */
        public void setNext(Node next) {
            this.next = next;
        }

        /** 
         * Set the parameter element as the node's data
         * @param element - new element 
         */
        public void setElement(E element) {
            this.data = element;
        }

        /** 
         * Accessor to get the next Node in the list 
         * @return the next node
         */
        public Node getNext() {
            return this.next;
        }

        /** 
         * Accessor to get the prev Node in the list
         * @return the previous node  
         */
        public Node getPrev() {
            return this.prev;
        }

        /** 
         * Accessor to get the Nodes Element 
         * @return this node's data
         */
        public E getElement() {
            return this.data;
        }
    }
    protected class MyListIterator implements ListIterator<E> {

        // class variables here
        Node left,right;
        int idx;
        boolean forward;
        boolean canRemoveOrSet;
        

        /**
         * constructor for MyListIterator
         * initialize class variables
         */
        public MyListIterator(){
            this.left = head;
            this.right = head.next;
            this.idx = 0;
            this.forward = true;
            this.canRemoveOrSet = false;
        }

        /**
         * @return whether there is a available element node in the next
         */
        public boolean hasNext() {
            // check the next node is not dummy node
            if(right == tail){
                return false;
            }
            return true;
        }

        /**
         * Return the next element in the list when going forward, 
         * and move the iterator forward by one node.
         * @return the next element in the list when going forward
         */
        public E next(){
            //check whether there is a available element node in the next
            if(hasNext() == false) {
                throw new NoSuchElementException();
            }
            // set the left and right
            left = right;
            right = left.next;
            //increment of idx
            idx++;
            // set the canRemobeOrSet and forward
            canRemoveOrSet = true;
            forward = true;
            // return the element of next node
            return left.getElement();
        }

        /**
         * @return whether there is a avaiable element node in the previous
         */
        public boolean hasPrevious(){
            // check the previous node is not dummy node
            if(left.getElement() != null){
                return true;
            }
            return false;
        }
        
        /**Return the next element in the list when going backward, 
         * and move the iterator backward by one node.
         * @return the next element in the list when going backward
         */
        public E previous(){
            //check whether is a avaiable element node in the previous
            if(hasPrevious() == false) {
                throw new NoSuchElementException();
            }
            // set the left and right
            right = left;
            left = right.prev;
            //decrement of idx
            idx--;
            // set the canRemobeOrSet and forward
            canRemoveOrSet = true;
            forward = false;
            // return the element of previous node
            return right.getElement();
        }

        /**
         * @return the index of the element 
         * that would be returned by a call to next().
         */
        public int nextIndex(){
            //Return the list size if at the end of the list.
            if(right == tail){
                return size;
            }
            return idx;
        }
        
        /**
         * @return the index of the element 
         * that would be returned by a call to previous().
         */
        public int previousIndex(){
            //Return -1 if at the start of the list.
            if(left == head){
                return -1;
            }
            return idx-1;
        }

        /**
         * Insert the given item into the list 
         * immediately before the element that would be returned by next(),
         * or after the element that would be returned by previous().
         * @param element (the added element)
         */
        public void add(E element){
            //check the input element is valid
            if(element == null){
                throw new NullPointerException();
            }
            Node temp = new Node(element);
            Node theprev = left;
            Node thenext = right;
            theprev.setNext(temp);
            temp.setPrev(theprev);
            temp.setNext(thenext);
            thenext.setPrev(temp);
            left = temp;

            //set the canRemoveOrSet to false
            canRemoveOrSet = false;
            // increment of idx
            idx++;

        }

        /**
         * For the node returned by the most recent next/previous call, 
         * replace its value with the new value element.
         * @param element (the new element will be set)
         */
        public void set(E element){
            //check the input element is valid
            if(element == null){
                throw new NullPointerException();
            }
            // check there is next or previous called
            if(canRemoveOrSet == false){
                throw new IllegalStateException();
            }
            // if the most recent next() called 
            if(forward){
                left.setElement(element);
            }
            // if the most recent previous called
            else{
                right.setElement(element);
            }
        }
        
        /**
         * Remove the last element node returned 
         * by the most recent next/previous call.
         */
        public void remove(){
            // check there is next or previous called
            if(canRemoveOrSet == false){
                throw new IllegalStateException();
            }
            // if the most recent nex() called
            if(forward){
                Node theprevs = left.prev;
                Node thenext = right;
                theprevs.setNext(thenext);
                thenext.setPrev(theprevs);
                left = left.prev;
                idx--;
            }
            // if the most recent previous() called
            else{
                Node theprevs = left;
                Node thenext = right.next;
                theprevs.setNext(thenext);
                thenext.setPrev(theprevs);
                right = right.next;
            }
            //set the canRemoveOrSet to false
            canRemoveOrSet = false;
        }


    }
    
    /**override the AbstractList implementations*/
    public ListIterator<E> listIterator(){
        MyLinkedList listLen1 =  new MyLinkedList();
        ListIterator listLen1Iter = listLen1.new MyListIterator();
        return listLen1Iter;
    }

    /**override the AbstractList implementations*/
    public Iterator<E> iterator(){
        MyLinkedList listLen1 =  new MyLinkedList();
        Iterator listLen1Iter = listLen1.new MyListIterator();
        return  listLen1Iter;
    }
    /** Only 0-argument constructor is defined */
    public MyLinkedList() {
        // initialize the head and tail 
        head = new Node(null);
        tail = new Node(null);

        head.next = tail;
        head.prev = tail;
        tail.next = head;
        tail.prev = head;

        //initialize the size
        this.size = 0;
    }

    /** @return the size of the linkedlist */
    @Override
    public int size() {
        return this.size; 
    }

    /**
     * Get data of type E within the node at position index.
     * @param index (the index of the data will be getted)
     * @return (the data in that index)
     */
    @Override
    public E get(int index) {
        // check the index is valid
        if( index < 0 || index >= this.size ){
            throw new IndexOutOfBoundsException("The index is invalid");
        }

        //tranverse the linklist
        Node ptr = head;
        Node temp = head;
        int curIndex = 0;  
        while( ptr != tail ) {
            // find the corret data
            if(curIndex == index){
                temp = ptr.next;
            }
            ptr = ptr.next;
            curIndex++; 
            }
        return (E) temp.data; 
    }

    /**
     * Add a node into this list by index.
     * @param index (the index of the data that will be added)
     * @param data (the data will be added)
     */
    @Override
    public void add(int index, E data) {
        // check the data is valid
        if( data == null ){
            throw new NullPointerException("The data is null");
        }
        // check the index is valid
        if( index < 0 || index > this.size ){
            throw new IndexOutOfBoundsException("The index is invalid");
        }
        //tranverse the linklist until in front of the index
        Node temp = new Node(data);
        Node ptr = head;
        for(int i = 0; i < index; i++){
            ptr = ptr.getNext();
        }

        // linked list with new node containing the data.
        Node theprev = ptr;
        Node thenext = ptr.getNext();
        theprev.setNext(temp);
        temp.setPrev(theprev);
        temp.setNext(thenext);
        thenext.setPrev(temp);

        // increment of size;
        size++;
    }

    /**
     * add a node at the end of linkedlist
     * @param data (the data will be added)
     * @return true
     */
    public boolean add(E data) {
        // check data is valid
        if( data == null ){
            throw new NullPointerException("data is null");
        }
        // using add(index,data) method
        add(size, data);

        // return boolean value
        return true;
    }

    /**
     * Set the element for the node at index to data 
     * and return the element that was previously stored in this node.
     * @param index (the index of the data that will be set)
     * @param data (the data will be set)
     * @return (data will be set)
     */
    public E set(int index, E data) {
        // check the data is valid
        if( data == null ){
            throw new NullPointerException();
        }
        // check the index is valid
        if( index < 0 || index >= this.size ){
            throw new IndexOutOfBoundsException();
        }

        // tranverse the linkedlist
        Node ptr = head;
        int curIndex = 0;  
        while(ptr != tail){
            // set the data to correct index
            if(curIndex == index){
                ptr.next.data = data;
            }
            ptr = ptr.next;
            curIndex++;
        }
        return (E) data; 
    }

    /**
     * Remove the node from the position index in this list 
     * @param index (the index of removing data)
     * @return (return the data within the removed node.)
     */
    public E remove(int index) {
        // check the index is valid
        if( index < 0 || index >= this.size ){
            throw new IndexOutOfBoundsException();
        }
        //tranverse the linklist until in front of the index
        Node ptr = head;
        for(int i = 0; i <= index; i++){
            ptr = ptr.getNext();
        }
        Node theprevs = ptr.getPrev();
        Node thenext = ptr.getNext();
        theprevs.setNext(thenext);
        thenext.setPrev(theprevs);
        //decrement of size
        size--;
        return (E) ptr.getElement();
    }

    /**
     * Remove all nodes from the list
     */
    public void clear() {

      head.setNext(tail);
      tail.setPrev(head);
      size = 0;
    }

    /**
     * Determine if the list is empty
     * @return (whether the linkedlist is empty)
     */
    public boolean isEmpty() {
        return this.size <= 0;  
    }

    /**
     * returns the Node at a specified index, not the content.
     * @param index (the index of data that will be getted)
     * @return the Nth data
     */
    protected Node getNth(int index) {
        // check the index is valid
        if( index < 0 || index >= this.size ){
            throw new IndexOutOfBoundsException();
        }

        //tranverse the linkedlist
        Node ptr = head;
        Node temp = head;
        int curIndex = 0;  
        while( ptr != tail ){
            if(curIndex == index){
                temp = ptr.next;
            }
            ptr = ptr.next;
            curIndex++;
        }
        return temp;
    }
}