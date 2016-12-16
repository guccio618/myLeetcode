
public class Le_005_Longest_Palindromic_Substring {
	// by other, time complexity is O(n)
	public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return new String();
        }
    
        int n = s.length();
        char[] letters = s.toCharArray();
        int index = 0;
        int maxLen = 1;
        int strHead = 0;
        
        while(index < n){
            if(n - index <= maxLen / 2){
                break;
            }
            
            int front = index, back = index;
            while(back + 1 < n && letters[back] == letters[back + 1]){
                back++;
            }
            
            index = back + 1;
            while(back + 1 < n && front - 1 >= 0 && letters[back + 1] == letters[front - 1]){
                back++;
                front--;
            }
            
            if(maxLen < (back - front + 1)){
                maxLen = back - front + 1;
                strHead = front;
            }
        }
        
        return s.substring(strHead, strHead + maxLen);
    }
	
	
	
	// by Jackie using DP, time complexity is O(n^2)
	public String longestPalindrome2(String s) {
        if(s == null || s.length() == 0){
            return new String();
        }
        
        int n = s.length();
        int front = 0, back = 1;
        boolean[][] memo = new boolean[n][n];
        
        for(int i = 0; i < n; i++){
            memo[i][i] = true;
        }
        for(int i = 0; i < n - 1; i++){
            memo[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
            if(memo[i][i + 1] == true){
                front = i;
                back = i + 2;
            }
        }
        
        for(int length = 2; length < n; length++){
            for(int start = 0; start + length < n; start++){
                memo[start][start + length] = memo[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length);
                if(memo[start][start + length] == true){
                    front = start;
                    back = start + length + 1;
                }
            }
        }
        
        return s.substring(front, back);
    }
}
