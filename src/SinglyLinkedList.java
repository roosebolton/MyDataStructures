/**
*@author roosebolton github.com/roosebolton
*A SinglyLinkedList implementation, based on Goodrich Tamassia Goldwasser
**/
class SinglyLinkedList<E>{

  /**
  *Internal class for Node representation in Linked List. Nodes contain object of same generic type E as SinglyLinkedList type E
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
  private Node<E> head = null;
  private Node<E> tail = null;
  private int size = 0;

  /**
  *Default constructor
  **/
  public SinglyLinkedList(){   
  }
  

  /**
  *@return Returns size of the SinglyLinkedList
  **/
  public int size(){return size;}

  /**
  *@return Returns true if SinglyLinkedList is empty, false otherwise
  **/
  public boolean isEmpty(){ return size==0;
  }

  /**
  *@return Returns last element E of SinglyLinkedList is not empty, null otherwise
  **/
  public E last(){
    if(isEmpty()){return null;}
    else{return tail.getElement();}
  }

  /**
  *Adds element at front of SinglyLinkedList
  **/
  public void addFirst(E e){
    //First belongs at head anyway
    head = new Node<>(e,head);
    //is the SinglyLinkedList empty?
    if(isEmpty()){
      //the tail is also the head
      tail = head;
    }
    //the size of the SinglyLinkedList has increased by 1
    size++;
  }

  /**
  *Adds element at end of SinglyLinkedList
  **/
  public void addLast(E e){
      //The newest Node<E> can be instantiated
      Node<E> newest = new Node<>(e,null); 
      //is the SinglyLinkedList emtpy
      if(isEmpty()){
        //the head Node will also be the new last Node, because the SinglyLinkedList is empty. !The next parameter of newest is still null as there is no next Node<E> for the last node.
        head = newest;
      }
      else{
        //current tail gets a next Node and is no longer the actual tail
        tail.setNext(newest);
      }
      //set newest Node<E> as actual tail
      tail = newest;
      
      size++;
  }
    
    /**
    *Removes the first Node from the SinglyLinkedList
    *@return Returns first element E of SinglyLinkedList is not empty, null otherwise, 
    **/
    public E removeFirst(){
      //if the SinglyLinkedList is emtpy, return null
      if(isEmpty()){
        return null;
      }
      //the element E to return is the element of the head Node<E> that can be fetched with the Node<E> getElement() method
      E answer = head.getElement();
      //already set the new head, which is the next Node from the current head
      head = head.getNext();
      //the size of the SinglyLinkedList has decreased by 1
      size--;
      //if the SinglyLinkedList is now empty, the tail should be set to null, as there is no more tail object
      if(isEmpty()){tail=null;}
      //finally return answer
      return answer; 
    }
}
