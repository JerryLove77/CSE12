/**
 * Name: Jianrui Zhang
 * ID: A16878087
 * Email: Jiz145@ucsd.edu
 * Sources used: zyBook chapter 7
 * 
 * This file contains MyBST<K,V> class which K extends
 * Comparable<K>. In MyBST<K,V>, there is a static class
 * MyBSTNode<K,V>, which will help to write the method 
 * in MyBST<K,V>
 
 */

// import statement
import java.util.ArrayList;

/**
 * This class 5 methods. In this class, there is a static class 
 * MyBSTNode<K,V>, which will help to write the method 
 * in MyBST<K,V>. Those five methods will access and manipulate
 * the local variables
 */
public class MyBST<K extends Comparable<K>,V>{
    MyBSTNode<K,V> root = null;
    int size = 0;


    protected boolean contains(MyBSTNode root, K value){
        if(root == null){
            return false;
        }
        if(root.key == value){
            return true;
        }
        return contains(root.getLeft(),value) ||
        contains(root.getRight(),value);
    }
    public int size(){
        return size;
    }

    /**
     * Insert a new node containing 
     * the arguments key and value into BST
     * @param key (key of node to insert)
     * @param value (value of node to insert)
     * @return (If a node with key already exists, 
     * return the original value . Otherwise, null )
     */
    public V insert(K key, V value){
        if(key == null){
            throw new NullPointerException();
        }

        MyBST.MyBSTNode<K, V> curr = this.root;
        if(contains(curr,key)){
            while(curr.predecessor() != null){
                curr = curr.predecessor();
            }

            if(root.key == key){
                V temp = root.value;
                root.value = value;
                return temp;
            }
            else{
                while(curr.key != key){
                    curr = curr.predecessor();
                }
                V temp = curr.value;
                curr.value = value;
                return temp;
            }
        }
        else{
            if(root == null){
                root = new MyBSTNode<K,V>(key,value,null);
                size++;
                return null;
            }
            else{
                while(curr != null){
                    if(key.compareTo(curr.key) < 0){
                        if(curr.getLeft() == null){
                            curr.left = new MyBSTNode<K,V>(key,value,curr);
                            curr =null;
                            size++;
                        }
                        else{
                            curr = curr.getLeft();
                        }
                    }
                    else{
                        if(curr.getRight() == null){
                            curr.right = new MyBSTNode<K,V>(key, value,curr);
                            curr = null;
                            size++;
                        }
                        else{
                            curr = curr.getRight();
                        }
                    }
                }
            }
            return null;
        }
    }

    /**
     * Search for a node with key equal to key
     * @param key (key to find )
     * @return (the value of node with the key, 
     * if no such node,null)
     */
    public V search(K key){
        MyBSTNode<K, V> curr = this.root;
        if (key == null) {
            return null;
        }
        while(curr != null) {
            if(key == curr.key) {
                return curr.value;
            }
            // go right side
            else if(key.compareTo(curr.getKey()) > 0){
                 curr = curr.getRight();
            }
            //go left side
            else if(key.compareTo(curr.getKey()) < 0){
                curr = curr.getLeft();
           }
        }
        return null;
    }

    /**
     * Search and remove a node with key equal to key 
     * @param key (key to find and remove)
     * @return (the value of removed node,
     * if no such node,null)
     */
    public V remove(K key){

        MyBSTNode<K,V> par = null;
        MyBSTNode<K,V> curr = root;
        V removed = null;
        while(curr != null) {
            // find node
            if(key == curr.key) {
                removed = curr.value;
                // leaf node with no children
                if(curr.getLeft() == null && 
                curr.getRight() == null) {
                    if(par == null) {
                        root = null;
                    }
                    else if(par.getLeft() == curr) {
                        par.setLeft(null);;
                    }
                    else{
                        par.setRight(null);
                    }
                    size--;
                }
                // leaf node only with left children
                else if(curr.getRight() == null) {
                    if(par == null) {
                        root = curr.getLeft();
                    }
                    else if(par.getLeft() == curr) {
                        par.setLeft(curr.getLeft());
                    }
                    else {
                        par.setRight(curr.getLeft());
                    }
                    size--;
                }
                //leaf node only with right children
                else if(curr.getLeft() == null) {
                    if(par == null) {
                        root = curr.getRight();
                    }
                    else if(par.getLeft() == curr) {
                        par.setLeft(curr.getRight());
                    }
                    else {
                        par.setRight(curr.getRight());
                    }
                    size--;
                }
                // with 2 children
                else{
                    MyBSTNode<K,V> suc = curr.getRight();
                    while(suc.getLeft() != null) {
                        suc = suc.getLeft();
                    }
                    V successorData = suc.value;
                    remove(suc.key);
                    curr.value = successorData;
                }
                return removed;
            }
            // search right side
            else if(curr.key.compareTo(key) < 0) {
                par = curr;
                curr = curr.getRight();
            }
            // search left side
            else{
                par = curr;
                curr = curr.getLeft();
            }
        }
        return removed;
    }
    
    /**
     * Do an in-order traversal of the tree, 
     * adding each node to the end of an ArrayList
     * @return (the ArrayList of sorted elements in MyBST)
     */
    public ArrayList<MyBSTNode<K, V>> inorder(){
        ArrayList<MyBSTNode<K, V>> result = new ArrayList<MyBSTNode<K, V>>();
        MyBSTNode<K,V> curr = this.root;
        // if BST is empty
        if (this.size == 0){
            return result;
        }
        while(curr.getLeft() != null) {
            curr = curr.getLeft();
        }
        while(curr != null) {
            result.add(curr);
            curr = curr.successor();
        }
        return result;
    }

    static class MyBSTNode<K,V>{
        private static final String TEMPLATE = "Key: %s, Value: %s";
        private static final String NULL_STR = "null";

        private K key;
        private V value;
        private MyBSTNode<K,V> parent;
        private MyBSTNode<K,V> left = null;
        private MyBSTNode<K,V> right = null;

        /**
         * Creates a MyBSTNode<K,V> storing specified data
         * @param key the key the MyBSTNode<K,V> will
         * @param value the data the MyBSTNode<K,V> will store
         * @param parent the parent of this node
         */
        public MyBSTNode(K key, V value, MyBSTNode<K, V> parent){
            this.key = key;
            this.value = value;
            this.parent = parent; 
        }

        /**
         * Return the key stored in the the MyBSTNode<K,V>
         * @return the key stored in the MyBSTNode<K,V>
         */
        public K getKey(){
            return key;
        }

        /**
         * Return data stored in the MyBSTNode<K,V>
         * @return the data stored in the MyBSTNode<K,V>
         */
        public V getValue(){
            return value;
        }

        /**
         * Return the parent
         * @return the parent
         */
        public MyBSTNode<K,V> getParent(){
            return parent;
        }

        /**
         * Return the left child 
         * @return left child
         */
        public MyBSTNode<K,V> getLeft(){
            return left;
        }

        /**
         * Return the right child 
         * @return right child
         */
        public MyBSTNode<K,V> getRight(){
            return right;
        }

        /**
         * Set the key stored in the MyBSTNode<K,V>
         * @param newKey the key to be stored
         */
        public void setKey(K newKey){
            this.key = newKey;
        }

        /**
         * Set the data stored in the MyBSTNode<K,V>
         * @param newValue the data to be stored
         */
        public void setValue(V newValue){
            this.value = newValue;
        }

        /**
         * Set the parent
         * @param newParent the parent
         */
        public void setParent(MyBSTNode<K,V> newParent){
            this.parent = newParent;
        }

        /**
         * Set the left child
         * @param newLeft the new left child
         */
        public void setLeft(MyBSTNode<K,V> newLeft){
            this.left = newLeft;
        }

        /**
         * Set the right child
         * @param newRight the new right child
         */
        public void setRight(MyBSTNode<K,V> newRight){
            this.right = newRight;
        }

        /**
         * TODO: add inline comments for this method to demonstrate your
         *   understanding of this method. The predecessor can be implemented
         *   in a similar way.
         *
         * This method returns the in order successor of current node object.
         * It can be served as a helper method when implementing inorder().
         * @return the successor of current node object
         */
        public MyBSTNode<K, V> successor(){
            //if there is right child
            if(this.getRight() != null){
                MyBSTNode<K,V> curr = this.getRight();
                while(curr.getLeft() != null){
                    curr = curr.getLeft();
                }
                return curr;
            }
            else{
                MyBSTNode<K,V> parent = this.getParent();
                MyBSTNode<K,V> curr = this;
                //while this is not root and this is right child
                while(parent != null && curr == parent.getRight()){
                    curr = parent;
                    parent = parent.getParent();
                }
                return parent;
            }
        }

        /**
         * find a node with greatest key 
         * that is still smaller than the key of the current node
         * @return(the node with the greatest key 
         * that is still smaller than the key of the current node.
         * If there is no smaller key, return null.)
         */
        public MyBSTNode<K, V> predecessor(){
            if(this.getLeft() != null) {
                MyBSTNode<K,V> curr = this.getLeft();
                while(curr.getRight() != null){
                    curr = curr.getRight();
                }
                return curr;
            }
            else {
                MyBSTNode<K,V> parent = this.getParent();
                MyBSTNode<K,V> curr = this;
                while(parent != null && curr == parent.getLeft()) {
                    curr = parent;
                    parent = parent.getParent();
                }
                return parent;
            }
        }

        /** This method compares if two node objects are equal.
         * @param obj The target object that the currect object compares to.
         * @return Boolean value indicates if two node objects are equal
         */
        public boolean equals(Object obj){
            if (!(obj instanceof MyBSTNode))
                return false;

            MyBSTNode<K,V> comp = (MyBSTNode<K,V>)obj;
            
            return( (this.getKey() == null ? comp.getKey() == null : 
                this.getKey().equals(comp.getKey())) 
                && (this.getValue() == null ? comp.getValue() == null : 
                this.getValue().equals(comp.getValue())));
        }

        /**
         * This method gives a string representation of node object.
         * @return "Key:Value" that represents the node object
         */
        public String toString(){
            return String.format(
                    TEMPLATE,
                    this.getKey() == null ? NULL_STR : this.getKey(),
                    this.getValue() == null ? NULL_STR : this.getValue());
        }
    }

}