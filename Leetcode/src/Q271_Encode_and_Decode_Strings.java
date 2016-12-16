import java.util.ArrayList;
import java.util.List;


public class Q271_Encode_and_Decode_Strings {
	// by other
	public String encode(List<String> strs) {
		if(strs == null || strs.size() == 0){
            return new String();
        }
        
        StringBuilder builder = new StringBuilder();
        
        for(String str : strs){
            builder.append(str.length()).append("/").append(str);
        }
        
        return builder.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
    	List<String> ans = new ArrayList<String>();
    	
        if(s == null || s.length() == 0){
            return ans;
        }
        
        int index = 0;
        int len = s.length();
        
        while(index < len){
            int position = s.indexOf("/", index);
            int size = Integer.valueOf(s.substring(index, position));
            String word = s.substring(position + 1, position + size + 1);
            ans.add(word);
            index = position + size + 1;
        }
        
        return ans;
    }
    
    
    
    public static void main(String[] args){
    	Q271_Encode_and_Decode_Strings t = new Q271_Encode_and_Decode_Strings();
    	List<String> list = new ArrayList<String>();
    	List<String> ans = new ArrayList<String>();
    	
    	list.add("stringA");
    	list.add("stringB");
    	list.add("stringC");
    	
    	String str = t.encode(list);
    	
    	System.out.println(str);
    	
    	ans = t.decode(str);
    	
    	for(int i = 0; i < ans.size(); i++){
    		System.out.print(ans.get(i) + " ");
    	}
    	
    	
    	
    }
}
