import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*******
 * 
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

 * 
 * */

public class Le_243_Shortest_Word_Distance {
	// solution 1: time complexity is O(n)
	public int shortestDistance(String[] words, String word1, String word2) {
		if(words == null || words.length == 0){
            return 0;
        }
        
        int len = words.length;
        int ans = Integer.MAX_VALUE;
        int pos1 = -1, pos2 = -1;

        for(int i = 0; i < len; i++){
            if(words[i].equals(word1)){
                if(pos2 > -1){
                    ans = Math.min(ans, i - pos2);    
                }
                pos1 = i;
            } else if(words[i].equals(word2)){
                if(pos1 > -1){
                    ans = Math.min(ans, i - pos1);
                }
                pos2 = i;
            }
        }        
        
        return ans;
    }
	
	
	
	// solution 2: using hashmap, time complexity is O(n^2)
	public int shortestDistance2(String[] words, String word1, String word2) {
        HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        for(int i = 0; i < words.length; i++){
            if(map.containsKey(words[i])){
                List<Integer> list = map.get(words[i]);
                list.add(i);
                map.put(words[i], list);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(words[i], list);
            }
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(int i : map.get(word1)){
            for(int j : map.get(word2)){
                ans = Math.min(ans, Math.abs(i - j));
            }
        }
        
        return ans;
    }
	
	
	
	
	
	
	
	
	/**************************** main function ********************************/
	
	public static void main(String[] args){
		Le_243_Shortest_Word_Distance t = new Le_243_Shortest_Word_Distance();
		String[] words ={"practice", "makes", "perfect", "coding", "makes"};
		System.out.println(t.shortestDistance(words, "coding", "makes"));
	}
}
