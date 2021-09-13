/**
*@author roosebolton github.com/roosebolton
*An interface for a Position. A Position acts like a marker in a List. So while the element or index of the Node to which the position belongs might change, the Position stays the same. If you know the position, you can reach it in O(n)
**/
public interface Position<E>{
  /**
  *Returns the element stored at this position.
  *@return Returns the element stored at this position.
  *@throws IllegalStateException if position is no longer valid(not a position)
  **/
  E getElement()throws IllegalStateException; 
}
