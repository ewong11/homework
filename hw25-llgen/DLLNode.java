/*****************************************************
 * class DLLNode
 * Implements a doubly-linked node,
 * for use in lists and other collection classes.
 * Stores data of type String
 *****************************************************/

public class DLLNode
{
  private Object _cargo;    //cargo may only be of type String
  private DLLNode _nextNode, _prevNode; //pointers to next, prev DLLNodes

    public DLLNode(Object s, DLLNode next, DLLNode prev){
	_cargo = s;
	_nextNode = next;
	_prevNode = prev;
    }

    //accessors

    public Object getCargo() {
	return _cargo;
}

    public DLLNode getNext() {
	return _nextNode;
}

    public DLLNode getPrev() {
	return _prevNode;
}

    //mutators

    public Object setCargo(Object s){
	Object old = _cargo;
	_cargo = s;
	return old;
    }

    public DLLNode setNext(DLLNode next) {
	DLLNode old = _nextNode;
	_nextNode = next;
	return old;
    }

    public DLLNode setPrev(DLLNode prev) {
	DLLNode old = _prevNode;
	_prevNode = prev;
	return old;
    }

    public String toString(){
	return (String)_cargo;
}

}//end class DLLNode
