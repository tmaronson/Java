s
import java.util.Arrays;

public class Carriage {
	public static int findSeat(int n, int[] arr) {
		
		float carCap = n/arr.length;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i]/carCap <= 0.5) return i;
		}
		return -1;
	}
}		