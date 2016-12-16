/***********************************************
 * 罗马数字左加右减原则
 *
 ***********************************************/


public class Le_013_Roman_to_Integer {
	public int romanToInt(String s) {
        if (s == null || s.length()==0) {
	    	return 0;
	    }
	    
	    int[] hash = new int[256];
	    hash[(int)('I')] = 1;
	    hash[(int)('V')] = 5;
	    hash[(int)('X')] = 10;
	    hash[(int)('L')] = 50;
	    hash[(int)('C')] = 100;
	    hash[(int)('D')] = 500;
	    hash[(int)('M')] = 1000;
	    int n = s.length();
	    char[] letters = s.toCharArray();
	    int ans = hash[(int)letters[n - 1]];
	    
	    for(int i = n - 2; i >= 0; --i){
	        if(hash[(int)letters[i + 1]] <= hash[(int)letters[i]]){
	            ans += hash[(int)letters[i]];
	        } else {
	            ans -= hash[(int)letters[i]];
	        }
	    }
	    
	    return ans;
    }
}
