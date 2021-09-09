/**
*@author roosebolton github.com/roosebolton
*An interface for a List. In a list deletions and insertions can also take place at other positions than those of the first or last index
**/
public interface List<E>{

  /**
  *Returns the number of elements in the list
  *@return Returns the number of elements in the list
  **/
  int size();

  /**
  *Checks if the list is empty
  *@return Returns true if the list is empty, null otherwise
  **/
  boolean isEmpty();

  /**
  *Returns but not removes element E at givenm index
  *@return Returns but not removes element E at givenm index
  **/
  E get(int index) throws IndexOutOfBoundsException;

  /**
  *Replaces the element at the given index with the given element
  *@return Returns and removes the current (replaced) element E at given index
  **/
  E set(int index, E element) throws IndexOutOfBoundsException;

  /**
  *Inserts the given element at the given index, shifting subsequent elements one position further
  **/
  void add(int index, E element) throws IndexOutOfBoundsException;


  /**
  *Returns and removes the element at given index, shifting subsequent elements back one position
  *@return Returns and removes the element at given index
  **/
  E remove(int index) throws IndexOutOfBoundsException;
}
