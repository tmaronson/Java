
import java.util.*;

class Result {

    /*
     * Complete the 'minimizeBias' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY ratings as parameter.
     */

    public static int minimizeBias(List<Integer> ratings) {
        
        Collections.sort(ratings);
        int sum = 0;
        for(int i = 0; i < ratings.size(); i += 2) {
            sum += ratings.get(i + 1) - ratings.get(i);
        }
        return sum;
     }

}

// Use JavaScript for same problem.
 * Complete the 'minimizeBias' function below USING JAVASCRIPT.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY ratings as parameter.
 */

function minimizeBias(ratings) { 
    // Write your code here
   ratings.sort((a, b) => {return a - b}); // Must sort numerically using comparator type function instead of sorting by String type.
    var sum = 0;
    for(var i = 0; i < ratings.length; i += 2) {
        sum += ratings[i + 1] - ratings[i];
    }
    return sum;
}


