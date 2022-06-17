/**
 * Tests to check the implementation of reverseRegion method in MyArrayList.java
*/

//other import statements

import static org.junit.Assert.assertEquals;

import org.junit.*;

//IMPORTANT: DO NOT MODIFY THE TEST HEADERS!
/**
 * This class contains various test cases to test the reverseRegion method
 */
public class ReverseArrayListTester {
    MyArrayList<Integer> i1;
    MyLinkedList i2;
    private final static int INVALIDINDEX = -1;
    private final static int SIZE = 7;
    /**
     * Run before every test
     */
    @Before
    public void setUp(){
        Integer[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        i1 = new MyArrayList<>(arr);
        i2 = new MyLinkedList<>(arr);

    }


    /**
     * Tests reverseRegion method when either fromIndex or toIndex
     * or both are out of bounds.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testReverseIndexOutOfBounds(){
        //TODO: Add your test case
        i1.reverseRegion(INVALIDINDEX, 0);
        i2.reverseRegion(INVALIDINDEX, 0);
    }

    /**
     * Tests reverseRegion method when
     * fromIndex > toIndex
     */
    @Test
    public void testReverseFromIndexGreater(){
        //TODO: Add your test case
        i1.reverseRegion(1, 0);
        for(int i = 0; i < SIZE; i++){
            assertEquals(Integer.valueOf(i),i1.get(i));
        }

        i2.reverseRegion(1,0);
        for(int i = 0; i < SIZE; i++){
            assertEquals(Integer.valueOf(i),i2.get(i));
        }
        

    }

    /**
     * Tests reverseRegion method when
     * fromIndex and toIndex are within bounds and
     * in the middle of the list 
     * (i.e. fromIndex > 0 and toIndex < size-1), 
     * and fromIndex is less than toIndex.
    */
    @Test
    public void testReverseIndexWithinBounds(){
        i1.reverseRegion(1, 2);
        assertEquals("Checks that value is changed",
        Integer.valueOf(2), i1.get(1));
        assertEquals(Integer.valueOf(1),i1.get(2));

        i2.reverseRegion(1, 2);
        assertEquals(Integer.valueOf(2),i2.get(1));
        assertEquals(Integer.valueOf(1),i2.get(2));

        //TODO: Add your test case
    }

    /**
     * Custom test : reverse twice
    */
    @Test
    public void testReverseCustom(){
        //TODO: Add your test case
        i1.reverseRegion(1, 2);
        assertEquals("Checks that value is changed",
        Integer.valueOf(2), i1.get(1));
        assertEquals(Integer.valueOf(1),i1.get(2));
        i1.reverseRegion(1,2);
        assertEquals(Integer.valueOf(1),i1.get(1));
        assertEquals(Integer.valueOf(2),i2.get(2));

        i2.reverseRegion(1, 2);
        assertEquals(Integer.valueOf(2),i2.get(1));
        assertEquals(Integer.valueOf(1),i2.get(2));
        i2.reverseRegion(1, 2);
        assertEquals(Integer.valueOf(1),i2.get(1));
        assertEquals(Integer.valueOf(2),i2.get(2));

    }


}
