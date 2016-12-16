/****************************************************************
 * 使用三个数代替heap
 * 
 ****************************************************************/


public class Le_334_Increasing_Triplet_Subsequence {
	public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3){
            return false;
        }
        
        int num1 = Integer.MIN_VALUE;
        int num2 = Integer.MIN_VALUE;
        int num3 = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            if(num1 == Integer.MIN_VALUE || nums[i] < num1){
                num1 = nums[i];
                continue;
            } 
            if( (nums[i] > num1) && (num2 == Integer.MIN_VALUE || nums[i] < num2) ){ // 注意需要严格当nums[i] > num1时
                num2 = nums[i];
                continue;
            }
            if(nums[i] > num1 && nums[i] > num2 && num3 == Integer.MIN_VALUE){   // 注意需要严格当nums[i] > num1 && nums[i] > num2时
                num3 = nums[i];
                break;
            }
        }

        return !(num3 == Integer.MIN_VALUE);
    }
}
