/**
*@author roosebolton github.com/roosebolton
*An interface for a positional list. A positional list is a collection of positions. Via the position, its element can be accesed. 
**/
public interface PositionalList<E>{
/**
*Returns the size of the PostionalList<E>
*@return Returns the size of the PostionalList<E>
**/
int size();

/**
*Tests if PostionalList<E> is empty
*Returns true if PostionalList<E> is empty, false otherwise
**/
boolean isEmpty();

/**
*Returns the first position of the PostionalList<E> 
*@return Returns the first position of the PostionalList<E>, null if empty
**/
Position<E> first();

/**
*Returns the last position of the PostionalList<E> 
*@return Returns the last position of the PostionalList<E>, null if empty
**/
Position<E> last();

/**
*Returns the position before given position, or null if given position is the first position
*@return Returns the position before given position, or null if given position is the first 
*@throws IllegalArgumentException if given position is not valid
**/
Position<E> before(Position<E> position)throws IllegalArgumentException;

/**
*Returns the position after given position, or null if given position is the last position
*@return Returns the position after given position, or null if given position is the last position
*@throws IllegalArgumentException if given position is not valid
**/
Position<E> after(Position<E> position)throws IllegalArgumentException;

/**
*Inserts given element at front of PostionalList<E> and returns the new Position
@return Returns the new position after inserting its given element
**/
Position<E> addFirst(E element);

/**
*Inserts given element at end of PostionalList<E> and returns the new Position
@return Returns the new position after inserting its given element
**/
Position<E> addLast(E element);

/**
*Insert given element before the given position and returns its new position
@return Returns the new position after inserting its given element before the given position
*@throws IllegalArgumentException
**/
Position<E> addBefore(Position<E> position, E element)throws IllegalArgumentException;

/**
*Insert given element after the given position and returns its new position
@return Returns the new position after inserting its given element after the given position
*@throws IllegalArgumentException
**/
Position<E> addAfter(Position<E> position, E element)throws IllegalArgumentException;

/**
*Replaces the element stored at the given Position end returns the replaced element. 
*@return Returns the replaced element 
*@throws IllegalArgumentException
**/
E set(Position<E> position, E element)throws IllegalArgumentException;

/**
*Removes the element stored at the given Position<E> end returns the removed element, also invalidates the Position<E>. 
*@return Returns the replaced element 
*@throws IllegalArgumentException
**/
E remove(Position<E> position)throws IllegalArgumentException;

}
