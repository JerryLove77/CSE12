/**
 * Name: Jianrui Zhang
 * ID: A16878087
 * Email: Jiz145@ucsd.edu
 * Sources used: None
 * 
 * Implments the methods in MyList.java. 
 * Provide several constructors to declare MyArrayList
 */

 /**
  * several constructors to declare MyArraylist.
  * two instance variale array data, and int size.
  * several methods to modify data and size.
  */


  public class MyArrayList <E> implements MyList<E>{
    // instance variables

    //The underlying data structure of the ArrayList
    Object[] data;
    //the number of valid elements in your data array
    int size;
    final private static int DEFAULT_CAPACITY = 5;
    final private static int FACTOR = 2;


    /** Default constructor
     * Set the Object array to array with default capacity
     * Set the size to 0
     */
    public MyArrayList(){
        this.data = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }
    
    /**constructor with size argument
     * Set the Object array to array with initial capacity
     * @param initialCapacity (the initial capacity)
     */
    public MyArrayList(int initialCapacity){

        // check whether initial capacity is valid
        if(initialCapacity < 0){
            throw new IllegalArgumentException();
        }

        // Initialize the Object array with the length of initialCapacity
        this.data = new Object[initialCapacity];
    }

    /**constructor with list argument
     * shallow copy the input array to the instance variables
     * @param arr (input array)
     */
    public MyArrayList (E[] arr){
        // check whether arr is null
        if(arr == null){
            this.data = new Object[DEFAULT_CAPACITY];
            this.size = 0;
        }
        else{
            //Initialize the instance variables with the input array

            //capacity equal to the length of arr.
            this.data = new Object[arr.length];

            //size equals to length of arr
            this.size = arr.length;

            //shallow copy of arr to data
            for(int i = 0; i < arr.length; i++){
                this.data[i] = arr[i];
            }
        }

    }

    /** expand the data length to the required length
     * @param requiredCapacity (the length of data need to be)
     */
    public void expandCapacity(int requiredCapacity){
        int currentCapa = this.data.length;

        //check requiredCapacity is valid
        if(requiredCapacity < currentCapa){
            throw new IllegalArgumentException();


        }

        // double current capacity if it is greater than 0
        if(currentCapa > 0){
            currentCapa = FACTOR * currentCapa;
        }

        // set current capacity if it equals to 0
        if(currentCapa == 0){
            currentCapa = DEFAULT_CAPACITY;
        }

        //If the capacity is still not enough, 
        //then set the capacity to requiredCapacity.
        if(currentCapa < requiredCapacity){
            currentCapa = requiredCapacity;
        }

        //creating copy array temp
        Object[] temp = new Object[this.data.length];
        for(int i = 0; i < this.data.length; i++){
            temp[i] = this.data[i];
        }

        //shallow copy the array temp to data
        this.data = new Object[currentCapa];
        for(int i = 0; i < temp.length; i++){
                this.data[i] = temp[i];    
        }
       

    }

    /** @return the length of data*/
    public int getCapacity(){
        return data.length;
    }

    /**insert element at specific array in the index of index
     * @param index (the index of inserted element)
     * @param element (the inserted element)
     */
    public void insert(int index, E element){
        //check whether the index is valid
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        //expand the capacity
        if(size == getCapacity()){
            expandCapacity(data.length);
        }
        // set the element to the array data at the index
        for(int i = size-1;i>=0;i--){
            if(i>=index){
                Object temp = data[i];
                data[i+1] = temp;
            }
        }
        data[index] = element;
        //increment of size
        size++;
        }
        
    /** set the element at the end of the array
     * @param element (the appended input)
     */
    public void append(E element){

        //expand the capacity
        if(size == getCapacity()){
            expandCapacity(getCapacity()+1);
        }

        // append the element to the end of array
        this.data[this.size] = element;

        // increment of size
        size++;
    }

    /** set the element to the beginning of the array
     * @param element (the prepended input)
     */
    public void prepend(E element){ 

        //expand the capacity
        if(size == getCapacity()){
            expandCapacity(getCapacity()+1);
        }

        // shallow copy of data and move all element in data backforward.
        for(int i = size; i > 0; i--){
            this.data[i] =this.data[i-1];
        }

        // prepend the element to the beginning of array
        this.data[0] = element;

        // increment of size
        size++;
    }

    /**@return the value in the array at the index
     * @param index (the index of value to get)
     */
    public E get(int index){
        // check the index is valid
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        // return the getter value
        return (E) data[index];
    }

    /**@return the overwritten value in the array at the index
     * @param index (the index of value to set)
     * @param element (the element to set in)
     */
    public E set(int index, E element){
        // check the index is valid
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        //copy the return value of set
        Object temp = new Object();
        temp = this.data[index];

        //set the element to the array in the index 
        this.data[index] = element;

        //return the overwritten value
        return (E) temp;
    }

    /** @return the removed value in the array at the index
     * @param index (the index of the value to be removed)
     */
    public E remove(int index){
        // check the index is valid
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        //copy the value that will be removed
        Object temp = this.data[index];

        //creating a copy array copy which contain value of non-removed
        Object[] copy = new Object[size-1];
        for(int i = 0; i < size; i++){
            if(i < index){
                copy[i] = this.data[i];
            }
            else if(i > index){
                copy[i-1] = this.data[i];
            }
        }

        //declare the data and shallow copy the array copy to the data
        this.data = new Object[getCapacity()];
        for(int j = 0; j < copy.length; j++){
            this.data[j] = copy[j];
        }

        //decrement of size
        size--;

        // return removed value
        return (E) temp;
    }

    /** @return the size
     */
    public int size(){
        return size;
    }
}

 // Hint: the 'capacity' (length of data array) is not the same as the 'size'
 // Size is the number of elements in the ArrayList, i.e., the number of valid
 // elements in the array