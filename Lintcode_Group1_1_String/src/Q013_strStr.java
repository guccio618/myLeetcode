
public class Q013_strStr {
	public int strStr(String source, String target) {
        if(source == null || target == null || source.length() < target.length()){
            return -1;
        }
        if(source.length() == 0 || target.length() == 0){
            return 0;
        }
        
        int sLen = source.length();
        int tLen = target.length();
        
        for(int i = 0; i <= sLen - tLen; ++i){
            if(source.charAt(i) != target.charAt(0)){
                continue;
            }
            
            int j = 0;
            while(j < tLen && source.charAt(i + j) == target.charAt(j)){
                j++;
            }
            if(j == tLen){
                return i;
            }
        }
        
        return -1;
	}
}
