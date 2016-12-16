import java.util.HashSet;
import java.util.Set;


public class Q395_Longest_Substring_with_At_Least_K_Repeating_Characters {
	public int longestSubstring(String s, int k) {
        if(s == null || k <= 0){
            return 0;
        }
        
        int len = s.length();
        int maxLen = 0;      
        int front = 0, back = 0;
        Set<Character> set = buildSet(s, k);
        
        while(back < len){
        	while(front < len && set.contains(s.charAt(front))){
        		front++;
        	}
        	
        	int localMax = getMaxLen(s, back, front - 1, k);
        	maxLen = Math.max(maxLen, localMax);
        	front++;
        	back = front;
        }
        
        return maxLen;
    }
    
    public int getMaxLen(String s, int start, int end, int k){
		int[] hash = new int[256];
		int localMax = 0;
		Set<Character> numSet = new HashSet<Character>();
		int front = start, back = start;
		
		for(int i = start; i <= end; i++){
    		hash[s.charAt(i)]++;
    	}
		
		for(int i = 0; i < 256; i++){
			if(hash[i] > 0 && hash[i] < k){
				numSet.add((char) i);
				System.out.println("char = " + (char) i);
			}
		}
		
		while(back <= end){
			int[] validHash = new int[256];
			
			while(front <= end && !numSet.contains(s.charAt(front))){
				validHash[s.charAt(front)]++;
				front++;
			}
			
			if(isValid(validHash, k)){
				localMax = Math.max(localMax, front - back);
			}
			
			front++;
			back = front;
		}
		
		return localMax;
	}
	
	public Set<Character> buildSet(String s, int k){
		int[] hash = new int[256];
		Set<Character> set = new HashSet<Character>();
		
		for(char c : s.toCharArray()){
			hash[c]++;
		}
		
		for(int i = 0; i < 256;i ++){
			if(hash[i] >= k){
				set.add((char) i);
			}
		}
		
		return set;
	}
	
	public boolean isValid(int[] hash, int k){
		int count = 0;
		
		for(int i = 0; i < 256; i++){
			if(hash[i] > 0){
				count++;
			}
			
			if(hash[i] > 0 && hash[i] < k){
				return false;
			}
		}

		return count > 0;
	}
	
	
	
	
	
	public static void main(String[] args){
		Q395_Longest_Substring_with_At_Least_K_Repeating_Characters t = new Q395_Longest_Substring_with_At_Least_K_Repeating_Characters();
//		String s = "aaaaaaaaaaaaaaaabbbbbbbbbbbbaaaaaaabbbbbbbbbbbbcccccccccccdddddddddddddddddddeeeeeeeeeeeeeeefffffffffffffffgggggggggggggggggggghhhhhhhhhhhhhhhhiiiiiiiiiiiiiiiiiiiiiijjjjjjjjjjjjjjjjjjjjjjjjkkkkkkkkkkkkkkkkkkkk";
		String s = "ababacb";
		int k = 3;
		System.out.println(t.longestSubstring(s, k));
	}
}
