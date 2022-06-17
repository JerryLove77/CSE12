/**
 * Name:Aaron Li
 * ID:A17120396
 * Email:aal005@ucsd.edu
 * Sources used: None
 * 
 * This file contains all custom tester methods for MyMinHeap.
 * It contains 1 class.
 */

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * This class contains all custom tester methods.
 */
public class AaronCustomTester {

	/**
	 * Test the constructor when collection is null
	 */
	@Test
	public void testMyMinHeapConstructor() {
		try {
			MyMinHeap<Integer> totest = new MyMinHeap<Integer>(null);
			fail();
		} catch (NullPointerException e) {
		}
	}

	/**
	 * Test the getMinChildIdx method when
	 * the current index is the leaf index
	 */
	@Test
	public void testGetMinChildIdx() {
		ArrayList<Integer> test = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
		MyMinHeap<Integer> totest = new MyMinHeap<Integer>(test);
		assertEquals(-1, totest.getMinChildIdx(3));
	}

	/**
	 * Test the percolateUp method when the index is at the bottom(leaf)
	 */
	@Test
	public void testPercolateUp() {
		//initializing
		ArrayList<Integer> test = new ArrayList<Integer>(Arrays.asList(new Integer[] { 3, 2, 4, 1 }));
		MyMinHeap<Integer> totest = new MyMinHeap<Integer>();
		totest.data = test;
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 3, 4, 2));

		//to-test method
		totest.percolateUp(3);
		
		//comparing
		for (int i = 0; i < expected.size(); i++) {
			assertEquals(expected.get(i), totest.data.get(i));
		}
	}

	/**
	 * Test the percolateDown method when the index is at the middle
	 */
	@Test
	public void testPercolateDown() {
		//initializing
		ArrayList<Integer> test = new ArrayList<Integer>(Arrays.asList(new Integer[] { 3, 2, 4, 1 }));
		MyMinHeap<Integer> totest = new MyMinHeap<Integer>();
		totest.data = test;
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(3, 1, 4, 2));

		//to-test method
		totest.percolateDown(1);
		
		//comparing
		for (int i = 0; i < expected.size(); i++) {
			assertEquals(expected.get(i), totest.data.get(i));
		}
	}

	/**
	 * Test the deleteIndex method when deleting the leaf
	 */
	@Test
	public void testDeleteIndex() {
		//initializing
		ArrayList<Integer> test = new ArrayList<Integer>(Arrays.asList(new Integer[] { 3, 2, 4, 1 }));
		MyMinHeap<Integer> totest = new MyMinHeap<Integer>();
		totest.data = test;
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(3, 2, 4));
		
		//to-test method
		totest.deleteIndex(3);
		
		//comparing
		for (int i = 0; i < expected.size(); i++) {
			assertEquals(expected.get(i), totest.data.get(i));
		}
	}

	/**
	 * Test the deleteIndex method when deleting the middle
	 */
	@Test
	public void testDeleteIndex2() {
		//initializing
		ArrayList<Integer> test = new ArrayList<Integer>(Arrays.asList(new Integer[] { 3, 2, 4, 1 }));
		MyMinHeap<Integer> totest = new MyMinHeap<Integer>();
		totest.data = test;
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 3, 4));
		
		//to-test method
		totest.deleteIndex(1);
		
		//comparing
		for (int i = 0; i < expected.size(); i++) {
			assertEquals(expected.get(i), totest.data.get(i));
		}
	}

	/**
	 * Test the insert method when the argument is null
	 */
	@Test
	public void testInsert() {
		//initializing
		ArrayList<Integer> test = new ArrayList<Integer>(Arrays.asList(new Integer[] { 3, 2, 4, 1 }));
		MyMinHeap<Integer> totest = new MyMinHeap<Integer>();
		totest.data = test;
		
		//to-test method
		try {
			totest.insert(null);
			fail();
		} catch (NullPointerException  e) {
		}
	}
	

	/**
	 * Test the insert method when the original heap has no elements
	 */
	@Test
	public void testInsert2() {
		//initializing
		MyMinHeap<Integer> totest = new MyMinHeap<Integer>();
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1));
		
		//to-test method
		totest.insert(1);
		
		//comparing
		for (int i = 0; i < expected.size(); i++) {
			assertEquals(expected.get(i), totest.data.get(i));
		}
	}

	/**
	 * Test remove when the original heap has no elements
	 */
	@Test
	public void testRemove() {
		//initializing
		MyMinHeap<Integer> totest = new MyMinHeap<Integer>();
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1));
		
		//to-test method
		Integer removed = totest.remove();
		
		//comparing
		for (int i = 0; i < expected.size(); i++) {
			assertEquals(null, removed);
		}
	}

	/**
	 * Test getMin when the data is null
	 */
	@Test
	public void testGetMin() {
	//initializing
		MyMinHeap<Integer> totest = new MyMinHeap<Integer>();
		
		//to-test method
		Integer min = totest.getMin();
		
		//comparing
		assertEquals(null, min);
	}
}