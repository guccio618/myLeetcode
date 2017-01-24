import java.util.Arrays;

/********
 * 
Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.

Return 2. Because there are two triplets which sums are less than 2:

	[-2, 0, 1]
	[-2, 0, 3]
	
Follow up:
	Could you solve it in O(n2) runtime?
 * 
 * */

public class Q259_3Sum_Smaller {
	// brute force is O(n^3)
	
	// time O(n^2)
	public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int len = nums.length;
        int count = 0;
        Arrays.sort(nums);
        
        for(int i = 0; i < len - 2; i++){
            int left = i + 1, right = len - 1;
            
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                
                if(sum >= target){
                    right--;
                } else {
                    count += (right - left);
                    left++;     // 这里必须将left++ !!!
                } 
            }
        }
        
        return count;
    }
	
	
	
	public static void main(String[] args){
		Q259_3Sum_Smaller t = new Q259_3Sum_Smaller();
		int[] nums = {-2, 0, 1, 3};
		System.out.println(t.threeSumSmaller(nums, 4));
	}
}
