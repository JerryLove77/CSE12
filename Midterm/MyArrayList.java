import java.util.ArrayList;

/**
 * Name: Jianrui Zhang
 * ID: A16878087
 * Email: Jiz145@ucsd.edu
 * File description: 
 * Several methods and constructor about ArrayList
 * and work for reverse method.
 */

/**
 * Implementation of MyReverseList. Several methods 
 * and constructor about ArrayList and work for reverse method.
 */
public class MyArrayList<E> implements MyReverseList<E> {
    static final int DEFAULT_CAPACITY = 5;
    
    Object[] data;
    int size;

    //IMPORTANT: DO NOT MODIFY THIS CONSTRUCTOR!
    //IMPORTANT: DO NOT ADD ANY MORE CONSTRUCTORS!

    /**
     * Constructor to create an array list with the given array's elements
     * @param arr - array of elements to be used to construct the ArrayList
     */
    public MyArrayList(E[] arr) {
        if (arr == null) {
            this.data = new Object[DEFAULT_CAPACITY];
        } else {
            this.data = arr.clone();
            this.size = arr.length;
        }
    }

    /**
	 * @param fromIndex (reversed region beginning index)
     * @param toIndex (reversed region ending index)
     * rever the region from fromIndex to toIndex of Array
	 */
    public void reverseRegion(int fromIndex, int toIndex){
        if(fromIndex < 0 || toIndex > size){
            throw new IndexOutOfBoundsException();
        }
        if(fromIndex < toIndex){
            for(int i = 0; i <= (toIndex-fromIndex)/2; i++){
                Object temp = data[fromIndex+i];
                data[fromIndex+i] = data[toIndex-i];
                data[toIndex-i] = temp;
            }    
        }

    }

    @Override
    /**
     * A method that returns the number of valid elements
     * in the ArrayList 
     * @return - number of valid elements in the arraylist
     */
    public int size() {
        return this.size;
    }

    @Override
    /**
     * A method that returns an Element at the specified index
     * @param index - the index of the return Element
     * @return Element at specified index
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) data[index];
    }
}
