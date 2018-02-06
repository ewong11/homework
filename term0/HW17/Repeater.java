//Eric Wong
//APCS1 Pd2
//HW17 -- Do I repeat myself?
//2017/10/16

public class Repeater
{
    public static String fenceW (int numPosts ){
	String fence = "|";
	while (numPosts > 1){
	    fence += "--|";
	    numPosts -= 1;
	} // end loop
	return fence;
    } // end fenceR()
    
    
    public static String fenceR (int numPosts) {
        String fence = "|";
        while (numPosts > 1) {
           fence = fence + "--|";
           fenceR(numPosts -= 1);
        }
        return fence;
    }

    
    public static void main ( String[] args ){
	System.out.println(fenceR(1));
	System.out.println(fenceW(6));
    }
	
} // end class Repeater()
