//eric wong
//APCS2 pd8
//HW30 - Stacks on Stacks on Stacks on Stacks…
//2018-04-10
/*****************************************************
 * skeleton for class Latkes
 * Implements a stack of Strings using an encapsulated array
 *****************************************************/

public class Latkes
{
  private String [] _stack;
  private int _stackSize;
  private int capacity;

  //constructor
  public Latkes( int size )
  {
    _stack = new String[size]; //sets a set size for the array
    capacity = size; //variable to track the max size
    _stackSize = 0; //tracks the current number of latkes
  }

  //means of insertion
  public void push( String s )
  {
    //checks if any more latkes can be added...if so, just return - dont alter array
    if (isFull()) {
      return;
    }
    //if the array is empty, simply append the latke to the beginning of the array (index 0)
    else if (_stackSize == 0) {
      _stack[0] = s;
      _stackSize++;
    }
    else {
      String[] temp = new String[capacity];
      for (int x = 0; x < capacity; x++) {
        temp[x] = _stack[x]; //creates a temporary copy of _stack
      }
      for (int x = 1; x < capacity; x++) {
        _stack[x] = temp[x-1]; //add all elements of stack except the first element, using temp as a template
      }
      _stack[0] = s;
      _stackSize++; //adds 1 to number of latkes in stack
      }
    }

  //means of removal
  public String pop( )
  {
    String retStr; //used to return the string being removed
    if (!isEmpty()) {
      String[] temp = new String[capacity];
      retStr = _stack[0];
      for (int x = 0; x < capacity; x++) {
        temp[x] = _stack[x]; //creates a copy of the _stack array
      }
      for (int x = 0; x < capacity-1; x++) {
        _stack[x] = temp[x+1]; //creates a stack array, but withou the first element
      }
      _stackSize--;
    }
    else { //when the array is empty
      return "No more latkes!";
    }
    return retStr; //returns element 'popped'
  }

  //chk for emptiness
  public boolean isEmpty()
  {
    return _stackSize == 0;
  }

  //chk for fullness
  public boolean isFull()
  {
    return _stackSize == capacity;
  }

  public String toString() {
    String retStr = "[";
    for (String s: _stack) {
      retStr += s + ",";
    }
    retStr += "]";
    return retStr;
  }


  //main method for testing
  public static void main( String[] args )
  {

      Latkes tastyStack = new Latkes(12);

      tastyStack.push("aoo");
      tastyStack.push("boo");
      tastyStack.push("coo");
      tastyStack.push("doo");
      tastyStack.push("eoo");
      tastyStack.push("foo");
      tastyStack.push("goo");
      tastyStack.push("hoo");
      tastyStack.push("ioo");
      tastyStack.push("joo");
      tastyStack.push("coocoo");
      tastyStack.push("cachoo");
      System.out.println(tastyStack.isFull());
      System.out.println(tastyStack);
      //cachoo
      System.out.println( tastyStack.pop() );
      //coocoo
      System.out.println( tastyStack.pop() );
      //joo
      System.out.println( tastyStack.pop() );
      //ioo
      System.out.println( tastyStack.pop() );
      //hoo
      System.out.println( tastyStack.pop() );
      //goo
      System.out.println( tastyStack.pop() );
      //foo
      System.out.println( tastyStack.pop() );
      //eoo
      System.out.println( tastyStack.pop() );
      //doo
      System.out.println( tastyStack.pop() );
      //coo
      System.out.println( tastyStack.pop() );
      //boo
      System.out.println( tastyStack.pop() );
      //aoo
      System.out.println( tastyStack.pop() );

      //stack empty by now; SOP(null)
      System.out.println( tastyStack.pop() );

  }//end main()

}//end class Latkes
