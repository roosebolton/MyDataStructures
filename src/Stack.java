/**
*An interface for a implementing a Stack datastructure, based on Goodrich Tamassia Goldwasser. A stack pushes and pops elements from a collection, comparable with taking plates from- or putting them on top of a stack of plates.
*@author roosebolton github.com/roosebolton
**/
public interface Stack<E>{

/**
*Returns the size of the Stack<E>
*@return Returns the size of the Stack<E>
**/
int size();

/**
*Tests if Stack<E> is empty
*@return Returns true if Stack<E> if empty, null otherwise
**/
boolean int size();

/**
*Pushes an element E onto the Stack<E>
**/
void push(E e);

/**
*Returns but not removes the top element E from the Stack
*@return Returns but not removes the top element E from the Stack
**/
E top();

/**
*Returns and removes the top element E from the Stack
*@return Returns and removes the top element E from the Stack
**/
E pop();

}
