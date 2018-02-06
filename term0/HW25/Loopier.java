//Eric Wong
//APCS1 pd2
//HW25 All Hallow's Eve
//2017-11-01

public class Loopier {
    // populates an existing array with randomly generated ints
    public static void  populate(int[] nums, int lower, int upper) {
	for (int x=0; x < nums.length; x++) {
	    nums[x] = (int)(Math.random() * (upper-lower) + lower);
	}
    }
//prints a string with the of the elements of the array parameter using a for each loop
    public static String arrayToString(int[] nums) {
	String retstr = "";
    for (int x: nums) {
        retstr += x + " ";
    }
    //using a regular for loop
/* 	for (int x = 0; x < nums.length; x++) {
	    retstr += nums[x] + " ";
	}
    */
	return retstr;
    }

    //returns the index of the target integer in an array
    //if the array does not contain the target, returns -1
    public static int linSearch(int [] a, int target) {
	int index = -1;
	for (int x =0; x < a.length; x++) {
	    if (a[x] == target) {
		index = x;
	    }
	}
	return index;
    }

    //recursive method to return the index of a target integer
    //in order the 'shorten' the array with every successive call to self, 
    //a new array must be created with one less memory allocation than before.
    //The values are filled in starting with index 1 of the original array
    //(meaning index 0 is removed)
    public static int linSearchR(int[] a, int target) {
	if (linSearch(a, target) == -1) {
        return -1;
    }
    if (a[0] != target) {
        int[] b = new int[a.length-1];
        for (int x = 0; x < a.length-1; x++) {
            b[x] = a[x+1];
        }
        return linSearchR(b, target) + 1;
    }
    return 0;    
    }
    
    //returns the number of times a target integer appears in the array
    public static int freq(int[] a, int target) {
	int count = 0;
	for (int index = 0; index < a.length; index++) {
	    if (a[index]== target ) {
		count += 1;
	    }
	}
	return count;
    }
    
    // returns the number of times a target integer appears in the array with
    // recursion
    public static int freqRec(int[] a, int target) {
        if (a.length == 0) {
            return 0;
       }
        if (a[0] == target) {
            int[] b = new int[a.length-1];
            for (int x = 0; x < a.length -1 ;x++) {
                b[x] = a[x+1];
            }
            return freqRec(b, target) + 1;
        }
    
        else {
            int[] b = new int[a.length-1];
            for (int x =0; x < a.length -1 ; x++) {
                b[x] = a[x+1];
            }
            return freqRec(b, target);
        }
    }
            
            
    

    public static void main(String[] args) {
	int [] array; //initializes a new array
	array = new int[3]; //allocates 50 blocks of memory for the array
	populate(array, 100, 120); //gives each element of the array a random value
    /*array[0] = 11;
    array[1] = 12;
    array[2] = 10;
    */
    // test case for each method
	System.out.println(arrayToString(array));
    System.out.println("---------find index of target-----------");
	System.out.println(linSearch(array, 12));
    System.out.println(linSearch(array, -1));
    System.out.println(linSearch(array, 0));
    System.out.println(linSearch(array, 103));
    System.out.println("---------find index of target (recursion)-----------");
    System.out.println(linSearchR(array, 12));
    System.out.println(linSearchR(array, 0));
    System.out.println(linSearchR(array, -1));
    System.out.println(linSearchR(array, 103));
    System.out.println("---------find frequency of target-----------");
	System.out.println(freq(array, -3));
    System.out.println(freq(array, 455));
    System.out.println(freq(array, 12));
    System.out.println("---------find frequency of target (recursion)-----------");
    System.out.println(freqRec(array, 11));
    System.out.println(freqRec(array, 111));
    System.out.println(freqRec(array, -11));
    }
}
	    
