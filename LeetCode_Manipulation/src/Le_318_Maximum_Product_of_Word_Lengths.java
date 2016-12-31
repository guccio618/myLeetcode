
public class Le_318_Maximum_Product_of_Word_Lengths {
	/********************************************************************/
	// by other using Bit Manipulation， nice!!!
	public int maxProduct(String[] words) {
        int[] checker = new int[words.length];
        int max = 0;
        
        // populating the checker array with their respective numbers
        for (int i = 0; i < checker.length; i++) {
            int num = 0;
            for (int j = 0; j < words[i].length(); j++) {
                num |= 1 << (words[i].charAt(j) - 'a');   // 标记上0-26中的某一个字母出现过
            }
            checker[i] = num;
        }

        for (int i = 0, len = words.length; i < len-1; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((checker[i] & checker[j]) == 0) // checking if the two strings have common character
                    max = Math.max(max, words[i].length() * words[j].length());
            }
        }  
        return max;
    }
	
	
	
	/*************************************************************************/
	// by Jackie using hash[256], a little bit slow, time complexity O(n^2)
	public int maxProduct2(String[] words) {
        if(words == null || words.length == 0){
            return 0;
        }
        
        int n = words.length;
        int[][] hashs = new int[n][256];
        int max = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < words[i].length(); j++){
                hashs[i][words[i].charAt(j)]++;
            }
        }
        
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(nonCommonLetter(hashs, i, j) == true){
                    int product = words[i].length() * words[j].length();
                    max = Math.max(max, product);
                }
            }
        }
        
        return max;
    }
    
    public boolean nonCommonLetter(int[][] hashs, int row1, int row2){
        for(int i = 0; i < 256; i++){
            if(hashs[row1][i] > 0 && hashs[row2][i] > 0){
                return false;
            }
        }
        return true;
    }
}
