//Eric Wong
//APCS1 pd2
//HW13 -- May ah Hahv S'maur, Please?
//2017-10-09
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
    
    //precondtion: takes two integers
    //postcondition: returns the integer arithmetic mean of the two numbers
    public static int mean(int a, int b){
	return ((a + b)/2);
    }

    //precondtion: takes two integers
    //postcondition: returns twothe double arithmetic mean of the two numbers 
    public static double mean(double a, double b) {
	return (a + b)/2;
    }

    //precondtion: takes two integers
    //postcondition: returns the highest integer
    public static int max(int a, int  b) {
	if (a > b) {
	    return a;
		}
	else {
	    return b;
		}
    }

    //precondtion: takes two doubles
    //postcondition: returns the highest double
     public static double max(double a, double  b) {
	if (a > b) {
	    return a;
		}
	else {
	    return b;
		}
    }

    //precondition: pass 2 integer parameters
    //postcondition: find the max value of the two values
    public static int geoMean(int a, int b) {
	return (int)Math.sqrt(a*b);
    }

    //precondition: pass 2 integer parameters
    //postcondition: find the max value of the two values
    public static double geoMean(double a, double  b) {
	return Math.sqrt(a*b);
    }
    //precondition: pass 3 integer parameters
    //postcondition: find the max value of the three values
    public static int max(int a, int b, int c) {
	if (Stats.max(a, b) < c) {
	    return c;
		}
	else {
	    return max(a, b);
	}
    }
   
    //precondition: pass 3 integer double parameters
    //postcondition: find the max value of the three values
   public static double max(double  a, double b, double c) {
	if (Stats.max(a, b) < c) {
	    return c;
		}
	else {
	    return max(a, b);
		}
    }

    // precondition: pass three integer parameters, of which the product has to be positive
    //postcondition: returns the geometric mean of the three integers
    public static int geoMean(int a, int b, int c) {
	return (int)Math.round(Math.pow(a*b*c, 1d/3));
    }

    // precondition: pass three double  parameters, of which the product of is positive
    //postcondition: returns the geometric mean of the three doubles
    public static double geoMean(double a, double  b, double c) {
	return Math.pow(a*b*c, (1d/3d));
    }
}
    
