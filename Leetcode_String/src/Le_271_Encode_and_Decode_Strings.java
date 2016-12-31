import java.util.ArrayList;
import java.util.List;
/********
 * 
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}
Machine 2 (receiver) has the function:
vector<string> decode(string s) {
  //... your code
  return strs;
}
So Machine 1 does:

string encoded_string = encode(strs);
and Machine 2 does:

vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.

Note:
	The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized enough to work on any possible characters.
	Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
	Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.

 * 
 * */

public class Le_271_Encode_and_Decode_Strings {
	// 
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
    
    
    
    
    
    
    
    
    
    /********************** main function ****************************/
    
    public static void main(String[] args){
    	Le_271_Encode_and_Decode_Strings t = new Le_271_Encode_and_Decode_Strings();
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
