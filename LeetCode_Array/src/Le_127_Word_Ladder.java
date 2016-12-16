import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*******************************************************
 * Given two words (beginWord and endWord), and a 
 * dictionary's word list, find the length of shortest 
 * transformation sequence from beginWord to endWord, 
 * such that:
 *		Only one letter can be changed at a time
 *		Each intermediate word must exist in the word list
 ********************************************************/
public class Le_127_Word_Ladder {
	
	/***********************************************************/
	// by ninechapter using BFS of graph
	public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null || dict.size() == 0) {
            return 0;
        }

        HashSet<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        visited.add(start);
        dict.add(end);           // 必须把end加入dict
        
        int step = 1;          // 必须从1开始
        while(!queue.isEmpty()) {
            step++;
            int size = queue.size();  // 设置size,相当于层序遍历
            
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                
                for (String nextWord: findWordRange(word, dict)) {
                	if (nextWord.equals(end)) {
                        return step;
                    }
                    if (visited.contains(nextWord)) {
                        continue;
                    }
                    
                    visited.add(nextWord);
                    queue.offer(nextWord);
                }
            }
        }
        return 0;
    }
	
	public ArrayList<String> findWordRange(String word, Set<String> dict){
        ArrayList<String> wordList = new ArrayList<String>();
        char[] letters = word.toCharArray();
        int len = word.length();
              
        for (int i = 0; i < len; i++) {
        	char temp = letters[i];      //此步非常重要，因为每次只能改变一个位置，因此改动下一个位置时，需要还原前一位
            for (char k = 'a'; k <= 'z'; k++) {
                if(k == letters[i]){
                    continue;
                }
                
                letters[i] = k;
                String newWord = new String(letters);
                if(dict.contains(newWord)){
                    wordList.add(newWord);
                }
            }
            letters[i] = temp;         //此步非常重要，因为每次只能改变一个位置，因此改动下一个位置时，需要还原前一位
        }
        
        return wordList;
    }
	
	
	
	/***********************************************************/
	//by other using BFS of graph
	public static int ladderLength2(String beginWord, String endWord, Set<String> wordList) {
	    Queue<String> queue = new LinkedList<>();
	    queue.add(beginWord);
	    wordList.add(endWord);
	    int step = 0;
	    while (!queue.isEmpty()) {
	        step++;
	        int size = queue.size();
	        for (int i = 0; i < size; i++) {
	            String source = queue.poll();
	            if (source.equals(endWord)) return step;
	            char[] array = source.toCharArray();
	            for (int j = 0; j < source.length(); j++) { // select one bit and change it for another
	                for (char k = 'a'; k <= 'z'; k++) {     // character from "a" to "z"
	                    char temp = array[j];               // temp is used for recording the previous value of array[j] 
	                    array[j] = k;
	                    String newStr = new String(array);
	                    if (wordList.contains(newStr)) {
	                        wordList.remove(newStr);   // means this word has been visited and should be remove from wordList
	                        queue.add(newStr);
	                    }
	                    array[j] = temp;
	                }
	            }
	        }
	    }
	    return wordList.contains(endWord) ? 0 : step;
	}
	
	public static void main(String[] args){
		Le_127_Word_Ladder t = new Le_127_Word_Ladder();
		Set<String> wordList = new HashSet<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		System.out.println(t.ladderLength("hit", "cog", wordList));
	}
}
