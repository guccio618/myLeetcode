import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class Q171_Anagrams {
	// by Jackie
	public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String>();
        if(strs == null || strs.length == 0){
            return res;
        }
        int len = strs.length;
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        
        for(int i = 0; i < len; ++i){
            char[] arrays = strs[i].toCharArray();
            Arrays.sort(arrays);
            String newStr = new String(arrays);
            if(map.containsKey(newStr)){
            	ArrayList<String> list = map.get(newStr);
            	list.add(strs[i]);
                map.put(newStr, list);
            } else{
            	ArrayList<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(newStr, list);
            }
        }
        
        for(ArrayList<String> list : map.values()){
        	if(list.size() > 1){
        		res.addAll(list);
        	}
        }
        
//        Iterator iter = map.entrySet().iterator();
//        while(iter.hasNext()){
//        	HashMap.Entry entry = (HashMap.Entry) iter.next();
//        	ArrayList<String> list = (ArrayList<String>) entry.getValue();
//        	if(list.size() > 1){
//        		res.addAll(list);
//        	}
//        }
        return res;
    }
}
