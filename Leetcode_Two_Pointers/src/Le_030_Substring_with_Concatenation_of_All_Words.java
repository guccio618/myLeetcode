import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**************************************
You are given a string, s, and a list of words, words, that are all of the same length. 
Find all starting indices of substring(s) in s that is a concatenation of each word in 
words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).

 * 
 * 
 * 应用类似hash[256]的方法
 * 字符用hash[256], string用hahsmap
 * 
 **************************************/

public class Le_030_Substring_with_Concatenation_of_All_Words {
	public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList();
        
        if(s == null || s.length() == 0 || words == null || words.length == 0) {
            return ans;
        }
        
        Map<String, Integer> map = new HashMap();
        int sLen = s.length();
        int wordLen = words[0].length();
        int wordNum = words.length;
        
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        for(int start = 0; start <= sLen - wordNum * wordLen; start++) {
            Map<String, Integer> copyMap = new HashMap(map);
            
            for(int j = 0; j < wordNum; j++) {
                String newWord = s.substring(start + j * wordLen, start + (j+1) * wordLen);
                
                if(copyMap.containsKey(newWord)) {
                    int count = copyMap.get(newWord);
                    
                    if(count == 1) {
                        copyMap.remove(newWord);
                        
                        if(copyMap.size() == 0) {
                            ans.add(start);
                            break;
                        } 
                    } else {
                        copyMap.put(newWord, count - 1);
                    }
                } else {
                    break;
                }
            }
        }
        
        return ans;
    }
}
