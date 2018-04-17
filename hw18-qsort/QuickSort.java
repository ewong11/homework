//Eric Wong
//APCS2 pd8
//HW18 -- QuickSort
//2018-03-13t

/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): makes use of the partition method. Essentially, we are taking an unsorted array
 and partitioning it. The post-condition of this is that the index of the pivot is returned and
 the value of the element at the pivot position is in its final place in a sorted array.
 Knowing this, we can recursively partition each subsequent partitioned array, using a
 different pivot point each time. Because partiton places the value at index pivot in the right place,
 by calling partiton enough times to use every pivot point, the list will end up sorted.
 *
 * 2a. Worst pivot choice and associated runtime:
 *  O(n^2): when the pivot point is either the largest or the smallest number of the array
 * 2b. Best pivot choice and associated runtime:
*  O(nlogn): when the pivot is the midpoint of each list
 * 3. Approach to handling duplicate values in array:
 * the algorithim seems to take care of duplicates because partiton will still place them in the correct spor
 *****************************************************/

public class QuickSort
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o ) {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array
  public static void printArr( int[] a ) {
    for ( int o : a )
	    System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d ) {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal ) {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }
  public static int partition( int[] arr, int left, int right, int pivot) {
    int v = arr[pivot];
    swap( pivot, right, arr);
    int s = left;
    for( int i = left; i < right; i++ ) {
        if ( arr[i] <= v) {
      swap( i, s, arr );
      s++;
        }
    }
    swap(s,right,arr);

    return s;
  }
  //--------------^  HELPER METHODS  ^--------------



  /*****************************************************
   * void qsort(int[])
   * @param d -- array of ints to be sorted in place
   *****************************************************/
  public static void qsort( int[] d )
  {
    qsortH(d,0,d.length-1);
  }

  //you may need a helper method...
  public static void qsortH(int[] arr, int left, int right) {
    if (left==right)
      return;
    if(left < right) {
      int pvtpos = partition(arr,left,right,(left+right)/2);
      qsortH(arr,left,pvtpos-1);
      qsortH(arr,pvtpos+1,right);
    }
  }

  //main method for testing
  public static void main( String[] args )
  {

    //get-it-up-and-running, static test case:
    int [] arr1 = {7,1,5,12,3};
    System.out.println("\narr1 init'd to: " );
    printArr(arr1);

    qsort( arr1 );
    System.out.println("arr1 after qsort: " );
    printArr(arr1);

    // randomly-generated arrays of n distinct vals
    int[] arrN = new int[10];
    for( int i = 0; i < arrN.length; i++ )
    arrN[i] = i;

    System.out.println("\narrN init'd to: " );
    printArr(arrN);

    shuffle(arrN);
    System.out.println("arrN post-shuffle: " );
    printArr(arrN);

    qsort( arrN );
    System.out.println("arrN after sort: " );
    printArr(arrN);


    //get-it-up-and-running, static test case w/ dupes:
    int [] arr2 = {7,1,5,12,3,7};
    System.out.println("\narr2 init'd to: " );
    printArr(arr2);

    qsort( arr2 );
    System.out.println("arr2 after qsort: " );
    printArr(arr2);


    // arrays of randomly generated ints
    int[] arrMatey = new int[20];
    for( int i = 0; i < arrMatey.length; i++ )
    arrMatey[i] = (int)( 48 * Math.random() );

    System.out.println("\narrMatey init'd to: " );
    printArr(arrMatey);

    shuffle(arrMatey);
    System.out.println("arrMatey post-shuffle: " );
    printArr(arrMatey);

    qsort( arrMatey );
    System.out.println("arrMatey after sort: " );
    printArr(arrMatey);

  }//end main

}//end class QuickSort
