/********
 * 
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

 * 
 * */

public class Le_162_Find_Peak_Element {
	// time is O(logn)
	public int findPeakElement(int[] nums) {
		if(nums == null || nums.length == 0){
            return 0;
        }
        
        int left = 0, right = nums.length - 1;    // 不会越界
        
        while(left + 1 < right){
            int mid = left + (right - left) / 2;  // 防止溢出
            if(nums[mid] < nums[mid + 1]){        // 注意mid和mid+1, mid-1比较
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if(nums[left] > nums[right]){
            return left;
        } else {
            return right;
        }
    }
}
