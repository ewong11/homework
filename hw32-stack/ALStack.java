import java.util.ArrayList;

public class ALStack<PANCAKE> implements Stack<PANCAKE>{
  private int stackSize;

  private ArrayList<PANCAKE> stack = new ArrayList<PANCAKE>();

  //Return true if this stack is empty, otherwise false.
  public boolean isEmpty() {
    return stackSize == 0;
  }

  //Return top element of stack without popping it.
  public PANCAKE peek() {
    return stack.get(stackSize);
  }

  //Pop and return top element of stack.
  public PANCAKE pop() {
    PANCAKE ret = stack.get(stackSize);
    stack.remove(stackSize);
    return ret;
  }

  //Push an element onto top of this stack.
  public void	push( PANCAKE x ) {
    stack.add(x);
  }

}
