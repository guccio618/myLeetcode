import java.util.ArrayList;
import java.util.Arrays;
/******
 * 
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. 
Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
 * 
 * */

public class Le_300_Longest_Increasing_Subsequence {
	/***************************************************************
	 * nlogn方法很巧
	 * 
	 * 
	 ***************************************************************/
	// solution 1: using binary, time O(nlogn)
	public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int firstInsertPos = 0;
        
        for(int element : nums){
            if(firstInsertPos == 0 || element > nums[firstInsertPos - 1]){
                nums[firstInsertPos++] = element;
            } else {
                int index = Arrays.binarySearch(nums, 0, firstInsertPos, element);
                
                if(index < 0){
                    nums[-(index + 1)] = element;
                }
            }
        }
        
        return firstInsertPos;
    }
	
	
	
	
	// solution 2: using ArrayList, time complexity O(nlogn), space O(n)
	public int lengthOfLIS2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i < n; ++i){
            updateList(list, nums[i]);
        }
        
        return list.size();
    }
    
    public void updateList(ArrayList<Integer> list, int target){
        if(list.size() == 0 || target > list.get(list.size() - 1)){    // 只有 “ > ” 
            list.add(target);
        } else {
            int pos = findPos(list, target);
            list.set(pos, target);
        }
    }
    
    public int findPos(ArrayList<Integer> list, int target){
    	if(list.size() == 0){
    		return 0;
    	}
    	
        int left = 0, right = list.size() - 1;
        
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            int midNum = list.get(mid); 
            
            if(midNum < target){
                left = mid;
            } else {
                right = mid;
            }
        }

        if(list.get(left) >= target){
            return left;
        } else if(list.get(right) >= target){
            return right;
        } else {
            return right + 1;
        }
    }
    
    
    

    
    // solution 3: using DP, time complexity O(n^2), space O(n)
    public int lengthOfLIS3(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int[] dp = new int[nums.length];
        int maxLen = 1;
        int n = nums.length;
        
        for(int i = 1; i < n; ++i){
        	dp[i] = 1;
        	
            for(int j = 0; j < i; ++j){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1); 
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }
        
        return maxLen;
    }
}
