/*******
 * 
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:
	1. The length of both num1 and num2 is < 110.
	2. Both num1 and num2 contains only digits 0-9.
	3. Both num1 and num2 does not contain any leading zero.
	4. You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * 
 * */
public class Q043_Multiply_Strings {
	public String multiply(String num1, String num2) {
        if(num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0){
            return new String();
        }
        
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
        int sum = 0;
        int mul = 0;
        int x = 0, y = 0;
        StringBuffer builder = new StringBuffer();
        
        for(int i = m - 1; i >= 0; --i){
            for(int j = n - 1; j >= 0; --j){
                mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                x = i + j;
                y = i + j + 1;
                sum = mul + pos[y];
                
                pos[x] += sum / 10;
                pos[y] = sum % 10;
            }
        }
        
        for(int num : pos){
            if(builder.length() == 0 && num == 0){   // 防止 99 * 0 会得到 000的结果 ！！！
                continue;
            }
            
            builder.append(num);
        }
        
        return (builder.length() == 0) ? "0" : builder.toString();
    }
}
