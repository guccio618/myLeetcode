import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/********
 * 
Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.

For example:
	Given s = "aabb", return ["abba", "baab"].
	Given s = "abc", return [].
	
 * 
 * */

public class Q267_Palindrome_Permutation_II {
	/*****************************************
	 * 266的follow up
	 * 
	 *****************************************/
	// using backtrack
	public List<String> generatePalindromes(String s) {
        List<String> ans = new ArrayList<>();
        
        if(s == null || s.length() == 0) {
            return ans;
        } else if(s.length() == 1) {
            ans.add(s);
            return ans;
        }
        
        int[] hash = new int[256];
        int len = s.length();
        
        for(char c : s.toCharArray()) {
            hash[c]++;
        }
        
        int count = 0;
        String solution = "";
        
        for(int i = 0; i < 256; i++) {
            if(hash[i] % 2 == 1) {
                count++;
                solution += (char) (i);
                hash[i]--;
            }
            
            if(count > 1) {
                return ans;
            }
        }
        
        backtrack(hash, solution, ans, len);
        return ans;
    }
    
    public void backtrack(int[] hash, String solution, List<String> ans, int len) {
        if(solution.length() == len) {
            ans.add(solution);
            return;
        }
        
        for(int i = 0; i < 256; i++) {
            if(hash[i] > 0) {
                hash[i] -= 2;
                String str = (char) (i) + solution + (char) (i);
                backtrack(hash, str, ans, len);
                hash[i] += 2;
            }
        }
    }

    
    
    
    
    
    
    
    
    
    
	
	/********************************************************/

	public List<String> generatePalindromes2(String s) {
        List<String> ans = new ArrayList<String>();
        if(s == null || s.length() == 0){
            return ans;
        }
        
        boolean[] visited = new boolean[s.length()];
        backtrack(s, visited, "", ans);
        return ans;
    }
    
    public void backtrack(String s, boolean[] visited, String path, List<String> ans){
        if(path.length() == s.length()){
            if(isPalindrome(path)){
                ans.add(path);
            }
            return;
        }
        
        for(int i = 0; i < s.length(); i++){
            if(visited[i] == true){
                continue;
            }
            visited[i] = true;
            backtrack(s, visited, path + s.charAt(i), ans);
            visited[i] = false;
        }
    }
    
    public boolean isPalindrome(String str){
        if(str.length() == 1){
            return true;
        }
        
        int left = 0, right = str.length() - 1;
        
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    
    
    /********************************************************/
    // by other
    public List<String> generatePalindromes3(String s) {
        List<String> ans = new ArrayList<String>();
        if(s == null || s.length() == 0){
            return ans;
        } else if(s.length() == 1){
        	ans.add(s);
        	return ans;
        }
        
        char[] array = s.toCharArray();
        Arrays.sort(array);
        StringBuffer builder = new StringBuffer();
        int n = array.length;
        int faster = 1, slower = 0;
        char mark = ' ';
        int count = 0;
        
        while(faster < n){
            if(array[faster] == array[slower]){
                builder.append(array[faster]);
                faster += 2;
                slower += 2;
            } else {
                mark = array[slower];
                slower++;
                faster++;
                count++;
            }
        }
        
        if(array[n - 1] != array[n - 2]){
        	count++;
        	mark = array[n - 1];
        }
        if(count > 1){
    		return ans;
    	}
        
        String newStr = builder.toString();
        boolean[] visited = new boolean[newStr.length()];
        backtrack(ans, visited, newStr, "");
        
        for(int i = 0; i < ans.size(); i++){
        	String str = ans.get(i);
        	StringBuffer sb = new StringBuffer(str);
        	String revereStr = sb.reverse().toString();
        	str = count == 0 ? str + revereStr : str + mark + revereStr;
        	ans.set(i, str);
        }
        
        return ans;
	}
	
	public void backtrack(List<String> ans, boolean[] visited, String newStr, String solution){
		if(solution.length() == newStr.length()){
			ans.add(solution);
			return;
		}
		
		for(int i = 0; i < newStr.length(); i++){
			if(visited[i] == true){
				continue;
			}
			visited[i] = true;
			backtrack(ans, visited, newStr, solution + newStr.charAt(i));
			visited[i] = false;
		}
	}
    
	
	
	/********************************************************/
	// by Jackie
	public List<String> generatePalindromes4(String s) {
        List<String> ans = new ArrayList<String>();
        if(s == null || s.length() == 0){
            return ans;
        }

        int[] hash = new int[256];
        int n = s.length();
        
        for(int i = 0; i < n; i++){
            hash[s.charAt(i)]++;
        }
        
        int singleCharNum = getSingleCharNum(hash);
        
        if(singleCharNum > 1){
            return ans;
        }
        
        String str = getStr(hash);
        char[] letters = str.toCharArray();
        boolean[] visited = new boolean[letters.length];
        char c = singleCharNum == 0 ? ' ' : getSingleChar(hash);
        
         backtrack(ans, "", letters, visited, c);
         return ans;
    }
    
    public void backtrack(List<String> ans, String solution, char[] letters, boolean[] visited, char c){
        if(solution.length() == letters.length){
            StringBuilder builder = new StringBuilder(solution);
            builder.reverse();
            if(c != ' '){
                builder.insert(0, solution + c);
            } else {
                builder.insert(0, solution);
            }
            ans.add(builder.toString());
            return;
        }
        
        for(int i = 0; i < letters.length; i++){
            if(visited[i] == false){
                visited[i] = true;
                backtrack(ans, solution + letters[i], letters, visited, c);
                visited[i] = false;
                
                while(i + 1 < letters.length && letters[i] == letters[i + 1]){
                    i++;
                }
            }
            
            
        }
    }
       
    public int getSingleCharNum(int[] hash){
        int count = 0;
        
        for(int i = 0; i < 256; i++){
            if(hash[i] % 2 == 1){
                count++;
            }
        }
        
        return count;
    }
    
    public String getStr(int[] hash){
        StringBuilder builder = new StringBuilder();
        
        for(int i = 0; i < 256; i++){
            if(hash[i] >= 2){
            	int count = hash[i] / 2;       // 注意这里往builder时，count的取值方式 ！！！
            	for(int j = 0; j < count; j++){
            		builder.append((char)(i));
            	}
            }
        }
        return builder.toString();
    }
    
    public char getSingleChar(int[] hash){
        char c = ' ';
        for(int i = 0; i < 256; i++){
            if(hash[i] % 2 == 1){
                c = (char)(i);
                break;
            }
        }
        return c;
    }
	
	/****************************** main function ********************************/
	
    public static void main(String[] args){
    	Q267_Palindrome_Permutation_II t = new Q267_Palindrome_Permutation_II();
    	String str = "aaaaaa";
    	List<String> res = t.generatePalindromes4(str);
    	
    	for(int i = 0; i < res.size(); i++){
    		System.out.print(res.get(i) + ", ");
    	}
    }
}
