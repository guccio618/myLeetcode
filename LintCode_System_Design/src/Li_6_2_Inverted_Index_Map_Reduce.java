import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class Li_6_2_Inverted_Index_Map_Reduce {
	public static class Map {
        public void map(String _, Document value, OutputCollector<String, Integer> output) {
            int id = value.id;
            StringBuffer temp = new StringBuffer("");
            String content = value.content;
            int n = content.length();
            
            for (int i = 0; i < n; ++i) {
                if (content.charAt(i) == ' ') {
                    if (temp.length() > 0)
                        output.collect(temp.toString(), id);
                    temp = new StringBuffer("");
                } else {
                    temp.append(content.charAt(i));
                }
            }
            
            if (temp.length() > 0){
                output.collect(temp.toString(), id);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values, OutputCollector<String, List<Integer>> output) {
        	List<Integer> results = new ArrayList<Integer>();
            Set<Integer> set = new HashSet<Integer>();
            while (values.hasNext()) {
            	int id = values.next();
            	if(!set.contains(id)){
            		results.add(id);
            		set.add(id);
            	}          	
            }
            output.collect(key, results);
        }
    }
    
    class OutputCollector<K, V> {
    	public void collect(K key, V value){
    		// Adds a key/value pair to the output buffer
    		
    	};
    }
    
    class Document {
    	public int id;
    	public String content;
	}
}
