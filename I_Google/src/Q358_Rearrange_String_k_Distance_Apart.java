/*******
 * 
Given a non-empty string str and an integer k, rearrange the string such that the same characters are at least distance k from each other.

All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

Example 1:
str = "aabbcc", k = 3

Result: "abcabc"

The same letters are at least distance 3 from each other.
Example 2:
str = "aaabc", k = 3 

Answer: ""

It is not possible to rearrange the string.
Example 3:
str = "aaadbbcc", k = 2

Answer: "abacabcd"

Another possible answer is: "abcabcda"

The same letters are at least distance 2 from each other.

 * 
 * */

public class Q358_Rearrange_String_k_Distance_Apart {
	// using Greedy, time complexity O(n)
	public String rearrangeString(String str, int k) {
        if(str == null || str.length() == 0 || k <= 0){
            return str;
        }
        
        int len = str.length();
        int[] letters = new int[256];
        int[] valid = new int[256];
        StringBuilder builder = new StringBuilder();
        
        for(int i = 0; i < len; i++){
            letters[str.charAt(i)]++;
        }

        for(int i = 0; i < len; i++){
            int candidate = getMaxFrequency(letters, valid, i);
            
            if(candidate == -1){
                return "";
            }
            
            letters[candidate]--;
            valid[candidate] = i + k;
            builder.append((char)(candidate));     // candidate is a char
        }
        
        return builder.toString();
    }
    
	// Greedy, find the max frequency character
    public int getMaxFrequency(int[] letters, int[] valid, int index){
        int maxFrequency = 0;
        int candidate = -1;
        
        for(int i = 0; i < 256; i++){
            if(letters[i] > maxFrequency && index >= valid[i]){
                maxFrequency = letters[i];
                candidate = i;
            }
        }
        
        return candidate;
    }
	
	
	
	
	// using backtrack, but TLE
	private String ans = "";
    
    public String rearrangeString2(String str, int k) {
        if(str == null || str.length() == 0 || k <= 0){
            return str;
        }
        
        int len = str.length();
        int[] letters = new int[256];
        int[] hash = new int[256];
        
        for(int i = 0; i < len; i++){
            letters[str.charAt(i)]++;
        }

        backtrack(letters, hash, "", k);
        return ans;
    }
    
    public void backtrack(int[] letters, int[] hash, String solution, int k){
        if(!ans.equals("")){
            return;
        } 
         if(isEmpty(letters)){
            ans = solution;
            return ;
        }
        
        char delChar = (solution.length() >= k) ? solution.charAt(solution.length() - k) : ' ';    
        
        if(delChar != ' '){
            hash[delChar]--;
        }

        for(int i = 0; i < 256; i++){
            if(letters[i] > 0 && hash[i] == 0){
                letters[i]--;
                hash[i]++;
                backtrack(letters, hash, solution + (char)(i), k);
                letters[i]++;
                hash[i]--;
                
                if(!ans.equals("")){
                    break;
                }
            }
        }
        
        if(delChar != ' '){
            hash[delChar]++;
        }
    }
    
    public boolean isEmpty(int[] letters){
        for(int i = 0; i < 256; i++){
            if(letters[i] > 0){
                return false;
            }
        }
        
        return true;
    }
    
    
    
    
    
    
    
    
    
    /***************************** main function **********************************/
    
    public static void main(String[] args){
    	Q358_Rearrange_String_k_Distance_Apart t = new Q358_Rearrange_String_k_Distance_Apart();
    	String str = "bbabcaccaaabababbaaaaccbbcbacbacacccbbcaabcbcacaaccbabbbbbcacccaccbabaccbacabcabcacb";
    	int k = 2;
    	   	
    	System.out.println(t.rearrangeString2(str, k));
    }
}
