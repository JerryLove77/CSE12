/**
 * Name: Jianrui Zhang
 * ID: A16878087
 * Email: Jiz145@ucsd.edu
 * Sources used: None
 * 
 * This file contains CustomTester class which will
 * test the methods. Those test cases are not included 
 * in the PublicTester class
 */

// import statement
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

/**
 * This class is used to test the methods in MyBST class, 
 * MyCalendar class, MyBSTIterator class. Those test cases
 * are not included in the PublicTester class
 */
public class CustomTester {

    MyBST<Integer, String> tree, emptyTree;
    MyBST.MyBSTNode<Integer, Integer> root, two, three, six;

    @Before
    public void BSTsetup(){
        emptyTree = new MyBST<>();
        MyBST.MyBSTNode<Integer, String> root = 
            new MyBST.MyBSTNode<>(4, "four", null);
        MyBST.MyBSTNode<Integer, String> two = 
            new MyBST.MyBSTNode<>(2, "two", root);
        MyBST.MyBSTNode<Integer, String> six = 
            new MyBST.MyBSTNode<>(6, "six", root);
        MyBST.MyBSTNode<Integer, String> three = 
            new MyBST.MyBSTNode<>(3, "three", two);

        this.tree = new MyBST<>();
        this.tree.root = root;
        root.setLeft(two);
        root.setRight(six);
        two.setRight(three);
        this.tree.size = 4;
    }

    /**
     * Test 1 when calling successor() on a non-leaf node
     */
    @Test
    public void successorTest1(){
        MyBST.MyBSTNode<Integer,String> two = tree.root.getLeft();
        assertEquals(two.getRight(), two.successor());
    }

    /**
     * Test 2 when calling successor() to leaf node
     */
    @Test
    public void successorTest2(){
        MyBST.MyBSTNode<Integer,String> three = 
            tree.root.getLeft().getRight();
        assertEquals(tree.root, three.successor());
    }

    /**
     * Test 3 when calling insert() to empty tree
     */
    @Test
    public void inserTest1(){
        emptyTree.insert(2, "two");
        MyBST.MyBSTNode<Integer,String> expected = 
            new MyBST.MyBSTNode<Integer,String>(2, "two", null);


        assertEquals(1, emptyTree.size());
        assertEquals(expected, emptyTree.root);
    }

    /**
     * Test 4 when calling insert() to 
     * tree which has node with key already
     */
    @Test
    public void inserTest2(){
        String expected = "two";
        assertEquals(expected,tree.insert(2, "two"));
        assertEquals(4,tree.size());

    }

    /**
     * Test 5 when calling insert() with null key
     */
    @Test
    public void insertTest3(){
        boolean nullexception = false;
        try{
            this.tree.insert(null, "one");
        }
        catch(NullPointerException e){
            nullexception = true;
        }
        assertTrue(nullexception);

    }

    /**
     * Test 6 when calling search() to empty tree
     */
    @Test
    public void searchTest1(){
        assertEquals(null, emptyTree.search(0));
    }

    /**
     * Test 7 when calling remove() to empty tree
     */
    @Test
    public void removeTest1(){
        assertEquals(null, emptyTree.remove(0));
        assertEquals(0, emptyTree.size());
    }

    /**
     * Test 8 when calling remove() to
     * tree which not include a node with the key
     */
    @Test
    public void removeTest2(){
        assertEquals(null,this.tree.remove(10));
        assertEquals(4, this.tree.size);
    }
    
    /**
     * Test 9 when calling inorder() to empty tree
     */
    @Test
    public void inorderTest1(){
        ArrayList<MyBST.MyBSTNode<Integer, Integer>> expected 
            = new ArrayList<>();
        assertEquals(expected, emptyTree.inorder());
    }

    /**
     * Test 10 when calling book with negative start integer
     */
    @Test
    public void calendarTest1(){
        MyCalendar cal = new MyCalendar();
        boolean illealexception = false;
        try{
            cal.book(-1,1);
        }catch(IllegalArgumentException e){
            illealexception =true;
        }
        assertTrue(illealexception);
    }
}
