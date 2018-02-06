/*
  MattJackieInezDigit -- Maggie Zhao, Henry Carver, Eric Wong & rubber ducky
  APCS1 pd02
  HW23 -- Etterbay Odingcay Oughthray Ollaborationcay ...Ippyay.
  2017-10-25 W
*/
/***
 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
 *          9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 *      PROTIP: Make this class compilable first,
 *      then develop and test one method at a time.
 *      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 
 -----------------OUR TO-DO LIST---------------------------
     
 * a method to find the first punctuation 
 - iterate through the string until we come upon a punctuation (',.)
 - does punctuation affect the translation? (don't --> on'tday)     
     
 * a method to determine whether or not a y is a vowel
 - check if the y is preceded or followed by a vowel (e.g. fly, spy, spyer, lying)
    
 * for compound words, each syllable/word is transcribed separately (e.g. birdhouse --> ird-bay-ouse-hay
 ***/

public class Pig
{
    //Q: How does this initialization make your life easier?
    //A: It helps keep my code and my thoughts organized, which makes coding easier
    //and makes us less prone to errors
    private static final String VOWELS = "aeiou";


    /*=====================================
      boolean hasA(String,String) -- checks for a letter in a String
      pre:  w != null, letter.length() == 1
      post: hasA("cat", "a") -> true
      hasA("cat", "p")       -> false
      =====================================*/
    public static boolean hasA( String w, String letter ) 
    {
	// If the letter is in the string, w, the index will be a number that is not -1. If the letter is in the string, the statement below will return true.
      
	return (w.indexOf(letter) != -1 );

    }//end hasA()

    
    /*=====================================
      boolean isAVowel(String) -- tells whether a letter is a vowel
      precondition: letter.length() == 1
      =====================================*/
    public static boolean isAVowel( String letter ) 
    {
	// If the letter is in the string, VOWELS, (if the letter is a vowel), the index will be a number that is not -1. If the letter is a vowel, the statement below will return true. 
	letter = letter.toLowerCase();
	return (VOWELS.indexOf(letter) != -1 ) ;
      
    }//end isaVowel()


    /*=====================================
      int countVowels(String) -- counts vowels in a String
      pre:  w != null
      post: countVowels("meatball") -> 3
      =====================================*/
    public static int countVowels( String w ) 
    {
	// Checks each letter in the string to see if it is a vowel. If the letter is a vowel, the counter goes up by one. 
	int counter = 0;
	for (int x = 0; x < w.length(); x+= 1){
	    if (isAVowel(w.substring( x, x + 1))) {
		counter = counter + 1;
	    }
	}
	return counter;
    }


    /*=====================================
      boolean hasAVowel(String) -- tells whether a String has a vowel
      pre:  w != null
      post: hasAVowel("cat") -> true
      hasAVowel("zzz")       -> false
      =====================================*/
    public static boolean hasAVowel( String w ) 
    {
	// Checks each letter in the string to see if it is a vowel. If the letter is a vowel, return true.
	return countVowels(w) > 0;
    }


    /*=====================================
      String allVowels(String) -- returns vowels in a String
      pre:  w != null
      post: allVowels("meatball") -> "eaa"
      =====================================*/
    public static String allVowels( String w ) 
    {
	// Checks each letter in the string to see if it is a vowel. If the letter is a vowel, add it to a result string.
	String restr = "";
	for (int x = 0; x < w.length(); x += 1){
	    if (isAVowel(w.substring( x, x + 1))) {
		restr  =  restr + w.substring(x, x + 1);
	    }
	}
	return restr;
    }
    /*==============================
      pre: w != null
      post : firstVowel("") -->  ""
      firstVowel("zzz") -->  ""
      firstVowel("meatball") --> "e"
      ==============================*/
    public static String firstVowel( String w)
    {
        if (allVowels(w).equals("")) {
            return "";
        }
        else{
	    return allVowels(w).substring(0,1);
	}}


    /* ==============================
       pre: w != null and w.length() > 0
       post: beginsWithVowel("apple")  --> true
       beginsWithVowel("strong") --> false
       ==============================*/
    public static boolean beginsWithVowel(String w) {
	return isAVowel(w.substring(0,1));
    }
    
    /* ==================================
       pre: w.length() > 0
       post: engToPig("apple")  --> "appleway"
       engToPig("strong") --> "ongstray"
       engToPig("java")   --> "avajay"
       ====================================*/
    
    public static String engToPig(String w) {
        w = w.toLowerCase(); 
        String restr = "";
        int appender = w.indexOf(firstVowel(w)); //finds the first vowel
        String appended = w.substring(0, appender); //takes all the consonants (sounds) before the vowel, and turns it into a separate string the consonant sounds 
        if (beginsWithVowel(w)) {
            restr =  w + "way";
	}
        /* 
	   if (hasA(w, "y")) {
	   int x = w.indexOf("y");
	   if (x > 0 && !(isAVowel(x-1,x)) ) {
	   restr = w.substring(x) + w.substring(0,x) + "ay"
	   }
	   restr = w.substring(x) + w.substring(0,1) + "ay"; 
	   }
	*/
        if ((w.indexOf("qu")) == 0 ) {
            restr = w.substring(2) + "quay";
        }
        else {
            restr = w.substring(appender) + appended + "ay";
	}
	restr = restr.substring(0,1) + restr.substring(1);
	return restr; 
    }
        
                    
    public static void main( String[] args ) 
    {
	/* YOUR TEST CALLS HERE */
	System.out.println("Now testing hasA();");
	System.out.println(hasA("cat", "a")); //true
	System.out.println(hasA("cat", "p")); //false
	System.out.println("/------------------------------------- \n");

	System.out.println("Now testing isAVowel();");
	System.out.println(isAVowel("a")); //true
	System.out.println(isAVowel("z")); //false
	System.out.println(isAVowel("e")); //true
	System.out.println(isAVowel("x")); //false
	System.out.println("/------------------------------------- \n");

	System.out.println("Now testing countVowels():");
	System.out.println(countVowels("meatball")); //3
	System.out.println(countVowels("gargantuan")); //4
	System.out.println(countVowels("nymph")); //0
	System.out.println("/------------------------------------- \n");

	System.out.println("Now testing hasAVowel();");
	System.out.println(hasAVowel("cat")); //true
	System.out.println(hasAVowel("zzz")); //false
	System.out.println(hasAVowel("slavery")); //true
	System.out.println(hasAVowel("myth")); //false
	System.out.println("/------------------------------------- \n");
      
	System.out.println("Now testing allVowels();");
	System.out.println(allVowels("meatball")); //"eaa"
	System.out.println(allVowels("flibber")); //"ie"
	System.out.println(allVowels("lunchbox")); //"uo"
	System.out.println(allVowels("outrageous")); //"ouaeou"
	System.out.println("/------------------------------------- \n");
	
	System.out.println("Now testing firstVowels();");
	System.out.println(firstVowel("meatball")); //"e"
	System.out.println(firstVowel("flibber")); //"i"
	System.out.println("/------------------------------------- \n");
      
	System.out.println("Now testing beingsWithVowel();");
	System.out.println(beginsWithVowel("lunchbox")); //false
	System.out.println(beginsWithVowel("outrageous")); //true
	System.out.println(beginsWithVowel("Eatball")); //true
      	System.out.println("/------------------------------------- \n");
	
	System.out.println("Now testing engToPig();");
	System.out.println(engToPig("Yay")); //"ayyay"
	System.out.println(engToPig("Quail")); //"uailqay"
	System.out.println(engToPig("Outrageous")); //"outrageousway"
	System.out.println(engToPig("scholar")); //"olarschay"
     	System.out.println("/------------------------------------- \n");
      
    }//end main()

}//end class Pig
