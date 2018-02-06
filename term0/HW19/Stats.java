//Eric Wong and Henry Carver - Talladega Mornings
//APCS1 pd2
//HW19 -- gcd 3 ways
//2017-10-18
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
    System.out.println(gcdER(15, 20));
    System.out.println(gcdER(25, 20));
    System.out.println(gcdER(1, 20));
    System.out.println(gcdER(0, 15));
    System.out.println(gcdEW(15, 20));
    System.out.println(gcdEW(10, 0));
    System.out.println(gcdEW(21, 6));
    System.out.println("-----" + 1%32);
    System.out.println(gcd(21, 6));
    System.out.println(gcd(8,32));
    System.out.println(gcd(0, 6));
    System.out.println(gcd(1, 6));
    System.out.println(gcd(28, 4));
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
   
    //doesnt work
    public static int gcd(int a, int b) {
        int div = 1;
        if (a == 0 || b ==0) {
            return 0;
        }
        while (div % Math.min(a, b) != 0 ) { //&& (max(a,b) % div == 0))){
            div += 1;
        }
        while (max(a,b) % div != 0) {
            div -=1; 
        }
        return div;
    }
    /*Euclid's Algorithm
    Euclid's Algorithm begins by seeing if a divides b, if it does, then the GCD is a. 
    Otherwise, subtract the minimum value from the maximum, and if the new number is 0, 
    then the minimum is the GCD. If the new number is not 0, subtract the new number again 
    from the minimum until a number gets to 0, and return the adjusted number.
     */
    public static int gcdER(int a, int b) {
        if (a == 0 || b ==0) {
            return 0;
        }
        if (a%b ==0) {
            return b;
        }
        else {
            return gcdER((max(a,b) - Math.min(a,b)), Math.min(a,b));
        }
    }
    public static int gcdEW(int a, int b) {
        if (a == 0 || b== 0) {
            return 0;
        }
        while ( a % b != 0) {
            a = (max(a,b) - Math.min(a,b));
            b = Math.min(a,b);
        }
        return Math.min(a,b);
        }
    }
    
