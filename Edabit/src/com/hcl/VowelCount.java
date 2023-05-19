package com.hcl;

/* This is not the best application to apply recursion but 
 * just going by requirements on Edabit. This takes on sort of an
 * iterative approach also but can't really help it with String as parameter.
 */
public class VowelCount {
	
	static int i = 0;
	public static int countVowels(String str) {
		
		if(str.length() == 0) 
			return 0;
		if(i == str.length() - 1) { // base case
			//i = 0; // must reset since static and will be index out of range with further calls
			return isVowel(str.charAt(str.length() - 1));
		}
		return isVowel(str.charAt(i++)) +  countVowels(str);
				
	}
	
	static int isVowel(char c) {
		
		if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
			return 1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		
		String s = "bbbab";
		System.out.println(VowelCount.countVowels(s));
	}
}
