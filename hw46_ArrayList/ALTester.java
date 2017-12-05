//Eric Wong
//APCS pd02
//HW46 -- Al<B> Sorted!
//2017-12-04

import java.util.ArrayList;

public class ALTester
{

  public static void populate(ArrayList<Comparable> a) {
    int x = 0;
	   while(x<23) {
       a.add((int)(Math.random() * 10));
       x++;
     }
	}

  public static boolean sort(ArrayList<Comparable> a) {
  boolean ret = true;
  for (int x = 1; x < 23; x++) {
    if((a.get(x)).compareTo(a.get(x-1)) < 0) {
      ret = false;
    }

    }
  return ret;
}
    public static void main(String[] args) {
      ArrayList<Comparable> foo = new ArrayList<Comparable>();
      populate(foo);
      System.out.println(foo);
      System.out.println(sort(foo));
    }
}
