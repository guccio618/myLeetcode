import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Q249_Group_Shifted_Strings {
	public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ans = new ArrayList<List<String>>();
        
        if (strings == null || strings.length == 0) {
            return ans;
        }
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String word : strings) {
            String firstShiftedString = getFirstShifted(word);
            
            if (map.containsKey(firstShiftedString)) {
                map.get(firstShiftedString).add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(firstShiftedString, list);
            }
        }
        
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> list = entry.getValue();
            Collections.sort(list);
            ans.add(list);
        }
        
        return ans;
    }
    
    public String getFirstShifted(String target){
        char[] letters = target.toCharArray();
        int len = letters.length;
        int diff = letters[0] - 'a';
        
        for (int i = 0; i < len; i++) {
            int curDiff = letters[i] - 'a' - diff;
            
            if (curDiff >= 0) {
                letters[i] -= diff;
            } else {
                letters[i] = (char) (curDiff + 26 + 'a');
            }
        }
        
        return new String(letters);
    }
    
    
    
    public static void main(String[] args){
    	Q249_Group_Shifted_Strings t = new Q249_Group_Shifted_Strings();
    	String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
//    	String[] strings = {"az", "ba"};
    	List<List<String>> ans = t.groupStrings(strings);
    	
    	for(int i = 0; i < ans.size(); i++){
    		for(int j = 0; j < ans.get(i).size(); j++){
    			System.out.print(ans.get(i).get(j) + ", ");
    		}
    		System.out.println();
    	}
    }
}
