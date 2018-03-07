//Eric Wong
//APCS2 pd8
//HW07 -- A MAn, A Plan, A Canal: Panama!
//2018-02-13

public class Resrever {
  //O(n) sort - creates a new string and adds to the string from the last letter
  //runs in linear time, as we iterate throuhg all the elements
  public static String revN(String a) {
    String ret = "";
    for(int x = a.length()-1; x >= 0;x--){
      ret += a.substring(x,x+1);
    }
    return ret;
  }

  //swap, which runs in O(1) constant time
  public static String swap(String a, String b) {
    String retstr = "";
    retstr = (b + a);
    return retstr;
  }

  //splits the string in half and recurses - runs in O(logn) time
  public static String reverse(String a) {
    if ( a.length() <= 1 )
      return a;

    //else, halve dataset and recurse on each half
    int leftLen = a.length() / 2;
    String leftHalf = a.substring(0,leftLen);
    String rightHalf = a.substring(leftLen, a.length());

    return swap( reverse(leftHalf), reverse(rightHalf) );
  }
  public static void main(String[] args) {
    System.out.println(revN("stressed"));
    System.out.println(reverse("stressed"));
  }
  }
