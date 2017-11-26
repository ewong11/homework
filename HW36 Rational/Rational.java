//Eric Wong
//APCS1 pd02
//HW36 -- Be Rationsl
//2017-11-18

public class Rational {
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
	String str = "";
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
    
    public static void main(String[] args) {
    // Test Cases --------------------------------------------------------------
    Rational r = new Rational(2,3);
    Rational s = new Rational(1,2);
    //Testing Methods
    //to String
    System.out.println("toString Test");
    System.out.println();
    System.out.println(r);
    System.out.println(s);
    System.out.println("----------------------------------------------------");
    //floatValue
    System.out.println("Float test");
    System.out.println();
    System.out.println(r.floatValue());
    System.out.println(s.floatValue());
    System.out.println("----------------------------------------------------");
    //multiply
    System.out.println("Multiply test");
    System.out.println();
    r.multiply(s);
    s.multiply(r);
    System.out.println("----------------------------------------------------");
    //divide
    System.out.println("Divide test");
    System.out.println();
    r.divide(s);
    s.divide(r);
    }
}
        
    
    
    
	
	
