//Eric Wong
//APCS pd02
//HW46 -- Al<B> Sorted!
//2017-12-04

import java.util.ArrayList;

public class ALTester
{

  public static void randomPop(ArrayList<Comparable> a) {
    int x = 0;
	   while(x<23) {
       a.add((int)(Math.random() * 10));
       x++;
     }
	}

    public static void upPop(ArrayList<Comparable> a, int amount) {
	for(int i = 0;i < amount; i++) {
	    a.add(i);
     }
	}

        public static void downPop(ArrayList<Comparable> a, int amount) {
	    for(int i = (amount -1);i >= 0; i--) {
	    a.add(i);
     }
	}


    

  public static boolean sort(ArrayList<Comparable> a) {
  boolean ret = true;
  for (int x = 1; x < a.size(); x++) {
      if((a.get(x)).compareTo(a.get(x-1)) < 0 || a.get(x).compareTo(a.get(x-1))  0  {
      return false;
    }

    }
  return ret;
}
    public static void main(String[] args) {
      ArrayList<Comparable> foo = new ArrayList<Comparable>();
      ArrayList<Comparable> joe = new ArrayList<Comparable>();
      ArrayList<Comparable> toe = new ArrayList<Comparable>();
      randomPop(foo);
      System.out.println(foo);
      System.out.println(sort(foo));
      upPop(joe, 23);
      System.out.println(joe);
      System.out.println(sort(joe));
      downPop(toe, 23);
      System.out.println(toe);
      System.out.println(sort(toe));
    }
}
