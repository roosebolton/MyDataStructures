/**
*@author roosebolton github.com/roosebolton
*An array based implementation of the Queue interface, based on Goodrich Tamassia Goldwasser. Using a modulo operator for rotating, because the first element keeps shifting to the end of the Queue<E> over time.
**/
public class ArrayQueue<E> implements Queue<E>{

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
public ArrayQueue(){this(CAPACITY);}
/**
*Constructor that initializes the data array of a custom size as an Object[] array, but with a save cast as E[]. Is also used by standard constructor.
**/
public ArrayQueue(int capacity){
  data = (E[]) new Object[capacity];
}

//methods

/**
*Returns the number of queue elements
*@return Returns the number of elements in the Queue<E>
**/
public int size(){return size;}

/**
*Tests wether the Queue<E> is empty
*@return Returns true if the Queue<E> is emtpy, false otherwise
**/
public boolean isEmpty(){return(size==0);}

/**
*Inserts element at the rear of the Queue<E>
**/
public void enqueue(E element)throws IllegalStateException{
//is the queue full?
  if(size==data.length){throw new     IllegalStateException("Stack is full");}
  //use modulo arithmetic to calculate new last position, this could for example lead to a later element being put on a lower index than the index of the first element, if the queue at some point had reached the last index and another element was added while the queue was nog full
  int avail = (f+size)%data.length; //avail is index for new element
  //add new element to Queue<E> at index avail
  data[avail] = element;
  //the size of the Queue<E> has increased by 1
  size++;
}

/**
*Returns the first element of the Queue<E>
*@return Returns but not removes the the first element of the Queue<E>, returns null if Queue<E> is empty
**/
public E first(){
  //is the Queue<E> empty?
  if(isEmpty()){return null;}
  //return element at index f
  return data[f];
}

/**
*Returns ande removes the first element of the Queue<E>
*@return Returns and removes the the first element of the Queue<E>, returns null if Queue<E> is empty
**/
public E dequeue(){
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



}
