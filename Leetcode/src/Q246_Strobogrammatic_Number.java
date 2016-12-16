import java.util.HashMap;
import java.util.Map;


public class Q246_Strobogrammatic_Number {
	public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) {
            return false;
        }
        
        String str1 = "01689";
        String str2 = "01986";
        String str3 = "018";
        int left = 0, right = num.length() - 1;
        
        while (left < right) {
            char digit1 = num.charAt(left);
            char digit2 = num.charAt(right);
            int index1 = str1.indexOf(digit1);
            
            if (index1 > -1) {
                if (digit2 != str2.charAt(index1)) {
                    return false;
                } else {
                    left++;
                    right--;
                }
            } else {
                return false;
            }
        }
        
        if (left == right) {
            return str3.indexOf(num.charAt(left)) != -1;
        } else {
            return true;
        }
    }
	
	public boolean isStrobogrammatic2(String num) {
        if(num == null || num.length() == 0){
            return false;
        } 
        
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        int left = 0, right = num.length() - 1;
        
        while(left < right){
            char c1 = num.charAt(left);
            char c2 = num.charAt(right);
            
            if(!map.containsKey(c1) || map.get(c1) != c2){
                return false;
            }
            
            left++;
            right--;
        }
        
        if(left == right){
            char c = num.charAt(left);
            return (c == '0' || c == '1' || c == '8');
        } else {
            return true;    
        }
    }
}
