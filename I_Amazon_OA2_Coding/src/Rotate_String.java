
public class Rotate_String {
	public static boolean isRotation(String s1, String s2) {
		if(s1 == null || s2 == null) {
			if(s1 == null && s2 == null) {
				return true;
			} else {
				return false;
			}
		} else if(s1.length() != s2.length()) {
			return false;
		}
		
		int len = s1.length();
		
		for(int i = 0; i < len; i++) {
			if(s1.charAt(i) != s2.charAt(len - 1 - i)) {
				return false;
			}
		}
		
		return true;
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		String str1 = "ab";
		String str2 = "aa";
		System.out.println(isRotation(str1, str2));
	}
}
