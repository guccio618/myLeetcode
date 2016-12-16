import java.util.ArrayList;
import java.util.List;

/*****************************************
 * 266的follow up
 * 
 *****************************************/

public class Le_267_Palindrome_Permutation_II {
	public List<String> generatePalindromes(String s) {
        List<String> ans = new ArrayList<String>();
        if(s == null || s.length() == 0){
            return ans;
        } else if(s.length() == 1){
        	ans.add(s);
        	return ans;
        }
        
        int n = s.length();
        int[] hash = new int[256];
        
        for(int i = 0; i < n; i++){
            hash[s.charAt(i)]++;
        }
        
        if(isPalindrome(hash) == false){
            return ans;
        }
        
        int position = -1;
        for(int i = 0; i < 256; i++){
            if(hash[i] % 2 == 1){
                position = i;
            }
        }
        
        if(position == -1){
            backtrack(ans, "", hash, n);
        } else{
            String str = new String();
            str += (char) (position);
            hash[position]--;
            backtrack(ans, str, hash, n);
        }
        
        return ans;
    }
    
    public void backtrack(List<String> ans, String solution, int[] hash, int n){
        if(solution.length() == n){
            ans.add(solution);
            return;
        }
        
        for(int i = 0; i < 256; i++){
            if(hash[i] > 0){
                String str = (char) (i) + solution + (char) (i);
                hash[i] -= 2;
                backtrack(ans, str, hash, n);
                hash[i] += 2;
            }
        }
    }
    
    public boolean isPalindrome(int[] hash){
        int count = 0;
        for(int i = 0; i < 256; i++){
            if(hash[i] % 2 == 1){
                count++;
            }
            if(count > 1){
                return false;
            }
        }
        return true;
    }
}
