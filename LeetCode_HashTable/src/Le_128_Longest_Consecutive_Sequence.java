import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/*******
 * 
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
	Given [100, 4, 200, 1, 3, 2],
	The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

	Your algorithm should run in O(n) complexity.
	
 * 
 * */

public class Le_128_Longest_Consecutive_Sequence {
	// solution 1: time is O(n), space is O(n)
	public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Set<Integer> set = new HashSet<>();
        int maxLen = 0;
        
        for (int num : nums) {
            set.add(num);
        }
        
        for (int i = 0; i < nums.length; i++) {
            int left = nums[i] - 1;
            int right = nums[i] + 1;
            
            while (set.contains(left)) {
                set.remove(left);
                left--;
            }
            
            while (set.contains(right)) {
                set.remove(right);
                right++;
            }
            
            maxLen = Math.max(maxLen, right - left - 1);
        }
        
        return maxLen;
    }
	
	
	
	
	
	// solution 2: 
	public int longestConsecutive2(int[] nums) {
		if (nums == null || nums.length == 0) {
            return 0;
        }
		
        HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        int maxLong = 1;
        int temp = 0, currentMaxLong = 0;
        
        for(int i : nums) {
            myMap.put(i, 0);
        }
        
        for(int i : nums){
            if(myMap.get(i) == 1) {
            	continue;
            }
            
            temp = i;
            currentMaxLong = 1;
            
            while(myMap.containsKey(temp + 1)){
                currentMaxLong++;
                temp++;
                myMap.put(temp, 1);
            }
            
            temp = i;
            
            while(myMap.containsKey(temp - 1)){
                currentMaxLong++;
                temp--;
                myMap.put(temp, 1);
            }
            
            maxLong = Math.max(currentMaxLong, maxLong);
        }
        
        return maxLong;
    }
}
