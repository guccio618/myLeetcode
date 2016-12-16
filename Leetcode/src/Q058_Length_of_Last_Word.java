
public class Q058_Length_of_Last_Word {
	// by Jackie
	public int lengthOfLastWord(String s) {
		if(s == null || s.length() == 0){
            return 0;
        }
        
        s = s.trim();
        int n = s.length();
        for(int i = n - 1; i >= 0; i--){
            if(s.charAt(i) == ' '){
                return n - i - 1;
            }
        }
        
        return n;
    }
	
	
	
	/********************************************************/
	// by Jackie using regular express, a little bit slow
	public int lengthOfLastWord2(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        String[] strArray = s.split("\\s{1,}");
        if(strArray.length == 0){
        	return 0;
        }
        
        return strArray[strArray.length - 1].length();    
    }
	
	
	
	
	public static void main(String[] args){
		Q058_Length_of_Last_Word t = new Q058_Length_of_Last_Word();
		String str = "   Hello world   ";
		System.out.println(t.lengthOfLastWord2(str));
	}
}
