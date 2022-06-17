/**
 * Name: Jianrui Zhang
 * ID: A16878087
 * Email: Jiz145@ucsd.edu
 * File description: 
 * This file contains CSE12NaryTreeTester class.
 * Those test cases are used to test the methods in
 * CSE12NaryTree class
 */

// import statement
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * This class contains 4 test cases to test the
 * methods in CSE12NaryTreeTester class. 
 */
public class CSE12NaryTreeTester {
    CSE12NaryTree<Integer> completeTree, emptyTree;
    ArrayList<Integer> intList, sortIntList;
    private final static int FIVE = 5;

    /**
     * set up variables used in tester
     */
    @Before
    public void setup(){
        emptyTree = new CSE12NaryTree<>(FIVE);
        emptyTree.size = 0;

        completeTree = new CSE12NaryTree<>(FIVE);
        CSE12NaryTree<Integer>.Node root = this.completeTree.new Node(4);
        CSE12NaryTree<Integer>.Node child1 = this.completeTree.new Node(3);
        CSE12NaryTree<Integer>.Node child2 = this.completeTree.new Node(2);
        CSE12NaryTree<Integer>.Node child3 = this.completeTree.new Node(6);
        CSE12NaryTree<Integer>.Node child4 = this.completeTree.new Node(5);
        CSE12NaryTree<Integer>.Node child5 = this.completeTree.new Node(1);
        completeTree.root = root;
        completeTree.root.addChild(child1);
        completeTree.root.addChild(child2);
        completeTree.root.addChild(child3);
        completeTree.root.addChild(child4);
        completeTree.root.addChild(child5);
        completeTree.size = 6;

        intList = new ArrayList<>();
        intList.add(3);
        intList.add(2);
        intList.add(6);
        intList.add(5);
        intList.add(1);

        sortIntList = new ArrayList<>();
        sortIntList.add(1);
        sortIntList.add(2);
        sortIntList.add(3);
        sortIntList.add(4);
        sortIntList.add(5);
        sortIntList.add(6);
    }
    /**
     * Test add() method to empty tree
     */
    @Test
    public void testAdd(){
        emptyTree.add(FIVE);
        assertEquals(1,emptyTree.size);
        assertEquals(Integer.valueOf(FIVE),emptyTree.root.getData());

    }

    /**
     * Test sontains method to complete tree contained element
     */
    @Test
    public void testContains(){
        assertTrue(completeTree.contains(FIVE));
    }

    /**
     * Test sortTree() method to empty tree
     */
    @Test
    public void testSortTree(){
        // should return a empty arraylist
        assertEquals(0,emptyTree.sortTree().size());
    }

    /**
     * Test calling add() method mulitiple times,
     * test contains() to complete tree not contained element, 
     * and Test sortTree() methods to complete tree.
     */
    @Test
    public void testCustom(){
        // add() mulitiple times
        emptyTree.add(4);
        emptyTree.add(3);
        emptyTree.add(2);
        emptyTree.add(6);
        emptyTree.add(5);
        emptyTree.add(1);

        // test add() method to complete tree
        for(int i = 0; i < FIVE; i++){
            assertEquals(Integer.valueOf(intList.get(i)),
            emptyTree.root.getChildren().get(i).getData());
        }

        //test contains() method to complete tree if not contains the element
        assertTrue(! emptyTree.contains(10));
        
        // test sortTree() method
        for(int i = 0; i < FIVE; i++){
            assertEquals(Integer.valueOf(sortIntList.get(i)), 
            emptyTree.sortTree().get(i));
        }
    }
}
