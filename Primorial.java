
import java.util.List;
import java.util.ArrayList;

public class Challenge {
	
	public static final int UPPER_LIMIT = 1000;
	
	public static int primorial(int n) {
		
		List<Integer> primes = new ArrayList<>();
		primes.add(2); // add only even prime
		for(int i = 3; i <= UPPER_LIMIT; i++) {
			// reached prime limit in list
			if(primes.size() == n) {
				break;
			}
				if(isPrime(i)) {
					primes.add(i);
				}
		}
		return calcProduct(primes);
  }
	
	public static boolean isPrime(int num) {
           if (num <= 1) {
               return false;
           }
           for (int i = 2; i <= Math.sqrt(num); i++) {
               if (num % i == 0) {
                   return false;
               }
           }
           return true;
    }
	
	static int calcProduct(List<Integer> primes) {
		int total = 1;
		for(int num : primes) {
			total *= num;
		}
		return total;
	}
}