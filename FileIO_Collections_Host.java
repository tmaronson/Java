
import java.util.stream.*;

public class Solution {
    private static final Scanner scan = new Scanner(System.in);
    
    public static void main(String args[]) throws Exception {
        // read the string filename
        String filename;
        String line = null;
        filename = scan.nextLine();
        
        List <String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        while((line = br.readLine()) != null) {
            String[] arrLine = line.split(" ");
            list.add(arrLine[0]);
        }
        
       Collections.sort(list);
       BufferedWriter writer = new BufferedWriter(new FileWriter("records_" + filename));
        Set<String> set = new HashSet<>(list);
        for(String host : set) {
            writer.write(host + " " + Collections.frequency(list, host));
            writer.newLine();
        }
        writer.flush();
        writer.close();
        br.close();
        
    }
}