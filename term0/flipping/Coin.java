//Eric Wong
//APCS1 pd2
//HW15 -- Get it While You Can 
//2017-10-14

public class Coin {
    // instance variables
    public  double value;
    public String upFace;
    public String name;
    public int flipCtr;
    public int headsCtr;
    public int tailsCtr;
    public double bias;
    public int matchCtr;


    // default constructor
    public Coin() {
	value = 0.00;
	name = "denomiation";
        upFace = "heads";
        flipCtr = 0;
        headsCtr = 0;
        tailsCtr = 0;
        bias = .7;
	matchCtr = 0;
    }

    //1st overloaded constructor: parameter changes denomination of coin
    public Coin(String denom) {
	this();
	name = denom;
    }

    // 2nd overloaded constructor: parameters changes denomination and face
    public Coin(String denom, String face) {
	this();
        name = denom;
        upFace = face;
    }
    
    //main method
    public static void main(String[] args) {}

    //flip method that uses the previously determined bias to determine the likelihood of getting head
    public String flip() {
	double coinFlip = Math.random(); //new random double between 0.0 and 1.0
	//	System.out.println(bias);
	//	System.out.println(coinFlip);
	if (coinFlip < bias) { //compares bias and the new double from coinFlip
	    upFace = "heads";
	    headsCtr += 1;
	    flipCtr += 1;
	    return "heads";
	}
	else {
	    upFace = "tails";
	    tailsCtr += 1;
	    flipCtr += 1;
	    return "tails";
	}
    }
    //overwritten toString() that also prints out value to test assignValue
    public String toString() {
	String coinInfo = name + "---" + upFace;
	coinInfo += "\n" + value;
	return coinInfo;
    }
    //compares the faces of two different coins
    public boolean equals(Coin args) {
	return upFace.equals(args.upFace);
    }
    //assigns a monetary value to a coin based on its name
    public void assignValue() {
	if (name.equals("penny")) {
		value = .01;
	}
	if (name.equals("nickel")) {
		    value = .05;
	}
	if (name.equals("dime")) {
		    value = .1;
	}
	if (name.equals("quarter")) {
		    value = .25;
	}
    }

    public String  flipping(Coin coin, int numHeads) {
	while (headsCtr +  coin.headsCtr < numHeads) {
	    flip();
	    coin.flip();
    }
        String ret = "\nCoin 1 heads: " + headsCtr;
	ret = ret + "\nCoin 2 heads: " +coin.headsCtr;
	ret += "\nFlips Coin 1: " + flipCtr;
	ret += "\nFlips Coin 2: " + coin.flipCtr;
	return ret;
    }



    public String matching(Coin coin, int numMatches) {
	while (matchCtr < numMatches) {
	    flip();
	    coin.flip();
	    if ( equals(coin) ) {
		matchCtr += 1;
	    }
	}
	return "\nNumbr of flips for x matches: " + flipCtr;
    }

     public int match13000(Coin coin) {
	 while (matchCtr < 13000) {
	    flip();
	    coin.flip();
	    if (equals(coin)) {
		matchCtr += 1;
	    }
	}
	while (matchCtr%2001 != 0) {
	     flip();
	    coin.flip();
	    if (equals(coin)) {
		matchCtr += 1;
	    }
	}
	//return "\nNumbr of flips: " + flipCtr;
	return flipCtr;
     }
}
 
	    
	
