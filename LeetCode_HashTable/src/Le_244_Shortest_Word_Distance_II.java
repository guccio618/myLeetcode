import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*******
 * 
This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words 
and your method will be called repeatedly many times with different parameters. 
How would you optimize it?
Design a class which receives a list of words in the constructor, 
and implements a method that takes two words word1 and word2 and 
return the shortest distance between these two words in the list.

For example,
	Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
	Given word1 = “coding”, word2 = “practice”, return 3.
	Given word1 = "makes", word2 = "coding", return 1.

Note:
	You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
	
 * 
 * */

public class Le_244_Shortest_Word_Distance_II {
	private Map<String, List<Integer>> map;
    
    public Le_244_Shortest_Word_Distance_II(String[] words) {
        if(words == null || words.length == 0) {
            return ;
        }
        
        map = new HashMap<String, List<Integer>>();
        
        for(int i = 0; i < words.length; i++) {
            if(map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        if(!map.containsKey(word1) || !map.containsKey(word2)) {
            return 0;
        }
        
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int index1 = 0, index2 = 0;
        int minDistance = Integer.MAX_VALUE;
        
        while(index1 < list1.size() && index2 < list2.size()) {
            int num1 = list1.get(index1);
            int num2 = list2.get(index2);
            minDistance = Math.min(minDistance, Math.abs(num1 - num2));
            
            if(num1 < num2) {
                index1++;
            } else {
                index2++;
            }
        }
        
        return minDistance;
    }
}
