//Eric Wong
//apcs2 pd8
//hw34 -- the english do not wait in line
//2018-04-16

public class NodeQueue<Quesar> implements Queue<Quesar>{
  private LLNode<Quesar> head, tail;
  private int size;

  public NodeQueue() {
    tail = new LLNode<Quesar>(null,head); //instantiates a tail node, whos next node is head
    head = tail; //assigns head to tail

  }

  public Quesar dequeue() {
    Quesar retVal = head.getValue();
    //System.out.println("b4: " + head.getValue());
    LLNode<Quesar> temp = new LLNode<Quesar>(null,tail); //node to 'walk down' from tail to head
    while (temp.getNext() != head) {
      temp = temp.getNext();
    }
    head = temp;
    //finds the node right before head

    if (temp == tail) { //gets the last element
      retVal = tail.getValue();
    }

    size--;
    return retVal;
  }

  public void enqueue(Quesar x) {
    LLNode<Quesar> temp = new LLNode<Quesar>(x, tail); //creates a temporary node
    tail = temp;
    size++;

  }

  public boolean isEmpty() { //tests if empty
    return size == 0;
  }

  public Quesar peekFront() { //checks what is at head
    return head.getValue();
  }

  public static void main(String[] args) { //main method for testing
    NodeQueue<String> Q = new NodeQueue<String>();
    Q.enqueue("hi");
    Q.enqueue("i");
    Q.enqueue("am");
    Q.enqueue("groot");
    Q.enqueue("who");
    Q.dequeue();
    Q.enqueue("are");
    Q.enqueue("you?");

    System.out.println(Q.isEmpty());
    while (!(Q.isEmpty()))
      System.out.println(Q.dequeue());


}
}
