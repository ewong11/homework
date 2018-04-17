//Eric Wong
//APCS pd8
//HW16 - About Face
//2018-03-08

public class Mysterion {

  public static void swap(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }
  public static void printArray(int[] a){
    String foo = "[";
    for( int i = 0; i < a.length; i++ ) {
      foo += a[i] + ",";
    }
    if ( foo.length() > 1 )
      //shave off trailing comma
      foo = foo.substring( 0, foo.length()-1 );
    foo += "]";
    System.out.println(foo);;
  }
  /*
  a represents index 0, or the first number
  b represent the last index
  c represents the middle index
  the algorithm does not sort the entire list, rather it seems to sort only a part of it.
  the algo sorts everything prior to the middle value of the original array.
  */
  public static int partialSort(int[] arr, int first, int last, int middle) {
    int v = arr[middle];
    swap(arr, middle, last);
    int s = first;
    for(int i = 0; i < last; i++) {
      if (arr[i] < v) {
        swap(arr,s,i);
        s+=1;
    }
  }
    swap(arr,last,s);
    return s;
  }
  public static void main(String[] args) {
    int[] test1 = {7,3,5,1,5};
    /*
    int[] test2 = {1,2,3,4,5};
    int[] test3 = {12,3,1,9,10,70,22};
    int[] test4 = {5,4,3,6,1};
    int[] test5 = {7,1,5,12,3};
    int[] swapT = {1,2,3};
    */
    //test1
    System.out.println(partialSort(test1,0,4,1));
    printArray(test1);
    //test2
    /*
    System.out.println(partialSort(test1,0,3,1));
    printArray(test1);
    //test3
    System.out.println(partialSort(test1,0,3,2));
    printArray(test1);
    //test5
    System.out.println(partialSort(test1,0,3,3));
    printArray(test1);
    //test5
  //  System.out.println(partialSort(test5,0,3,4));
    //printArray(test1);
    */

  //  swap(swapT,1,2);
    //printArray(swapT);
  }
}
