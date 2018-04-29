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


public class RQ<T> implements Queue<T>
{
  //instance variables
  private LLNode<T> _front, _end;
  private int _size;


  // default constructor creates an empty queue
  public RQ()
	{
    _end = _front = null;

	}//end default constructor


  public void enqueue( T enQVal )
  {
    if (_size == 0) {
      _end= new LLNode(enQVal,_front);
      _front = _end;
    }
    else {
  LLNode<T> temp = new LLNode(enQVal, _end);
  _end = temp;
  _size++;
}
  }//end enqueue()


  // remove and return thing at front of queue
  // assume _queue ! empty
  public T dequeue()
  {
    sample();
    T retVal = _front.getValue();
    LLNode temp = _end;
    while (temp.getNext().getValue() != _front.getValue()) {
      temp = temp.getNext();
    }
    temp.setNext(temp.getNext().getNext());
    return retVal;
  }//end dequeue()


  public T peekFront()
  {
    return _front.getValue();
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
    /*
    LLNode<T> temp = null;
    for (int i = 0; i < _size; i++) {

      for (int i = 0; i < rand; i++) {
        temp = temp.getNext();
    }
    */
    int rand =(int) (Math.random()*_size-1);
    LLNode temp = _end;
    for (int i = 0; i < rand; i++) {
      temp = temp.getNext();
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


      Queue<String> PirateQueue = new RQ<String>();

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
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
/*
      System.out.println("\nnow dequeuing fr empty queue...");
      System.out.println( PirateQueue.dequeue() );
*/

  }//end main

}//end class RQueue
