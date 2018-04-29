//Team Barcode -- Eric Wong, Sean Roudnitsky
//APCS2 pd8
//HW36 -- Now Let’s Consider You Lot at Fake Terry’s
//2018-04-28

/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 ******************************************************/


public class RQueue<T> implements Queue<T>
{
  //instance variables
  private LLNode<T> _front, _end;
  private int _size;


  // default constructor creates an empty queue
  public RQueue()
	{
    _front = _end = null;

	}//end default constructor


  public void enqueue( T enQVal )
  {
    LLNode<T> tmp = new LLNode(enQVal, _front);
    if (_size == 0) {
      _front = new LLNode(enQVal, _end); //assigns a value to front
      _size++;
      //_end = _front;
    }
    else if (_size == 1) {
      _end = tmp; //assigns a value to end, which was previously null
      _front.setNext(_end);
      _size++;
    }
    else {
      _end.setNext(tmp); //adds values to the end
      _end = _end.getNext(); //reassigns end
      _size++;
    }
  }//end enqueue()


  // remove and return thing at front of queue
  // assume _queue ! empty
  public T dequeue()
  {
    T retVal;
    LLNode<T> first = _front; //assigns a pointer that stays at front
    sample(); //shuffles to create a new 'front'
    if (_size == 1) { //if size is one, returns whatever is at front (last element)
      retVal =  _front.getValue();
      _front = null; //removes value at front
      return retVal;
    }
/*
    if (_front.getValue() == first.getValue()) { //if, after shuffle, front still points at front
      retVal = _front.getValue(); //return what front points to, rather than what comes next
      _front = first = _front.getNext(); //setsfront and first to next node
    }
    */

    else {

    retVal = _front.getNext().getValue(); //removes what is at front
    _front.setNext((_front.getNext().getNext())); //removes node
    //_front = _front.getNext(); //lol i forgot this -- sets front to what is next
  }
    //_front = first; //front goes back to front of queue
    _size--;

    return retVal;
  }//end dequeue()


  public T peekFront()
  {
    return _front.getValue();//.getNext();
  }
  /******************************************
   * void sample() -- a means of "shuffling" the queue
   * Algo: 1. use Math.random() to generate a random int
   *       2. use a for loop to iterate thru the queue until reach said index
   *       3. set the new node as your new '_front'
   *
   ******************************************/
  public void sample ()
  {
    LLNode<T> temp = _front;
    int rand = (int) (Math.random()*_size-1);
    //System.out.println("sample: " + rand);
    for (int i = 0; i < rand; i++) {
      //if (_size == 1) {
        //temp = _front;
      //}
      //else {
      temp = temp.getNext();
    //}
  }
  _front = temp;
  }//end sample()


  public boolean isEmpty()
  {
    return (_size == 0);
  } //O(1)


    // print each node, separated by spaces
  public String toString()
  {
    String retStr = "";
    LLNode<T> temp = _front;
    for (int i = 0; i < _size; i++) {
      //System.out.println(temp.getValue());
      retStr += temp.getValue() + " ";
      temp = temp.getNext();
    }
    return retStr;

  }//end toString()



  //main method for testing
  public static void main( String[] args )
  {


      RQueue<String> PirateQueue = new RQueue<String>();

      System.out.println("\nnow enqueuing...");
      PirateQueue.enqueue("Dread");
      PirateQueue.enqueue("Pirate");
      PirateQueue.enqueue("Robert");
      PirateQueue.enqueue("Blackbeard");
      PirateQueue.enqueue("Peter");
      PirateQueue.enqueue("Stuyvesant");

      System.out.println("\nnow testing toString()...");
      System.out.println( PirateQueue ); //for testing toString()...
      System.out.println("\nnow dequeuing...");
/*
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      /*
      //System.out.println(PirateQueue.peekFront());
      //PirateQueue.sample();
      //System.out.println(PirateQueue.peekFront());
      //System.out.println( PirateQueue.dequeue() );
      //PirateQueue.dequeue();

      System.out.println(PirateQueue);
      PirateQueue.dequeue();
      System.out.println(PirateQueue);
      PirateQueue.dequeue();
      System.out.println(PirateQueue);
      PirateQueue.dequeue();
      System.out.println(PirateQueue);
      PirateQueue.dequeue();
      System.out.println(PirateQueue);
      PirateQueue.dequeue();
      System.out.println(PirateQueue);
      PirateQueue.dequeue();

*/
      System.out.println( PirateQueue.dequeue() );
      System.out.println("front: " + PirateQueue.peekFront());
      System.out.println(PirateQueue);
      System.out.println( PirateQueue.dequeue() );
      System.out.println("front : " + PirateQueue.peekFront());
      System.out.println(PirateQueue);
      System.out.println( PirateQueue.dequeue() );
      System.out.println(PirateQueue);
      System.out.println( PirateQueue.dequeue() );
      System.out.println(PirateQueue);
      System.out.println( PirateQueue.dequeue() );
/*
      System.out.println("\nnow dequeuing fr empty queue...");
      System.out.println( PirateQueue.dequeue() );
*/

  }//end main

}//end class RQueue
