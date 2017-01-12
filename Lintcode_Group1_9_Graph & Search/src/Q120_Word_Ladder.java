import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class Q120_Word_Ladder {
	/***********************************************************/
	// by ninechapter
	public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null || dict.size() == 0) {
            return 0;
        }

        HashSet<String> hash = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        hash.add(start);
        
        int length = 1;          // 必须从1开始
        while(!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();     
                for (String nextWord: findWordRange(word, dict)) {
                    if (hash.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(end)) {
                        return length;
                    }
                    
                    hash.add(nextWord);
                    queue.offer(nextWord);
                }
            }
        }
        return 0;
    }
	
	public ArrayList<String> findWordRange(String word, Set<String> dict){
        ArrayList<String> wordList = new ArrayList<String>();
        char[] array = word.toCharArray();
        int len = word.length();
              
        for (int i = 0; i < len; i++) {
        	char temp = array[i];      //此步非常重要，因为每次只能改变一个位置，因此改动下一个位置时，需要还原前一位
            for (char k = 'a'; k <= 'z'; k++) {
                if(k == array[i]){
                    continue;
                }
                
                array[i] = k;
                String newWord = new String(array);
                if(dict.contains(newWord)){
                    wordList.add(newWord);
                }
            }
            array[i] = temp;         //此步非常重要，因为每次只能改变一个位置，因此改动下一个位置时，需要还原前一位
        }
        
        return wordList;
    }
	
    
	
	/***********************************************************/
	// by other
	public int ladderLength2(String start, String end, Set<String> dict) {
        // write your code here
        if(start == null || end == null || start.length() == 0 || end.length() == 0){
            return 0;
        }
    
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        dict.add(end);
        int step = 0;
        int len = start.length();
    
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String source = queue.poll();
                if (source.equals(end)){
                    return step;    
                } 
                char[] array = source.toCharArray();
                for (int j = 0; j < len; j++) {
                    for (char k = 'a'; k <= 'z'; k++) {
                        char temp = array[j];
                        array[j] = k;
                        String newStr = new String(array);
                        if (dict.contains(newStr)) {
                            dict.remove(newStr);
                            queue.add(newStr);
                        }
                        array[j] = temp;
                    }
                }
            }
        }
        return dict.contains(end) ? 0 : step;
	}
	
	
	public static void main(String[] args){
		Q120_Word_Ladder t = new Q120_Word_Ladder();
		Set<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		System.out.println(t.ladderLength("hit", "cog", set));
		System.out.println(t.ladderLength2("hit", "cog", set));
	}
}
