//Eric Wong
//APCS1 - PD2
//HW21 -- Otnay Ybay ethay Airhay Onway Ymay Inneechay Inchay Inchay
//2017-10-24
public class Pig
{
  //Q: How does this initialization make your life easier?
  //It helps me organize my thinking and makes incremental testing more natural
  private static final String VOWELS = "aeiou";
  /*=====================================
    boolean hasA(String,String) -- checks for a letter in a String
    pre:  w != null, letter.length() == 1
    post: hasA("cat", "a") -> true
    hasA("cat", "p")       -> false
    =====================================*/
  public static boolean hasA( String w, String letter ) 
  {
    boolean ret = false;
    if (w.length() == 0) {
        return ret;
    }
    if (letter.equals(w.substring(0,1))) {
        ret = true;
    }
    else if (w.length() > 0) {
        return hasA(w.substring(1), letter);
    }
    return ret;
    
  }//end hasA()
  /*=====================================
    boolean isAVowel(String) -- tells whether a letter is a vowel
    precondition: letter.length() == 1
    =====================================*/
  public static boolean isAVowel( String letter ) 
  {
/*     int index = 0;
    if (letter.equals(VOWELS.substring(index,index+1))) {
        return true;
    }
    else {
         */
    int vowelIndex = 0;
    for (int index = 0; index < VOWELS.length(); index ++) {
        if (letter.equals(VOWELS.substring(index, index + 1))) {
            return true;
        }
        else {
            
        }
    }
     return false;
  }
  /*=====================================
    int countVowels(String) -- counts vowels in a String
    pre:  w != null
    post: countVowels("meatball") -> 3
    =====================================*/
  public static int countVowels( String w ) 
  {
    int count = 0;
    for (int len = w.length(); len > 0; len --) {
        if (isAVowel(w.substring(0, 1))) {
            count += 1;
            w = w.substring(1);
        }
        else {
            w = w.substring(1);
        }
    }
    return count;
  }
  /*=====================================
    boolean hasAVowel(String) -- tells whether a String has a vowel
    pre:  w != null
    post: hasAVowel("cat") -> true
    hasAVowel("zzz")       -> false
    =====================================*/
  public static boolean hasAVowel( String w ) 
  {
    for (int i = w.length(); i > 0; i--) {
        if (isAVowel(w.substring(0, 1))) {
            return true;
        }
        else {
            w = w.substring(1);
        }
  
  }
    return false;
  }
  /*=====================================
    String allVowels(String) -- returns vowels in a String
    pre:  w != null
    post: allVowels("meatball") -> "eaa"
    =====================================*/
  public static String allVowels( String w ) 
  {
    String retStr = "";
    for (int i = w.length(); i > 0; i--)
        if (isAVowel(w.substring(0,1))) {
            retStr += w.substring(0,1);
            w = w.substring(1);
        }
        else {
            w =w.substring(1);
        }
        return retStr;
  }

  public static void main( String[] args ) 
  {
    /* YOUR TEST CALLS HERE */
    System.out.println(hasA("tre", "g"));
    System.out.println(isAVowel("a"));
    System.out.println(isAVowel("b"));
    System.out.println(isAVowel("i"));
    System.out.println(countVowels("meatball"));
    System.out.println(countVowels("jkgd"));
    System.out.println(countVowels("eeaaiiioou"));
    System.out.println(hasAVowel("meatball"));
    System.out.println(hasAVowel("eaa"));
    System.out.println(hasAVowel("mtbl1"));
    System.out.println(allVowels("meatball"));
    System.out.println(allVowels("eaa"));
    System.out.println(allVowels("mtbl1"));
  }//end main()

}//end class Pig
