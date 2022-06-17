/**
 * Name: Jianrui Zhang
 * ID: A15878087
 * Email: Jiz145@ucsd.edu
 * Sources used: None
 * 
 * This file contains the CustomTester class. 
 * It will test the methods and constructors of MyMinHeap class,
 * MyPriorityQueue class and Tickect class
 */

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class will test the methods and constructors of MinHeap class,
 * MyPriorityQueue class and Tickect class.
 * These test cases will be excluded from the PublicTester.
 * 
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class CustomTester {
	
	static void initMinHeap(MyMinHeap<Integer> heap, ArrayList<Integer> data) {
		heap.data = new ArrayList<>(data);
	}
	
	/**
	 * Test the constructor when input is null
	 */
	@Test
	public void testMyMinHeapConstructor() {
		boolean exception = false;
		try{
			ArrayList<Integer> inputList = null;
			MyMinHeap<Integer> minHeap = new MyMinHeap<>(inputList);
		}catch(NullPointerException e){
			exception = true;
		}
		assertTrue(exception);
	}

	/**
	 * Test the getMinChildIdx method 
	 * when element in the index is the leaf node
	 */
	@Test
	public void testGetMinChildIdx() {
		MyMinHeap<Integer> heap = new MyMinHeap<>();
		ArrayList<Integer> startingList = new ArrayList<Integer>(
			Arrays.asList(
				new Integer[] { 5, 3, 4 }
			)
		);

		initMinHeap(heap, startingList);
		assertEquals( -1, heap.getMinChildIdx(1));

	}

	/**
	 * Test the percolateUp method when index is 0
	 */
	@Test
	public void testPercolateUp() {
		MyMinHeap<Integer> heap = new MyMinHeap<>();
		ArrayList<Integer> startingList = new ArrayList<Integer>(
			Arrays.asList(
				new Integer[] { 1, 4, 4, 2, 2 }
			)
		);
		initMinHeap(heap, startingList);
		heap.percolateUp(0);
		Integer[] expected ={1, 4, 4, 2, 2};
		for (int i = 0; i < 5; i++) {
			assertEquals(expected[i],
			heap.data.get(i));
		}
	}

	/**
	 * Test the percolateDown method when index is size() -1
	 */
	@Test
	public void testPercolateDown() {
		MyMinHeap<Integer> heap = new MyMinHeap<>();
		ArrayList<Integer> startingList = new ArrayList<Integer>(
			Arrays.asList(
				new Integer[] { 1, 4, 4, 2, 2 }
			)
		);
		initMinHeap(heap, startingList);
		heap.percolateDown(4);
		Integer[] expected ={1, 4, 4, 2, 2};

		for (int i = 0; i < 5; i++) {
			assertEquals(expected[i],
			heap.data.get(i));
		}
	}

	/**
	 * Test the deleteIndex method when index is size() -1
	 */
	@Test
	public void testDeleteIndex() {
		MyMinHeap<Character> heap = new MyMinHeap<>();
		ArrayList<Character> startingList = new ArrayList<Character>(
			Arrays.asList(
				new Character[] {1, 4, 4, 2, 2 }
			)
		);
		heap.data = new ArrayList<>(startingList);
		heap.deleteIndex(heap.size()-1);
		Character[] expected = { 1,4,4,2 };
		for (int i = 0; i < 4; i++) {
			assertEquals(expected[i], heap.data.get(i));
		}
		assertEquals(4, heap.data.size());

	}

	/**
	 * Test the deleteIndex method 
	 * when index is in the middle of the heap
	 */
	@Test
	public void testDeleteIndex2() {
		MyMinHeap<Integer> heap = new MyMinHeap<>();
		ArrayList<Integer> startingList = new ArrayList<Integer>(
			Arrays.asList(
				new Integer[] { 1, 4, 4, 2, 2 }
			)
		);
		initMinHeap(heap, startingList);
		heap.percolateDown(2);
		Integer[] expected ={1, 4, 4, 2};

		for (int i = 0; i < 4; i++) {
			assertEquals(expected[i],
			heap.data.get(i));
		}
	}

	/**
	 * Test the insert method when element is null
	 */
	@Test
	public void testInsert(){
		boolean exception = false;
		MyMinHeap<Integer> heap = new MyMinHeap<>();
		try{
			heap.insert(null);
		}catch (NullPointerException e){
			exception = true;
		}
		assertTrue(exception);
	}

	/**
	 * Test the insert method 
	 * when element is larger than any elemnet in the heap
	 */
	@Test
	public void testInsert2(){
		MyMinHeap<Integer> heap = new MyMinHeap<>();
		ArrayList<Integer> startingList = new ArrayList<Integer>(
			Arrays.asList(
				new Integer[] { 1, 4, 4, 2, 2 }
			)
		);
		initMinHeap(heap, startingList);

		heap.insert(5);

		Integer[] expected ={1, 4, 4, 2, 2, 5};

		for (int i = 0; i < 6; i++) {
			assertEquals(expected[i],
			heap.data.get(i));
		}

	}

   
	/**
	 * Test remove when heap is empty
	 */
	@Test
	public void testRemove(){
		MyMinHeap<Integer> heap = new MyMinHeap<>();
		assertEquals(null, heap.remove());
	}

  
	/**
	 * Test getMin when heap is empty
	 */
	@Test
	public void testGetMin(){
		MyMinHeap<Integer> heap = new MyMinHeap<>();
		assertEquals(null, heap.getMin());
	}
}