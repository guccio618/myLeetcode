/********
 * 
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
	the contiguous subarray [2,3] has the largest product = 6.
	
 * 
 * */

public class Q152_Maximum_Product_Subarray {
	// solution 1: using dp, time O(n), space O(n)
	public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        int[] maxValue = new int[len];
        int[] minValue = new int[len];
        maxValue[0] = minValue[0] = nums[0];
        int globalMax = nums[0];
        
        for(int i = 1; i < len; i++) {
            if(nums[i] > 0) {
                maxValue[i] = Math.max(nums[i], maxValue[i - 1] * nums[i]);
                minValue[i] = Math.min(nums[i], minValue[i - 1] * nums[i]);
            } else {
                maxValue[i] = Math.max(nums[i], minValue[i - 1] * nums[i]);
                minValue[i] = Math.min(nums[i], maxValue[i - 1] * nums[i]);
            }
            
            globalMax = Math.max(globalMax, maxValue[i]);
        }
        
        return globalMax;
    }
	
	
	
	// solution 2: follow up, improve the space, using dp, time O(n), space O(1)
	public int maxProduct2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int globalMax = nums[0];
        int curMax = nums[0], curMin = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > 0) {
                curMax = Math.max(nums[i], curMax * nums[i]);
                curMin = Math.min(nums[i], curMin * nums[i]);
            } else {
                int prevMax = curMax;
                curMax = Math.max(nums[i], curMin * nums[i]);
                curMin = Math.min(nums[i], prevMax * nums[i]);
            }
            
            globalMax = Math.max(globalMax, curMax);
        }
        
        return globalMax;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	/****************************** main function **********************************/
	public static boolean isProduct(int[] nums, int target) {
		if(nums == null || nums.length == 0){
			return false;
		} else if(target == 0) {
			for(int num : nums) {
				if(num == 0) {
					return true;
				}
			}
			
			return false;
		}
		
		int sign = 1;
		int product = 1;
		int front = 0;
		int len = nums.length;
		int targetFlag = target > 0 ? 1 : -1;
		target = Math.abs(target);
		
		for(int back = 0; back < len; back++) {
			while(front < len && product < target) {
				sign = nums[front] > 0 ? sign : -sign;
				product *= Math.abs(nums[front++]);
			}
			
			if(product == target) {
				if(product * sign == target * targetFlag) {
					return true;
				}
			}
			
			product /= Math.abs(nums[back]);
			sign = nums[back] > 0 ? sign : -sign;
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {		
		int[] nums= {1, -2, 3, 4, -5, 6 };
		int[] targets = {12, 20, -20};
		
		for(int target : targets) {
			System.out.println(isProduct(nums, target));
		}
		
	}
}
