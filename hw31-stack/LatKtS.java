//Eric Wong
//APCS2 pd8
//HW31: Stack: What is it Good For?
//2018-04-11
/*****************************************************
 * skeleton for class LatKtS
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/


public class LatKtS
{

  /**********************************************************
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **********************************************************/
  public static String flip( String s )
  {
    Latkes orig = new Latkes(s.length());
    String retStr = "";
    for(int i =0; i<s.length(); i++) {
      orig.push(s.substring(i,i+1));
      //System.out.println(s.substring(i,i+1));
    }
    for(int x = 0; x < s.length(); x++) {
      retStr += orig.pop(); //appends to right side of return string
    }
    return retStr;
  }//end flip()


  /**********************************************************
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **********************************************************/
  public static boolean allMatched( String s )
  {
    Latkes stack = new Latkes(s.length());
    Latkes temp = new Latkes(s.length());
    for(int i =0; i<s.length(); i++) {
      stack.push(s.substring(i,i+1));
      //System.out.println(s.substring(i,i+1));
    }
    if(s.length()%2 == 0) { //need to check if there is an even number of parentheses
    while(!(stack.isEmpty())) {
      if(stack.peek().equals("}") || stack.peek().equals(")") || stack.peek().equals("]")) {
        temp.push(stack.pop()); //temp keeps track of closing brackets - stack pops them into temp
      }
      else if (isMatch(temp.peek(),stack.peek())) {
        //if the next paren is an opening one, checks if it corresponds to the most recent closing paren
        temp.pop();
        stack.pop();
        //if so, remove the opening and closing from both temp and stack
      }
      else {
        return false; //if not, then they are not all matched
      }
    }
  }
  else {
    return false;
  }
return true;
  }//end allMatched()

//helper method to check if opening paren matches with a corresponding closing paren
  public static boolean isMatch(String b, String a) {
    if (a.equals("{")) {
      if(b.equals("}"))
        return true;
      else
        return false;
    }
    else if (a.equals("[")) {
      if(b.equals("]"))
        return true;
      else
        return false;
    }
    else if (a.equals("(")) {
      if(b.equals(")"))
        return true;
      else
        return false;
    }
    else
      return false;
  }

  //main method to test
  public static void main( String[] args )
  {

    //System.out.println(flip("stressed"));
    //System.out.println(isMatch("{", ")"));
    //System.out.println(isMatch("()", ")"));

    System.out.println(allMatched( "({}[()])" )); //true
    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
  }

}//end class LatKtS
