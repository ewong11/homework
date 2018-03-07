//Eric Wong
//APCS2 pd8
//HW07 -- A MAn, A Plan, A Canal: Panama!
//2018-02-13

public class Resrever {
  public static String revN(String a) {
    String[] ret = new String[a.length()];
    int insert = 0;
    for (int pos = a.length()-1; pos >= 0; pos--){
      ret[insert] = a[pos];
      insert++;
    }
    return String(ret);
  }

  public static swap(String a, String b) {
    String retstr = "";
    retstr = (b + a)
    return retstr;
  }

  public static String reverse(String a, String b) {
    if ( a.length <= 1 )
      return a;

    //else, halve dataset and recurse on each half
    int leftLen = a.length / 2;
    String leftHalf = a.substring(0,leftLen);
    String rightHalf = a.substring(leftLen, a.length())

    return swap( reverse(leftHalf), reverse(rightHalf) );
  }//end sort()
  public static void main(String[] args) {
    System.out.println(revN("stressed");
  }
  }
}
