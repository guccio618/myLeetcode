/***********************************************
 * 从大往小移动
 *
 ***********************************************/

public class Le_012_Integer_to_Roman {
	public String intToRoman(int num) {
        if(num < 0){
            return "";
        }
        
        StringBuilder builder = new StringBuilder();
        int[] nums = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		int digit = 0;
		
		while(num > 0){
		    int time = num / nums[digit];
		    num -= nums[digit] * time;
		    for(int i = 0; i < time; i++){
		        builder.append(symbols[digit]);
		    }
		    digit++;
		}
		
		return builder.toString();
    }
}
