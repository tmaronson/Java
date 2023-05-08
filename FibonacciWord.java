
/*
This is not a good problem in the first place - very stupid!
*/

public class FibonacciWord {
	public static String generateWord(int n) {
    if (n < 2) {
      return "invalid";
    }
    StringBuilder sb = new StringBuilder();
    return generateFib(n, "b", "a", sb);
  }

  private static String generateFib(
      int n, String prevMinusOne, String prevMinusTwo, StringBuilder sb) {
    if (n == 0) { // return - base case for this function which is recursively called.
      return sb.toString().substring(0, sb.toString().length() - 2);
    }
    sb.append(prevMinusOne + ", ");
    String temp = prevMinusOne; // start and take previous String and then String before that - Fibonacci.
    prevMinusOne = prevMinusTwo;
    prevMinusTwo = prevMinusTwo + temp;
    return generateFib(--n, prevMinusOne, prevMinusTwo, sb);
  }
}