  /**
*@author roosebolton github.com/roosebolton
*An linked list based implentation of a deque. This is basically a doubly linked list implementing the Deque<E> interface.
**/
public class LinkedDeque<E> implements Deque<E>{

/**
*Internal class for Node representation in SinglyLinkedList. Nodes contain object of same generic type E as LinkedDeque type E
**/
private static class Node<E>{
  private E element;
  private Node<E> prev;

  private Node<E> next;
  
  public Node(E element, Node<E> prev,Node<E> next){
    this.element = element;
    this.prev = prev;
    this.next = next;
  }
  
  public E getElement(){return element;}
  public void setPrev(Node<E> prev){this.next = prev;}
  public Node<E> getPrev(){return prev;}
  public void setNext(Node<E> next){this.next = next;}
  public Node<E> getNext(){return next;}
}

//attributes
private Node<E> header;
private Node<E> trailer;
private int size = 0;


//contstructor for empty LinkedDeque
public LinkedDeque(){
  //sentinel Node at front
  header = new Node<E>(null,null,null);
  //sentinel Node at back that in empty LinkedDeque is preceded by the header
  trailer = new Node<E>(null,header,null);
  //the header is followed by the trailer
  header.setNext(trailer);
}

/**
*@return Returns size of the LinkedDeque
**/ 
public int size(){return size;}

/**
*@return Returns true if LinkedDeque is empty, false otherwise
**/
public boolean isEmpty(){return size==0;};

/**
*@return Returns first element E if LinkedDeque is not empty, null otherwise
**/
public E first(){
  if(isEmpty()){return null;}
  else{return 
  //following the header is the first Node<E>
  header.getNext().getElement();}
}

/**
*@return Returns last element E if LinkedDeque is not empty, null otherwise
**/
public E last(){
  if(isEmpty()){return null;}
  else{return 
  //preceding the trailer is the last Node<E>
  trailer.getPrev().getElement();}
}

/**
*Adds a Node<E> between to consecutive nodes
**/
public void addBetween(E element, Node<E> predecessor,Node<E> successor){
  //create and link the new Node
  Node<E> newest = new Node<>(element,predecessor,successor);
  //predecessor gets newest as next Node<E>
  predecessor.setNext(newest);
  //successor gets newest als previous Node<E>
  successor.setPrev(newest);
  //the size of the LinkedDeque has increased by 1
  size++;
}

public E remove(Node<E> node){
  //get the predecessor of the Node<E> to be removed
  Node<E> predecessor = node.getPrev();
  //get the successor of the Node<E> to be removed
  Node<E> successor = node.getNext();
  //set successor as next node predecessor
  predecessor.setNext(successor);
  //set predecessor as next node predecessor
  successor.setPrev(predecessor);
  //the size of the LinkedDeque has decreased by 1
  size--;
  //return the element of the removed Node<E>
  return node.getElement();
}


/**
*Adds element at front of LinkedDeque
**/
public void addFirst(E element){
  //add between header and its next Node<E>
  addBetween(element,header,header.getNext());
}

/**
*Removes and returns element from front of LinkedDeque, returns null if LinkedDeque is empty
@return Returns the element of the removed Node<E>
**/
public E removeFirst(){
  //is the LinkedDeque empty?
  if (isEmpty()){return null;}
  //use remove method for removing and returning Node<E> and element 
  return remove(header.getNext());
}


/**
*Adds element at back of LinkedDeque
**/
public void addLast(E element){
  //add between trailer and its next Node<E>
  addBetween(element, trailer.getPrev(),trailer);
}


/**
*Removes and returns element from back of LinkedDeque, returns null if LinkedDeque is empty
*@return Returns the element of the removed Node<E>
**/
public E removeLast(){
  if(isEmpty()){return null;}
  return remove(trailer.getPrev());
}


}
