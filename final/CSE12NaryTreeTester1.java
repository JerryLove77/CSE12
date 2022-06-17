/**
 * TODO: Add file header
 * Name:
 * ID:
 * Email:
 * File description: 
 */
 
import static org.junit.Assert.*;
import org.junit.*;

import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * TODO: Add class header
 */
public class CSE12NaryTreeTester1 {
    CSE12NaryTree<Integer> tree;
    CSE12NaryTree<Integer> treeWithRootOnly;
    /**
     * TODO: Add test case description.
     */
    @Before
    public void setup(){
       //           3
       //         / / | \  \
       //        5 10 7  6  9
        this.tree=new CSE12NaryTree<>(5);
        this.treeWithRootOnly=new CSE12NaryTree<>(5);
        CSE12NaryTree<Integer>.Node root = tree.new Node(3);
        CSE12NaryTree<Integer>.Node newroot = tree.new Node(1000);

        this.tree.root=root;
        List<CSE12NaryTree<Integer>.Node> childrenOfRoot=new ArrayList<>();
        CSE12NaryTree<Integer>.Node five = tree.new Node(5);
        CSE12NaryTree<Integer>.Node ten = tree.new Node(10);
        CSE12NaryTree<Integer>.Node seven = tree.new Node(7);
        CSE12NaryTree<Integer>.Node six = tree.new Node(6);
        CSE12NaryTree<Integer>.Node nin = tree.new Node(9);
        childrenOfRoot.add(five);
        childrenOfRoot.add(ten);
        childrenOfRoot.add(seven);
        childrenOfRoot.add(six);
        childrenOfRoot.add(nin);
        root.children=childrenOfRoot;
        this.tree.size=6;
        
        treeWithRootOnly.root=newroot;
    }

    @Test
    public void testAdd(){
        CSE12NaryTree<Integer>.Node root=tree.root;
        CSE12NaryTree<Integer>.Node eleven = tree.new Node(11);
        List<CSE12NaryTree<Integer>.Node> childrenOfFive=new ArrayList<>();
        childrenOfFive.add(eleven);
        root.children.get(1).children=childrenOfFive;
        tree.add(11);
        assertSame( 5, root.getNumChildren());
        assertSame( 1, root.children.get(1).getNumChildren());
        assertSame(11, root.children.get(0).children.get(0).data);
    }

    /**
     * TODO: Add test case description
     */
    @Test
    public void testContains(){
        assertFalse(tree.contains(1000));
        assertTrue(tree.contains(5));
    }

    /**
     * TODO: Add test case description
     */
    @Test
    public void testSortTree(){
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1000);
        assertEquals(expected, treeWithRootOnly.sortTree());
    }

    /**
     * TODO: Add test case description
     */
    @Test
    public void testCustom(){
        ArrayList<Integer> expected2 = new ArrayList<>();
        expected2.add(3);
        expected2.add(5);
        expected2.add(6);
        expected2.add(7);
        expected2.add(9);
        expected2.add(10);
        assertEquals(expected2, tree.sortTree());
    }
}
