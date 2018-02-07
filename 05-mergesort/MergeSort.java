//Eric Wong
//APCS pd8
//HW05 -- Step 1: Split, Step 2: ?, Step 3: Sorted!
//2018-02-06
/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:
  merge: creates a new list of a length equal to the length of the other
  two lists combined
  tracks current position in each list with a variable
  compares the values of the elements at current position in each list and
  the lower value is added to the new list. The current position for that list
  is increased by 1. Repeat until the current postion of one list is greater than
  its length, then add the rest of the other list to the new lists
  sort:recursive method that creates new lists of half the previous length until
  there is are lists with 1 value. Return this value and merge the values.
  ======================================*/

public class MergeSort
{
  /******************************************************
   * int[] merge(int[],int[])
   * Merges two input arrays
   * Precond:  Input arrays are sorted in ascending order
   * Postcond: Input arrays unchanged, and
   * output array sorted in ascending order.
   ******************************************************/
  private static int[] merge( int[] a, int[] b )
  {
    int[] output = new int[a.length + b.length];
    int aIndex = 0;
    int bIndex = 0;
    int i = 0;
    for( int counter = 0; counter < output.length; counter ++) {
      //if array a is 'empty' (sorted)
      if(aIndex >= a.length) {
        for (int x = bIndex; x < b.length; x++) {
          output[i] = b[x];
          i++;
        }
        return output;
      }
      //if array b is empty (sorted)
      if(bIndex >= b.length) {
        for (int y = aIndex; y < a.length; y++) {
          output[i] = a[y];
          i++;
        }
        return output;
    }
      else if(a[aIndex] < b[bIndex]) {
        output[i] = a[aIndex];
        aIndex++;
        i++;
      }
      else {
        output[i] = b[bIndex];
        bIndex++;
        i++;
      }
    }
    return output;
  }//end merge()


  /******************************************************
   * int[] sort(int[])
   * Sorts input array using mergesort algorithm
   * Returns sorted version of input array (ascending)
   ******************************************************/
  public static int[] sort( int[] arr )
  {
    if(arr.length <= 1){
      return arr;
    }
    int mid = arr.length/2;
    int[] arrayA = new int[mid];
    int[] arrayB = new int[arr.length - mid];
    int bCount = 0;
    for(int a = 0; a < arrayA.length; a++) {
      arrayA[a] = arr[a];
    }
    for(int b = 0; b < arrayB.length; b++) {
      arrayB[b] = arr[b + mid];
      bCount++;
    }
    return merge(sort(arrayA),sort(arrayB));
  }//end sort()



  //-------------------HELPERS-------------------------
  //tester function for exploring how arrays are passed
  //usage: print array, mess(array), print array. Whaddayasee?
  public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
      a[i] = 0;
  }

  //helper method for displaying an array
  public static void printArray( int[] a ) {
    System.out.print("[");
    for( int i : a )
      System.out.print( i + ",");
    System.out.println("]");
  }
  //---------------------------------------------------


  //main method for testing
  public static void main( String [] args ) {


      int[] arr0 = {0};
      int[] arr1 = {1};
      int[] arr2 = {1,2};
      int[] arr3 = {3,4};
      int[] arr4 = {1,2,3,4};
      int[] arr5 = {4,3,2,1};
      int[] arr6 = {9,42,17,63,0,512,23};
      int[] arr7 = {9,42,17,63,0,9,512,23,9};

      System.out.println("\nTesting mess-with-array method...");
      printArray( arr3 );
    //  mess(arr3);
      printArray( arr3 );

      System.out.println("\nMerging arr1 and arr0: ");
      printArray( merge(arr1,arr0) );
      printArray( merge(arr3,arr4) );

      System.out.println("\nMerging arr2 and arr3: ");
      printArray( merge(arr3,arr2) );

      System.out.println("\nSorting arr4-7...");
      printArray( sort( arr4 ) );
      printArray( sort( arr5 ) );
      printArray( sort( arr6 ) );
      printArray( sort( arr7 ) );
  }//end main()

}//end class MergeSort
