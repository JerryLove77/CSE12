/**
 * Name: Jianrui Zhang
 * ID: A16878087
 * Email: Jiz145@ucsd.edu
 * Sources used: None
 * 
 * Implemented the AbstractList 
 * Methods about accessing and manipuling
 * LinkedList
 * 
 */

import java.util.AbstractList;

/**
 * constructor to declare MyLinkedList
 * instance variables and the method of accessing and manipulating 
 * variables.
 */
public class MyLinkedList<E> extends AbstractList<E> {

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
            throw new IndexOutOfBoundsException();
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
            throw new NullPointerException();
        }
        // check the index is valid
        if( index < 0 || index > this.size ){
            throw new IndexOutOfBoundsException();
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
            throw new NullPointerException();
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