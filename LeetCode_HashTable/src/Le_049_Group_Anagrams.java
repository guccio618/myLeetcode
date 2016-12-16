import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/******
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note: All inputs will be in lower-case.

 * 
 * 
 * */

public class Le_049_Group_Anagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> ans = new ArrayList<List<String>>();
	    
	    if(strs == null || strs.length == 0){
	        return ans; 
	    }
	    
	    Map<String, List<String>> map = new HashMap<String, List<String>>();
	    
	    for(String str : strs){
	        String orderStr = getOrderStr(str);
	        
	        if(map.containsKey(orderStr)){
	            map.get(orderStr).add(str);
	        } else {
	            List<String> list = new ArrayList<String>();
	            list.add(str);
	            map.put(orderStr, list);
	        }
	    }
	    
	    for(Map.Entry<String, List<String>> entry : map.entrySet()){
	        ans.add(entry.getValue());
	    }
	    
	    return ans;
    }
    
	public String getOrderStr(String str){
	    char[] letters = str.toCharArray();
	    Arrays.sort(letters);
	    return new String(letters);
	}
    
    
    
    
	
	/************************ main function ***************************/
	
    public static void main(String[] args){
    	Le_049_Group_Anagrams t = new Le_049_Group_Anagrams();
    	String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    	List<List<String>> res = t.groupAnagrams(strs);
    	
    	for(int i = 0; i < res.size(); ++i){
    		for(int j = 0; j < res.get(i).size(); ++j){
    			System.out.print(res.get(i).get(j) + ", ");
    		}
    		System.out.println();
    	}
    }
}
