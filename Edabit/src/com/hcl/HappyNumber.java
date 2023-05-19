package com.hcl;

import static java.lang.Math.*;

public class HappyNumber {

    int result = 0;
	static boolean newCalc = true;
	public static void main(String[] args) {
		System.out.println(new HappyNumber().isHappy(36368));

	}
		
	private boolean isHappy(int i) {
		getSum(i);
		System.out.println("result = " + result);
		if(result == 1)
			return true;
		if(result == 4 )
			return false;
		else
			return false;
		
	}

	/* Method could be coded in another way to use a data structure to check sums for
	 more than one value of the same sum. Also, return type of int and boolean type
	 for method above could be integrated better maybe.
	*/
	private int getSum(int i) {
		System.out.println("result = " + result + " " + " i = " + i);
		if(result == 1 && i == 1) { // base cases
			return 1;
		}
		if(result == 4 && i == 4) { 
			return 4;
		}
		 
		if(newCalc)
			result = 0; // start new calculation
		result += pow(i % 10, 2);
		
		if(i < 10) {
			newCalc = true;
			return getSum(result); // reached the end of summing this number
		}
		else {
			newCalc = false;
			return (result + getSum(i/10));  // get the next digit to the left for this number
		}
		
	}

}
