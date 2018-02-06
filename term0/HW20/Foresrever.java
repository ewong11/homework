//Eric Wong
//APCS1 Pd2
//HW20 - For the Love of Strings
//2017-10-19

public class Foresrever {
    
    //uses the for loop to construct a "fence"
    
    public static String fenceF(int posts) {
        String fence = "|";
        if (posts == 0) {
            fence = "";
            return fence;
        }
        for(int count = posts; count > 0; count --) {
            fence += "--|";
        }
        return fence;
    }
    
    // uses the for loop to reverse a String
    
    public static String reverseF(String s) {
        String retStr = "";
        int length = s.length();
        for(int count = 0; count != length; count ++) {
            retStr += s.substring(s.length()-1);
            s = s.substring(0, s.length()-1);
        }
        return retStr;
    }
    
    //uses recursion to reverse a string
    public static String reverseR(String s) {
        if (s.length() == 1) { //base case
            return s;
        }
        else {
        return s.substring(s.length() -1) + reverseR(s.substring(0, s.length() -1));
        }
        
    }
    
    
    public static void main(String[] args) {
        System.out.println(fenceF(3));
        System.out.println(reverseF("hello"));
        System.out.println(reverseR("hello"));
    }
}