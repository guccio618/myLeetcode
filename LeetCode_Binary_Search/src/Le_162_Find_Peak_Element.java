
public class Le_162_Find_Peak_Element {
	public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int left = 0, right = nums.length - 1;   // 不会越界
        
        while(left + 1 < right){
            int mid = (left + right) / 2;
            if(nums[mid] < nums[mid + 1]){     // 注意mid和mid+1, mid-1比较
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
