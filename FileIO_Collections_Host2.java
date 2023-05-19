public class Solution {
    private static final Scanner scan = new Scanner(System.in);
    
    public static void main(String args[]) throws Exception {
        // read the string filename
        String filename;
        String line = null;
        filename = scan.nextLine();
        
        Map <String, Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        while((line = br.readLine()) != null) {
             String[] arrLine = line.split(" ");
             String host = arrLine[0];
              Integer reqs = map.get(host);
              if(reqs == null) {
                  map.put(host, 1);
              } else{
                   map.put(host, ++reqs);
              }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("records_" + filename));
        for(String host : map.keySet()) {
            writer.write(host + " " + map.get(host));
            writer.newLine();
        }
        writer.flush();
        writer.close();
        br.close();
        
    }
        
}
