
public class Q482_License_Key_Formatting {
	// test case: [------] [k = 100] -> "",  [2] [k = 2] -> s
	public String licenseKeyFormatting(String s, int k) {
		if(s == null || s.length() == 0 || k <= 0) {
            return s;
        } 
		
        StringBuilder sb = new StringBuilder();
        
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '-') {
                sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));  // the number of character in current group is n !!!
            }
        }
        
        return sb.reverse().toString().toUpperCase();
    }
	
	
	
	
	
	
	
	
	
	
	
	
	/********************************* main function *****************************************/
	
	public static void main(String[] args) {
		Q482_License_Key_Formatting t = new Q482_License_Key_Formatting();
		String S = "2-4A0r7-4k";
		int K = 3;
		System.out.println(t.licenseKeyFormatting(S, K));
	}
}
