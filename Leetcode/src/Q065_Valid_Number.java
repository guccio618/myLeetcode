
public class Q065_Valid_Number {
	// by other
	
	// test case: 
    // blank in front or back -> valid
    // blank in the middle
    // more than one dot
    // more than one e
    // has e after dot
    // need to have num before e
    // +, - should be put before all the number
    // invalid input: 6 + 1
    // valid input: 11e+6
    
    
    public boolean isNumber(String s) {
		if(s == null || s.length() == 0){
            return false;
        }
        
        s = s.trim();
        int len = s.length();
        boolean hasE = false, hasDot = false;
        boolean hasNum = false, hasNumAfterE = true;
        
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            
            if(Character.isDigit(c)) {
                hasNum = true;
                hasNumAfterE = true;
            } else if(c == '.') {
                if(hasDot || hasE) {
                    return false;
                }
                
                hasDot = true;
            } else if(c == 'e') {
                if(hasE || !hasNum) {
                    return false;
                }
                
                hasE = true;
                hasNumAfterE = false;
            } else if(c == '+' || c == '-') {
                if(i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        
        return hasNum && hasNumAfterE;
    }
	
	
	
	public static void main(String[] args){
		Q065_Valid_Number t = new Q065_Valid_Number();
		String str = "0e123";
		System.out.println(t.isNumber(str));
	}
}
