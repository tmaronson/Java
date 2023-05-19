package com.hcl;

public class LongDigits {
	
	public static int digitsCount(long n) {
		
		if(n/10 == 0)
			return 1;
		else 
			return digitsCount(n/10) + 1;
	}
}
