import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/******
 * 
An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example: 
Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> 
false

isUnique("cart") -> 
true

isUnique("cane") -> 
false

isUnique("make") -> 
true

 * 
 * */

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
