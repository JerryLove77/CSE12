/**
 * Name: Jianrui Zhang
 * ID: A16878087
 * Email: Jiz145@ucsd.edu
 * File description: 
 * This file contains CSE12NaryTree<E> class. 
 * It extends Comparable<E>.
 */

// import statement
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * This class contains a inner class which will be used. 
 * This have three methods, two helper methods and a constructor
 * to mimic N-ary tree.
 */
public class CSE12NaryTree<E extends Comparable<E>> {
    
    /**
     * This inner class encapsulates the data and children for a Node.
     * Do NOT edit this inner class.
     */
    protected class Node{
        E data;
        List<Node> children;
    
        /**
         * Initializes the node with the data passed in
         * 
         * @param data The data to initialize the node with
         */
        public Node(E data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    
        /**
         * Getter for data
         * 
         * @return Return a reference to data
         */
        public E getData() {
            return data;
        }

        /**
         * Setter for the data
         * 
         * @param data Data that this node is set to
         */
        public void setData(E data) {
            this.data = data;
        }

        /**
         * Getter for children
         * 
         * @return reference to the list of children
         */
        public List<Node> getChildren() {
            return children;
        }

        /**
         * Returns the number of children
         * 
         * @return number of children
         */
        public int getNumChildren() {
            // assume there are no nulls in list
            return children.size();
        }

        /**
         * Add the given node to this node's list of children
         * 
         * @param node The node to add
         */
        public void addChild(Node node) {
            children.add(node);
        }
    
    }
    
    Node root;
    int size;
    int N;

    /**
     * helper method
     * convert N-ary tree to a arraylist
     * @return (a arraylist stored nodes of tree)
     */
    protected ArrayList<Node> toList(){
        ArrayList<Node> tree = new ArrayList<>(); 
        // empty tree
        if(root == null) {
            return tree;
        }
        Queue<CSE12NaryTree<E>.Node> temp = new LinkedList<>();
        CSE12NaryTree<E>.Node curr = root;
        temp.add(curr);
        while(temp.isEmpty() != true){
            int tempsize = temp.size();
            while(tempsize > 0) {
                Node nodeAdd = temp.remove();
                tree.add(nodeAdd);
                for(int i = 0; i < nodeAdd.getNumChildren(); i++) {
                    System.out.println(nodeAdd.children.get(i).data);
                    temp.add(nodeAdd.children.get(i));
                }
                tempsize--;
            }
        }
        return tree;
    }

    /**
     * helper method
     * get the index of parent node 
     * @param idx (index ofcurrent node)
     * @return (the idex of parent node)
     */
    protected int getParenetidx(int idx){
        return (idx-1)/N;
    }

    
    /**
     * Constructor that initializes an empty N-ary tree, with the given N
     * 
     * @param N The N the N-tree should be initialized with
     */
    public CSE12NaryTree(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException();
        }
        this.root = null;
        this.size = 0;
        this.N = N;
    }

    /**
     * add a node with element to tree
     * @param element (the element will be added)
     */
    public void add(E element) {
        //chekc vaild element
        if(element == null) {
            throw new NullPointerException();
        }
        CSE12NaryTree<E>.Node temp = new Node(element);
        // empty tree
        if(root == null){
            root = temp;
        }
        else{
            ArrayList<Node> NodesList = this.toList();
            // find parent node
            int idx = this.getParenetidx(NodesList.size());
            CSE12NaryTree<E>.Node parent = NodesList.get(idx);
            parent.addChild(temp);
        }
        // increment of size
        size++;
    }

    /**
     * Check if element is in the N-ary tree. 
     * @param element (the element we want to find)
     * @return (whether tree contains node with element)
     */   
    public boolean contains(E element) {
        // check the vaild element
        if(element == null) {
            throw new NullPointerException();
        }
        // convert to arraylist
        ArrayList<Node> nodeList = toList();
        // to find the element
        for(int i = 0; i < nodeList.size(); i++) {
            if(nodeList.get(i).data == element) {
                return true;
            }
        }
        return false;
    }

    /**
     * heap sort on the tree
     * @return (an ArrayList of all elements in the tree in sorted order)
     */
    public ArrayList<E> sortTree(){
        ArrayList<E> sortedList = new ArrayList<>();
        ArrayList<Node> nodeList = this.toList();
        // using Priority Queue to sort the tree
        PriorityQueue<E> priorityQ = new PriorityQueue<E>();
        for(int i = 0; i < nodeList.size(); i++) {
            priorityQ.add(nodeList.get(i).data);
        }
        //copy the element to sortedList
        while(priorityQ.size() > 0) {
            sortedList.add(priorityQ.remove());
        }
        return sortedList;
    }
}
