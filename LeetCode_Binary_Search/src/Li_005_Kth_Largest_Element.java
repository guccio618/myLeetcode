
public class Li_005_Kth_Largest_Element {
	public int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        return quickSelect(nums, 0, nums.length - 1, nums.length - k + 1);
    }
    
    public int quickSelect(int[] nums, int left, int right, int k) {
        if(left == right){
        	return nums[left];
        }
        
        int position = partition(nums, left, right);
        
        if(position + 1 == k){
        	return nums[position];
        } else if(position + 1 < k){                            // 第k个，因此需要position + 1
        	return quickSelect(nums, position + 1, right, k);   // position + 1, 以position为分界 
        } else {                                                // position - 1
        	return quickSelect(nums, left, position - 1, k);
        }
    }
    
    public int partition(int[] nums, int left, int right) {
        if(left == right){
        	return left;
        }
        
        int x = left;
        int pivot = nums[right];
        int temp = 0;
        
        for(int i = left; i < right; i++){
        	if(nums[i] <= pivot){        // 小于等于
        		temp = nums[i];
        		nums[i] = nums[x];
        		nums[x] = temp;
        		x++;
        	}
        }
        
        temp = nums[x];
        nums[x] = nums[right];
        nums[right] = temp;
        return x;
    }
}
