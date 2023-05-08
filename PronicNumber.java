
public class PronicNumber {
	public static boolean isHeteromecic(int n) {
		double sqrtN = Math.sqrt(n);
		int smallerSqrt = (int)sqrtN - 1;
		int biggerSqrt = (int)sqrtN + 1;
		return (int)sqrtN*smallerSqrt == n || (int)sqrtN*biggerSqrt == n; 
	}
}