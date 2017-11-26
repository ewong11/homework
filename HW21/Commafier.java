//Eric Wong
//APCS1 - Pd2
//HW21 - Karmacomma
//2017-10-23
public class Commafier {
    
    /* using a for loop to add a comma after every 
    three numbers - reconstructs string starting from the back of the orig string */
    
    public static String commafyF(int x) {
        String retStr = "";
        String str = Integer.toString(x);
        for(;str.length() > 3;) {
            retStr = "," + str.substring(str.length() -3) + retStr;
            str = str.substring(0, str.length() -3);
        }
        retStr = str + retStr;
        return retStr;
    }
    
    /* uses recursion to add a comma affter every 3 numbers from the back
    adds commas starting from the back; divides by 1000 for each recursive call to the function
    to a get a number 3 digits less */
    public static String commafyR(int x) {
        String str = Integer.toString(x);
        if (str.length() > 3) {
           str = commafyR(x/1000) + "," + str.substring(str.length() -3);
        }

        return str;
    }
    
    public static void main(String[]args) { 
     //---------------------------TEST CASES-------------------
        System.out.println(commafyF(434534235));
        System.out.println(commafyR(123456));
        System.out.println(commafyR(0));
        System.out.println(commafyF(123456));
        System.out.println(commafyF(300));
        System.out.println(commafyF(0));
        
    // using a foreach loop (fyF) - same as the commafyR method, except no need to convert 
    // int input into a string, because input is already a string
     for (String str :args) {
        String retStr = "";
        for(;str.length() > 3;) {
            retStr = "," + str.substring(str.length() -3) + retStr;
            str = str.substring(0, str.length() -3);
        }
        retStr = str + retStr;
        System.out.println( retStr);
        
    }
    // using a foreach loop (fyR)
    // same as commafyR method, except we change the String input into a string
    for (String str: args) {
        int x = Integer.parseInt(str);
        if (str.length() > 3) {
           str = commafyR(x/1000) + "," + str.substring(str.length() -3);
        }
        
        System.out.println( str);
    }}}