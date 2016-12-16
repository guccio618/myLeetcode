public class Q402_Remove_K_Digits {
	public String removeKdigits(String num, int k) {
        if(num.length() == k){
        	return "0";
        }
        
        int count = 0;
        StringBuilder builder = new StringBuilder();
        
        for(char c : num.toCharArray()){
        	while(builder.length() > 0 && builder.charAt(builder.length() - 1) > c && count < k){
        		builder.deleteCharAt(builder.length() - 1);
        		count++;
        	}
        	
        	if(builder.length() == 0 && c == '0'){
        		continue;
        	} else {
        		builder.append(c);
        	}
        }
        
        return builder.length() == 0 ? "0" : builder.substring(0, builder.length() - k + count); 
	}
	
	
	
	/*********************************************************/
	public String removeKdigits2(String num, int k) {
		if (k <= 0) {
			return num;
		} else if (k >= num.length()) {
			return "0";
		}

		String ans = num;

		for (int i = 0; i < k; i++) {
			ans = removeOneDigit(ans);
		}

		return ans;
	}
	
	public String removeOneDigit(String num) {
		int len = num.length();
		int index = len - 1;
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < len - 1; i++) {
			if (num.charAt(i) > num.charAt(i + 1)) {
				index = i;
				break;
			}
		}

		for (int i = 0; i < len; i++) {
			char c = num.charAt(i);

			if (builder.length() == 0 && c == '0' || i == index) {
				continue;
			}

			builder.append(c);
		}

		return builder.length() == 0 ? "0" : builder.toString();
	}
	
	
	
	/*********************************************************/
	public static void main(String[] args){
		Q402_Remove_K_Digits t = new Q402_Remove_K_Digits();
		String num = "1234567890";
		int k = 9;
		System.out.println(t.removeKdigits(num, k));
	}
}
