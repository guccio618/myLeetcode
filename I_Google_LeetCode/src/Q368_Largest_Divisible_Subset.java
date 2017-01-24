import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*****
 * 
Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

	nums: [1,2,3]

	Result: [1,2] (of course, [1,3] will also be ok)
	
Example 2:

	nums: [1,2,4,8]

	Result: [1,2,4,8]

 * 
 * */


public class Q368_Largest_Divisible_Subset {
	// test case: [],  [1]
	
	// solution 1: using self-definded class, time complexity is O(n^2), space is O(n)
	public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        
        if(nums == null || nums.length == 0) {
            return ans;
        }
        
        int len = nums.length;
        Pair[] array = new Pair[len];
        int startIndex = -1;
        int maxLen = 0;
        Arrays.sort(nums);
        
        for(int i = 0; i < len; i++) {
            array[i] = new Pair(nums[i], 1, -1);
            
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0 && array[i].longestSize < array[j].longestSize + 1) {
                    array[i].longestSize = array[j].longestSize + 1;
                    array[i].preIndex = j;
                }
            }
            
            if(maxLen < array[i].longestSize) {
                maxLen = array[i].longestSize;
                startIndex = i;
            }
        }
        
        while(startIndex != -1) {
            ans.add(array[startIndex].value);
            startIndex = array[startIndex].preIndex;
        }
        
        return ans;
    }
    
    class Pair {
        int value;
        int longestSize;
        int preIndex; 
        
        public Pair(int value, int longestSize, int preIndex) {
            this.value = value;
            this.longestSize = longestSize;
            this.preIndex = preIndex;
        }
    }
	
    
    
	// solution 2: using two arrays, time complexity is O(n^2), space is O(n)
	public List<Integer> largestDivisibleSubset2(int[] nums) {
		if(nums == null || nums.length == 0){
            return new ArrayList<Integer>();
        }
        
        Arrays.sort(nums);
        int len = nums.length;
        List<Integer> ans = new ArrayList<Integer>();
        int[] curLongestSize = new int[len];
        int[] prevIndexArray = new int[len];
        int maxLen = 0;
        int startIndex = -1;
        
        for(int i = 0; i < len; i++){
            curLongestSize[i] = 1;
            prevIndexArray[i] = -1;
            
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0 && curLongestSize[j] + 1 > curLongestSize[i]){
                    curLongestSize[i] = curLongestSize[j] + 1;
                    prevIndexArray[i] = j;
                }
            }
                
            if(maxLen < curLongestSize[i]){
                maxLen = curLongestSize[i];
                startIndex = i;
            }
        }
        
        while(startIndex != -1){
            ans.add(nums[startIndex]);
            startIndex = prevIndexArray[startIndex];
        }
        
        return ans;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/************************************ main function ***********************************/
	// by Jackie, time complexity is O(n^2), space is O(n)
	public List<Integer> largestDivisibleSubset3(int[] nums) {
		if(nums == null || nums.length == 0){
            return new ArrayList<Integer>();
        }  
        
        Arrays.sort(nums);
        List<Integer> ans = null;
        int len = nums.length;
        List<Integer>[] dp = new List[len];
        int maxLen = 0;
        
        for(int i = 0; i < len; i++){
            if(dp[i] == null){
                dp[i] = new ArrayList<Integer>();
                dp[i].add(nums[i]);
                
                if(maxLen < 1){
                    maxLen = 1;
                    ans = dp[i];
                }
            }
            
            for(int j = i + 1; j < len; j++){
                if(nums[j] % nums[i] == 0){
                    if(dp[j] == null || dp[i].size() + 1 > dp[j].size()){
                        dp[j] = new ArrayList<Integer>(dp[i]);
                        dp[j].add(nums[j]);
                        
                        if(maxLen < dp[j].size()){
                            maxLen = dp[j].size();
                            ans = dp[j];
                        }
                    } 
                }
            }
        }
        
        return ans;
    }
	
	
	
	public static void main(String[] args){
		Q368_Largest_Divisible_Subset t = new Q368_Largest_Divisible_Subset();
		int[] nums = {1};
		List<Integer> list = t.largestDivisibleSubset(nums);
		
		for(int num : list){
			System.out.print(num + ", ");
		}
	} 
}
