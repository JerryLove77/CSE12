/**
 * Name:Jianrui Zhang
 * ID: A16878087
 * Email: Jiz145@ucsd.edu
 * Sources used: None
 * 
 * This file contains all the Custom tests.
 * The test cases in this file are not in the public tester.
 */

import org.junit.*;
import static org.junit.Assert.*;

/**
 * This class contains public test cases for MyDeque, MyStack, and MyQueue
 * The test cases in this class will not be in the public tester
 * 
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class CustomTester {
    Integer[] orig;
    Integer[] finalOrdering;

    /**
     * Helper method to initialize all instance variables of MyDeque
     * @param deque The deque to initialize
     * @param data The data array
     * @param size The value for size
     * @param front The value for front
     * @param rear The value for rear
     */
    static void initDeque(MyDeque<Integer> deque, Object[] data, int size, 
            int front, int rear) {
        deque.data = data;
        deque.size = size;
        deque.front = front;
        deque.rear = rear;
        }
    // ----------------MyDeque class----------------
    /**
     * Test the constructor when initialcapacity less than zero
     */
    @Test
    public void testMyDequeConstructor() {
        boolean exceptionThrown = false;
        try{
            MyDeque<Integer> deque = new MyDeque<>(-1);
        } catch(IllegalArgumentException e){
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);

    }

    /**
     * Test the expandCapacity method when capacity is zero
     */
    @Test
    public void testMyDequeExpandCapacity() {
        MyDeque<Integer> deque = new MyDeque<>(0);
        Integer[] orig = {};
        Integer[] finalOrdering = {null,null,null,null,null,null,null,null,null,null};
        initDeque(deque, orig,0,0,0);

        deque.expandCapacity();

        assertEquals(10,deque.data.length);
        assertEquals(0,deque.size);
        assertEquals(0, deque.front);
        assertEquals(0,deque.rear);

        for (int i = 0; i < deque.data.length; i++) {
            assertEquals(finalOrdering[i], deque.data[i]);
        }



    }

    /**
     * Test addFirst to deque containing several elements 
     * at begining of the array
     */
    @Test
    public void testAddFirst() {
        MyDeque<Integer> deque = new MyDeque<>(10);
        Integer[] orig = {0, 1, 2, 3, null, null, null, null, null, null };
        Integer[] finalOrdering = {0, 1, 2, 3, null, null, null, null, null, 9};
        initDeque(deque, orig, 4, 0, 3);

        deque.addFirst(9);

        assertEquals(10, deque.data.length);
        assertEquals(5, deque.size);
        assertEquals(9, deque.front);
        assertEquals(3, deque.rear);
        for (int i = 0; i < deque.data.length; i++) {
            assertEquals(finalOrdering[i], deque.data[i]);
        }

    }

    /**
     * Test the addLast to deque containing several elements
     * at the end of the array
     */
    @Test
    public void testAddLast() {
        MyDeque<Integer> deque = new MyDeque<>(10);
        Integer[] orig = {null, null, null, null, null, null, 6, 7, 8, 9};
        Integer[] finalOrdering = {0, null, null, null, null, null, 6, 7, 8, 9};
        initDeque(deque, orig, 4, 6, 9);

        deque.addLast(0);

        assertEquals(10, deque.data.length);
        assertEquals(5, deque.size);
        assertEquals(0,deque.rear);
        assertEquals(6,deque.front);

        for (int i = 0; i < deque.data.length; i++) {
            assertEquals(finalOrdering[i], deque.data[i]);
        }


    }

    /**
     * Test the removeFirst  to deque containing one element 
     * at middle of the array
     */
    @Test
    public void testRemoveFirst() {
        MyDeque<Integer> deque = new MyDeque<>(10);
        Integer[] orig = {null, null, null, null, null, null, null, 7, null, null};
        Integer[] finalOrdering = {null, null, null, null, null, null, null, null, null, null};
        initDeque(deque, orig, 1, 7, 7);

        deque.removeFirst();

        assertEquals(10, deque.data.length);
        assertEquals(0, deque.size);
        assertEquals(7,deque.rear);
        assertEquals(7,deque.front);

        for (int i = 0; i < deque.data.length; i++) {
            assertEquals(finalOrdering[i], deque.data[i]);
        }


        

    }

    /**
     * Test the removeLast to deque containing several elements 
     * at the end of array
     */
    @Test
    public void testRemoveLast() {
        MyDeque<Integer> deque = new MyDeque<>(10);
        Integer[] orig = {null, null, null, null, null, null, 6, 7, 8, 9};
        Integer[] finalOrdering = {null, null, null, null, null, null, 6, 7, 8, null};
        initDeque(deque, orig, 4, 6, 9);

        deque.removeLast();

        assertEquals(10, deque.data.length);
        assertEquals(3, deque.size);
        assertEquals(8,deque.rear);
        assertEquals(6,deque.front);

        for (int i = 0; i < deque.data.length; i++) {
            assertEquals(finalOrdering[i], deque.data[i]);
        }



        

    }

    /**
     * Test the peekFirst method when deque does not have any elements
     */
    @Test
    public void testPeekFirst(){
        MyDeque<Integer> deque = new MyDeque<>(10);
        Integer[] orig = {null, null, null, null, null, null, null, null, null, null};
        initDeque(deque, orig, 0, 0, 0);

        assertEquals(null,deque.peekFirst());

    }

    /**
     * Test the peekLast method when deque does not have any elements
     */
    @Test
    public void testPeekLast(){
        MyDeque<Integer> deque = new MyDeque<>(10);
        Integer[] orig = {null, null, null, null, null, null, null, null, null, null};
        initDeque(deque, orig, 0, 0, 0);

        assertEquals(null,deque.peekLast());

    }

    // ----------------MyStack class----------------
    /**
     * Test MyStack when the initial capcaity is zero
     *  and call push and pop methods to it.
     */
    @Test
    public void testMyStack(){
        MyStack<Integer> stack = new MyStack<>(0);
        assertTrue(stack.empty());
        stack.push(0);
        stack.push(9);
        assertEquals(10,stack.theStack.data.length);
        assertEquals(0,stack.theStack.rear);
        assertEquals(9,stack.theStack.front);
        assertEquals(2,stack.size());
        assertEquals(Integer.valueOf(9),stack.peek());
        stack.pop();
        assertEquals(10,stack.theStack.data.length);
        assertEquals(1,stack.size());
        assertEquals(0,stack.theStack.front);
        assertEquals(0,stack.theStack.rear);
        assertEquals(Integer.valueOf(0),stack.peek());

    }

    // ----------------MyQueue class----------------
    /**
     * Test MyQueue when initial capcaity is zero
     * call enqueue and dequeue methods to it.
     */
    @Test
    public void testMyQueue(){
        MyQueue<Integer> queue = new MyQueue<>(0);
        assertTrue(queue.empty());
        queue.enqueue(0);
        assertEquals(10,queue.theQueue.data.length);
        assertEquals(1, queue.size());
        assertEquals(0, queue.theQueue.front);
        assertEquals(0, queue.theQueue.rear);
        assertEquals(Integer.valueOf(0),queue.peek());
        queue.dequeue();
        assertEquals(10,queue.theQueue.data.length);
        assertEquals(0, queue.size());
        assertEquals(0, queue.theQueue.front);
        assertEquals(0, queue.theQueue.rear);
        assertEquals(null,queue.peek());

    }
}
