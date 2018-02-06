//Eric Wong
//APCS-pd2
//HW57
//2017-12-20
/***
 * class Matrix -- models a square matrix
 *
 * BACKGROUND:
 * A matrix is a rectangular array.
 * Its dimensions are numRows x numColumns.
 * Each element is indexed as (row,column):
 *  eg,
 *   for 2 x 3 matrix M:
 *        -       -
 *   M =  | a b c |
 *        | d e f |
 *        -       -
 *   ... d is at position (2,1) or M[2,1]
 *
 * TASK:
 * Implement methods below, categorize runtime of each.
 * Test in main method.
 ***/


public class Matrix
{
  //constant for default matrix size
  private final static int DEFAULT_SIZE = 2;

  private Object[][] matrix;

  //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
  public Matrix()
	{
    matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
  }


  //constructor intializes an a*a matrix
  public Matrix( int a )
  {
    matrix = new Object[a][a];
    for (int y = 1; y <= matrix.length; y++) {
      for (int x = 1; x <= matrix[1].length; x++) {
        set(y,x, (int)(Math.random()*100));
      }
    }
  }


  //return size of this matrix, where size is 1 dimension
  private int size()
  {
    return matrix.length * matrix[1].length; //multiplies x and y
  }


  //return the item at the specified row & column
  private Object get( int r, int c )
  {
    return matrix[r-1][c-1];
  }


  //return true if this matrix is empty, false otherwise
  private boolean isEmpty()
  {
    for (int x = 1; x < matrix.length; x++) {
      for (int i = 1; i < matrix[0].length; i++) {
        if(this.get(x, i) != null) { //checks if each value is null
          return false;
        }
        }
      }
      return true;
    }


  //overwrite item at specified row and column with newVal
  //return old value
  private Object set( int r, int c, Object newVal )
  {
    Object old = matrix[r-1][c-1];
    matrix[r-1][c-1] = newVal;
    return old;
  }


  //return String representation of this matrix
  // (make it look like a matrix)
  public String toString()
  {
    String retstr = "";
      for(int y = 0; y < matrix.length; y++) {
        retstr += "| "; //beginning of new row
          for(int x = 0; x < matrix[y].length; x++) {
              retstr += matrix[y][x] + " ";
          }
          retstr = retstr + "|" + "\n";
      }
      return retstr +"\n";

    }

  //override inherited equals method
  //criteria for equality: matrices have identical dimensions,
  // and identical values in each slot
  public boolean equals( Object rightSide )
  {
    if ((this.size() == ((Matrix)rightSide).size()) //(Matrix) typecasting; compares size
    && (this.matrix.length == ((Matrix)rightSide).matrix.length)) {
      for (int x = 1; x < matrix.length -1 ; x++) {
        for (int y = 1; y < matrix[y].length-1; y++) {
          if (this.get(x,y) != ((Matrix)rightSide).get(x,y)) { //checks if each value is equal
            return false;
          }
        }
      }
    }
    else {
      return false;
    }
    return true;
  }


  //swap two columns of this matrix
  //(1,1) is top left corner of matrix
  //row values increase going down
  //column value increase L-to-R
  public void swapColumns( int c1, int c2  )
  {
    for (int y = 0; y < matrix.length; y++) {
      Object temp = matrix[y][c1-1]; //keeps value of one of the columsn before swapping
      matrix[y][c1-1] = matrix[y][c2-1];
      matrix[y][c2-1] = temp;

    }
  }


  //swap two rows of this matrix
  //(1,1) is top left corner of matrix
  //row values increase going down
  //column value increase L-to-R
  public void swapRows( int r1, int r2  )
  {
    for (int x = 0; x < matrix.length; x++) { //goes down the row
      Object temp = matrix[r1-1][x];
      matrix[r1-1][x] = matrix[r2-1][x];
      matrix[r2-1][x] = temp;
  }
}


  //main method for testing
  public static void main( String[] args )
  {
    Matrix bob = new Matrix(3);
    Matrix joe = new Matrix(3);
    //for (int y = 1; y <= bob.matrix.length; y++) {
      //for (int x = 1; x <= bob.matrix[1].length; x++) {
        //bob.set(y,x, (int)(Math.random()*100));
      //}
    //}


    System.out.println(bob.size());
    System.out.println(bob.get(2,1));
    System.out.println(bob.isEmpty());
    System.out.println(bob);
    //System.out.println(joe);
  //  System.out.println(bob.equals(joe));
    bob.swapColumns(1,3);
    System.out.println(bob);
    bob.swapRows(2,3);
    System.out.println(bob);
  }

}//end class Matrix
