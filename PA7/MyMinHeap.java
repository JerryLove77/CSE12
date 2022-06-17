/**
 * Name: Jianrui Zhang
 * ID: A16878087
 * Email: Jiz145@ucsd.edu
 * Sources used: None
 * 
 * This file contains MyMinHeap class which implements the 
 * MinHeapInterface based on the data. Also, it extends the 
 * Comparable<E>
 */

// Your import statements
import java.util.ArrayList;
import java.util.Collection;




/**
 * This class implements the MinHeapInterface based on the data, 
 * and extends the Comparable<E>. There are several helper methods
 * and core methods. Those helper methods will be used in core methods
 */
public class MyMinHeap<E extends Comparable<E>> implements MinHeapInterface <E>{
	public ArrayList<E> data;
	
	/**
	 * default constructor 
	 * initializes data to an empty ArrayList
	 */
	public MyMinHeap(){
		this.data = new ArrayList<>();
	}

	/**
	 * Initializes a min-heap using the elements in collection
	 * @param collection (the input collection)
	 */
	public MyMinHeap(Collection<? extends E> collection){
		//check whether the collection is null
		if(collection == null){
			throw new NullPointerException();
		}
		this.data = new ArrayList<>(collection);
		for (int i = this.data.size() - 1; i >= 0; i--){
			// check whether the element in collection is null
			if (this.data.get(i) == null){
				throw new NullPointerException();
			}
			this.percolateDown(i);
		}



	}


//helper methods

    /**
	 * Swap the elements at from and to indices in data
	 * @param from (the index of element will be swapped)
	 * @param to (the index of element will be swapped)
	 */
	protected void swap(int from, int to){
		E temp = this.data.get(from);
		this.data.set(from,this.data.get(to));
		this.data.set(to,temp);
	}

	/**
	 * Calculate and return the parent index of the parameter index
	 * @param index (index of element of which we will find the parent)
	 * @return (the index of parent of the input index)
	 */
	protected int getParentIdx(int index){
		return (index-1)/2;
	}

	/**
	 * Calculate and return the left child index of the parameter index
	 * @param index (index of element of which we will find leftChild)
	 * @return (index of leftChild of the input index)
	 */
	protected int getLeftChildIdx(int index){
		return (2*index+1);
	}

	/**
	 * Calculate and return the right child index of the parameter index
	 * @param index (index of element of which we will find RightChild)
	 * @return (index of RightChild of the input index)
	 */
	protected int getRightChildIdx(int index){
		return (2*index+2);
	}

	/**
	 * Return the index of the smaller child of the element at index
	 * @param index (index of element of which we will find smaller element)
	 * @return (index of SmallerChild of the input index)
	 */
	protected int getMinChildIdx(int index){
		// without any child
		if(getLeftChildIdx(index) >= this.data.size()){
			return -1;
		}
		// without right child
		else if(getRightChildIdx(index) >= this.data.size()){
			return getLeftChildIdx(index);
		}
		
		int result = this.data.get(getLeftChildIdx(index))
		.compareTo(this.data.get(getRightChildIdx(index)));
		if(result > 0){
			return getRightChildIdx(index);
		}
		else {
			return getLeftChildIdx(index);
		}
	}

	/**
	 * Percolate the element at index up 
	 * until no heap properties are violated by this element
	 * @param index (index of element which will be percolate up)
	 */
	protected void percolateUp(int index){
		int parentIdx = this.getParentIdx(index);
		// stop condition 1
		if(index != 0){
			// stop condition 2
			if(this.data.get(index).compareTo
			(this.data.get(parentIdx)) < 0){
				this.swap(index, parentIdx);
				index = parentIdx;
				this.percolateUp(index);
			}
		}
		}
	
	/**
	 * Percolate the element at index down 
	 * until no heap properties are violated by this element
	 * @param index (index of element which will be percolate down)
	 */
	protected void percolateDown(int index){
		int childIdx = this.getMinChildIdx(index);
		// stop condition 1
		if ((this.getMinChildIdx(index) != -1)){
			//stop condition 2
			if (this.data.get(index).compareTo
			(this.data.get(childIdx)) > 0) {
				this.swap(index, childIdx);
				index = childIdx;
				this.percolateDown(index);
			}
		}
		
	}

	/**
	 * Remove the element at index from data and return it
	 * @param index (the index of deleted element)
	 * @return (the deleted element)
	 */
	protected E deleteIndex(int index){
		E temp = this.data.get(index);
		// check whether index is the index of the last element
		if(index == this.data.size()-1){
		}
		if(index != this.data.size()-1){
			this.swap(index, this.data.size()-1);
			this.percolateDown(index);
			this.percolateUp(index);
		}
		this.data.remove(this.data.size()-1);
		return temp;
	}


// core methods

    /**
	 * Add element to the end of the heap 
	 * and percolate only the inserted element up 
	 * until no heap properties are violated
	 * @param element (the element will be inserted)
	 */
	public void insert(E element){
		// check whether the input is valid
		if(element == null){
			throw new NullPointerException();
		}
		else{
			this.data.add(element);
			int idx = this.data.size()-1;
			// check whether the element is less than parent
			if(this.data.get(idx).compareTo
			(this.data.get(getParentIdx(idx))) < 0){
				this.percolateUp(idx);
			}
		}

	}

	/**
	 * Return the root (smallest) element of the heap.
	 * @return the root element
	 */
	public E getMin(){
		// if heap is empty,
		if(this.data.size() == 0){
			return null;
		}
		// sorting the heap
		for (int i = this.data.size() - 1; i >= 0; i--){
			this.percolateDown(i);
		}
		return (E) this.data.get(0);
	}

	/**
	 * Remove and return the root (the smallest) element in the heap
	 * @return the removed element
	 */
	public E remove(){
		// if heap is empty
		if(this.data.size() == 0){
			return null;
		}
		E temp = this.getMin();
		this.deleteIndex(0);
		return (E) temp;
	}

	/**
	 * Return the number of elements in this min-heap.
	 * @return this.data.size()
	 */
	public int size(){
		return this.data.size();
	}

	/**
	 * Clear out the entire heap 
	 */
	public void clear(){
		this.data.clear();
	}
}