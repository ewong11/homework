//Eric Wong
//APCS1 pd2
//HW15 -- Get it While You Can 
//2017-10-14

public class Driver
{
    public static void main( String[] args )
    {

	//build Objects from blueprint specified by class Coin

	//test default constructor
        Coin mine = new Coin();

	//test 1st overloaded constructor
	Coin yours = new Coin( "quarter" );
  
	//test 2nd overloaded constructor
	Coin wayne = new Coin( "dollar", "heads" );
    
	/*
	//test toString() methods of each Coin
	System.out.println("mine: " + mine);
	System.out.println("yours: " + yours);
	System.out.println("wayne: " + wayne);

    
	//test flip() method
	System.out.println("\nAfter flipping...");
	yours.flip();
	wayne.flip();
	System.out.println("yours: " + yours);
	System.out.println("wayne: " + wayne);
    
	//test equals() method
	if ( yours.equals(wayne) ) 
	System.out.println( "Matchee matchee!" );
	else
	System.out.println( "No match. Firestarter you can not be." );
	//tests assignValue
	System.out.println("yours: " + yours);
	yours.assignValue();
	System.out.println("yours: " + yours);
*/

	int numHeads = 1000;
    while (yours.headsCtr +  wayne.headsCtr < numHeads) {
        yours.flip();
        wayne.flip();
	}
	
    String ret = "\nCoin 1 heads: " + yours.headsCtr;
	ret = ret + "\nCoin 2 heads: " + wayne.headsCtr;
	ret += "\nFlips Coin 1: " + yours.flipCtr;
	ret += "\nFlips Coin 2: " + wayne.flipCtr;
	System.out.println( ret);
	yours.flipCtr = 0;
	wayne.flipCtr = 0;
    

	//to test matches
	int matchCtr = 0;
	int numMatches = 1;
	while (matchCtr < numMatches) {
	    yours.flip();
	    wayne.flip();
	    if ( yours.equals(wayne) ) {
		matchCtr += 1;
	    }
	}
	matchCtr = 0;
	
	System.out.println("\nNumbr of flips for x matches: " + yours.flipCtr);
	wayne.flipCtr = 0;
	yours.flipCtr = 0;
	
	while (matchCtr < 13000) {
	    yours.flip();
	    wayne.flip();
	    if (yours.equals(wayne)) {
		matchCtr += 1;
	    }
	    else {
		matchCtr = matchCtr;
	    }
	while ((matchCtr % 2001.00) != 0) {
	    yours.flip();
	    wayne.flip();
	    if (yours.equals(wayne)) {
		matchCtr += 1;
	    }
	}
	}
        System.out.println("\nNumbr of matches: " + matchCtr);
	System.out.println(yours.flipCtr);

    }//end main()
}//end class
