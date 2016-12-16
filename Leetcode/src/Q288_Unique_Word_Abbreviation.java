import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Q288_Unique_Word_Abbreviation {
	private Map<String, Set<String>> map = new HashMap<String, Set<String>>();
    
    public Q288_Unique_Word_Abbreviation(String[] dictionary) {
        for(String word : dictionary){
            String abbrStr = getAbbreviation(word);
            
            if(map.containsKey(abbrStr)){
                map.get(abbrStr).add(word);
            } else {
                Set<String> set = new HashSet<String>();
                set.add(word);
                map.put(abbrStr, set);
            }
        }
    }

    public boolean isUnique(String word) {
        String abbrStr = getAbbreviation(word);
        
        if(!map.containsKey(abbrStr)){
            return true;
        } else {
            Set<String> set = map.get(abbrStr);
            
            if(set.size() > 1){
                return false;
            } else if(set.contains(word)){
                return true;
            } else {
                return false;
            }
        }
    }
    
    public String getAbbreviation(String word){
        if(word.length() <= 2){
            return word;
        } else {
            StringBuilder builder = new StringBuilder();
            builder.append(word.charAt(0)).append(word.length() - 2).append(word.charAt(word.length() - 1));
            return builder.toString();
        }
    }
}
