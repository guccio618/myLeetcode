import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


public class Q471_Top_K_Frequent_Words {
	// by Jackie
	protected class pair{
		public String word;
		public int frequency;
		
		public pair(String s, int f){
			word = s;
			frequency = f;
		}
	}
	
	public String[] topKFrequentWords(String[] words, int k) {
        if(words == null || words.length == 0 || k <= 0){
        	return new String[0];
        }
             
    	Comparator<pair> ListNodeComparator = new Comparator<pair>() {
        	public int compare(pair left, pair right) {
        		if(right.frequency == left.frequency){
        			return left.word.compareTo(right.word);
        		} else{
        			return right.frequency - left.frequency;
        		}
        	}
        };
        Queue<pair> heap = new PriorityQueue<pair>(10, ListNodeComparator);
        int len = words.length;
        
        Map<String, Integer> myMap = new HashMap<String, Integer>();
        
        for(int i = 0; i < len; ++i){
        	if(myMap.containsKey(words[i])){
        		myMap.put(words[i], myMap.get(words[i]) + 1);
        	} else {
        		myMap.put(words[i], 1);
        	}
        }
           
        Iterator iter = myMap.entrySet().iterator();
        while(iter.hasNext()){
        	Map.Entry entry = (Map.Entry) iter.next();
        	String word = (String) entry.getKey();
        	int fre = (int) entry.getValue();
        	heap.offer(new pair(word, fre));
        }
        
        String[] res = new String[k];
        for(int i = 0; i< k; ++i){
        	res[i] = heap.poll().word;
        }
        return res;
    }
	
	
	
	public static void main(String[] args){
		Q471_Top_K_Frequent_Words t = new Q471_Top_K_Frequent_Words();
		String[] words = {
		                   "yes", "lint", "code",
		                   "yes", "code", "baby",
		                   "you", "baby", "chrome",
		                   "safari", "lint", "code",
		                   "body", "lint", "code"			
						 };
		String[] res = t.topKFrequentWords(words, 4);
		
		for(int i = 0; i < res.length; ++i){
			System.out.print(res[i] + ", ");
		}
	}
}
