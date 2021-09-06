/**
*@author roosebolton github.com/roosebolton
*An array based implementation of the Stack interface, based on Goodrich Tamassia Goldwasser
**/
public class ArrayStack<E> implements Stack<E>{

//attributes

//constant of 1000 to be used as standard array size
public static final int CAPACITY=1000;

//the actual, not yet initialized array for objects of type E
private E[] data; 

//In een empty Stack with an array implementation, the index of the first element E is not even 0, for 0 would be the index of the first element. Therefore we start with index -1 for the emtpy stack, on which we can test.
private int t = -1; 

/**
*Standard constructor that initializes an array of size CAPACITY for object of type E, by using the another constructor that can also initialize with other array sized
**/
public ArrayStack(){this(CAPACITY);}

/**
*Constructor that initializes the data array of a custom size as an Object[] array, but with a save cast as E[]. Is also used by standard constructor.
**/
public ArrayStack(int capacity){data = (E[]) new Object[capacity];}

/**
*Returns the size of the Stack<E>
*@return Returns the size of the Stack<E>
**/
public int size(){return (t+1);}

/**
*Tests if Stack<E> is empty
*@return Returns true if Stack<E> if empty, null otherwise
**/
public boolean isEmpty(){return (t==-1);}

/**
*Pushes an element E onto the Stack<E>
**/
public void push(E e) throws IllegalStateException{
  //has the Stack reached its maximum capacity?
  if(size()==data.length){throw new IllegalStateException("Full Stack");}
  //the array at the next position from index t is filled with Element e
  data[++t]=e;
};

/**
*Returns but not removes the top element E from the Stack
*@return Returns but not removes the top element E from the Stack, or returns null if the Stack<E> is empty
**/
public E top(){
  //is the Stack empty?
  if(isEmpty()){return null;}
  //return element at index t, currently at top of Stack<E>
  return data[t];
};

/**
*Returns and removes the top element E from the Stack
*@return Returns and removes the top element E from the Stack, or returns null if the Stack<E> is empty
**/
public E pop(){
  //is the Stack<E> empty?
  if(isEmpty()){return null;}
  //the element to return
  E answer = data[t];
  //set current top element from Stack<E> to null
  data[t] = null;
  //the size of the Stack<E>, t, has decreased by 1
  t--;
  return answer;
}

}
