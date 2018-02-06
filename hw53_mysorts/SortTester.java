import java.util.ArrayList;
public class SortTester

{
  public static void main(String[] args) {
    /*Best Case BubbleSort: An array list that is already sorted in ascending order, so no 'swaps'
    need to be made.
    Worst Case BubbleSort: An arrayList in descending order, because every element must be
    swapped

    Best Case selectionSort: There is no "Best Case" because a swap will be made in each pass
    Worst Case selectionSort: There is no worse case- a swap is made in each pass

    BestCase insertionSort: IF the ArrayList is already sorted in ascending order
   Worst Case: if the arraylist is in descending order, because at least one swap will need to be made at each pass
*/
 //BubbleSort Best Case
  ArrayList bestCaseBub = new ArrayList<Comparable>();
  bestCaseBub.add(1);
  bestCaseBub.add(2);
  bestCaseBub.add(3);
  bestCaseBub.add(4);
  bestCaseBub.add(5);
  MySorts.bubbleSort(bestCaseBub);
  System.out.println("Best Case bubbleSort");
  System.out.println(bestCaseBub +"\n");

  //BubbleSort worst Case
  ArrayList worstCaseBub = new ArrayList<Comparable>();
  worstCaseBub.add(10);
  worstCaseBub.add(7);
  worstCaseBub.add(5);
  worstCaseBub.add(3);
  worstCaseBub.add(1);
  MySorts.bubbleSort(worstCaseBub);
  System.out.println("Worst Case bubbleSort");
  System.out.println(worstCaseBub + "\n");

  //selectionSort - no best or worst Case
  ArrayList sel = new ArrayList<Comparable>();
  sel.add(3);
  sel.add(5);
  sel.add(6);
  sel.add(2);
  sel.add(0);
  MySorts.selectionSort(sel);
  System.out.println("Selection Sort:");
  System.out.println(sel + "\n");

  //insertionSort Best Case
  ArrayList bestCaseIns = new ArrayList<Comparable>();
  bestCaseIns.add(1);
  bestCaseIns.add(2);
  bestCaseIns.add(3);
  bestCaseIns.add(4);
  bestCaseIns.add(5);
  MySorts.insertionSort(bestCaseIns);
  System.out.println("Best Case insertionSort" + "\n");
  System.out.println(bestCaseIns + "\n");

  //insertionSort worst Case
  ArrayList worstCaseIns = new ArrayList<Comparable>();
  worstCaseIns.add(10);
  worstCaseIns.add(8);
  worstCaseIns.add(7);
  worstCaseIns.add(4);
  worstCaseIns.add(2);
  MySorts.insertionSort(worstCaseIns);
  System.out.println("Worst insertionSort" + "\n");
  System.out.println(worstCaseIns + "\n");
  }
}
