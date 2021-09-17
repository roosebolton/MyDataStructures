import java.util.Iterator;

/**
*An interface for a Tree where nodes can have an arbitrary amount of children
**/
public interface Tree<E> extends Iterable<E>{

/**
*Returns the position of the Trees Root Element/Node
*@return Returns the position of the Trees Root Element/Node
**/
Position<E> root();

/**
*Returns the position of the parent of the given position. In a Tree, a Node had at most 1 parent.
*@return Returns the position of the parent of the given position.
*@throws Throws an IllegalArgumentException if Position is not valid
**/
Position<E> parent(Position<E> position) throws IllegalArgumentException;

/**
*Returns an iterable collection of the positions of children of a given position
*@return Returns an iterable collection of the children of a given position
*@throws Throws an IllegalArgumentException if Position is not valid
**/
Iterable<Position<E>> children(Position<E>position) throws IllegalArgumentException;

/**
*Returns the number of childeren of a given Position
*@return Returns the number of childeren of a given Position
*@throws Throws an IllegalArgumentException if Position is not valid
**/
int numChildren(Position<E> position)throws IllegalArgumentException;


/**
*Returns true if Node at given position is an internal Node
*@return Returns true if Node at given position is an internal Node, false otherwise
*@throws Throws an IllegalArgumentException if Position is not valid
**/
boolean isInternal(Position<E> position)throws IllegalArgumentException;

/**
*Returns true if Node at given position is an external Node
*@return Returns true if Node at given position is an external Node, false otherwise
*@throws Throws an IllegalArgumentException if Position is not valid
**/
boolean isExternal(Position<E> position)throws IllegalArgumentException;

/**
*Returns true if Node at given position is the root Node
*@return Returns true if Node at given position is the root Node, false otherwise
*@throws Throws an IllegalArgumentException if Position is not valid
**/
boolean isRoot(Position<E> position)throws IllegalArgumentException;


/**
*Returns the number of elements in the Tree
*@return Returns the number of elements in the Tree
**/
int size();

/**
Checks if the Tree is empty
*@return Returns true if the Tree is empty, null otherwise
**/
boolean isEmpty();

/**
*Returns an iterator for all elements in the tree, so that the tree itself is Iterable 
*@return Returns an iterator for all elements in the tree
**/
Iterator<E> iterator();

/**
*Returns an iterable collection of all positions of the Tree 
*@return Returns an iterable collection of all positions of the Tree
**/
Iterable<Position<E>> positions();


}
