
public class Q15_1_Longest_SubString {
	public int getLongestSubString(String str) {
		if(str == null || str.length() == 0) {
			return 0;
		}
		
		int len = str.length();
		int maxLen = 0;
		int[] hash = new int[2];
		
		for(int faster = 0, slower = 0; faster < len; faster++) {
			hash[str.charAt(faster) - '0']++;
			
			while(hash[0] > 0) {
				hash[str.charAt(slower++) - '0']--;
			}
			
			maxLen = Math.max(maxLen, faster - slower + 1);
		}
		
		return maxLen;
	}
	
	
	
	public int getLongestSubString_Follow_Up(String str, int k) {
		if(str == null || str.length() == 0) {
			return 0;
		}
		
		int len = str.length();
		int maxLen = 0;
		int[] hash = new int[2];
		
		for(int faster = 0, slower = 0; faster < len; faster++) {
			hash[str.charAt(faster) - '0']++;
			
			while(hash[0] > k) {
				hash[str.charAt(slower++) - '0']--;
			}
			
			maxLen = Math.max(maxLen, faster - slower + 1);
		}
		
		return maxLen;
	}
	
	
	
	
	
	
	
	
	
	
	/**************************** main function **********************************/
	
	public static void main(String[] args) {
		Q15_1_Longest_SubString t = new Q15_1_Longest_SubString();
		String str = "100001110111111001";
		System.out.println(t.getLongestSubString(str));
		System.out.println(t.getLongestSubString_Follow_Up(str, 2));
	}
}
