import java.util.*;
/******
 * 
Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
	The length of num is less than 10002 and will be ≥ k.
	The given num does not contain any leading zero.

Example 1:
	Input: num = "1432219", k = 3
	Output: "1219"
	Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:
	Input: num = "10200", k = 1
	Output: "200"
	Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:
	Input: num = "10", k = 2
	Output: "0"
	Explanation: Remove all the digits from the number and it is left with nothing which is 0.

 * 
 * */


public class Q402_Remove_K_Digits {
	// test case: [9] [1],  [112] [1],  k == num.length()
	
	// solution 1: using stack, time is O(n), space is O(n)
	public String removeKdigits(String num, int k) {
        if(num == null || num.length() == 0 || k < 0) {
            return num;
        } else if(k == num.length()) {
            return "0";
        }
        
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        
        for(char c : num.toCharArray()) {
            while(!stack.isEmpty() && c < stack.peek() && count < k) { 
                stack.pop();
                count++;
            }
            
            if(c == '0' && stack.isEmpty()) {   // first character should not be "0" !!!
                continue;
            } else {
                stack.push(c);
            }
        }
        
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        
        return sb.length() == 0 ? "0" : sb.substring(0, sb.length() - (k - count));   // 防止test case: [112, 1]
	}
	
	
	
	// solution 2: using stringbuilder, time is O(n), space is O(1)
	public String removeKdigits2(String num, int k) {
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
	
	
	
	
	
	
	
	
	
	
	
	
	/***************************************** main function *******************************************/
	public String removeKdigits3(String num, int k) {
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
//		String num = "1234567890";
		String num = "1230456";
		int k = 3;
		System.out.println(t.removeKdigits(num, k));
	}
}
