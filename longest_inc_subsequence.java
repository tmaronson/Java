
class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int len = 0; // longest inc. subsequence
        int[] p = new int[nums.length + 1];
        int[] x = new int[nums.length + 1]; // used if finding sequence
        int[] m = new int[nums.length + 1];
      for (int i = 0; i < nums.length; i++){ // for loop is n
    // Binary search for the largest positive j ≤ L
    // such that x[m[j]] < x[i]
        int lo = 1;
        int hi = len;
        while (lo <= hi) { // while loop is ~ log n so overall time complexity is n*logn.
           int mid = (int)Math.ceil((lo+hi)/2);
            if (nums[m[mid]] < nums[i])
                lo = mid + 1;
            else
                hi = mid - 1;
        }

    // After searching, lo is 1 greater than the
    // length of the longest prefix of x[i]
        int newL = lo;

    // The predecessor of x[i] is the last index of 
    // the subsequence of length newL-1
        p[i] = m[newL - 1];
        m[newL] = i;
    
        if (newL > len)        // If we found a subsequence longer than any we've
        // found yet, update len
            len = newL;

// Reconstruct the longest increasing subsequence
          /*int[] s = new int[len];
          int k = m[len];
          for (i = len-1; i> 0; i--) {
              s[i] = x[k];
              k = p[k];
          } */
        
      }
    return len;
    }
}