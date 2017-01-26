/*******
 * 
Given two binary strings, return their sum (also a binary string).

For example,
	a = "11"
	b = "1"
	Return "100".

 * 
 * */

public class Q067_Add_Binary {
	// solution 1:
	public String addBinary(String a, String b) {
        if(a == null){
            return b;
        } else if(b == null){
            return a;
        }
        
        int index1 = a.length() - 1;
        int index2 = b.length() - 1;
        char flag = '0';
        StringBuilder builder = new StringBuilder();
        
        while(index1 >= 0 || index2 >= 0){
            if(index1 >= 0 && index2 >= 0){
                char c1 = a.charAt(index1);
                char c2 = b.charAt(index2);
                
                if(c1 == '1' && c2 == '1'){
                    builder.insert(0, flag);
                    flag = '1';
                } else if(c1 == '1' || c2 == '1'){
                    builder.insert(0, flag == '1' ? '0' : '1');
                } else {
                    builder.insert(0, flag);
                    flag = '0';
                }
                
                index1--;
                index2--;
            } else if(index1 >= 0 && index2 < 0){
                char c1 = a.charAt(index1);
                
                if(c1 == '1'){
                    builder.insert(0, flag == '1' ? '0' : '1');
                } else {
                    builder.insert(0, flag);
                    flag = '0';
                }
                
                index1--;
            } else {
                char c2 = b.charAt(index2);
                
                if(c2 == '1'){
                    builder.insert(0, flag == '1' ? '0' : '1');
                } else {
                    builder.insert(0, flag);
                    flag = '0';
                }
                
                index2--;
            }
        }
        
        if(flag == '1'){
            builder.insert(0, flag);
        }
        
        return builder.toString();
    }
	
	
	
	// solution 2:
	public String addBinary2(String a, String b) {
        if(b.length() == 0) return a;
        if(a.length() == 0) return b;
        String res = "";
        int len = (a.length() > b.length()) ? a.length(): b.length(), cnt = 0, sum = 0;
        for(int i = 0; i < len; i++){
            if(i >= a.length())
                sum = b.charAt(b.length()-i-1) - '0' + cnt;
            else if(i >= b.length())
                sum = a.charAt(a.length()-i-1) - '0' + cnt;
            else
                sum = a.charAt(a.length()-i-1) - '0' + b.charAt(b.length()-i-1) - '0' + cnt;       
            if(sum > 1){
                cnt = 1;
                sum %= 2; 
            }
            else
                cnt = 0;
            res = (char)(sum + '0') + res;
        }
        if(cnt == 1) res = '1' + res;
        return res;
    }
	
	
	
	
	
	
	
	
	
	
	
	/**************************** main function *********************************/
	
	public static void main(String[] args){
		Q067_Add_Binary ab = new Q067_Add_Binary();
		String str1 = "10", str2 = "101111";
		System.out.println(ab.addBinary2(str1, str2));
	}
}
