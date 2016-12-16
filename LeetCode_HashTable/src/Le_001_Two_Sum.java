import java.util.HashMap;
import java.util.Map;
/*******
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 * 
 * */
public class Le_001_Two_Sum {
	/***********************************************/
	/** 1. Hashmap                                **/
	/** 	(1). Hashmap.get                      **/
	/** 	(2). Hashmap.put                      **/
	/** 	(3). Hashmap.containsKey              **/
	/***********************************************/
	// test case:
    // array contains 0 element: []
    // array contains 1 element: [1]
    // array contains 2 elements but not contain the target: [1, 2], target = 5
    // array contains duplicate:  [1, 2, 2], target = 3
	
	// using hashmap, time is O(n), space(n)
	public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length <= 1) {
            return new int[] {-1, -1};
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        
        return new int[] {-1, -1};
    }
}
