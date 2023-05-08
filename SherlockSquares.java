
import static java.lang.Math.*;

/*import java.util.stream.IntStream;
import java.util.stream.Collectors;
*/

//import java.util.List;

public class Challenge {
	
  public static int squares(int a, int b) {
		/* Both Streams method and for loop method are correct 
		but some tests time out. These solutions are more instructive 
		from a programming viewpoint.
		/*List<Integer> lst = getNumbersUsingRange(a, b);
		long count = lst.stream()
			.filter(i -> i % sqrt(i) == 0)
			.count();
			*/
		/*for (int i = a; i <= b; i++) {
			if(i % sqrt(i) == 0) count++;
		} */
		int count = (int)(floor(sqrt(b)) - ceil(sqrt(a)) + 1);
		return count;
  }
	
	/*
	public static List<Integer> getNumbersUsingRange(int start, int end) {
    return IntStream.range(start, end + 1)
      .boxed()
      .collect(Collectors.toList());
	}
	*/
}