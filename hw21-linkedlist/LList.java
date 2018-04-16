//Eric Wong and Jason Kim
//APCS2 pd08
//HW23 - Give and Take
//2018-03-22
/*****************************************************
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 *****************************************************/

public class LList implements List //your List interface must be in same dir
{

    //instance vars
    private LLNode _head;
    private int _size;

    // constructor -- initializes instance vars
    public LList( )
    {
	_head = null; //at birth, a list has no elements
	_size = 0;
    }


    //--------------v  List interface methods  v--------------

    public boolean add( String newVal ) //adds newVal to the beginning of the list
    {
	LLNode tmp = new LLNode( newVal, _head ); //the new head is the node contaning String newVal
	_head = tmp;
	_size++; //increase size
	return true;
    }

    public void add(int index, String newVal) { //adds newVal at a specified index
	if ( index < 0 || index > size()+1 ) //checking
	    throw new IndexOutOfBoundsException();

	if(index == 0){ //if the index is 0, simply use the other add method
	    add(newVal);
	    return;
	}
	LLNode newNode = new LLNode(newVal, null); //initialize the new node
	LLNode temp = _head; //alias to head 
	for (int i = 0; i < index-1; i++) { //for loop to get into the proper position
	    temp = temp.getNext(); //sets the position
	}
	newNode.setNext(temp.getNext()); //make the newNode point to the node at index n+1
	temp.setNext(newNode); //set a node to point to newNode
	_size++; //increase size
    }

    public String remove(int index) {
	if(index == 0){ //simpler process
	    String ret0 = _head.getCargo();
	    _head = _head.getNext();
	    _size--;
	    return ret0;
	}
	LLNode temp = _head; //alias to head
	for (int i = 0; i < index-1; i++) { //for loop to get into the proper position
	    temp = temp.getNext(); //sets the position
	}
	String ret = temp.getNext().getCargo(); //get the return string
	temp.setNext(temp.getNext().getNext()); //set the pointer
	_size--; //decrease the size
	return ret;
    }


    public String get( int index )
    {
	if ( index < 0 || index >= size() ) //check
	    throw new IndexOutOfBoundsException();

	String retVal;
	LLNode tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//check target node's cargo hold
	retVal = tmp.getCargo();
	return retVal;
    }


    public String set( int index, String newVal )
    {

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	LLNode tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//store target node's cargo
	String oldVal = tmp.getCargo();

	//modify target node's cargo
	tmp.setCargo( newVal );

	return oldVal;
    }


    //return number of nodes in list
    public int size() { return _size; }

    //--------------^  List interface methods  ^--------------


    // override inherited toString
    public String toString()
    {
	String retStr = "HEAD->";
	LLNode tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
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

	james.add( 3, "got" );
	System.out.println("added 'got' to index 3" );
	System.out.println( james );

	james.remove(0);
	System.out.println("removed index at 0");
	System.out.println(james);

	james.remove(2);
	System.out.println("removed index at 2");
	System.out.println(james);
    }

}//end class LList
