
public class Le_043_Multiply_Strings {
	// by other, nice!
	public String multiply(String num1, String num2) {
		if(num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0){
            return new String();
        }
        
        int len1 = num1.length(), len2 = num2.length();
        int[] digits = new int[len1 + len2];
        StringBuilder builder = new StringBuilder();
        int sum = 0;
        int multiply = 0;
        
        for(int i = len1 - 1; i >= 0; i--){
            for(int j = len2 - 1; j >= 0; j--){
                int x = i + j;
                int y = i + j + 1;
                
                multiply = (int) (num1.charAt(i) - '0') * (int) (num2.charAt(j) - '0');
                sum = multiply + digits[y];       // 往前进1， 此时的digits[y]等于之前的digits[x]，相当于flag进位 ！！！
                digits[x] += sum / 10;            // 均为对digits[x]操作 ！！！
                digits[y] = sum % 10;
            }
        }
        
        for(int digit : digits){
            if(builder.length() == 0 && digit == 0){     // 开始位置为0，不往stringbuilder里加，防止 99 * 0 会得到 000的结果 ！！！
                continue;
            }
            
            builder.append(digit);
        }
        
        return builder.length() == 0 ? "0" : builder.toString();
    }
}
