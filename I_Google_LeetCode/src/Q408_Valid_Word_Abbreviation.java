
public class Q408_Valid_Word_Abbreviation {
	// test case: [hi] [02] -> false,  [a] [1] -> true,  
	
	// using two pointers, time is O(n)
	public boolean validWordAbbreviation(String word, String abbr) {
        if(word == null || word.length() == 0 || abbr == null || abbr.length() == 0 || abbr.length() > word.length()) {
            return false;
        }
        
        int len1 = word.length(), len2 = abbr.length();
        int index1 = 0, index2 = 0;
        char[] letters1 = word.toCharArray();
        char[] letters2 = abbr.toCharArray();
        
        while(index1 < len1 && index2 < len2) {
            if(Character.isDigit(letters2[index2])) {
            	if(letters2[index2] == '0') {
            		return false;
            	}
            	
                int sum = 0;
                
                while(index2 < len2 && Character.isDigit(letters2[index2])) {
                    sum = sum * 10 + (letters2[index2] - '0');
                    index2++;
                }
                
                index1 += sum;   // 注意这里是 +sum !!!
            } else {
                if(letters1[index1++] != letters2[index2++]) {
                    return false;
                } 
            }
        }
        
        return index1 == len1 && index2 == len2;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	/********************************* main function **********************************/
	
	public static void main(String[] args) {
		Q408_Valid_Word_Abbreviation t = new Q408_Valid_Word_Abbreviation();
//		String word = "internationalization";
//		String abbr = "i12iz4n";
		String word = "a";
		String abbr = "1";
		
		System.out.println(t.validWordAbbreviation(word, abbr));
	}
}
