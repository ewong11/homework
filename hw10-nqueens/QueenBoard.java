//Eric Wong
//APCS02 pd8
//HW10 --  [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
//2018 -02-28

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 */

public class QueenBoard
{
  private int[][] _board;

  public QueenBoard( int size )
  {
    _board = new int[size][size];
  }


  /***
   * precondition: board is filled with 0's only.
   * postcondition: board has n queens
   * If a solution is found, board shows position of N queens,
   * returns true.
   * If no solution, board is filled with 0's,
   * returns false.
   */
  public boolean solve()
  {
    return solveH(0);
  }



  /**
   *Helper method for solve.
   */
  private boolean solveH( int col )
  {
    if (col == _board[0].length)
      return true;
    for (int row = 0; row < _board[0].length; row++)
      if(addQueen(row,col)) {
        addQueen(row,col);
        if (solveH(col+1)) {
          return true;
        }
        removeQueen(row,col);
      }
      return false;
  }
  public void printSolution()
  {
    /** Print board, a la toString...
        Except:
        all negs and 0's replaced with underscore
        all 1's replaced with 'Q'
    */
      String ans = "";
      for( int r = 0; r < _board.length; r++ ) {
        for( int c = 0; c < _board[0].length; c++ ) {
          if (_board[r][c] == 1)
            ans += "Q";
          else {
            ans += "_";
          }
          ans += "\t";
        }
        ans += "\n";
      }
      System.out.println(ans);
    }



  //================= YE OLDE SEPARATOR =================

  /***
   * adds a queen to the board and marks all the places where another piece
   cannot be place using a negative
   * precondition: there exists a 2D array of ints
   * postcondition: the position on the board has a queen (1)
   */
  private boolean addQueen(int row, int col){
    if(_board[row][col] != 0){
	    return false;
    }
    _board[row][col] = 1;
    int offset = 1;
    while(col+offset < _board[row].length){
	    _board[row][col+offset]--;
	    if(row - offset >= 0){
        _board[row-offset][col+offset]--;
	    }
	    if(row + offset < _board.length){
        _board[row+offset][col+offset]--;
	    }
	    offset++;
    }
    return true;
  }


  /***
   * takes out a queen by setting a 1 to a 0
   * precondition: there is a position on the board with a queen
   * postcondition: the queen is removed (1 to 0)
   */
  private boolean removeQueen(int row, int col){
    if ( _board[row][col] != 1 ) {
	    return false;
    }
    _board[row][col] = 0;
    int offset = 1;

    while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
        _board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
        _board[row+offset][col+offset]++;
	    }
	    offset++;
    }
    return true;
  }


  /***
   * used to print out the board
   * precondition: there is a 2D array of ints
   * postcondition: printed 2D array
   */
  public String  toString()
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
        ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
    }
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {
    QueenBoard b = new QueenBoard(5);
    QueenBoard a = new QueenBoard(5);
    /*
    System.out.println(b);
    b.addQueen(3,0);
    b.addQueen(0,1);
    System.out.println(b);
    b.removeQueen(3,0);
    System.out.println(b);
    */
    a.solve();
    a.printSolution();
  }

}//end class
