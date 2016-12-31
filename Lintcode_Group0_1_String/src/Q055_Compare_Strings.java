
public class Q055_Compare_Strings {
	public boolean compareStrings(String s, String t) {
		// by Jackie
        if(t == null){
            return true;
        } else if(s == null && t != null){
            return false;
        } else if(t.length() > s.length()){
            return false;
        }
        
        int[] count = new int[127];
        int len1 = s.length();
        int len2 = t.length();
        
        for(int i = 0; i < len1; ++i){
            count[s.charAt(i)]++;
        }
        
        for(int i = 0; i < len2; ++i){
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
