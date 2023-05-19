
mport java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'efficientJanitor' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts FLOAT_ARRAY weight as parameter.
     */

    // Max bags for a trip = 2 since 3*1.01 > 3. Sort List and add low, high for each bag pair.
    public static int efficientJanitor(List<Float> weight) {
        
        Collections.sort(weight);
        int lo = 0;
        int hi = weight.size() - 1;
        int trips = 0;
        while(lo < hi) {
            if( (weight.get(lo) + weight.get(hi)) <= 3.00) {
                hi = hi - 1;  // will form a pair  
                lo = lo + 1;
            } else { // can take a pair of garbage bags
               hi = hi - 1;
            }
            trips++; // update trips regardless of pair or not
            if(lo == hi) {
                trips += 1; // add a trip when equal
            }
    
        }
        return trips;
        
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int weightCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Float> weight = IntStream.range(0, weightCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Float::parseFloat)
            .collect(toList());

        int result = Result.efficientJanitor(weight);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

        /*Collections.sort(weight);
        int trips = 0;
        outer: for(int i = 0; i < weight.size(); i++) {
            for(int j = weight.size() - 1; j > i; j--) {
                //System.out.printf("%d  %f \n", trips,  weight.get(i) + weight.get(j));
                if(weight.get(i) + weight.get(j)) <= 3.00) {
                       trips++;
                       weight.remove(i);
                       weight.remove(j);
                       //System.out.printf("%d  %d ", trips,  i);
                       continue outer;
                    
                }
              
             }
            weight.remove(i);
            
            trips += 2;
            //System.out.println(trips);
           
        }
        return trips;
    }
    */
        
        


