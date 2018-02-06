//Eric Wong
//APCS1 pd2
//HW12 -- stAtistically sPeaking
//2017-10-05
public class Stats {
    //Main test function
    public static void main(String[] args) {
	System.out.println(mean(4,6));
	System.out.println("------Expected 5-----");
	System.out.println(mean(4.75,4.25));
	System.out.println("------Expected 4.5-----");
	System.out.println(max(198, 45));
	System.out.println("------Expected 198-----");
	System.out.println(max(43.5, 43.45));
	System.out.println("------Expected 43.5-----");
	System.out.println(geoMean(4,4));
	System.out.println("------Expected 4-----");
	System.out.println(geoMean(4.7, 5.6));
	System.out.println("------Expected 5.130-----");
    }
    
    // finds the arithmetic mean of two integers
    public static int mean(int a, int b){
	return ((a + b)/2);
    }

    //finds the arithmetic mean of two doubles
    public static double mean(double a, double b) {
	return (a + b)/2;
    }

    //finds the max value between two integers
    public static int max(int a, int  b) {
	if (a > b) {
	    return a;
		}
	else {
	    return b;
		}
    }

    //finds the max value between two doubles
     public static double max(double a, double  b) {
	if (a > b) {
	    return a;
		}
	else {
	    return b;
		}
    }

    //finds the geometric mean between two integers
    public static int geoMean(int a, int b) {
	return (int)Math.sqrt(a*b);
    }

    //finds the geometric mean between two coubles
    public static double geoMean(double a, double  b) {
	return Math.sqrt(a*b);
    }
}
    
