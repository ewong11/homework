//Eric Wong
//APCS pd02
//HW46 -- Al<B> Sorted!
//2017-12-04

import java.util.ArrayList;

public class ALTester {

    public static void  populate(int[] nums, int lower, int upper) {
	for (int x=0; x < nums.length; x++) {
	    nums[x] = (int)(Math.random() * (upper-lower) + lower);
	}
    }
    
    public static void main(String[] args) {
    }
}
