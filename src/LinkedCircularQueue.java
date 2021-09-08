/**
*@author roosebolton github.com/roosebolton
*A CircularlyLinkedList implementation of a Queue, based on Goodrich Tamassia Goldwasser. It is usefull for data that is cyclically arranged. Like turns in a game, for instance.
**/
public class LinkedCircularQueue<E> implements CircularQueue<E>{

//attributes

//the actual LinkedCircularQueue for the 
private CircularlyLinkedList<E> list = new CircularlyLinkedList<>();

//a standard contstructor is enough

/**
*Returns the number of queue elements
*@return Returns the number of elements in the Queue<E>
**/
public int size(){return list.size();}

/**
*Tests wether the Queue<E> is empty
*@return Returns true if the Queue<E> is emtpy, false otherwise
**/
public boolean isEmpty(){return list.isEmpty();}

/**
*Inserts element at the rear of the Queue<E>
**/
public void enqueue(E element){ list.addLast(element);}

/**
*Returns the first element of the Queue<E>
*@return Returns but not removes the the first element of the Queue<E>, returns null if Queue<E> is empty
**/
public E first(){ return list.first();}

/**
*Returns and removes the first element of the Queue<E>
*@return Returns and removes the the first element of the Queue<E>, returns null if Queue<E> is empty
**/
public E dequeue(){return list.removeFirst();}

/**
*Rotates the front element of the queue to the back. Does nothing if the queue is empty
**/
public void rotate(){list.rotate();}

}
