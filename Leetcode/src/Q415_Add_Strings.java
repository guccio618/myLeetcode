
public class Q415_Add_Strings {
	public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) {
            return num2;
        } else if (num2 == null || num2.length() == 0) {
            return num1;
        }

        int flag = 0;
        int sum = 0;
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        StringBuilder builder = new StringBuilder();
        
        while (index1 >= 0 || index2 >= 0) {
            if (index1 >= 0 && index2 >= 0) {
                int digit1 = num1.charAt(index1) - '0';
                int digit2 = num2.charAt(index2) - '0';
                sum = digit1 + digit2 + flag;
                index1--;
                index2--;
            } else if (index1 >= 0 && index2 < 0) {
                int digit1 = num1.charAt(index1) - '0';
                sum = digit1 + flag;
                index1--;
            } else {
                int digit2 = num2.charAt(index2) - '0';
                sum = digit2 + flag;
                index2--;
            }
            
            flag = sum / 10;
            sum %= 10;
            builder.insert(0, sum);
        }
        
        if (flag == 1) {
            builder.insert(0, flag);
        }
        
        return builder.toString();
    }
}
