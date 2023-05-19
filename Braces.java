

import java.util.Scanner;

// HR is not correct as their original stub code has String return type instead of boolean.
class Parser{
    static boolean isBalanced(String s) 
    {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '{' || c == '(') {  // two sets of block characters () and {}
                st.push(c);
                continue;
            }
            if(c == '}') { 
                if(st.empty() || st.pop() != '{')
				return false; // stack is empty but String still has } or next char not opening {
            }
            if(c == ')') {
                if(st.empty() || st.pop() != '(')
                    return false; // stack is empty but String still has ) or next char not opening (
            }
        }
        if(st.empty()) {
           return true;
        }
        return false;
    }
}

public class StackFindBalancedParens {
	
	public static void main(String[] args) {
		Parser parser = new Parser();
        
		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {
			System.out.println(parser.isBalanced(in.next()));
		}
        
		in.close();
	}
}

               
               
               
               