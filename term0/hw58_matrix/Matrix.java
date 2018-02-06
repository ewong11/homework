/*Eric Wong
APCSpd02
HW58 -- Make the Maxtrix work for you
2017-12-20
*/

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

    private Object[][] _matrix;

    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    public Matrix()
    {
	_matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
    }


    //constructor intializes an a*a matrix
    public Matrix( int a )
    {
	_matrix = new Object[a][a];
  for (int y = 1; y <= _matrix.length; y++) {
    for (int x = 1; x <= _matrix[1].length; x++) {
      set(y,x, (int)(Math.random()*100));
    }
  }
}


    //return size of this matrix, where size is 1 dimension
    private int size()
    {
	return _matrix.length;
    }


    //return the item at the specified row & column
    private Object get( int r, int c )
    {
	return _matrix[r-1][c-1];
    }


    //return true if this matrix is empty, false otherwise
    private boolean isEmpty( int r, int c )
    {
	return get(r,c) == null;

    }


    //overwrite item at specified row and column with newVal
    //return old value
    private Object set( int r, int c, Object newVal )
    {
	Object retVal = _matrix[r-1][c-1];
	_matrix[r-1][c-1] = newVal;
	return retVal;
    }


    //return String representation of this matrix
    // (make it look like a matrix)
    public String toString()
    {
	String foo = "";
	for( int i =0; i < size(); i++ ) {
	    foo += "| ";
	    for( int j=0; j < size(); j++ ) {
		foo += _matrix[i][j] + " "; //get(i+1,j+1)
	    }
	    foo += "|\n";
	}

	return foo;
    }


    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    public boolean equals( Object rightSide )
    {
	boolean foo = false;

	if (this == rightSide) foo = true;
	// checks for aliases  ex. m1.equals(m1) is true

	else if ( rightSide instanceof Matrix
		  && size() == ( (Matrix)rightSide).size() ) {
	    Matrix r = (Matrix) rightSide; //for cleaner code later
	    foo = true;
	    outer:
	    for( int i = 0; i < size(); i++ ) {
		for( int j = 0; j < size(); j++ ) {
		    if ( !isEmpty(i,j) && ( !get(i,j).equals(r.get(i,j) ) ) ) {
			foo = false;
			break outer;
		    }
		    else if ( !( isEmpty(i,j) && r.isEmpty(i,j) ) ) {
			foo = false;
			break outer;
		    }
		}
	    }
	}
	return foo;
    }//end equals()



    //swap two columns of this matrix
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapColumns( int c1, int c2  )
    {
	c1 = c1-1;
	c2 = c2-1;

	for( int i = 0; i < size(); i++ ) {
	    set( i, c1, set( i, c2, get(i,c1) ) );
	}
    }//O(n) b/c must visit n rows


    //swap two rows of this matrix
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapRows( int r1, int r2  )
    {
	r1 = r1-1;
	r2 = r2-2;
	Object [] temp = _matrix[r1];
	_matrix[r1] = _matrix[r2];
	_matrix[r2] = temp;
    }//O(1)


    //            PHASE 2
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //returns copy of row r
    public Object[] getRow( int r )
    {
      Object[] copy = new Object[_matrix.length];
      for (int x = 1; x < _matrix.length; x++) {
        copy[x] = _matrix[r-1][x]; //copies elements of old array into new array
      }
      return copy;
    }//O(n)

    //replaces row r with 1D array newRow
    //returns old row
    public Object [] setRow( int r, Object[] newRow ) //changes row
    {
      Object[] old = new Object[_matrix.length];
      for (int x = 0; x < _matrix.length; x++){
        old[x] = _matrix[r-1][x];
      }
      for(int y = 0; y < _matrix.length; y++) {
        _matrix[r-1][y] = newRow[y];
      }
      return old;
    }//O(n*n)

    public Object[] setCol( int c, Object[] newCol ) //changes column
    {
      Object old[] = new Object[_matrix.length];
      for (int x = 0; x < _matrix.length; x++){
        old[x] = _matrix[x][c-1];
      }
      for(int y = 0; y < _matrix.length; y++) {
        _matrix[y][c-1] = newCol[y];
    }
    return old;
  }//O(n*n)

    //M[i,j] -> M[j,i] for all i,j
    public void transpose()
    {
      for(int row = 0; row < size(); row++) {
        for(int y = row; y < size(); y++){ //each row you go down, you swap one less element or else it'll be redundant
          Object temp = _matrix[row][y]; //[row][y];
          _matrix[row][y] = _matrix[y][row];
          _matrix[y][row] = temp;
          }
        }
      }
    //O(n*n)

    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


    //main method for testing
    public static void main( String[] args )
    {
	Matrix m1 = new Matrix(); // 2 x 2
	Matrix m2 = new Matrix(10); // 10 x 10
	System.out.println("m1 size: " + m1.size());
	System.out.println("m2 size: " + m2.size());
	System.out.println("m1 get(1,1) : " + m1.get(1,1));
	System.out.println("m1 isEmpty(1,1) : " + m1.isEmpty(1,1));

	Matrix x = new Matrix(3); // 2x2
  Object[] a = new Object[2];
  a[0] = 0;
  a[1] = 1;
	//System.out.println(x);
	//x.set(1,1,"how");
	//x.set(1,2,"now");
	//x.set(2,1,"bro");
	//x.set(2,2,"cow");
	System.out.println(x);
  x.transpose();
  System.out.println(x);

	Matrix m3 = new Matrix(3); //3x3
	System.out.println(m1);
    }//end main()

}//end class Matrix
