import java.util.*;

public class Two_Sum {
	public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }    
        
        int[] ans = new int[2];
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < len; i++){
            if(map.containsKey(target - nums[i])){
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                return ans;
            } else {
                map.put(nums[i], i);
            }
        }
        
        return ans;
    }
	
	
	
	
	
	public int[] twoSum2(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }    
        
        int[] ans = new int[2];
        int left = 0, right = nums.length - 1;
        Arrays.sort(nums);
        
        while(left < right) {
        	int sum = nums[left] + nums[right];
        	
        	if(sum > target) {
        		right--;
        	} else if(sum < target) {
        		left++;
        	} else {
        		ans[0] = left;
        		ans[1] = right;
        		break;
        	}
        }
        
        return ans;
	}
}
