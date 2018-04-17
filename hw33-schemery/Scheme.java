//Eric Wong
//APCS2 pd9
//HW33 -- What a Racket
//2018-04-13

/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. remove whitespace from input String - into an array.
 *   2. iterate through the array from right to left, using a for loop
 *   3. push everything that is not a '(' onto a Stack
 *   4. when you come across an open parens, we will 'unload the stack'
 *      -using stack as the stack to 'unload', parse through the stack,
 *      performing the intended operation each time until you reach a
 *      closing parens. push the result onto the stack, and return to the for loop
 *   5. steps 2-4 will repeat until a final result is reacheds
 *
 *
 * STACK OF CHOICE: LLStack by Mr.Brown
 * I felt that Mr. Brown's version was most trustworthy
 * Will probably have a similar runtime had I used ALStack
 ******************************************************/

public class Scheme
{
  /******************************************************
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   ******************************************************/
  public static String evaluate( String expr )
  {
    String[] exprArr = expr.split("\\s+"); //creates an array without whitespace
    Stack<String> stack = new LLStack<String>(); //instantiate a new LLStack
    String retVal = ""; //return value

    for (int i = exprArr.length - 1; i > -1; i--) { //iterates from right to left
    if (exprArr[i].equals("(")) { //checks for open parens
	      String op = stack.pop(); //sets op equal to stack.pop()- the last item stacked before "(" should always be an operand
	      if (op.equals("+")) { //if + operation
		  stack.push(unload(1,stack));
	      }
	      else if (op.equals("-")) { //if - operation
		  stack.push(unload(2,stack));
	      }
	      else if (op.equals("*")) { //if * operation
		  stack.push(unload(3,stack));
	      }
	  }
	  else {
	      stack.push(exprArr[i]); //holds all values as you go thru array (except open parens)
	  }
      }
      retVal = stack.pop(); //the Stack should be only 1 value
      return retVal;
  }//end evaluate()


  /******************************************************
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   ******************************************************/
  public static String unload( int op, Stack<String> numbers )
  {
    int retVal = Integer.parseInt(numbers.pop()); //parses the Strings in numbers for Integers
    while (!(numbers.peek().equals(")"))) { //while the next value is not a closing parens
      int nextVal = Integer.parseInt(numbers.pop()); //gets the integer value of the top element
      if (op == 1) { //+
        retVal = retVal + nextVal;
      }
      else if (op == 2) { //-
        retVal = retVal - nextVal;
      }
      else if (op == 3) {//*
        retVal = retVal * nextVal;
      }
    }
    if (numbers.peek().equals(")")) { //checks for closing parens
      numbers.pop(); //if yes, remove the closing parens
    }
    return retVal + ""; //returns retVal , the + "" is needed to make it a String

  }

  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
    try {
      Integer.parseInt(s);
      return true;
    }
    catch( NumberFormatException e ) {
      return false;
    }
  }


  //main method for testing
  public static void main( String[] args )
  {


      String zoo1 = "( + 4 3 )";
      System.out.println(zoo1);
      System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
      //...7

      String zoo2 = "( + 4 ( * 2 5 ) 3 )";
      System.out.println(zoo2);
      System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
      //...17

      String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
      System.out.println(zoo3);
      System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
      //...29

      String zoo4 = "( - 1 2 3 )";
      System.out.println(zoo4);
      System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
      //...-4


  }//main

}//end class Scheme
