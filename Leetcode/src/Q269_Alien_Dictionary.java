import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class Q269_Alien_Dictionary {
	// by other using topology sort
	public String alienOrder(String[] words) {
		if(words == null || words.length == 0){
            return "";
        }
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int len = words.length;
        Set<Character>[] graph = new Set[256];
        Queue<Character> queue = new LinkedList<Character>();
        StringBuilder builder = new StringBuilder();
        
        for(String word : words){
            for(char c : word.toCharArray()){
                map.put(c, 0);
            }
        }

        for(int i = 0; i < len - 1; i++){
            if(words[i].equals(words[i + 1])){
                continue;
            }
            
            int minLen = Math.min(words[i].length() , words[i + 1].length());
            
            for(int index = 0; index < minLen; index++){
                char c1 = words[i].charAt(index);
                char c2 = words[i + 1].charAt(index);
                
                if(c1 != c2){
                    if(graph[c1] == null){
                        graph[c1] = new HashSet<Character>();
                    }
                    
                    if(!graph[c1].contains(c2)){
                        graph[c1].add(c2);
                        map.put(c2, map.getOrDefault(c2, 0) + 1);
                    }
                    
                    break;
                }
                
                if (words[i].charAt(minLen - 1) == words[i + 1].charAt(minLen - 1) && minLen < words[i].length()) {
                    return "";
                }
            }
        }
        
        for(char c : map.keySet()){
            if(map.get(c) == 0){
                queue.offer(c);
            }
        }
        
        while(!queue.isEmpty()){
            char node = queue.poll();
            builder.append(node);
            
            if(graph[node] == null){
                continue;
            }
            
            for(char next : graph[node]){
                int count = map.get(next);
                
                if(count == 1){
                    queue.offer(next);
                } else {
                    map.put(next, count - 1);
                }
            }
        }
        
        if(builder.length() == map.size()){
            return builder.toString();    
        } else {
            return "";
        }
    }

	
	
	
	public static void main(String[] args){
		Q269_Alien_Dictionary t = new Q269_Alien_Dictionary();
		String[] words = {
				"wrt",
				  "wrf",
				  "er",
				  "ett",
				  "rftt"
		};
		
		System.out.println(t.alienOrder(words));
	}
}
