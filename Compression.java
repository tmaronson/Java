import java.io.*;
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
     * Complete the 'compressedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING message as parameter.
	 
	 The code below is just a first guess and is not efficient.
	 9/14 test cases pass with all but one (maybe timeout here also) failing due to timeout.
     */

    public static String compressedString(String message) {
    // Write your code here
        
        char c = '|';
        char cPrev = '|';
        String strReturn = "";
        int count = 1;
        for(int i = 0; i < message.length(); i++) {
            cPrev = (i == 0) ? message.charAt(0) : message.charAt(i - 1);
            c = message.charAt(i);
            //System.out.printf("present %s, previous %s\n", c, cPrev);  //abaabbbc  ab2a3bc
            if((c == cPrev) && i != 0) { // char same as previous
               count++;
               continue;
           }
           if(count > 1){ // more than one consecutive char
                strReturn = strReturn + cPrev + count;
                count = 1;
               if(i == message.length() - 1) { // make sure we get last char if consecutive chars before final char
                   strReturn = strReturn + c;
               }
                continue;
            }
            if(i == message.length() - 1) {  // last char in String
                strReturn = strReturn + cPrev + c;
            }
            else if(i != 1) { // avoid printing first char in String twice
                strReturn = strReturn + cPrev;
                
            }
            count = 1;
        }
        if(count > 1) strReturn = c + new Integer(count).toString();
        return strReturn;
    }

}


class Result {
// below has same timeout problems but simpler.  9/14 tests pass
	public static String compressedString(String message) {
		String strReturn = "";
        int count = 1;
        int i = 0, j = 0;
        for(i = 0, j = i + 1; j < message.length(); i++, j++) {
            if(message.charAt(i) == message.charAt(j)) {
                count++;
                continue;
            }
            strReturn = count == 1 ? strReturn + message.charAt(j - 1) : strReturn + message.charAt(i) + count;
            count = 1;
        }
		// get last char in String
        if(count > 1) strReturn = message.charAt(i) + new Integer(count).toString();
        else strReturn += message.charAt(i);
        return strReturn;
	}
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String message = bufferedReader.readLine();

        String result = Result.compressedString(message);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


