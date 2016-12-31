import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/********
 * 
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

For example,
	Given n = 2, return ["11","69","88","96"].
	
 * 
 * */


public class Q247_Strobogrammatic_Number_II {
	private char[] array1 = {'0', '1', '6', '8', '9'};
    private char[] array2 = {'0', '1', '9', '8', '6'};
    private char[] array3 = {'0', '1', '8'};
    
    public List<String> findStrobogrammatic(int n) {
        List<String> ans = new ArrayList<String>();
        
        if(n <= 0){
            return ans;
        }

        recursive(ans, "", n);
        return ans;
    }
    
    public void recursive(List<String> ans, String solution, int n){
        if(solution.length() == n){
            if(n > 1 && solution.charAt(0) == '0'){
                return;
            }
            
            ans.add(solution);
            return;
        } 
        
        if(solution.length() == 0 && n % 2 == 1){
            for(char c : array3){
                recursive(ans, solution + c, n);
            }
        } else {
            for(int i = 0; i < array1.length; i++){
                recursive(ans, array1[i] + solution + array2[i], n);
            }
        }
    }
    
    
	
    /***************************************************************/
	public List<String> findStrobogrammatic2(int n) {
        List<String> ans = new ArrayList<String>();
        if(n < 1){
            return ans;
        }
        
        int[] nums1 = {0, 1, 8};
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');
        
        if(n % 2 == 1){
            helper(ans, map, "0", n);
            helper(ans, map, "1", n);
            helper(ans, map, "8", n);
        } else {
            helper(ans, map, "", n);
        }
        
        return ans;
    }
    
    public void helper(List<String> ans, Map<Character, Character> map, String solution, int n){
        if(solution.length() == n){
            ans.add(solution);
//            System.out.println("in here");
            return;
        }
        
        char[] nums2 = {'0', '1', '6', '8', '9'};
        
        for(int i = 0; i < 5; i++){
            char c1 = nums2[i];
            char c2 = map.get(c1);
            helper(ans, map, c1 + solution + c2, n);
        }
    }
    
    
    public static void main(String[] args){
    	Q247_Strobogrammatic_Number_II t = new Q247_Strobogrammatic_Number_II();
    	List<String> ans = t.findStrobogrammatic(1);
    	
    	for(int i = 0; i < ans.size(); i++){
    		System.out.print(ans.get(i) + ", ");
    	}
    }
}
