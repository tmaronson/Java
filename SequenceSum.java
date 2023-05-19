
 // Complete the getSequenceSum function below.
    static long getSequenceSum(int i, int j, int k) {
        
        long sum = 0;
		/* could compute sums with n(n + 1)/2 but need various cases if i, j negative so loops easy.
		Also we must adjust sum in formula for sequences that don't start at 1. But this is not hard.
		The formula has to be adjusted for i, j > 0; i, j < 0, i < 0 and j > 0.
		Then there is the issue of the sign of k, positive or negative. But Big(O)
		would be improved over the loops. Could be O(1).
		Below solution is about O(j - i + j - k) or O(Cn).
		*/
        for(int n = i; n <= j; n++) {
            sum += n;
        }
        for(n = j - 1; n >= k; n--) {
            sum += r;
        }
        return sum;
    }
