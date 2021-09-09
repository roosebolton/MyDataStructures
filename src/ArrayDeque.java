/**
*@author roosebolton github.com/roosebolton
*An array based implentation of a deque, using a circularly aproach for the array. A deque datastructure like a queue, in which elements can be removed from both ends.
**/
public class ArrayDeque<E> implements Deque<E>{

//attributes

//constant of 1000 to be used as standard array size
private static final int CAPACITY = 1000;
//the array containing the objects of type E
private E[] data;  
//the index of the initial first element in the
private int f = 0;
//the size of the ArrayQueue<E>
private int size = 0;

//constructors

/**
*Standard constructor that initializes an array of size CAPACITY for object of type E, by using a constructor that can also initialize with other array sizes
**/
public ArrayDeque(){this(CAPACITY);}
/**
*Constructor that initializes the data array of a custom size as an Object[] array, but with a save cast as E[]. Is also used by standard constructor.
**/
public ArrayDeque(int capacity){
  data = (E[]) new Object[capacity];
}

//methods

/**
*Returns the number of element in the ArrayDeque<E>
*@return Returns the number of element in the ArrayDeque<E>
**/
public int size(){return size;}

/**
*Tests wether the ArrayDeque<E> is empty
*@return Returns true if the ArrayDeque<E> is emtpy, false otherwise
**/
public boolean isEmpty(){return(size==0);}


/**
*Returns the first element of the Deque<E>
*@return Returns but not removes the the first element of the Deque<E>, returns null if Deque<E> is empty
**/
public E first(){
  //is the Deque<E> empty?
  if(isEmpty()){return null;}
  //return element at index f
  return data[f];
}

/**
*Inserts an element at the front of the Deque<E>
**/
public void addFirst(E element)throws IllegalStateException{
  //is the Deque full?
  if(data.length==size){
    throw new IllegalStateException("Deque is full");
  }
  //calculate new first index
  f=(f-1+data.length)%data.length;
  //put new element at first index
  data[f]=element;
  //size has increased by 1
  size++;
}

/**
*Returns and removes the first element of the Deque<E>
*@return Returns and removes the the first element of the Deque<E>, returns null if Deque<E> is empty
**/
public E removeFirst(){
  //is the Queue<E> empty?
  if(isEmpty()) return null;
  //collect the element to return, found at index f
  E answer = data[f];
  //set null on index of first element f
  data[f] = null;
  //adjust index f of first element with modulo arithmetic
  f=(f+1) % data.length;
  //the size of the Queue<E> has decreased by 1
  size--;
  //return the prior first element 
  return answer;
}

/**
*Returns the last element of the Deque<E>
*@return Returns but not removes the the last element of the Deque<E>, returns null if Deque<E> is empty
**/
public E last(){
  //is the Queue<E> empty?
  if(isEmpty()){return null;}
  //return last element
  return data[(f+size)%data.length];
}

/**
*Inserts an element at the rear of the Deque<E>
**/
public void addLast(E element)throws IllegalStateException{
//is the queue full?
  if(size==data.length){throw new     IllegalStateException("Deque is full");}
  //use modulo arithmetic to calculate new last position, this could for example lead to a later element being put on a lower index than the index of the first element, if the queue at some point had reached the last index and another element was added while the queue was nog full
  int avail = (f+size)%data.length; //avail is index for new element
  //add new element to Queue<E> at index avail
  data[avail] = element;
  //the size of the Queue<E> has increased by 1
  size++;
}

/**
*Returns and removes the last element of the Deque<E>
*@return Returns and removes the the last element of the Deque<E>, returns null if Deque<E> is empty
**/
public E removeLast(){
  //is Deque<E> empty
  if(isEmpty()){
  return null;
}
  //calculate last position
  int last = (f+size)%data.length;
  //get last element
  E answer = data[last];
  //nullify last position
  data[last]=null;
  //decrement size
  size--;
  //return answer
  return answer;
}



}
