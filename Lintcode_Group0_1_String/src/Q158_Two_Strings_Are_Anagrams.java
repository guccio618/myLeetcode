
public class Q158_Two_Strings_Are_Anagrams {
	// by Jackie
	public boolean anagram(String s, String t) {
        if(s == null || t == null){
            if(s != null || t != null){
                return false;
            } else{
                return true;
            }
        }
        if(s.length() != t.length()){
            return false;
        }
        
        int[] count = new int[127];
        int len = s.length();
        
        for(int i = 0; i < len; ++i){
            count[s.charAt(i)]++;
        }
        
        for(int i = 0; i < len; ++i){
            char c = t.charAt(i);
            if(count[c] > 0){
                count[c]--;
            } else{
                return false;
            }
        }
        
        return true;
    }
}
