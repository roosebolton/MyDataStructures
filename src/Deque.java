/**
*@author roosebolton github.com/roosebolton
*An interface for a Dequeue, a datastructure like a queue, in which elements can be removed from both ends.
**/
public interface Deque<E>{

/**
*Returns the number of element in the Deque<E>
*@return Returns the number of element in the Deque<E>
**/
int size();

/**
*Tests wether the Deque<E> is empty
*@return Returns true if the Deque<E> is emtpy, false otherwise
**/
boolean isEmpty();

/**
*Returns the first element of the Deque<E>
*@return Returns but not removes the the first element of the Deque<E>, returns null if Deque<E> is empty
**/
E first();

/**
*Returns the last element of the Deque<E>
*@return Returns but not removes the the last element of the Deque<E>, returns null if Deque<E> is empty
**/
E last();

/**
*Inserts an element at the front of the Deque<E>
**/
addFirst();

/**
*Inserts an element at the rear of the Deque<E>
**/
addLast();

/**
*Returns and removes the first element of the Deque<E>
*@return Returns and removes the the first element of the Deque<E>, returns null if Deque<E> is empty
**/
E removeFirst();

/**
*Returns and removes the last element of the Deque<E>
*@return Returns and removes the the last element of the Deque<E>, returns null if Deque<E> is empty
**/
E removeLast();


}
