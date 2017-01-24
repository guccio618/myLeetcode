/*****
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. 
 * If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
 * You are responsible to gather all the input requirements up front.
 * 
 * */

public class Q008_String_to_Integer_atoi {
	/****************************************************
	 * 遇到非数字的字符串，只返回但前有效的数字
	 * 
	 ****************************************************/
	public int myAtoi(String str) {
	    if(str == null || str.length() == 0){
	        return 0;
	    }
	    
	    str = str.trim();
	    int len = str.length();
	    
	    if(len == 0){
	        return 0;
	    }
	    
	    int flag = 1;
	    char[] letters = str.toCharArray();
	    long sum = 0;
	    
	    for(int i = 0; i < len; i++){
	        if(Character.isDigit(letters[i])){
	            sum = sum * 10 + (int)(letters[i] - '0');
	            
	            if(sum > Integer.MAX_VALUE){        // 防止越界 ！！！
	                break;
	            }
	        } else if(i == 0 && letters[i] == '+'){
	            continue;
	        } else if(i == 0 && letters[i] == '-'){
	            flag = -1;
	        } else {
	            break;
	        }
	    }
	    
	    sum = flag * sum;
	    
	    if(sum > Integer.MAX_VALUE){
	        return Integer.MAX_VALUE;
	    } else if(sum < Integer.MIN_VALUE){
	        return Integer.MIN_VALUE;
	    } else {
	        return (int) sum;
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/********************************************************/

	public int myAtoi2(String str) {
        if(str == null || str.length() == 0) return 0;
        long sum = 0;
        str = str.trim();
        int flag = 1;
        int i = 0;
        char[] nums = str.toCharArray();
        if(nums[0] == '+' || nums[0] == '-'){
        	if(nums[0] == '-') flag = -1;
        	i = 1;
        }

        for(int len = nums.length; i < len; ++i){
        	if(nums[i] > '9' || nums[i] < '0') 
        	    break;
            sum = sum*10 + (int)(nums[i]-'0'); 
            if (flag == 1 && sum > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (flag == -1 && (-1) * sum < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }      
        return (int) sum * flag;
    }
	
	
	public static void main(String[] args){
		Q008_String_to_Integer_atoi t = new Q008_String_to_Integer_atoi();
		System.out.println(t.myAtoi("9223372036854775809"));   // test case: "+1", "-1", "  -0012a42", "2147483648", "-2147483648", "      -11919730356x"
	}
}
