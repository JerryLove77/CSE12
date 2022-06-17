/**
 * Name: Jianrui Zhang
 * Email: Jiz145@ucsd.edu
 * Sources used: None
 * 
 * This file contains MeDeque class, which is an implementation 
 * for DequeInterface. Elements can be added/removed 
 * from the queue in a LIFO ordering.
 */

/**
 * This class implements the Deque ADT using data array, int size,
 * rear, and front. This class includes several methods to access and 
 * manipulate the local variables.
 */

 
public class MyDeque<E> implements DequeInterface<E> {
    //Instance variables
    Object[] data;
    int size;
    int rear;
    int front;
    private final static int DEFAULT = 10;
    private final static int TWO = 2;

    /** Initialize the Object array data with 
     * length of initialCapacity.
     * @param initialCapacity
     */
    public MyDeque(int initialCapacity){
        if(initialCapacity < 0){
            throw new IllegalArgumentException();
        }
        this.data = new Object[initialCapacity];
        this.size = 0;
        this.rear = 0;
        this.front = 0;
    }

    /**
     * @return the number of elements that exist in the deque.
     */
    @Override
    public int size(){
        return this.size;
    }

    /**
     * Doubles the current capacity
     */
    @Override
    public void expandCapacity(){
        if(data.length == 0){
            this.data = new Object[DEFAULT];
        }
        else{
            Object[] expanded = new Object[this.data.length * TWO];
            int cur = this.front;
            for (int i = 0; i < this.size(); i++){
                if (cur >= this.data.length){
                    cur = 0;
                }
                expanded[i] = this.data[cur];
                cur++; 
            }
            this.front = 0;
            this.rear = this.size() - 1;
            this.data = expanded;
        }
    }

    /**
     * Add the specified element to the front of the deque
     * @param element (the elemnet will be added )
     */
    @Override
    public void addFirst(E element){
        if(element == null){
            throw new NullPointerException();
        }
        if(size == data.length){
            expandCapacity();
        }
        if(size != 0){
            front = (front - 1 + data.length)%(data.length);
        }
        data[front] = element;
        size++;
    }



    /**
     * Add the specified element to the rear of the deque
     * @param element (the element will be added )
     */
    @Override
    public void addLast(E element){
        if(element == null){
            throw new NullPointerException();
        }
        if(size == data.length){
            expandCapacity();
        }
        if(size != 0){
            rear = (rear + 1 + data.length)%(data.length);
        }
        data[rear] = element;  
        size++;      
    }

    /**
     * Removes the element at the front of the deque
     * @return the element at the front of the deque
     */
    @Override
    public E removeFirst(){
        if(size == 0){
            return null;
        }
        Object temp = data[front];
        data[front] = null;
        if(size != 1){
            front = (front + 1 + data.length)%(data.length);
        }
        size--;
        return (E) temp;

    }

    /**
     * Removes the element at the rear of the deque
     * @return the element at the rear of the deque
     */
    @Override
    public E removeLast(){
        if(size == 0){
            return null;
        }
        Object temp = data[rear];
        data[rear] = null;
        if(size != 1){
            rear = (rear - 1 + data.length)%(data.length);
        }
        size--;
        return (E) temp;


    }

    /**
     * @return  the element at the front of the deque
     */
    @Override
    public E peekFirst(){
        if (this.size() <= 0){
            return null;
        }
        return (E) this.data[this.front];
    }

    /**
     * @return the element at the rear of the deque 
     */
    @Override
    public E peekLast(){
        if (this.size() <= 0){ 
            return null;
        }
        return (E) this.data[this.rear];

    }

    
}
