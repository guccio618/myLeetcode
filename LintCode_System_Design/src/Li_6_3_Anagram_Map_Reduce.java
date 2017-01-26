import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;


public class Li_6_3_Anagram_Map_Reduce {
	public static class Map {
        public void map(String key, String value, OutputCollector<String, String> output) {
            StringTokenizer tokenizer = new StringTokenizer(value);
            
            while (tokenizer.hasMoreTokens()) {
                String word = tokenizer.nextToken();
                String original = word;
                char[] chars = original.toCharArray();
                Arrays.sort(chars);
                String sorted = new String(chars);
                output.collect(sorted, word);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<String> values, OutputCollector<String, List<String>> output) {
            List<String> results = new ArrayList<String>();
            
            while (values.hasNext()) {
            	results.add(values.next());
            }
            
            output.collect(key, results);
        }
    }
    
    class OutputCollector<K, V> {
    	public void collect(K key, V value){
    		// Adds a key/value pair to the output buffer
    	};
	}
}
