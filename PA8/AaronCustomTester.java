
/**
 * Name:Aaron Li
 * ID:A17120396
 * Email:aal005@ucsd.edu
 * Sources used:zyBooks, lecture notes
 * 
 * This file is customer test for MyBST. It contains a tester class.
 */

import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * this class is tester class.
 */
public class AaronCustomTester {
    MyBST<Integer, Integer> skewedTree;
    MyBST<Integer, Integer> emptyTree;

    /**
     * This setup() initializes 2 different tree
     * (1) skewedTree
     * 6
     * \
     * 10
     * \
     * 15
     * (2) emptyTree
     * root = null (defalt constructor)
     */
    @Before
    public void setup() {

        MyBST.MyBSTNode<Integer, Integer> root = new MyBST.MyBSTNode<>(6, 1, null);
        MyBST.MyBSTNode<Integer, Integer> ten = new MyBST.MyBSTNode<>(10, 1, root);
        MyBST.MyBSTNode<Integer, Integer> fifteen = new MyBST.MyBSTNode<>(15, 1, ten);

        this.skewedTree = new MyBST<>();
        this.skewedTree.root = root;
        root.setRight(ten);
        ten.setRight(fifteen);
        this.skewedTree.size = 3;

        this.emptyTree = new MyBST<>();

    }

    // Test predecessor() on skewed tree
    @Test
    public void testNodePredecessor1() {
        // root
        assertSame(null, skewedTree.root.predecessor());
        // leaf
        MyBST.MyBSTNode<Integer, Integer> leaf = skewedTree.root.getRight().getRight();
        assertSame(skewedTree.root.getRight(), leaf.predecessor());
    }

    // Test insert method when key == null for skewedTree
    @Test
    public void testInsert1() {
        try {
            skewedTree.insert(null, 1);
            fail();
        } catch (NullPointerException e) {
        }
    }
    
    // Test insert method when key == null for emptyTree
    @Test
    public void testInsert2() {
    try {
        emptyTree.insert(null, 1);
        fail();
    } catch (NullPointerException e) {
        }
    }

    // Test insert method when key != null for empty tree
    @Test
    public void testInsert3() {
        this.emptyTree.insert(1, 1);
        assertEquals(Integer.valueOf(1),
                this.emptyTree.root.getKey());
    }

    // Test insert method when key != null for skewed tree
    @Test
    public void testInsert4() {
        this.skewedTree.insert(9, 1);
        assertEquals(Integer.valueOf(9),
                this.skewedTree.root.getRight().getLeft().getKey());
        this.skewedTree.insert(8, 1);
        assertEquals(Integer.valueOf(8),
                this.skewedTree.root.getRight().getLeft().getLeft().getKey());
    }

    // Test search method when node does not exist
    @Test
    public void testSearch() {
        assertEquals(null, emptyTree.search(3));
        assertEquals(null, skewedTree.search(3));
    }

    // Test remove method when node does not exist
    @Test
    public void testRemove1() {
        // empty tree
        assertEquals(null, emptyTree.remove(1));
        // skewed tree
        assertEquals(null, skewedTree.remove(1));

    }

    // Test remove method when node exist
    @Test
    public void testRemove2() {
        assertEquals(1, (int) skewedTree.remove(6));
        assertEquals(null, skewedTree.remove(6));
        assertEquals(10, (int) skewedTree.root.getKey());
        assertEquals(2, skewedTree.size());
    }

    // Test inorder method when it is empty
    @Test
    public void testInorder() {
        ArrayList<MyBST.MyBSTNode<Integer, Integer>> expectedRes = new ArrayList<>();
        ArrayList<MyBST.MyBSTNode<Integer, Integer>> actualRes = emptyTree.inorder();
        for (int i = 0; i < expectedRes.size(); i++) {
            assertSame(expectedRes.get(i), actualRes.get(i));
        }
    }

    // Test book method for calendar
    @Test
    public void testbook() {
        MyCalendar calendar = new MyCalendar();
        assertTrue(calendar.book(0, 5)); 
        assertTrue(calendar.book(5, 10)); 
        assertFalse(calendar.book(9, 12)); 
    }
}
