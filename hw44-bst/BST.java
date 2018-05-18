//Eric Wong, Kevin
//APCS2 - pd8
//HW43 -- BSTs is the Perfect place for Shade
//2018-05-02
/*****************************************************
 * class BST - v1:partial
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

    if ( _root == null ) {
      _root = newNode;
      return;
    }
    insert( _root, newNode );
  }
  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {
    if ( newNode.getValue() < stRoot.getValue() ) {
      //if no left child, make newNode the left child
      if ( stRoot.getLeft() == null )
        stRoot.setLeft( newNode );
      else //recurse down left subtree
        insert( stRoot.getLeft(), newNode );
      return;
    }
    else { // new val >= curr, so look down right subtree
      //if no right child, make newNode the right child
      if ( stRoot.getRight() == null )
        stRoot.setRight( newNode );
      else //recurse down right subtree
        insert( stRoot.getRight(), newNode );
      return;
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
    if ( currNode == null ) //stepped beyond leaf
      return;
    System.out.print( currNode.getValue() + " " );
    preOrderTrav( currNode.getLeft() );
    preOrderTrav( currNode.getRight() );
  }

  //recurse left, process root, recurse right
  public void inOrderTrav()
  {
    inOrderTrav( _root );
  }
  public void inOrderTrav( TreeNode currNode )
  {
    if ( currNode == null ) //stepped beyond leaf
      return;
    inOrderTrav( currNode.getLeft() );
    System.out.print( currNode.getValue() + " " );
    inOrderTrav( currNode.getRight() );
  }

  //recurse left, recurse right, process root
  public void postOrderTrav()
  {
    postOrderTrav( _root );
  }
  public void postOrderTrav( TreeNode currNode )
  {
    if ( currNode == null ) //stepped beyond leaf
      return;
    postOrderTrav( currNode.getLeft() );
    postOrderTrav( currNode.getRight() );
    System.out.print( currNode.getValue() + " "  );
  }

  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    TreeNode search( int target )
    {
      TreeNode temp = _root;
      while (temp.getValue() != target && temp != null) {
        if (temp.getValue() > target) {
          temp = temp.getLeft();
        }
        else {
          temp = temp.getRight();
        }
        if(temp == null) {
          return null;
        }
      }
      return temp;
    }
    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 0
     *****************************************************/
    public int height()
    {
      return height(_root);
    }
    private int height(TreeNode currNode) {
      int countL = 0;// = counter; //keeps track of left subtree
      int countR = 0;// = counter; //keeps track of right subtrees
      //as long as you are not a leaf, keep recursing
      //if you are a leaf, dont add to counter
      if (currNode.getLeft() == null && currNode.getRight() == null) {
        return 0;
      }
      //recurse left
      if (currNode.getLeft() != null) {
        countL += 1;
        countL += height(currNode.getLeft());
      }
      //recurse right
      if (currNode.getRight() != null) {
        countR += 1;
        countR += height(currNode.getRight());
      }
    //return larger of left and right subtree
    return Math.max(countL, countR);
    }


    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves()
    {
      return numLeaves(_root);
    }
    //helper
    private int numLeaves(TreeNode currNode) {
      int num = 0;
      if (currNode == null) {
        return num; //would be 0
      }
      //return 1 if you are a leaf
      if (currNode.getLeft() == null && currNode.getRight() == null) {
        return 1;
      }
      else {
        //recurse left and right to add to leaf counter
        num += numLeaves(currNode.getLeft());
        num += numLeaves(currNode.getRight());
      }
      return num;
    }

    public int remove(int target) {
      TreeNode leader = _root;
      TreeNode follow = null;

      //make sure element is in the list-
      if (search(target) == null) {
        return target;
      }
      //--------------------------------
      //point leader to target
      while (leader.getValue() != target) {
        if (target < leader.getValue()) {
          follow = leader;
          leader = leader.getLeft();
        }
        else {
          follow = leader;
          leader = leader.getRight();
        }
      }
        //if target is a leaf--------------------------------------
        if (leader.getLeft() == null && leader.getRight() == null) {
          if (target > follow.getValue()) {
            follow.setRight(null);
          }
          else {
            follow.setLeft(null);
          }
        }
        /*---------------------------------------------------------------*/
        //if target had two children, replace target with greatest on left
        else if (leader.getLeft() != null && leader.getRight() != null) {
          TreeNode currNode = leader;
          leader = leader.getLeft();
          while(leader.getRight() != null) {
            leader = leader.getRight();
          }
            remove(leader.getValue());
            currNode.setValue(leader.getValue());
        }
        /*-----------------------------------------------------------------*/
        //one child
        else {
          //right child
          if (target > follow.getValue()) {
            if (leader.getRight() != null) {
              follow.setRight(leader.getRight());
            }
            else {
              follow.setRight(leader.getLeft());
            }
          }
          //left child
          else {
            if (leader.getRight() != null) {
              follow.setLeft(leader.getRight());
            }
            else {
              follow.setLeft(leader.getLeft());
            }
          }
        }
      return target;
        /*********************************************************************/
      }



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
    arbol.insert( 9 );
    arbol.insert( 11 );
    arbol.insert(8);
    arbol.insert(7);
    arbol.insert(12);
    /*
    System.out.println( "\n-----------------------------");
    System.out.println( "pre-order traversal:" );
    arbol.preOrderTrav();
    */
    System.out.println( "\n-----------------------------");
    System.out.println( "in-order traversal:" );
    arbol.inOrderTrav();
/*
    System.out.println( "\n-----------------------------");
    System.out.println( "post-order traversal:" );
    arbol.postOrderTrav();
/*
    System.out.println( "\n-----------------------------");
    System.out.println( "height:");
    System.out.println(arbol.height());

    System.out.println( "\n-----------------------------");
    System.out.println( "leaves:");
    System.out.println(arbol.numLeaves());
    */
    System.out.println( "\n-----------------------------");
    System.out.println( "remove 5:");
    arbol.remove(5);
    arbol.inOrderTrav();

    System.out.println( "\n-----------------------------");
    System.out.println( "remove 2:");
    arbol.remove(12);
    arbol.inOrderTrav();

    System.out.println( "\n-----------------------------");
    System.out.println( "remove 7:");
    arbol.remove(7);
    arbol.inOrderTrav();
    System.out.println("\n");

  }

}//end class
