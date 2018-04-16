//Eric Wong
//APCS2 p8
//HW24 --On the DLL
//2018-03-26
/*****************************************************
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 * new in v2: add-at-index, remove
 *****************************************************/

public class LList implements List //your List interface must be in same dir
{

  //instance vars
  private DLLNode _head;
  private DLLNode _tail;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = null; //at birth, a list has no elements
    _tail = null;
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    DLLNode tmp = new DLLNode( newVal, _head, null );
    if(_size == 0) {
    //_tail = tmp;
    _head = tmp;
    _tail = tmp;
  }
  else if(_size == 1) {
    //sets the prevNode of tail to head (instead of null)
    _tail.setPrev(_head);
    _head = tmp;
    //_tail.setNext(_head.getNext());
  }
  else {
    _head = tmp;
  }
    _size++;
    return true;
}

  public boolean addEnd(String newVal)
  {
    DLLNode tmp = new DLLNode(newVal, _tail, _head);
    _tail = tmp;
    _size++;
    return true;
  }


  public String get( int index )
  {
    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    String retVal;
    DLLNode tmp = _head; //create alias to head
    DLLNode tmpL = _tail;

    //walk to desired node
    for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();
      //tmpL = _tail.getPrev();

    //check target node's cargo hold
    retVal = tmp.getCargo();
    return retVal;
  }


  public String set( int index, String newVal )
  {
    String oldVal;
    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    DLLNode tmp = _head; //create alias to head
    DLLNode tmpl = _tail;
    //walk to desired node
    if(index <= _size/2) {
    for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();
    oldVal = tmp.getCargo();
    tmp.setCargo( newVal );
    }

    else{
      //System.out.println("tail: " + _tail);
      //System.out.println("tailprev: " + _tail.getPrev().getCargo());
      //DLLNode tmp = _tail; //create alias to tail
      //walk to desired node
      for( int i= _size-1; i > index; i-- )
        tmpl = tmpl.getPrev();
      oldVal = tmpl.getCargo();
      tmpl.setCargo(newVal);
    }
    //store target node's cargo
    //String oldVal = tmp.getCargo();

    //modify target node's cargo
    //tmp.setCargo( newVal );

    return oldVal;
  }


  //return number of nodes in list
  public int size() { return _size; }


  //insert a node containing newVal at position index
  public void add( int index, String newVal ) {

    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    DLLNode newNode = new DLLNode( newVal, null,null );

    //if index==0, insert node before head node
    if ( index == 0 ) {
	    add( newVal );

    }
    else if(index == _size -1) {
      addEnd(newVal);
    }

    else {
	    DLLNode tmp = _head; //create alias to head
      DLLNode tmpl = _tail;

	    //walk to node before desired node
	    for( int i=0; i < index-1; i++ ) {
        tmp = tmp.getNext();
        tmpl = tmpl.getPrev();
      }

	    //insert new node
      tmp.setNext( newNode );
      tmpl.setPrev(newNode);
	    newNode.setNext(tmpl);
      newNode.setPrev(tmp);

	    //increment size attribute
	    _size++;
    }
  }


  //remove node at pos index, return its cargo
  public String remove( int index ) {

    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    String retVal;
    DLLNode tmp = _head; //create alias to head
    DLLNode tmpl = _tail; //alias to head

    //if index==0, remove head node
    if ( index == 0 ) {
	    //check target node's cargo hold
	    retVal = _head.getCargo();
	    //remove target node
	    _head = _head.getNext();
    }
    else if (index == _size-1){
      retVal = _tail.getCargo();
      _tail = _tail.getPrev();
    }
    else if(index < _size/2){
	    //walk to node before desired node
	    for( int i=0; i < index-1; i++ )
        tmp = tmp.getNext();
	    //check target node's cargo hold
	    retVal = tmp.getNext().getCargo();
	    //remove target node
	    tmp.setNext( tmp.getNext().getNext() );
    }
    else {
      for(int i = _size-1;i > index; i--) {
        tmpl = tmpl.getPrev();
      }
      //gets value of node to bo removed
      retVal = tmpl.getPrev().getCargo();
      tmpl.setPrev(tmpl.getPrev().getPrev());
    }

    //decrement size attribute
    _size--;

    return retVal;
  }

  //--------------^  List interface methods  ^--------------


  // override inherited toString
  public String toString()
  {
    String retStr = "HEAD->";
    DLLNode tmp = _head; //init tr
    DLLNode tmpl = _tail;
    while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
    }
    retStr += "TAIL";
    return retStr;
  }


  //main method for testing
  public static void main( String[] args )
  {

    LList james = new LList();

    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("beat");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("a");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("need");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("I");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    System.out.println( "2nd item is: " + james.get(1) );

    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );
    System.out.println( james );

    james.add(0,"whut");
    System.out.println( "...after add(0,whut): " );
    System.out.println( james );

    james.add(4,"phat");
    System.out.println( "...after add(4,phat): " );
    System.out.println( james );

    System.out.println( "...after remove last: "
                        + james.remove( james._size-1) );
    System.out.println( james );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james );

  }

}//end class LList
