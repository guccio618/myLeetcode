
public class Le_266_Palindrome_Permutation {
	public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0){
            return false;
        }
        
        int[] hash = new int[256];
        int n = s.length();
        int count = 0;
        
        for(int i = 0; i < n; i++){
            hash[s.charAt(i)]++;
        }
        
        for(int i = 0; i < 256; i++){
            if(hash[i] % 2 != 0){
                count++;
            }
        }
        
        return count <= 1;
    }
}
