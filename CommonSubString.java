

    public static void commonSubstring(List<String> a, List<String> b) {
    // Write your code here
       
        OUTER: for(int i = 0; i < a.size(); i++) {
                String strA = a.get(i);
                char[] arrStr = strA.toCharArray();
                Arrays.sort(arrStr);
            for(int j = 0; j < b.get(i).length(); j++) {
                String strB = b.get(i);
                
                if(Arrays.binarySearch(arrStr, new Character(strB.charAt(j))) >= 0) {  // 18/18 test cases pass!
                //if(strA.contains(new Character(strB.charAt(j)).toString())) {  13/18 test cases pass
                    System.out.println("YES");
                    continue OUTER;
                }
            }
            System.out.println("NO");
        }
   }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> a = new ArrayList<>();

        for (int i = 0; i < aCount; i++) {
            String aItem = bufferedReader.readLine();
            a.add(aItem);
        }

        int bCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> b = new ArrayList<>();

        for (int i = 0; i < bCount; i++) {
            String bItem = bufferedReader.readLine();
            b.add(bItem);
        }

        Result.commonSubstring(a, b);

        bufferedReader.close();
    }
}


