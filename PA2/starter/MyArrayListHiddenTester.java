/**
 * Name: Jianrui Zhang
 * ID: A16878087
 * Email: Jiz145@ucsd.edu
 * Sources used: None
 * Hidden Test case.
 * to check whether the methods and constructor in the MyArrayList.java
 * can work as well.
 */

 //IMPORTANT: Do not change the headers!

 import static org.junit.Assert.*;

 import org.junit.*;
 
 
 /**
  * Hidden test case
  */
 public class MyArrayListHiddenTester {
	 static final int DEFAULT_CAPACITY = 5;
	 static final int MY_CAPACITY = 3;
	 static final int INVALID_CAPACITY = -1;
 
	 Object[] arr = new Object[10];
	 Integer[] arrInts = { 1, 2, 3 };
 
	 private MyArrayList listEmpty, listCustomCapacity, 
		 listWithNull, listWithInt;
 
	 /**
	  * This sets up the test fixture. JUnit invokes this method before
	  * every testXXX method. The @Before tag tells JUnit to run this method
	  * before each test */
	 @Before
	 public void setUp() throws Exception {
		 listEmpty = new MyArrayList();
		 listCustomCapacity = new MyArrayList(MY_CAPACITY);
		 listWithNull = new MyArrayList(arr);
		 listWithInt = new MyArrayList<Integer>(arrInts);
		 
		 
	 }
 
	 /**
	  * Aims to test the constructor when the input argument
	  * is not valid
	  */
	 @Test(expected = IllegalArgumentException.class)
	 public void testConstructorInvalidArg(){
		 listCustomCapacity = new MyArrayList(INVALID_CAPACITY);
	 }
 
	 /**
	  * Aims to test the constructor when the input argument
	  * is null
	  */
	 @Test
	 public void testConstructorNullArg(){
		 listWithNull = new MyArrayList(null);
		 assertEquals("Check for default capacity",5, listWithNull.data.length);
		 assertEquals("Check for default size",0, listWithNull.size);
	 }
 
	 /**
	  * Aims to test the append method when an element is added to a full list
	  * Check reflection on size and capacity
	  */
	 @Test
	 public void testAppendAtCapacity(){
		 listWithInt.append(3);
 
		 assertEquals("Check that append increments size", 4, 
		 listWithInt.size);
		 assertEquals("Check that capacity is unchanged", 6, 
		 listWithInt.data.length);
		 assertEquals("check the correct element", 1, 
		 listWithInt.data[0]);
		 assertEquals("check the correct element", 2, 
		 listWithInt.data[1]);
		 assertEquals("check the correct element", 3, 
		 listWithInt.data[2]);
		 assertEquals("check the correct element", 3, 
		 listWithInt.data[3]);
	 }
 
	 /**
	  * Aims to test the prepend method when a null element is added
	  * Checks reflection on size and capacity
	  * Checks whether null was added successfully
	  */
	 @Test
	 public void testPrependNull(){
		 listWithInt.prepend(null);
		 assertEquals("Check that append increments size", 4, 
			 listWithInt.size);
		 assertEquals("Check that capacity is changed", 6, 
			 listWithInt.data.length);
		 assertEquals("check the correct element", null, 
			 listWithInt.data[0]);
		 assertEquals("check the correct element", 2, 
			 listWithInt.data[2]);
	 }
	 
	 /**
	  * Aims to test the insert method when input index is out of bounds
	  */
	 @Test(expected = IndexOutOfBoundsException.class)
	 public void testInsertOutOfBound(){
		 listWithNull.insert(11,3);
		 listEmpty.insert(6,3);
	 }
 
	 /**
	  * Insert multiple (eg. 1000) elements sequentially beyond capacity -
	  * Check reflection on size and capacity
	  * Hint: for loop could come in handy
	  */
	 @Test
	 public void testInsertMultiple(){
		 int numElement = 1000;
		 for(int i=0; i<numElement; i++){
			 listWithInt.insert(i, i);
		 }
		 assertEquals("Check that insert increments size", 1003, 
			 listWithInt.size);
		 assertEquals("Check that capacity is changed", 1536, 
			 listWithInt.data.length);
 
	 }
 
	 /**
	  * Aims to test the get method when input index is out of bound
	  */
	 @Test(expected = IndexOutOfBoundsException.class)
	 public void testGetOutOfBound(){
		 listWithNull.get(11);
		 listEmpty.get(6);
		 
	 }
 
	 /**
	  * Aims to test the set method when input index is out of bound
	  */
	 @Test(expected = IndexOutOfBoundsException.class)
	 public void testSetOutOfBound(){
		 listWithNull.set(11,3);
		 listEmpty.set(6,3);
	 }
 
 
	 /**
	  * Aims to test the remove method when input index is out of bound
	  */
	 @Test(expected = IndexOutOfBoundsException.class)
	 public void testRemoveOutOfBound(){
		 listWithNull.remove(11);
		 listEmpty.remove(6);
		 
	 }
 
	 /**
	  * Aims to test the expandCapacity method when 
	  * requiredCapacity is strictly less than the current capacity
	  */
	 @Test(expected = IllegalArgumentException.class)
	 public void testExpandCapacitySmaller(){
		 listWithNull.expandCapacity(9);
		 listEmpty.expandCapacity(4);
	 }
 
	 /**
	  * Aims to test the expandCapacity method when 
	  * requiredCapacity is greater than double(2x) the current capacity
	  */
	 @Test
	 public void testExpandCapacityExplode(){
		 listWithInt.expandCapacity(21);
 
		 assertEquals("Check the capacity after explode",21,listWithInt.data.length);
		 assertEquals("The size should still be the same",3, listWithInt.size);
 
		 listEmpty.expandCapacity(11);
		 assertEquals("Check the capacity after explode",11,listEmpty.data.length);
		 assertEquals("The size should still be the same",0,listEmpty.size);
 
 
	 }
 }