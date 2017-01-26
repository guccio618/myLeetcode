import java.util.Iterator;
import java.util.StringTokenizer;


public class Li_6_1_Word_Count {
	public static class Map {
        public void map(String key, String value, OutputCollector<String, Integer> output) {
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            StringTokenizer tokenizer = new StringTokenizer(value);
            while (tokenizer.hasMoreTokens()) {
                String word = tokenizer.nextToken();
                output.collect(word, 1);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values, OutputCollector<String, Integer> output) {
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            int sum = 0;
            while (values.hasNext()) {
            	sum += values.next();
            }
            output.collect(key, sum);
        }
    }
    
    class OutputCollector<K, V> {
    	public void collect(K key, V value){
    		// Adds a key/value pair to the output buffer
    		
    	};
    }
}
