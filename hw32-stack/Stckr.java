/*****************************************************
 * class Stckr
 * driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 *****************************************************/

public class Stckr
{
    public static void main( String[] args )
    {
	//Stack<String> cakes = new ALStack<String>();
	Stack<String> cakes = new LLStack();
  //System.out.println(cakes.isEmpty());

	cakes.push("hello");
  System.out.println(cakes.pop());
  cakes.push("i");
  cakes.push("am");
  cakes.push("groot");
  System.out.println(cakes.pop());
  System.out.println(cakes.pop());
  System.out.println(cakes.pop());
    }//end main

}//end class
