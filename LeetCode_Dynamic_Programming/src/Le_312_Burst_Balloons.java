/*****
 * 
Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note: 
(1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
(2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example:

Given [3, 1, 5, 8]

Return 167

    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
   
 * 
 * */

public class Le_312_Burst_Balloons {
	// solution 1: using DP, time O(n^2), space O(n^2)
	public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] newNums = new int[nums.length + 2];
        newNums[0] = 1;
        newNums[newNums.length - 1] = 1;
        
        for(int i = 0; i < nums.length; i++) {
            newNums[i+1] = nums[i];
        }
        
        int len = newNums.length;
        int[][] score = new int[len][len];
        
        for(int length = 2; length < len; length++) {
            for(int start = 0; start + length < len; start++) {
                int end = start + length;
                
                for(int k = start + 1; k < end; k++) {
                    score[start][end] = Math.max(score[start][end], score[start][k] + newNums[start] * newNums[k] * newNums[end] + score[k][end]); // 注意是start和end !!!
                }
            }
        }
        
        return score[0][len-1];
    }
	

	
	// solution 2: using Divide & Conquer
	public int maxCoins2(int[] iNums) {
	    int[] nums = new int[iNums.length + 2];
	    int n = 1;
	    for (int x : iNums) {
	    	nums[n++] = x;
	    }

	    nums[0] = nums[n] = 1;
	    int[][] memo = new int[nums.length][nums.length];
	    return burst(memo, nums, 0, nums.length-1);
	}

	public int burst(int[][] memo, int[] nums, int left, int right) {
	    if (left + 1 == right) {
	    	return 0;
	    }
	    if (memo[left][right] > 0) {
	    	return memo[left][right];
	    }
	    
	    int ans = 0;
	    
	    for (int i = left + 1; i < right; ++i) {
	        ans = Math.max(ans, nums[left] * nums[i] * nums[right] + burst(memo, nums, left, i) + burst(memo, nums, i, right));
	    }
	    
	    memo[left][right] = ans;
	    return ans;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/****************************************************/
	// by Jackie using backtrack, exceed time limit
	public int maxCoins4(int[] nums) {
        if(nums.length == 0) return 0;
        boolean[] visited = new boolean[nums.length];
        int max = -1;
        for(int i = 0; i < nums.length; ++i){
            max = Math.max(max, backtrack(nums, i, visited));
        }
        return max;
    }
    
    public int backtrack(int[] nums, int pos, boolean[] visited){
        if(pos == nums.length || visited[pos]) return 0;
        visited[pos] = true;
        int score = -1;
        int curScore = nums[pos];
        if(pos > 0){
            for(int i = pos-1; i >= 0; --i){
                if(visited[i] != true){
                    curScore *= nums[i];
                    break;
                }
            }
        }
        if(pos < nums.length-1){
            for(int i = pos+1; i < nums.length; ++i){
                if(visited[i] != true){
                    curScore *= nums[i];
                    break;
                }
            }
        }
        
        for(int i = 0; i < nums.length; ++i){
            score = Math.max(score, backtrack(nums, i, visited));
        }
        visited[pos] = false;
        return score+curScore;
    }
    
    
    public static void main(String[] args){
    	Le_312_Burst_Balloons t = new Le_312_Burst_Balloons();
    	int[] nums = {7,9,8,0,7,1,3,5,5,2,3};
    	System.out.println(t.maxCoins(nums));
    	System.out.println(t.maxCoins2(nums));
    }
}
