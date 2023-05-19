/* 7/11 test cases pass
 at least O(n^4) complexity */

public static int palindrome(String s) {
    // Write your code here
        Set<String> subs = new HashSet<>();
        for(int i = 0; i < s.length() - 1; i++) {
            for(int j = i + 1; j <= s.length(); j++) {
                String substr = s.substring(i, j);
                if(subs.contains(substr)) {
                    continue;
                }
                String strRev = new StringBuilder(substr).reverse().toString(); // compare to reverse String
                if(strRev.equals(substr)) {
                    subs.add(substr);
                }
                substr = null;
                strRev = null;
            }
        }
        return subs.size();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Result.palindrome(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


 /* 11/11 test cases pass
  O(n) complexity  This is Manacher's Algorithm
*/
  public static int palindrome(String input) {
    String formattedInput = "@" + input + "#";
    char inputCharArr[] = formattedInput.toCharArray();
    int radius[][] = new int[2][input.length() + 1];
    
    Set<String> palindromes = new HashSet<>();
    int max;
    for (int j = 0; j <= 1; j++) {
        radius[j][0] = max = 0;
        int i = 1;
        while (i <= input.length()) {
            palindromes.add(Character.toString(inputCharArr[i]));
            while (inputCharArr[i - max - 1] == inputCharArr[i + j + max])
                max++;
            radius[j][i] = max;
            int k = 1;
            while ((radius[j][i - k] != max - k) && (k < max)) {
                radius[j][i + k] = Math.min(radius[j][i - k], max - k);
                k++;
            }
            max = Math.max(max - k, 0);
            i += k;
        }
    }
      for (int i = 1; i <= input.length(); i++) {
        for (int j = 0; j <= 1; j++) {
            for (max = radius[j][i]; max > 0; max--) {
                palindromes.add(input.substring(i - max - 1, max + j + i - 1));
            }
        }
      }
      return palindromes.size();  
  }
}

// another method that works and passes all tests
 public static int palindrome(String s) {
         Set<String> set = new HashSet<String>();
            for (int i = 0; i < s.length(); i++) {
                // odd length palindrome
               search(s, i, i, set);
               
                // even length palindrome
               search(s, i, i + 1, set);
              
            }
        return set.size();
        
       
    }
 private static void search(String a, int start, int last, Set<String> set) {
            while (start >= 0 && last <= a.length() - 1 && a.charAt(start) == a.charAt(last)) {

                set.add(a.substring(start, last + 1));
                start--;
                last++;

            }
        }
        

}


