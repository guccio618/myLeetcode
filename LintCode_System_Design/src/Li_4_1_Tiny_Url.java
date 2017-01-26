import java.util.HashMap;


public class Li_4_1_Tiny_Url {
	private static int globalId = 0; 
    private HashMap<Integer, String> id2Url; 
    private HashMap<String, Integer> url2Id;
    
    public Li_4_1_Tiny_Url(){
        id2Url = new HashMap<Integer, String>();
        url2Id = new HashMap<String, Integer>();
    }
    
    /****************** long url to short url ****************/
    
    public String longToShort(String url) {
        if(url2Id.containsKey(url)){
            return "http://tiny.url/" + idtoShortKey(url2Id.get(url));
        } 
        globalId++;
        id2Url.put(globalId, url);
        url2Id.put(url, globalId);
        return "http://tiny.url/" + idtoShortKey(globalId);
    }
    
    public String idtoShortKey(int id){
        String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shortKey = "";
        
        while(id > 0){
            shortKey = chars.charAt(id % 62) + shortKey;
            id /= 62;
        }
        
        while(shortKey.length() < 6){
            shortKey = "0" + shortKey;
        }
        
        return shortKey;
    }

   
    /****************** short url to long url ****************/

    public String shortToLong(String url) {
        String shortKey = url.substring("http://tiny.url/".length());
        int id = shortKeytoId(shortKey);
        return id2Url.get(id);
    }
    
    public int shortKeytoId(String shortKey){
        int n = shortKey.length();
        int id = 0;
        for(int i = 0; i < n; ++i){
            id = id * 62 + toBase62(shortKey.charAt(i));
        }
        return id;
    } 
    
    public int toBase62(char c){
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10;
        }
        return c - 'A' + 36;
    }
}
