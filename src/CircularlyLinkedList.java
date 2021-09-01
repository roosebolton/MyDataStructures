/**
*@author roosebolton github.com/roosebolton
*A CircularlyLinkedList implementation, based on Goodrich Tamassia Goldwasser
**/
class CircularlyLinkedList<E> {

/**
*Internal class for Node representation in CircularlyLinkedList. Nodes contain object of same generic type E as CircularlyLinkedList type E
**/
private static class Node<E>{
  private E element;
  private Node<E> next;
  
  public Node(E element, Node<E> next){
    this.element = element;
    this.next = next;
  }
  
  public E getElement(){
    return element;
  }
  public void setNext(Node<E> next){
    this.next = next;
  }
  public Node<E> getNext(){
    return next; 
  }
}

//attributes
//because the list is circular, only the last node is needed as attribute
private Node<E> tail;
private int size = 0;

/**
*Default constructor
**/
public CircularlyLinkedList(){

}

/**
*@return Returns size of the CircularlyLinkedList
**/ 
public int size(){return size();}

/**
*@return Returns true if CircularlyLinkedList is empty, false otherwise
**/
public boolean isEmpty(){ return size==0;}

/**
*@return Returns first element E if CircularlyLinkedList is not empty, null otherwise
**/
public E first(){
  if(isEmpty()){return null;}
  else{return tail.getNext().getElement();}
}

/**
*@return Returns last element E if CircularlyLinkedList is not empty, null otherwise
**/
public E last(){
  if(isEmpty()){return null;}
  else{return tail.getElement();}
}

/**
*Rotates the first element to the back of the CircularlyLinkedList
**/
public void rotate(){
  //lCircularlyLinkedListist should not be empty
  if(tail!=null){
    //first item becomes new tail
    tail=tail.getNext();
  }
}

/**
*Adds Node<E> at front of CircularlyLinkedListist
**/
public void addFirst(E element){
  //is CircularlyLinkedListist empty?
  if(isEmpty()){
    //the tail is also the only Node<E> and has no next 
    tail=new Node<>(element,null);
    //because the tail has no next, the tail is its own next
    tail.setNext(tail);
  }
  else{
    //the next element of the current tail, wil be the next element of the new Node
    Node<E> newest = new Node<>(element,tail.getNext());
    //the tail now has a new next 
    tail.setNext(newest);
  }
  //the size of the CircularlyLinkedListist has increased by 1
  size++;
} 

/**
 *Adds element at end of CircularlyLinkedListist
 **/
 public void addLast(E e){
   //new element becomes first element
   addFirst(e);
   //by shifting the tail to this new element it becomes the last element
   tail = tail.getNext();
 }

/**
*Removes the first Node CircularlyLinkedListist
*@return Returns first element E of CircularlyLinkedListist is not empty,null otherwise,
**/
 public E removeFirst(E e){
   if(isEmpty()){return null;}
   //the the next element from the tail, is the first/head element
   Node<E> head = tail.getNext();
   //does the CircularlyLinkedListist consist of 1 element?
   if(head==tail){
     //the tail must now be set to null, since there is only one element
     tail=null;
   } 
   else{
     //the next first/head element will be the element after the current head element, which now needs to become the tails next element. 
     tail.setNext(head.getNext());
     //The former firs/head element is now not refered to. 
   }
  //the size of theCircularlyLinkedListist has decreasedby 1
   size--;
   //return the removed element
   return head.getElement();
 }
 
}
