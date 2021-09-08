/**
*An interface for a implementing a circular queue datastructure, based on Goodrich Tamassia Goldwasser. In a circular queue the first element shifts circularly. Is it usefull for data that is cyclically arranged. Like turns in a game, for instance. Because it's a queue, it extends the Queue interface.
*@author roosebolton github.com/roosebolton
**/
public interface CircularQueue<E> extends Queue<E>{

/**
*Rotates the front element of the queue to the back. Does nothing if the queue is empty
**/
void rotate();


}
