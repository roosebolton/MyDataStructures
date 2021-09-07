/**
*@author roosebolton github.com/roosebolton
*A LinkedList based implementation of the Stack interface, based on Goodrich Tamassia Goldwasser, using the Adapter pattern
**/
public class LinkedStack<E> implements Stack<E>{

//attributes

//The actual SinglyLinkedList<E> to be used for the Stack<E>
private SinglyLinkedList<E> list = new SinglyLinkedList<>();

//Standard constructor will do.

/**
*Returns the size of the Stack<E>, using the adapter pattern
*@return Returns the size of the Stack<E>
**/
public int size(){ return list.size();};

/**
*Tests if Stack<E> is empty, using the adapter pattern
*@return Returns true if Stack<E> if empty, null otherwise
**/
public boolean isEmpty(){return list.isEmpty();};

/**
*Pushes an element E onto the Stack<E>, using the adapter pattern
**/
public void push(E element){list.addFirst(element);};

/**
*Returns but not removes the top element E from the Stack, using the adapter pattern
*@return Returns but not removes the top element E from the Stack
**/
public E top(){return list.first();}

/**
*Returns and removes the top element E from the Stack, using the adapter pattern
*@return Returns and removes the top element E from the Stack
**/
public E pop(){return list.removeFirst();};

}
