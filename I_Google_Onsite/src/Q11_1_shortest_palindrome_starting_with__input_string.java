
public class Q11_1_shortest_palindrome_starting_with__input_string {
	public String shortestPalindromeStartWithInputString(String sourceStr, String targetStr) {
		if(sourceStr == null || targetStr == null) {
			return "";
		} else if(sourceStr.length() < targetStr.length()) {
			return "";
		}
		
		int sLen = sourceStr.length(), tLen = targetStr.length();
		
		for(int i = 0; i <= sLen - (tLen * 2 - 1); i++) {
			if(sourceStr.charAt(i) == targetStr.charAt(0)) {
				int j = 1;
				
				while(j < tLen && sourceStr.charAt(i + j) == targetStr.charAt(j)) {
					j++;
				}
				
				if(j == tLen) {
					String subStr1 = new StringBuilder(sourceStr.substring(i, i + tLen)).reverse().toString();
					int index1 = sourceStr.indexOf(subStr1);
					
					if(index1 == i + tLen) {
						return sourceStr.substring(i, i + tLen * 2);
					}
					
					String subStr2 = new StringBuilder(sourceStr.substring(i, i + tLen - 1)).reverse().toString();
					int index2 = sourceStr.indexOf(subStr2);
					
					if(index2 == i + tLen + 1) {
						return sourceStr.substring(i, i + tLen * 2 - 1);
					}
				}
			}
		}
		
		return "";
	}

	
	
	
	
	
	
	
	
	/****************************** main function **********************************/
	
	public static void main(String[] args) {
		Q11_1_shortest_palindrome_starting_with__input_string t = new Q11_1_shortest_palindrome_starting_with__input_string();
		String sourceStr = "abcdefggfed";
		String targetStr = "def";
		System.out.println(t.shortestPalindromeStartWithInputString(sourceStr, targetStr));
	}
}
