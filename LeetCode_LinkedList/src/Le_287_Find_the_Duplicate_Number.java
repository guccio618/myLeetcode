
public class Le_287_Find_the_Duplicate_Number {
	/***********************************************************/
	// by other using method like cycle linkedlist, very fast!
	public int findDuplicate(int[] nums) {
        if (nums.length > 1) {
            int slow = nums[0];
            int fast = nums[nums[0]];
            
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            
            while (fast != slow) {
                fast = nums[fast];
                slow = nums[slow];
            }
            
            return slow;
        }
        
        return -1;
    }
	
	
	
	/***********************************************************/
	//by jackie
	public int findDuplicate2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(nums[i] == nums[j])
                    return nums[i];
            }
        }
        return 0;
    }
}
