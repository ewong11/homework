//Eric Wong
//APCS2 p8
//HW26 -- Delteratour
//2018-03-27
/*****************************************************
 * class ItrWork -- skeleton
 * Allows for familiarization with iterators
 *****************************************************/

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItrWorkAL
{
    //using FOREACH loop
    //returns a boolean to indicate whether key is present in L
    public static boolean foundA( Integer key, LList<Integer> L )
    {
	for (int i: L) {
	    if (i == key) {
		return true;
	    }
	}
	return false;

    }

    //explicitly using an iterator
    //returns a boolean to indicate whether key is present in L
    public static boolean foundB( Integer key, LList<Integer> L )
    {
	Iterator it = L.iterator();
	while (it.hasNext()){
	    int i = (Integer) it.next();
	    if(i == key) {
		return true;
    }
  }
  return false;
}


    //using FOREACH loop
    //returns a list containing the odd numbers in L
    public static LList<Integer> oddsA( LList<Integer> L )
    {
	LList<Integer> retL = new LList<Integer>();
       for (int i: L) {
	  if (i%2 != 0) {
	      retL.add(i);
	 }
       }
       return retL;
    }

    //explicitly using an iterator
    //returns a list containing the odd numbers in L
    public static LList<Integer> oddsB( LList<Integer> L )
    {
	LList<Integer> retL = new LList<Integer>();
	Iterator it = L.iterator();
	while (it.hasNext()){
	    int i = (Integer) it.next();
	    if(i%2 != 0) {
	    retL.add(i);
	    }
    }
    return retL;
    }


    //explicitly using an iterator
    //modifies L s.t. it contains no evens
    public static void removeEvens( LList<Integer> L )
    {
        	List retL;
	Iterator it = L.iterator();
	while (it.hasNext()){
	    int i = (Integer) it.next();
	    if(i%2 == 0) {
	    it.remove();
	    }
    }
    }


    public static void main( String [] args )
    {
	//var type: List   obj type: ArrayList
	LList<Integer> L = new LList<Integer>();

	for( int i = 0; i < 10; i++ )
	    L.add(i);


	// TASK: write code to print the contents of ArrayList L...


	// a) using a FOREACH loop
  String retstr = "[";
  for(int i: L){
    retstr += i + ",";
  }
  retstr += "]";
  System.out.println(retstr);

	// b) explicitly using an iterator
  String ret = "[";
  Iterator it = L.iterator();
  while(it.hasNext()){
    ret += it.next() + ",";
  }
  ret += "]";
  System.out.println(ret);

	System.out.println("\nTesting foundA...");
	System.out.println("9 in L? -> " + foundA(9,L) );
	System.out.println("13 in L? -> " + foundA(13,L) );

	System.out.println("\nTesting foundB...");
	System.out.println("9 in L? -> " + foundB(9,L) );
	System.out.println("13 in L? -> " + foundB(13,L) );

	System.out.println("\nTesting oddsA...");
	LList<Integer> A = oddsA(L);
	for( int n : A ) System.out.println(n);

	System.out.println("\nTesting oddsB...");
	LList<Integer> B = oddsB(L);
	for( int n : B ) System.out.println(n);

	System.out.println("\nTesting removeEvens...");
	removeEvens(L);
	for( int n : L ) System.out.println(n);


    }//end main

}//end class ItrWork
