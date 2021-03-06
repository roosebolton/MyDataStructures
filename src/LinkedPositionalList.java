/import java.util.Iterator;
import java.util.NoSuchElementException;

/**
*@author roosebolton github.com/roosebolton
*A linked positional list is a collection of linked positions that contain the stored elements. 
**/
public class LinkedPositionalList<E> implements PositionalList<E>{

/**
*Internal class for Position representation. Nodes implement the Position interface. Because the class is static and private, the containing LinkedPositionalList class can offer an interface for Positions only, in stead of Nodes. 
**/
private static class Node<E> implements Position<E>{
  private E element;
  private Node<E> prev;
  private Node<E> next;
  
  public Node(E element, Node<E> prev,Node<E> next){
    this.element = element;
    this.prev = prev;
    this.next = next;
  }
  
  /**
  *This is the only method of the Position interface
  *@return Returns the element E of the Node
  *@throws IllegalStateException thrown if Node is no longer relevant/valid
  **/
  public E getElement() throws IllegalStateException
  {
    //if the Nodes next attribute refers to null, it is no longer a relevant/valid node
    if(next==null){
      throw new IllegalStateException("Position no longer valid");
    }  
    return element;
  }

  public void setElement(E element){
    this.element = element;
  }

  public void setPrev(Node<E> prev){this.next = prev;}

  public Node<E> getPrev(){return prev;}

  public void setNext(Node<E> next){this.next = next;}

  public Node<E> getNext(){return next;}
}


//attributes
private Node<E> header;
private Node<E> trailer;
private int size = 0;

/**
*Constructor that sets the header and trailer nodes
**/
public LinkedPositionalList(){
  //header with no element, previous or next attribute set
  header = new Node<>(null,null,null);
  //header with no element, the header as previous node and no next set as null
  trailer = new Node<>(null,header,null);
  //the header in an empty LinkedPositionalList is followed by the trailer
  header.setNext(trailer);
}

//private helper methods
/**
*Checks if a given Position, is an actualy an instance of a Node<E>. If so, it returns the Node<E>. 
*@return Returns the Node<E> if the Position is a instance of a Node<E>
*@throws Throws IllegalArgumentException if given Position<E> is not an instance of a Node<E>
**/
private Node<E> validate(Position<E> position)throws IllegalArgumentException{
  if(!(position instanceof Node)){
    throw new IllegalArgumentException("Invalid position");
  }
  //let a new Node<E> instance refer to the given position
  Node<E> node = (Node<E>) position; //safe cast
  //is the Node still relevant/valid?
  if(node.getNext()==null){
    throw new IllegalArgumentException("Position is no longer valid");
  }
  return node;
}

/**
*Returns the given node as a Position
*@return Returns the given node as a Position, of null if header or trailer
**/
private Position<E> position(Node<E> node){
  //check if the given Node is a header or trailer node
  if(node==header||node==trailer){
    return null;
  }
  return node;
}


/**
*Adds a given position between two given nodes
*@return Returns position added between two nodes
**/
private Position<E> addBetween(E element, Node<E> prev, Node<E> next){
  //make a new Node<E> with the prev Node<E> as predecessor and the next Node<E> as successor
  Node<E> newest = new Node<E>(element, prev,next);
  //set new Node<E> as successor of prev node
  prev.setNext(newest);
  //set new Node<E> as predecessor of next node
  next.setPrev(newest);
  //the size of the LinkedPositionalList<E> has increased by 1 
  size++;
  //return the added Node<E>
  return newest;
}

/**
*Returns the size of the LinkedPositionalList<E>
*@return Returns the size of the LinkedPositionalList<E>
**/
public int size(){ return size;}

/**
*Tests if LinkedPositionalList<E> is empty
*Returns true if LinkedPositionalList<E> is empty, false otherwise
**/
public boolean isEmpty(){return size==0;}

/**
*Returns the first position of the LinkedPositionalList<E> 
*@return Returns the first position of the LinkedPositionalList<E>, null if empty
**/
public Position<E> first(){return position(header.getNext());}

/**
*Returns the last position of the LinkedPositionalList<E> 
*@return Returns the last position of the LinkedPositionalList<E>, null if empty
**/
public Position<E> last(){ return position(trailer.getPrev());}


/**
*Returns the position before given position, or null if given position is the first position
*@return Returns the position before given position, or null if given position is the first 
*@throws IllegalArgumentException if given position is not valid
**/
public Position<E> before(Position<E> position)throws IllegalArgumentException{
  //instantiate new node if valid, throw excetpion otherwise
  Node<E> node = validate(position);
  return position(node.getPrev());
}

/**
*Returns the position after given position, or null if given position is the last position
*@return Returns the position after given position, or null if given position is the last position
*@throws IllegalArgumentException if given position is not valid
**/
public Position<E> after(Position<E> position)throws IllegalArgumentException{
  //instantiate new node if valid, throw excetpion otherwise
  Node<E> node = validate(position);
  return position(node.getNext());
}


/**
*Inserts given element at front of PostionalList<E> and returns the new Position
@return Returns the new position after inserting its given element
**/
public Position<E> addFirst(E element){
  return addBetween(element, header, header.getNext());
}

/**
*Inserts given element at end of PostionalList<E> and returns the new Position
@return Returns the new position after inserting its given element
**/
public Position<E> addLast(E element){ 
  return addBetween(element, trailer.getPrev(), trailer);
}

/**
*Insert given element before the given position and returns its new position
@return Returns the new position after inserting its given element before the given position
*@throws IllegalArgumentException
**/
public Position<E> addBefore(Position<E> position, E element)throws IllegalArgumentException{
  //instantiate new Node<E> if valid, throw exception otherwise
  Node<E> node = validate(position);
  //return node added bewteen given node and its predecessor
  return addBetween(element, node.getPrev(),node);
}

/**
*Insert given element after the given position and returns its new position
@return Returns the new position after inserting its given element after the given position
*@throws IllegalArgumentException
**/
public Position<E> addAfter(Position<E> position, E element)throws IllegalArgumentException{
  //instantiate new Node<E> if valid, throw exception otherwise
  Node<E> node = validate(position);
  //return node added bewteen given node and its successor 
  return addBetween(element, node,node.getNext());
}

/**
*Replaces the element stored at the given Position end returns the replaced element. 
*@return Returns the replaced element 
*@throws IllegalArgumentException
**/
public E set(Position<E> position, E element)throws IllegalArgumentException{
  //instantiate new Node<E> if valid, throw exception otherwise
  Node<E> node = validate(position);
  //get Element to return
  E answer = node.getElement();
  //set new given Element at given Position (Node<E>)
  node.setElement(element);
  //return the replaced element
  return answer;
}

/**
*Removes the element stored at the given Position<E> end returns the removed element, also invalidates the Position<E>. 
*@return Returns the replaced element 
*@throws IllegalArgumentException
**/
public E remove(Position<E> position)throws IllegalArgumentException{
  //instantiate new Node<E> if valid, throw exception otherwise
  Node<E> node = validate(position);
  //get the predecessor of the Node<E>
  Node<E> predecessor = node.getPrev();
  //get the successor of the Node<E>
  Node<E> successor = node.getNext();
  //link predecessor and successor
  predecessor.setNext(successor);
  //link successor and predecessor
  successor.setPrev(predecessor);
  //the size of the LinkedPositionalList<E> has decreased by 1 
  size--;
  //get answer to return
  E answer = node.getElement();
  //nullfy element of node to remove
  node.setElement(null);
  //nullfy next attribute of node to remove
  node.setNext(null);
  //nullfy prev attribute of node to remove
  node.setPrev(null);
  //node is now defunct
  //return removed Element
  return answer;

}


// support for iterating either positions and elements
  //---------------- nested PositionIterator class ----------------
  /**
   * A (nonstatic) inner class. Note well that each instance
   * contains an implicit reference to the containing list,
   * allowing us to call the list's methods directly.
   */
  private class PositionIterator implements Iterator<Position<E>> {

    /** A Position of the containing list, initialized to the first position. */
    private Position<E> cursor = first();   // position of the next element to report
    /** A Position of the most recent element reported (if any). */
    private Position<E> recent = null;       // position of last reported element

    /**
     * Tests whether the iterator has a next object.
     * @return true if there are further objects, false otherwise
     */
    public boolean hasNext() { return (cursor != null);  }

    /**
     * Returns the next position in the iterator.
     *
     * @return next position
     * @throws NoSuchElementException if there are no further elements
     */
    public Position<E> next() throws NoSuchElementException {
      if (cursor == null) throw new NoSuchElementException("nothing left");
      recent = cursor;           // element at this position might later be removed
      cursor = after(cursor);
      return recent;
    }

    /**
     * Removes the element returned by most recent call to next.
     * @throws IllegalStateException if next has not yet been called
     * @throws IllegalStateException if remove was already called since recent next
     */
    public void remove() throws IllegalStateException {
      if (recent == null) throw new IllegalStateException("nothing to remove");
      LinkedPositionalList.this.remove(recent);         // remove from outer list
      recent = null;               // do not allow remove again until next is called
    }
  } //------------ end of nested PositionIterator class ------------

  //---------------- nested PositionIterable class ----------------
  private class PositionIterable implements Iterable<Position<E>> {
    public Iterator<Position<E>> iterator() { return new PositionIterator(); }
  } //------------ end of nested PositionIterable class ------------

  /**
   * Returns an iterable representation of the list's positions.
   * @return iterable representation of the list's positions
   */
  @Override
  public Iterable<Position<E>> positions() {
    return new PositionIterable();       // create a new instance of the inner class
  }

  //---------------- nested ElementIterator class ----------------
  /* This class adapts the iteration produced by positions() to return elements. */
  private class ElementIterator implements Iterator<E> {
    Iterator<Position<E>> posIterator = new PositionIterator();
    public boolean hasNext() { return posIterator.hasNext(); }
    public E next() { return posIterator.next().getElement(); } // return element!
    public void remove() { posIterator.remove(); }
  }

  /**
   * Returns an iterator of the elements stored in the list.
   * @return iterator of the list's elements
   */
  @Override
  public Iterator<E> iterator() { return new ElementIterator(); }

public String toString(){
  //start String with ()
  StringBuilder sb = new StringBuilder("(");
  //get the first element in the list
  Node<E> walk = header.getNext();
  //is the list empty?
  while(walk!=trailer){
    //append the element
    sb.append(walk.getElement());
      //get the next element
      walk = walk.getNext();
      //if it is not the last element
      if(walk != trailer){
        //append a ,
        sb.append(", ");
      }
  }
  //if trailer is reached, append a )
  sb.append(")");
  //return the final string
  return sb.toString();
}  

}
