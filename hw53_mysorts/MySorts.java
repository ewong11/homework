//Eric Wong
//APCS pd02
//HW54 -- One File to Bring Them All
//2017-12-14

import java.util.ArrayList;

public class MySorts
{
  public static void insertionSort( ArrayList<Comparable> data )
{
for (int i = 1; i < data.size(); i++) { //loop to check each number
  for(int s = i; s > 0; s--) { //loop to put element in the right place
    if(data.get(s).compareTo(data.get(s-1)) < 0) {
      data.set(s, data.set(s-1, data.get(s)));
    }
  }
}
}
public static void selectionSort( ArrayList<Comparable> data )
{
  //note: this version places greatest value at rightmost end,

  //maxPos will point to position of SELECTION (greatest value)
  int maxPos;

  for( int pass = data.size()-1; pass > 0; pass-- ) {
    System.out.println( "\nbegin pass " + (data.size()-pass) );//diag
    maxPos = 0;
    for( int i = 1; i <= pass; i++ ) {
      System.out.println( "maxPos: " + maxPos );//diag
      System.out.println( data );//diag
      if ( data.get(i).compareTo( data.get(maxPos) ) > 0 )
        maxPos = i;
    }
    data.set( maxPos, ( data.set( pass, data.get(maxPos) ) ) );
    System.out.println( "after swap: " +  data );//diag
  }
}//end selectionSortV

public static void bubbleSort( ArrayList<Comparable> data )
{
  //make n-1 passes across collection
  for( int passCtr = 1; passCtr < data.size(); passCtr++ ) {
    System.out.println( "commencing pass #" + passCtr + "..." );

    //iterate from first to next-to-last element
    for( int i = 0; i < data.size()-1; i++ ) {
      //if element at i > element at i+1, swap
      if ( data.get(i).compareTo(data.get(i+1) ) > 0 )
        data.set( i, data.set(i+1,data.get(i)) );
      //System.out.println(data); //diag: show current state of list
    }
  }
}

}
