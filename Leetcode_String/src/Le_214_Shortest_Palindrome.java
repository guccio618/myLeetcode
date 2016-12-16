
public class Le_214_Shortest_Palindrome {
	/*************************************************/
	// by other, nice!!!
	public String shortestPalindrome(String s) {
		int j = 0;
		
	    for (int i = s.length() - 1; i >= 0; i--) {
	        if (s.charAt(i) == s.charAt(j)) { 
	        	j++; 
	        }
	    }
	    
	    if (j == s.length()) {
	    	return s; 
	    }
	    
	    String suffix = s.substring(j);
	    return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    }
	
	
	
	/*************************************************/
	// by Jackie, TLE                             
	public String shortestPalindrome2(String s) {
		if(s == null || s.length() == 0){
			return s;
		}
		
		int len = s.length();
		boolean[][] memo = getMemo(s);
		int leftNum = 0, rightNum = 0;
		
		for(int i = 0; i < len; i++){
			if(memo[0][i] == true){
				leftNum = i + 1;
			}
		}
		
		for(int i = len - 1; i >= 0; i--){
			if(memo[i][len - 1] == true){
				rightNum = len - i;
			}
		}
		
		if(leftNum > rightNum){
			String part2 = s.substring(leftNum);
			StringBuilder builder = new StringBuilder(part2);
			builder.reverse();
			return builder.toString() + s;
		} else {
			String part1 = s.substring(0, len - rightNum);
			StringBuilder builder = new StringBuilder(part1);
			builder.reverse();
			return s + builder.toString();
		}
	}
	
	public boolean[][] getMemo(String s){
		int len = s.length();

		boolean[][] memo = new boolean[len][len];
		
		for(int i = 0; i < len; i++){
			memo[i][i] = true;
		}
		
		for(int i = 0; i < len - 1; i++){
			memo[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
		}
		
		for(int length = 2; length < len; length++){
			for(int start = 0; start + length < len; start++){
				int end = start + length;
				memo[start][end] = memo[start + 1][end - 1] && s.charAt(start) == s.charAt(end);
			}
		}
		
		return memo;
	}
	


	/*************************************************/
	// by Jackie, but exceed time limit
	public String shortestPalindrome3(String s) {
        if(s == null || s.length() == 0){
            return new String();
        } else if(isPalindrome(s) == true){
            return s;
        }
        
        int n = s.length();
        int leftNum = 0, rightNum = 0;
        
        for(int end = n; end > 0; end--){
            if(isPalindrome(s.substring(0, end)) == true){
                leftNum = end;
                break;
            }
        }
        
        for(int start = 0; start < n; start++){
            if(isPalindrome(s.substring(start)) == true){
                rightNum = n - start;
                break;
            }
        }
        
        if(leftNum > rightNum){
            String part1 = s.substring(0, leftNum);
            String part2 = s.substring(leftNum);
            StringBuffer builder = new StringBuffer(part2);
            builder.reverse();
            builder.append(part1).append(part2);
            return builder.toString();
        } else {
            String part1 = s.substring(n - rightNum);
            String part2 = s.substring(0, n - rightNum);
            StringBuffer builder = new StringBuffer(s);
            StringBuffer builder2 = new StringBuffer(part2);
            builder2.reverse();
            builder.append(builder2);
            System.out.println(builder.length());
            return builder.toString();
        }
    }
    
    public boolean isPalindrome(String str){
        int left = 0, right = str.length() - 1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    
    
    
    
    public static void main(String[] args){
    	Le_214_Shortest_Palindrome t = new Le_214_Shortest_Palindrome();
    	String s = "abcd";
    	System.out.println(t.shortestPalindrome2(s));
    }
}
