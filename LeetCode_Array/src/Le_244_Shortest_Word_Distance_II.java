import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Le_244_Shortest_Word_Distance_II {
	private Map<String, List<Integer>> map;

    public Le_244_Shortest_Word_Distance_II(String[] words) {
        if(words == null || words.length == 0){
            return ;
        }
        
        map = new HashMap<String, List<Integer>>();
        for(int i = 0; i < words.length; i++){
            if(map.containsKey(words[i])){
                map.get(words[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        if(!map.containsKey(word1) || !map.containsKey(word2)){
            return 0;
        }
        
        int ans = Integer.MAX_VALUE;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        
        for(int i : list1){
            for(int j : list2){
                ans = Math.min(ans, Math.abs(i - j));
            }
        }
        
        return ans;
    }
}
