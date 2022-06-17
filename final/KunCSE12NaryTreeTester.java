/**
 * Name: Kun Wang
 * ID: A16807435
 * Email: kuw010@ucsd.edu
 * File description: This file contains the tester for NaryTree
 */
 
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * This is the tester class of NaryTree. 
 * It contains all the tests for Nary tree.
 */
public class KunCSE12NaryTreeTester {

    CSE12NaryTree<Integer> fiveTree, rootTree, threeTree; 

    /**
     * This is the method that setup the nary tree for the tests
     */
    @Before
    public void setUp(){
        this.fiveTree = new CSE12NaryTree<>(5);

        CSE12NaryTree.Node five = fiveTree.new Node(5);
        CSE12NaryTree.Node four = fiveTree.new Node(4);
        CSE12NaryTree.Node six = fiveTree.new Node(6);
        CSE12NaryTree.Node two = fiveTree.new Node(2);
        CSE12NaryTree.Node eight = fiveTree.new Node(8);
        CSE12NaryTree.Node nine = fiveTree.new Node(9);



        five.addChild(four);
        five.addChild(six);
        five.addChild(two);
        five.addChild(eight);
        five.addChild(nine);

        fiveTree.root = five;
        fiveTree.size = 6;


        this.rootTree = new CSE12NaryTree<>(5);
        CSE12NaryTree.Node one = rootTree.new Node(1);
        rootTree.root = one;
        rootTree.size = 1;

        this.threeTree = new CSE12NaryTree<>(3);
        CSE12NaryTree.Node nodeFive = threeTree.new Node(5);
        CSE12NaryTree.Node nodeFour = threeTree.new Node(4);
        CSE12NaryTree.Node nodeSix = threeTree.new Node(6);
        CSE12NaryTree.Node nodeTwo = threeTree.new Node(2);
        CSE12NaryTree.Node nodeEight = threeTree.new Node(8);
        CSE12NaryTree.Node nodeNine = threeTree.new Node(9);

        nodeFive.addChild(nodeFour);
        nodeFive.addChild(nodeSix);
        nodeFive.addChild(nodeTwo);
        nodeFour.addChild(nodeEight);
        nodeFour.addChild(nodeNine);

        threeTree.root = nodeFive;
        threeTree.size = 6;

    }

    /**
     * Tests add on a 5-ary tree that contains a root and 5 children
     */
    @Test
    public void testAdd(){
        fiveTree.add(10);
        ArrayList<Integer> expected = new ArrayList<>(); 
        expected.add(10);
        assertEquals(7, fiveTree.size);
        CSE12NaryTree.Node four = 
            (CSE12NaryTree.Node) fiveTree.root.getChildren().get(0);
        CSE12NaryTree.Node ten = 
            (CSE12NaryTree.Node)four.getChildren().get(0);
        assertEquals(10, ten.data);
    }

    /**
     * Tests contains on 5-ary tree when element in not present in it
     */
    @Test
    public void testContains(){
        assertFalse( fiveTree.contains(12));
    }

    /**
     * Tests sort tree on 5-ary tree that contains only root node
     */
    @Test
    public void testSortTree(){
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);

        assertEquals(expected, rootTree.sortTree());
    }

    /**
     * Test sort tree on 5-ary tree with root and 5 child
     */
    @Test
    public void testCustom(){
        ArrayList<Integer> expected = new ArrayList<Integer>(
			Arrays.asList(
					new Integer[] {2,4,5,6,8,9}
			)
		);

        assertEquals(expected, fiveTree.sortTree());
    }

    /**
     * This test sort tree on 3-ary three with two levels
     */
    @Test
    public void testCustom2(){
        ArrayList<Integer> expected = new ArrayList<Integer>(
			Arrays.asList(
					new Integer[] {2,4,5,6,8,9}
			)
		);
        assertEquals(expected, threeTree.sortTree());
    }

}
