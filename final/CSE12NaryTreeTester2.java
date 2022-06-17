/**
 * TODO: Add file header
 * Name: Run
 * ID: 
 * Email: 
 * File description: 
 */
 
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * TODO: Add class header
 */
public class CSE12NaryTreeTester2 {
    CSE12NaryTree<Integer> temp;
    CSE12NaryTree<Integer> empty;

    @Before
    /**
     * 
     */
    public void setUp() {
        temp = new CSE12NaryTree<>(5);
        empty = new CSE12NaryTree<>(5);
        empty.size = 0;
        empty.N = 5;
        empty.root = null;
        CSE12NaryTree<Integer>.Node root = temp.new Node(5);
        CSE12NaryTree<Integer>.Node One = temp.new Node(1);
        CSE12NaryTree<Integer>.Node two = temp.new Node(2);
        CSE12NaryTree<Integer>.Node four = temp.new Node(4);
        CSE12NaryTree<Integer>.Node six = temp.new Node(6);
        CSE12NaryTree<Integer>.Node seven = temp.new Node(7);
        root.addChild(One);
        root.addChild(two);
        root.addChild(four);
        root.addChild(six);
        root.addChild(seven);
        temp.size = 6;
        temp.root = root;
        temp.N = 5;
    }

    /**
     * TODO: Add test case description.
     */
    @Test
    public void testAdd(){
        temp.add(9);
        assertEquals(Integer.valueOf(9), temp.root.getChildren().get(0).children.get(0).data);
        assertEquals(Integer.valueOf(7), (Integer) temp.size);
        temp.add(18);
        assertEquals(Integer.valueOf(18), temp.root.getChildren().get(0).children.get(1).data);
        assertEquals(Integer.valueOf(8), (Integer) temp.size);
        
    }

    /**
     * TODO: Add test case description
     */
    @Test
    public void testContains(){
        assertFalse(temp.contains(100));
    }

    /**
     * TODO: Add test case description
     */
    @Test
    public void testSortTree() {
        ArrayList<Integer> test = new ArrayList<Integer>();
        test.add(1);
        empty.add(1);
        assertEquals(Integer.valueOf(1), empty.root.getData());
        assertEquals(1, empty.size);
        assertEquals(test,empty.sortTree());
    }

    /**
     * TODO: Add test case description
     */
    @Test
    public void testCustom(){
        ArrayList<Integer> test = new ArrayList<Integer>();
        test.add(1);
        test.add(2);
        test.add(4);
        test.add(5);
        test.add(6);
        test.add(7);
        test.add(9);
        test.add(18);
        temp.add(9);
        temp.add(18);
        assertEquals(test, temp.sortTree());
    }
}
