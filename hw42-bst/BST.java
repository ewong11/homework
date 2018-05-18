//Eric Wong
//APCS2 - pd8
//HW42 -- Algorithm as Data Structure
//2018-05-01
/*****************************************************
 * class BST - v1:partial
 * SKELETON
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT)
 *
 * A BST maintains the invariant that, for any node N with value V,
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value,
 *  and any value in its right subtree must be greater.)
 * This BST only holds ints (its nodes have int cargo)
 *****************************************************/

public class BST
{

  //instance variables / attributes of a BST:
  TreeNode _root;

  /*****************************************************
   * default constructor
   *****************************************************/
  BST( )
  {
    _root = null;
  }


  /*****************************************************
   * void insert( int )
   * Adds a new data element to tree.
   *****************************************************/
  public void insert( int newVal )
  {
    TreeNode newNode = new TreeNode( newVal );
    //if the root is, the first insert will be the root
    if (_root == null) {
      _root = newNode;
    }
    else {
      insert(_root, newNode);
  }
  }
  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {
    //if left subtree is null, insert to left
    if (stRoot.getLeft() == null) {
      stRoot.setLeft(newNode);
    }
    //if rightsubtree is null, insert to right
    else if (stRoot.getRight() == null) {
      stRoot.setRight(newNode);
    }
    else {
      //check ahead to determine which side is unbalanced
      //adds to left first
      if (stRoot.getLeft().getLeft() == null || stRoot.getLeft().getRight() == null) {
        insert(stRoot.getLeft(), newNode);
    }
    //when the next level for the left subtree is filled, insert ot right subtree
    else {
      insert(stRoot.getRight(), newNode);
    }
    }
  }//end insert()




  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

  // each traversal should simply print to standard out
  // the nodes visited, in order

  //process root, recurse left, recurse right
  public void preOrderTrav()
  {
    preOrderTrav( _root );
  }
  public void preOrderTrav( TreeNode currNode )
  {
    //print root
    System.out.println(currNode.getValue());
    //recurse left
    if (!(currNode.getLeft() == null)) {
      preOrderTrav(currNode.getLeft());
    }
    //recurse right
    if(!(currNode.getRight() == null)) {
      preOrderTrav(currNode.getRight());
    }
  }

  //recurse left, process root, recurse right
  public void inOrderTrav()
  {
    inOrderTrav(_root);
  }
  public void inOrderTrav( TreeNode currNode )
  {
    //recurse left
    if(!(currNode.getLeft()== null)) {
      inOrderTrav(currNode.getLeft());
    }
    //process root
    System.out.println(currNode.getValue());

    //recurse right
    if(!(currNode.getRight()== null)) {
      inOrderTrav(currNode.getRight());
    }
  }

  //recurse left, recurse right, process root
  public void postOrderTrav()
  {
      postOrderTrav(_root);
  }
  public void postOrderTrav( TreeNode currNode )
  {
    //recurse left
    if (!(currNode.getLeft() == null)) {
      postOrderTrav(currNode.getLeft());
    }
    //recurse right
    if (!(currNode.getRight() == null)) {
      postOrderTrav(currNode.getRight());
    }
    //process root
    System.out.println(currNode.getValue());
  }

  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  //main method for testing
  public static void main( String[] args )
  {


      BST arbol = new BST();

      //PROTIP: sketch state of tree after each insertion
      //        ...BEFORE executing these.
      arbol.insert( 4 );
      arbol.insert( 2 );
      arbol.insert( 5 );
      arbol.insert( 6 );
      arbol.insert( 1 );
      arbol.insert( 3 );

      System.out.println( "\n-----------------------------");
      System.out.println( "pre-order traversal:" );
      arbol.preOrderTrav();


      System.out.println( "\n-----------------------------");
      System.out.println( "in-order traversal:" );
      arbol.inOrderTrav();
      System.out.println( "\n-----------------------------");
      System.out.println( "post-order traversal:" );
      arbol.postOrderTrav();

      System.out.println( "\n-----------------------------");
  }

}//end class
