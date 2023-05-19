import java.net.*;
import com.google.gson.*;


class Result {

    /*
     * Complete the 'getUsernames' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts INTEGER threshold as parameter.
     *
     * URL for cut and paste
     * https://jsonmock.hackerrank.com/api/article_users?page=<pageNumber>
     */

    public static List<String> getUsernames(int threshold) throws IOException {
        
        List<String> names = new ArrayList<>();
        
       
        
       /* Gson gson = new Gson();
        Type mapType = new TypeToken<Map<String, Map<String, String>[]>>(){}.getType();
        Map<String, Map<String, String>[]> map = gson.fromJson(jsonString, mapType);
        System.out.println(map);
        String username = map.get("data")[0].get("username");
        int numSubmitted = Integer.parseInt(map.get("data")[0].get("submission_count"));
        if(numSubmitted > 10) {
            names.add(username);
        } */
        
        String str = null, jsonString = "";
        URL url = new URL("https://jsonmock.hackerrank.com/api/article_users?page=1");
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        String line1 = br.readLine();
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(line1).getAsJsonObject() ; 
        int numPages = Integer.parseInt(json.get("total_pages").toString());
        for(int p = 1; p <= numPages; p++) {
            url = new URL("https://jsonmock.hackerrank.com/api/article_users?page=" + p);
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            str = null;
            jsonString = "";
            while((str = br.readLine()) != null) {
                jsonString += str;
            }
            json = parser.parse(jsonString).getAsJsonObject() ;
            JsonArray results = json.getAsJsonArray("data");
            for(int i = 0; i < results.size(); i++) {
                JsonObject result = results.get(i).getAsJsonObject(); 
                String name = result.get("username").getAsString(); // get returns JsonElement
                int numSubmits = Integer.parseInt(result.get("submission_count").getAsString());
                if(numSubmits > threshold) {
                    names.add(name.trim());
                }
            }
        }
                
        return names;

    }

}

