/**
*@author roosebolton github.com/roosebolton
*A simplified implementation of an ArrayList, that takes O(n) time for adding and removing items and does not dynamically grow. Based on Goodrich Tamassia Goldwasser 
**/
public class SimpleArrayList<E> implements List<E>{
 
  //attributes
  public static final int CAPACITY=1000; 

  //the size of the SimpleArrayList
  private int size = 0;
  //the actual array
  private E[] data;

  //constructors

  /**
  *Standard constructor that uses specialized contstructor to use CAPACITY as size for the SimpleArrayList<E>
  **/
  public SimpleArrayList(){
    this(CAPACITY);
  }
  
  //contstructor that sets array size
  public SimpleArrayList(int capacity){
    data = (E[]) new Object[capacity]; 
  }
  
  //
  /**
  *Returns the number of elements in the list
  *@return Returns the number of elements in the list
  **/
  public int size(){return size;}

  /**
  *Checks if the list is empty
  *@return Returns true if the list is empty, null otherwise
  **/
  public boolean isEmpty(){ return (size==0);}

  /**
  *Does nothing if given index is valid, throws out of bounds exception if otherwise, protected for use within package
  **/
  protected void checkIndex(int index, int length){
    //if the index is smaller then 0 of greater then the given length (of the array), the index is out of bounds
    if(index<0 || index>=length){
      throw new IndexOutOfBoundsException();
    }
  }

  /**
  *Returns but not removes element E at givenm index
  *@return Returns but not removes element E at givenm index
  **/
  public E get(int index) throws IndexOutOfBoundsException{
    // is index in bounds?
    checkIndex(index, size);
    //return element at index
    return data[index];
  }

  /**
  *Replaces the element at the given index with the given element
  *@return Returns and removes the current (replaced) element E at given index
  **/
  public E set(int index, E element) throws IndexOutOfBoundsException{
    //is index in bounds?
    checkIndex(index, size);
    //get element to be replaced
    E temp = data[index];
    //set the new elemen at index
    data[index] = element;
    //return replaced
    return temp;
  }

  /**
  *Inserts the given element at the given index, shifting subsequent elements one position further
  **/
  public void add(int index, E element) throws IndexOutOfBoundsException, IllegalStateException{
    //is index in bounds if size in increased by 1
    checkIndex(index, size+1);
    //if the size is currently equal to the size of the array
    if(size==data.length){
      throw new IllegalStateException("Array is full");
    }
    //for ever index, starting with the last index in the array, do, for every decrement of 1, shift all handled indexes on place further in the array
    for(int i = size-1; i >= index;i--){
      //the element of n is put into index at n+1, thereby shifting one index up
      data[i+1]=data[i];
    }
    //after the shifting took place, on the given index, there is now no element. in that place the given element is put
    data[index]=element;
    //the size of the Queue<E> has increased by 1
    size++;
  }


  /**
  *Returns and removes the element at given index, shifting subsequent elements back one position
  *@return Returns and removes the element at given index
  **/
  public E remove(int index) throws IndexOutOfBoundsException{
    checkIndex(index, size);
    //the element to Return
    E temp = data[index];
    //for ever index, starting at the given index, do, for every increment of 1, shift all handled indexes on place back in the array
    for(int i=index;i<size-1;i++){
      //the element of n is put into index at n-1, thereby shifting one index down
      data[i]=data[i+1];
    }
    //empty at last index so there is no useles data in memory (for garbage collection)
    data[size-1] = null;
    //return removed
    return temp;

  }
 //////////////////private ArrayIterator class/////////////////

//private iterator class, for iterating over iterable representation of the ArrayList
private class ArrayIterator implements Iterator<E>{
  private int j=0; //index of the next element to report
  //status to use for safely removing an element
  private boolean removable = false;
  
  /*
  *Shows if ther is a next element in the collection, has acces to size because the ArrayIterator class is not static and can therefor check there is a next element to be iterated over. Must be implemented due to Iterator interface.
   *@return Returns true if there is a next element to iterate over in the collection, false otherwise
  **/
  public boolean hasNext(){return (j < size);}
 
  /**
  *Returns the next element in the collection to iterate over
  *@return Returns the next element in the collection to iterate over. Must be implemented due to Iterator interface.
  *throws Throws NoSuchElementException
  */
  public E next()throws NoSuchElementException{
    //is there a next element?
    if(j==size){
      throw new NoSuchElementException("No next element");
    }
    //set next element as removable from collection
    removable = true;
    //return the next element and increment j for future call to next() with j++. Has acces to data because ArrayIterator is not a static private class
    return data[j++];
  }

  /**
  *Removes the current element at iterator "cursor" position
  *@throws Throws an IllegalStateException if element may not be removed or has not yet been "called" by iterator
  **/
  public void remove()throws IllegalStateException{
    //is there an element to remove?
    if (!removable){
      throw new IllegalStateException("Nothing to remove");
    }
    //the last returned increment is the item to remove and can be found at position j-1
    ArrayList.this.remove(j-1);
    //as a result to removing, the current next element has shifted one index to the left at j-1
    j--;
    //do not leave the status of removable true, should be handled per element
    removable = false;
  }
}


}
