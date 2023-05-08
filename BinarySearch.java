
public class BinarySearch {
	public static boolean binarySearch(int arr[], int left, int right, int key) {
		
		if(right <= left) return false;
		int mid = left + (right - left)/2;
		int cmp = arr[mid] - key;  
		if(cmp > 0) return binarySearch(arr, left, mid, key);
		else if(cmp < 0) return binarySearch(arr, mid + 1, right, key);
		else return true; // found key
	}
}