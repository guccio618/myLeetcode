import java.util.*;

public class Q422_Valid_Word_Square {
	public boolean validWordSquare(List<String> words) {
        if(words == null || words.size() == 0) {
            return true;
        }
        
        int size = words.size();
        
        for(int x = 0; x < size; x++) {
            String word1 = words.get(x);
            
            for(int y = 0; y < word1.length(); y++) {
                if(y >= size) {
                    return false;
                }
                
                if(x == y) {
                    continue;
                }
                
                String word2 = words.get(y);
                char c1 = word1.charAt(y);
                
                if(x >= word2.length() || word2.charAt(x) != c1) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
