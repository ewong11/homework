//Eric Wong
//APCS1 pd02
//HW36 -- Be More Rationsl
//2017-11-20

public class Rational implements Comparable{
    // instance variables
    private int num;
    private int denom;

    // default constructor
    public Rational() {
    }
    
    //overloaded constructor
    public Rational(int n, int d) {
	if (d != 0) {
	    num = n;
	    denom = d;
	}
	else{
	    num = 0;
	    denom = 1;
	    System.out.println("error: invalid value for denominator");
	}
    }
    //---------------------------------------------------------------
    //Methods
    //---------------------------------------------------------------
    
    //toString method
    public String toString() {
	return num + "/" + denom;
    }
    
    //returns the most precise floating point value of the number
    public double floatValue() {
	return (num * 1.0)/ (denom*1.0);
    }
    
    // takes one rational object and multiplies it with another
    public void multiply(Rational s) {
        int retNum = s.num * num;
        int retDem = s.denom * denom;
        String ans = retNum + "/" + retDem + " ";
        System.out.println("Final Answer: " + ans + s + " remains " + s.num + "/" + s.denom);
    }
    
    // takes one rational object and divides it with another
    public void divide(Rational s) {
        int retNum = s.num * denom;
        int retDem = s.denom * num;
        String ans = retNum + "/" + retDem + " ";
        System.out.println("Final Answer: "  + ans + s + " remains " + s.num + "/" + s.denom);
    }
    
    // adds two rationals

    public void add(Rational s) {
        int finalDenom = lcm(this.denom, s.denom);
        double ratio0 = (finalDenom*1.0)/denom;
        double ratio1 = (finalDenom*1.0)/s.denom;
        double finalNum = (double)num*ratio0 + (double)s.num*ratio1;
        System.out.println(finalNum + "/" + finalDenom);
        //System.out.println("denom: "+ denom + " x :" + ratio0 + " x1: " + ratio1 + " finalNum: " + finalNum);
        }
    //subtracts two rationals
    public void subtract(Rational s) {
        int finalD = lcm(this.denom, s.denom);
        int ratio0 = finalD/denom;
        int ratioB = finalD/s.denom;
        int finalN = num*ratio0 - s.num*ratioB;
        System.out.println(finalN + "/" + finalD);
    }
    
    // finds the lcm using gcd - helpful when adding and subtracting
    public static int lcm(int a, int b) {
        if (a==b) {
            return a;
        }
        else
        return (a*b)/ gcdR(a,b);
    }
    //finds the gcd of the num and denom of the Rational
    public int gcd() {
        return gcdR(num, denom);
    }
    
    //simplifies the rational
    public void reduce() {
        int gcd = this.gcd();
        num = num/gcd;
        denom = denom/gcd;
        //System.out.println(num + "/" + denom);      
    }
    
    //if the two Rationals are equal, return 0
    //if the calling number is bigger than parameter return 1
    //if the calling number is smaller than the parameter return -1
    public int compareTo(Rational s) {
        if (this.floatValue() == s.floatValue()) {
            return 0;
        }
        else if (this.floatValue() > s.floatValue()) {
            return 1;
        }
        else{ return -1;}
    }
    
    
    public static int gcdR( int a, int b){ // Does a recursive algorithm of GCD
        if (a % b == 0) {
                return b;
        }
        return gcdR( b, a%b);
}
         
    // gcd method note: first parameter has to be greater
    public static int gcdEW(int a, int b) {
        int counter = 1;
        int common = 1;
        int max;
        if (a > b) {
            max = a;
        }
        else {
            max =b;
        }
        while (counter < max) {
            if(a%counter == 0 && b%counter == 0) {
                common = counter;
                counter += 1;
            }
            else {
                counter += 1;
            }
        }
        return common;
    }

    
    
    public static void main(String[] args) {
	
	// Test Cases ----------------------------------------------------------
	Rational r = new Rational(2,3);
	Rational s = new Rational(1,2);
    Rational q = new Rational(4,2);
    Rational e = new Rational(4,4);
	/*
	//Testing Methods
	//to String
	System.out.println("toString Test");
	System.out.println();
	System.out.println(r);
	System.out.println(s);
	System.out.println("------------------------------------------------");
	//floatValue
	System.out.println("Float test");
	System.out.println();
	System.out.println(r.floatValue());
	System.out.println(s.floatValue());
	System.out.println("-------------------------------------------------");
	//multiply
	System.out.println("Multiply test");
	System.out.println();
	r.multiply(s);
	s.multiply(r);
	System.out.println("-------------------------------------------------");
	//divide
	System.out.println("Divide test");
	System.out.println();
	r.divide(s);
	s.divide(r);
	*/
    System.out.println("-------------------------------------------------");
    System.out.println("addition test");
	r.add(s);
    s.add(r);
    System.out.println("-------------------------------------------------");
    System.out.println("subtraction test");
    r.subtract(s);
    s.subtract(r);
    System.out.println("-------------------------------------------------");
    System.out.println("gcd test");
    System.out.println(r.gcd());
    System.out.println(s.gcd());
    System.out.println(q.gcd());
    System.out.println("-------------------------------------------------");
    System.out.println("reduce test");
    r.reduce();
    System.out.println(r);
    q.reduce();
    System.out.println(q);
    System.out.println("-------------------------------------------------");
    System.out.println("compareTo test");
    System.out.println(r.compareTo(s)); //1
    System.out.println(s.compareTo(r)); //-1
    System.out.println(e.compareTo(e)); //0
}
}
        
    
    
    
	
	
