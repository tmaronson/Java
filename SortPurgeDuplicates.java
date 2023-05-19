

import java.util.*;

public class Program {
	public static Integer[] uniqueSort(int[] nums) {
		
		Arrays.sort(nums);
		Set<Integer> set = new TreeSet<>();
		for(Integer i : nums) {
			set.add(i);
		}
		Integer[] arr = set.stream().toArray(Integer[]::new);
		return arr;
	}
}