import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Q243_Shortest_Word_Distance {
	/****************************************************************/
	// by Jackie, time complexity is O(n)
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
	
	
	
	/****************************************************************/
	// by Jackie using hashmap, time complexity is O(n^2)
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
	
	public static void main(String[] args){
		Q243_Shortest_Word_Distance t = new Q243_Shortest_Word_Distance();
		String[] words ={"practice", "makes", "perfect", "coding", "makes"};
		System.out.println(t.shortestDistance(words, "coding", "makes"));
	}
}
