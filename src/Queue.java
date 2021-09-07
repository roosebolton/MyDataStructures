/**
*An interface for a implementing a queue datastructure, based on Goodrich Tamassia Goldwasser. In a queue the first element added is also the first element to be removed, like an English bus stop queue. A queue works First in, first out: FIFO.
*@author roosebolton github.com/roosebolton
**/
public interface Queue<E>{

/**
*Returns the number of queue elements
*@return Returns the number of elements in the Queue<E>
**/
int size();

/**
*Tests wether the Queue<E> is empty
*@return Returns true if the Queue<E> is emtpy, false otherwise
**/
boolean isEmpty();

/**
*Inserts element at the rear of the Queue<E>
**/
void Enqueue();

/**
*Returns the first element of the Queue<E>
*@return Returns but not removes the the first element of the Queue<E>, returns null if Queue<E> is empty
**/
E first();

/**
*Returns ande removes the first element of the Queue<E>
*@return Returns and removes the the first element of the Queue<E>, returns null if Queue<E> is empty
**/
E dequeue();

}
