/**
*@author roosebolton github.com/roosebolton
*A simplified implementation of an ArrayList, that takes O(n) time for adding and removing items and does not dynamically grow. So no suboptimal in many ways compared to the Java util ArrayList 
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
  private boolean isEmpty(){ return (size==0);}

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


}
