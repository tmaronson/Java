class Result {

    /*
     * Complete the 'minStart' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static long minStart(List<Integer> arr) {
    // Write your code here
        
                
        int x = 0;
        int i = 0;
        
        for(x = 1; x < 1e18; x++) {
            long sum = x;
            for(i = 0; i < arr.size(); i++) {
                sum += arr.get(i);
                if(sum < 1) {
                    // If you leave out the line below you will pass at least 3 tests. Why do I need it
                    x += Math.abs(sum) + 1;  // abs gets you to 0 so add 1 to get at least 1 per prob. stmt. 12/13 pass with 1 timeout test
                    break;
                }

            }
            if(i == arr.size()) {
                break;
            }
        }

        return x - 1;
    }

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(bufferedReader.readLine().trim());
            arr.add(arrItem);
        }

        long result = Result.minStart(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


}

