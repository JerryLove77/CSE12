import static org.junit.Assert.*;
import org.junit.*;
/**
 * Name: Jianrui Zhang
 * ID: A16878087
 * Email: Jiz145@ucsd.edu
 * Sources used: None
 * 
 * The custom test case about MyLinkedList
 * Those test cases are not included in Public test
 * 
 */

 /**
  * The custom test case about MyLinkedList
  * Those test cases are not included in Public test
  */
public class MyLinkedListCustomTester {
    private MyLinkedList<Integer> emptyIntegerList;
    private MyLinkedList<String> threeStringList;
    private String[] strData = {"CSE 12", "Paul Cao", "Christine Alvarado"};
    static final int NEGATIVEINDEX = -1;

    /**
     * This sets up the test fixture. JUnit invokes this method before
     * every testXXX method. The @Before tag tells JUnit to run this method
     * before each test.
     */
    @Before
    public void setUp() {
        emptyIntegerList = new MyLinkedList<Integer>();
        threeStringList = new MyLinkedList<>();
        MyLinkedList<String>.Node node0 =  
            this.threeStringList.new Node(this.strData[0]);
        MyLinkedList<String>.Node node1 =  
            this.threeStringList.new Node(this.strData[1]);
        MyLinkedList<String>.Node node2 =  
            this.threeStringList.new Node(this.strData[2]);

        this.threeStringList.head.next = node0;
        node0.prev = this.threeStringList.head;
        node0.next = node1;
        node1.prev = node0;
        node1.next = node2;
        node2.prev = node1;
        node2.next = this.threeStringList.tail;
        this.threeStringList.tail.prev = node2;
        this.threeStringList.size = 3;
    }

    /**
     * Test the add method when data is null
     */
    @Test (expected = NullPointerException.class)
    public void testAdd() {
        emptyIntegerList.add(null);
    }

    /**
     * Test the add with index method when data is null
     */
    @Test(expected = NullPointerException.class)
    public void testAddWithIndexTestOne() {
        emptyIntegerList.add(0,null);
    }

    /**
     * Test the add with index method when add to non empty list.
     */	
    @Test
    public void testAddWithIndexTestTwo() {
        threeStringList.add(3,"JerryLove");
        assertEquals("Check tail reference is updated",
        "JerryLove",this.threeStringList.tail.prev.data);
        assertEquals("Check head reference is updated",
        "CSE 12",this.threeStringList.head.next.data);
        assertEquals("Check size is updated", 
        4, this.threeStringList.size);
    }

    /**
     * Test the get method when index is greater than size
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet() { 
        threeStringList.get(3);
    }

    /**
     * Test the getNth method when index is nagative
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetNth() {
        emptyIntegerList.getNth(NEGATIVEINDEX);
    }

    /**
     * Test the set method when great than size
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSet() {
        threeStringList.set(3,"JerryLove");
    }

    /**
     * Test the remove method when index is negative
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveTestOne() {
        threeStringList.remove(NEGATIVEINDEX);
    }
    
    /**
     * Test the remove method 
     * when remove node in the index of 0 in the empty linkedlist
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveTestTwo() {
        emptyIntegerList.remove(0);
    }

    /**
     * Test the clear method when clear empty linkedlist
     */
    @Test
    public void testClear() {
        emptyIntegerList.clear();
        assertTrue("Check the list is empty", 
        emptyIntegerList.isEmpty());
    }

    /**
     * Test the size method when size is not zero
     */
    @Test
    public void testSize() {
        assertEquals("The list with 3 elements should have a size of 3",
        3,threeStringList.size());
    }
}