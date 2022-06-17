import static org.junit.Assert.*;
import org.junit.*;

import java.util.*;

/**
* TODO: This is the file for self testing
* Name:
* ID:
* Email:
* File description: 
*/

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * TODO: Add class header
 * 
 */

public class AARON {
    CSE12NaryTree<Integer> completeTree2;
    CSE12NaryTree<Integer> duplicatTree2;

    CSE12NaryTree<Integer> completeTree3;
    CSE12NaryTree<Integer> size1Tree3;
    CSE12NaryTree<Integer> nonCompleteTree3;
    CSE12NaryTree<Integer> emptyTree3;

    @Before
    public void setup() {
        // == binary tree--//
        completeTree2 = new CSE12NaryTree<>(2);
        CSE12NaryTree<Integer>.Node ONE = completeTree2.new Node(1);
        CSE12NaryTree<Integer>.Node TWO = completeTree2.new Node(2);
        CSE12NaryTree<Integer>.Node THREE = completeTree2.new Node(3);
        CSE12NaryTree<Integer>.Node Four = completeTree2.new Node(4);
        CSE12NaryTree<Integer>.Node Five = completeTree2.new Node(5);
        CSE12NaryTree<Integer>.Node Six = completeTree2.new Node(6);
        CSE12NaryTree<Integer>.Node SEVEN = completeTree2.new Node(7);

        completeTree2.root = THREE;
        THREE.addChild(TWO);
        THREE.addChild(ONE);
        TWO.addChild(Four);
        TWO.addChild(Five);
        ONE.addChild(Six);
        ONE.addChild(SEVEN);
        completeTree2.size = 7;

        duplicatTree2 = new CSE12NaryTree<>(2);
        CSE12NaryTree<Integer>.Node ONEd1 = duplicatTree2.new Node(1);
        CSE12NaryTree<Integer>.Node ONEd2 = duplicatTree2.new Node(1);
        CSE12NaryTree<Integer>.Node ONEd3 = duplicatTree2.new Node(1);
        CSE12NaryTree<Integer>.Node ONEd4 = duplicatTree2.new Node(1);

        CSE12NaryTree<Integer>.Node TWOd1 = duplicatTree2.new Node(2);
        CSE12NaryTree<Integer>.Node TWOd2 = duplicatTree2.new Node(2);
        CSE12NaryTree<Integer>.Node THREEd = duplicatTree2.new Node(3);
        duplicatTree2.root = THREEd;
        THREEd.addChild(TWOd1);
        THREEd.addChild(TWOd2);
        TWOd1.addChild(ONEd1);
        TWOd1.addChild(ONEd2);
        TWOd2.addChild(ONEd3);
        TWOd2.addChild(ONEd4);
        duplicatTree2.size = 7;

        // == Three-nary tree--//
        completeTree3 = new CSE12NaryTree<>(3);
        CSE12NaryTree<Integer>.Node TONE = completeTree3.new Node(1);
        CSE12NaryTree<Integer>.Node TTWO = completeTree3.new Node(2);
        CSE12NaryTree<Integer>.Node TTHREE = completeTree3.new Node(3);
        CSE12NaryTree<Integer>.Node TFour = completeTree3.new Node(4);
        CSE12NaryTree<Integer>.Node TFive = completeTree3.new Node(5);
        CSE12NaryTree<Integer>.Node TSix = completeTree3.new Node(6);
        CSE12NaryTree<Integer>.Node TSEVEN = completeTree3.new Node(7);
        CSE12NaryTree<Integer>.Node TEIGHT = completeTree3.new Node(8);
        CSE12NaryTree<Integer>.Node TNINE = completeTree3.new Node(9);
        CSE12NaryTree<Integer>.Node TTEN = completeTree3.new Node(10);
        CSE12NaryTree<Integer>.Node TELEVEN = completeTree3.new Node(11);
        CSE12NaryTree<Integer>.Node TTWELF = completeTree3.new Node(12);
        CSE12NaryTree<Integer>.Node TTHIRTEEN = completeTree3.new Node(13);
        completeTree3.root = TEIGHT;
        TEIGHT.addChild(TFive);
        TEIGHT.addChild(TSix);
        TEIGHT.addChild(TNINE);
        TFive.addChild(TTHREE);
        TFive.addChild(TTEN);
        TFive.addChild(TTWELF);
        TSix.addChild(TSEVEN);
        TSix.addChild(TTHIRTEEN);
        TSix.addChild(TELEVEN);
        TNINE.addChild(TFour);
        TNINE.addChild(TTWO);
        TNINE.addChild(TONE);
        completeTree3.size = 13;

        CSE12NaryTree<Integer> size1Tree3 = new CSE12NaryTree<>(3);
        CSE12NaryTree<Integer>.Node ATWO = size1Tree3.new Node(2);
        size1Tree3.root = ATWO;
        size1Tree3.size = 1;

        nonCompleteTree3 = new CSE12NaryTree<>(3);
        CSE12NaryTree<Integer>.Node DTWO = nonCompleteTree3.new Node(2);
        CSE12NaryTree<Integer>.Node DTHREE = nonCompleteTree3.new Node(3);
        CSE12NaryTree<Integer>.Node DFour = nonCompleteTree3.new Node(4);
        CSE12NaryTree<Integer>.Node DFive = nonCompleteTree3.new Node(5);
        CSE12NaryTree<Integer>.Node DSix = nonCompleteTree3.new Node(6);
        CSE12NaryTree<Integer>.Node DSEVEN = nonCompleteTree3.new Node(7);
        CSE12NaryTree<Integer>.Node DEIGHT = nonCompleteTree3.new Node(8);
        CSE12NaryTree<Integer>.Node DNINE = nonCompleteTree3.new Node(9);
        CSE12NaryTree<Integer>.Node DTEN = nonCompleteTree3.new Node(10);
        CSE12NaryTree<Integer>.Node DELEVEN = nonCompleteTree3.new Node(11);
        CSE12NaryTree<Integer>.Node DTWELF = nonCompleteTree3.new Node(12);
        CSE12NaryTree<Integer>.Node DTHIRTEEN = nonCompleteTree3.new Node(13);
        nonCompleteTree3.root = DEIGHT;
        DEIGHT.addChild(DFive);
        DEIGHT.addChild(DSix);
        DEIGHT.addChild(DNINE);
        DFive.addChild(DTHREE);
        DFive.addChild(DTEN);
        DFive.addChild(DTWELF);
        DSix.addChild(DSEVEN);
        DSix.addChild(DTHIRTEEN);
        DSix.addChild(DELEVEN);
        DNINE.addChild(DFour);
        DNINE.addChild(DTWO);
        nonCompleteTree3.size = 12;

        emptyTree3 = new CSE12NaryTree<>(3);
        emptyTree3.size = 0;
    }

    /**
     * Test add method for complete binary tree
     */
    @Test
    public void testaddCB() {
        completeTree2.add(1);
        completeTree2.add(2);
        completeTree2.add(3);
        completeTree2.add(4);
        completeTree2.add(5);
        completeTree2.add(6);
        completeTree2.add(7);
        completeTree2.add(8);
        completeTree2.add(9);

        CSE12NaryTree<Integer>.Node root = completeTree2.root;
        assertSame(1, root.getChildren().get(0).getChildren().get(0).getChildren().get(0).getData());
        assertSame(2, root.getChildren().get(0).getChildren().get(0).getChildren().get(1).getData());
        assertSame(3, root.getChildren().get(0).getChildren().get(1).getChildren().get(0).getData());
        assertSame(4, root.getChildren().get(0).getChildren().get(1).getChildren().get(1).getData());
        assertSame(5, root.getChildren().get(1).getChildren().get(0).getChildren().get(0).getData());
        assertSame(6, root.getChildren().get(1).getChildren().get(0).getChildren().get(1).getData());
        assertSame(7, root.getChildren().get(1).getChildren().get(1).getChildren().get(0).getData());
        assertSame(8, root.getChildren().get(1).getChildren().get(1).getChildren().get(1).getData());
        assertSame(9,
                root.getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getData());
    }

    /**
     * test add for duplicated binary tree
     */
    @Test
    public void testaddDB() {
        duplicatTree2.add(1);
        duplicatTree2.add(2);
        duplicatTree2.add(3);
        duplicatTree2.add(4);
        duplicatTree2.add(5);
        duplicatTree2.add(6);
        duplicatTree2.add(7);
        duplicatTree2.add(8);
        duplicatTree2.add(9);

        CSE12NaryTree<Integer>.Node root = duplicatTree2.root;
        assertSame(1, root.getChildren().get(0).getChildren().get(0).getChildren().get(0).getData());
        assertSame(2, root.getChildren().get(0).getChildren().get(0).getChildren().get(1).getData());
        assertSame(3, root.getChildren().get(0).getChildren().get(1).getChildren().get(0).getData());
        assertSame(4, root.getChildren().get(0).getChildren().get(1).getChildren().get(1).getData());
        assertSame(5, root.getChildren().get(1).getChildren().get(0).getChildren().get(0).getData());
        assertSame(6, root.getChildren().get(1).getChildren().get(0).getChildren().get(1).getData());
        assertSame(7, root.getChildren().get(1).getChildren().get(1).getChildren().get(0).getData());
        assertSame(8, root.getChildren().get(1).getChildren().get(1).getChildren().get(1).getData());
        assertSame(9,
                root.getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getData());
    }

    /**
     * test add for noncomplete 3-nary tree
     */
    @Test
    public void testadd3n() {
        nonCompleteTree3.add(1);
        nonCompleteTree3.add(2);

        CSE12NaryTree<Integer>.Node root = nonCompleteTree3.root;
        assertSame(1, root.getChildren().get(2).getChildren().get(2).getData());
        assertSame(2, root.getChildren().get(0).getChildren().get(0).getChildren().get(0).getData());

    }

    /**
     * Test contian method for binary duplicated
     */
    @Test
    public void testContains() {
        assertTrue(duplicatTree2.contains(1));
        assertFalse(duplicatTree2.contains(4));
        duplicatTree2.add(4);
        assertTrue(duplicatTree2.contains(4));
    }

    /**
     * Test contian method for empty
     */
    @Test
    public void testContains2() {
        emptyTree3.add(4);
        assertTrue(emptyTree3.contains(4));
    }

    /**
     * Test sort for binary duplicated tree
     */
    @Test
    public void testSortTree() {
        ArrayList<Integer> actual = duplicatTree2.sortTree();
        ArrayList<Integer> expected = new ArrayList<>(
                Arrays.asList(new Integer[] { 1, 1, 1, 1, 2, 2, 3 }));

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    /**
     * Test sort for binary complete tree
     */
    @Test
    public void testSortTree2() {
        ArrayList<Integer> actual = completeTree2.sortTree();
        ArrayList<Integer> expected = new ArrayList<>(
                Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7 }));

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

}
