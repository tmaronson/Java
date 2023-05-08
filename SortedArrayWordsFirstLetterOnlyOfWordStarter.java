import java.util.*;

/*
This works for first char of word only.
Would use streams but wanted to show if others did
not know about Stream interface.
*/
public class WordList {
	
	public static boolean isSorted(String[] w, String l) {
		
		
		char c = 'a';
		int strAlphbt = 0;
		List<Integer> lst = new ArrayList<>();
		for(int i = 0; i < w.length; i++) {
			c = w[i].charAt(0);  // account for more than first character
			strAlphbt = l.indexOf(c); // find index of char in alphabet
			lst.add(strAlphbt);
		}
		List <Integer> lstSort = new ArrayList<>(lst);
		Collections.sort(lstSort);
		System.out.println(lst);
		System.out.println(lstSort);
		return lst.equals(lstSort);
		
		
}