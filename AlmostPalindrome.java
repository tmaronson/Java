
import java.util.Stack;

public class Challenge {
  public static boolean almostPalindrome(String str) {
		
		Stack<Character> stack = new Stack<>();
		int len = str.length();
		char charFwd = ' ';
		char charBwd = ' ';
		for(int i = 0, j = len - 1; i < (len - 1)/2; i++, j--) {
			charFwd = str.charAt(i);
			charBwd = str.charAt(j);
			stack.push(charFwd);
			// Avoid exception if trying to pop empty stack.
			if(charFwd == charBwd && !stack.empty()) {
				stack.pop();
			}
		}
		// One char left in stack if just one character diff in palindrome
		if(stack.size() == 1) return true;
		return false;
  }
}