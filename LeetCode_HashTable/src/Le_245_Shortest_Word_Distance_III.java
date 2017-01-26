import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*******
 * 
This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
word1 and word2 may be the same and they represent two individual words in the list.

For example,
	Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
	Given word1 = “makes”, word2 = “coding”, return 1.
	Given word1 = "makes", word2 = "makes", return 3.

Note:
	You may assume word1 and word2 are both in the list.
	
 * 
 * */

public class Le_245_Shortest_Word_Distance_III {
	// solution 1: using classification discussion
	public int shortestWordDistance(String[] words, String word1, String word2) {
        if(words == null || words.length == 0 || word1 == null || word2 == null) {
            return 0;
        }
        
        int minDistance = Integer.MAX_VALUE;
        
        if(!word1.equals(word2)) {
            Map<String, Integer> map = new HashMap<>();
            
            for(int i = 0; i < words.length; i++) {
                if(words[i].equals(word1)) {
                    if(map.containsKey(word2)) {
                        minDistance = Math.min(minDistance, i - map.get(word2));
                    }
                } else if(words[i].equals(word2)) {
                    if(map.containsKey(word1)) {
                        minDistance = Math.min(minDistance, i - map.get(word1));
                    }
                } 
            
                map.put(words[i], i);
            }
        } else {
            int prevPos = -1;
            
            for(int i = 0; i < words.length; i++) {
                if(words[i].equals(word1)) {
                    if(prevPos != -1) {
                        minDistance = Math.min(minDistance, i - prevPos);
                    }
                    
                    prevPos = i;
                }
            }
        }
        
        return minDistance;
    }
	
	
	
	// solution 2:
	public int shortestWordDistance2(String[] words, String word1, String word2) {
        if(words == null || words.length == 0){
            return 0;
        }
        
        int len = words.length;
        int pos1 = -1, pos2 = -1;
        int minLen = Integer.MAX_VALUE;
        
        for(int i = 0; i < len; i++){
            if(words[i].equals(word1)){
                if(word1.equals(word2)){
                    if(pos1 != -1){
                        minLen = Math.min(minLen, i - pos1);
                    }
                } else {
                    if(pos2 != -1){
                        minLen = Math.min(minLen, i - pos2);
                    }
                }
                
                pos1 = i;
            } else if(words[i].equals(word2)){
                if(pos1 != -1){
                    minLen = Math.min(minLen, i - pos1);
                }
                
                pos2 = i;
            }
        }
        
        return minLen;
    }
	
	
	
	
	
	
	
	
	
	
	
	/****************************** main function **********************************/
	// by Jackie, 分类讨论
	public int shortestWordDistance3(String[] words, String word1, String word2) {
        if(words == null || words.length == 0){
            return 0;
        }
        
        if(word1.equals(word2)){
            return sameHelper(words, word1);
        } else {
            return diffHelper(words, word1, word2);
        }
    }
    
    
    public int diffHelper(String[] words, String word1, String word2){
        int n = words.length;
        int flag = 0;
        int position1 = 0, position2 = 0;
        int ans = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            if(words[i].equals(word1)){
                position1 = i;
                if(flag == 2){
                    ans = Math.min(ans, position1 - position2);
                }
                flag = 1;
            }
            if(words[i].equals(word2)){
                position2 = i;
                if(flag == 1){
                    ans = Math.min(ans, position2 - position1);
                }
                flag = 2;
            }
        }
        
        return ans;
    }
    
    public int sameHelper(String[] words, String word){
        int n = words.length;
        int last = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            if(words[i].equals(word)){
                if(last == Integer.MAX_VALUE){
                    last = i;
                } else {
                    ans = Math.min(ans, i - last);
                    last = i;
                }
            }
        }
        
        return ans;
    }
    
    
    
    // by Jackie using hashmap
    public int shortestWordDistance4(String[] words, String word1, String word2) {
        if(words == null || words.length == 0){
            return 0;
        }
        
        int ans = Integer.MAX_VALUE;
        int n = words.length;
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        
        for(int i = 0; i < n; i++){
            if(map.containsKey(words[i])){
                map.get(words[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(words[i], list);
            }
        }
        
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        
        for(int i : list1){
            for(int j : list2){
                if(i != j){
                    ans = Math.min(ans, Math.abs(i - j));
                }
            }
        }
        
        return ans;
    }
    
    
    
    
    
    
    public static void main(String[] args){
    	Le_245_Shortest_Word_Distance_III t = new Le_245_Shortest_Word_Distance_III();
    	String[] words = {"a", "a"};
    	System.out.println(t.shortestWordDistance(words, "a", "a"));
    }
}
