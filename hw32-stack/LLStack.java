//eric wong
//APCS2 pd8
//HW31 -- Leon Leonwood Stack
//2018-04-11

import java.util.LinkedList;

public class LLStack<PANCAKE> implements Stack<PANCAKE>{

  private int stackSize;
  private LinkedList<PANCAKE> head = new LinkedList<PANCAKE>();

  public LLStack() {
    stackSize = 0;
    //head = tail = null;
  }

  public boolean isEmpty() {
    return stackSize == 0;
  }
  public PANCAKE peek(){
    return head.get(stackSize);
  }
  public PANCAKE pop() {
    return head.removeLast();
  }
  public void push(PANCAKE x) {
    head.add(x);
    stackSize += 1;
  }



}
