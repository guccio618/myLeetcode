
public class Lecture5_Dynamic_Programming_04_Maximum_Product_Subarray {
	public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;        
        int[] max = new int[len];
        int[] min = new int[len];
        int result = nums[0];
        max[0] = min[0] = nums[0];
        
        for(int i = 1; i < len; ++i){
            min[i] = max[i] = nums[i];
            if(nums[i] > 0){
                max[i] = Math.max(max[i], max[i-1]*nums[i]);
                min[i] = Math.min(min[i], min[i-1]*nums[i]);
             } else if(nums[i] < 0){
                max[i] = Math.max(max[i], min[i-1]*nums[i]);
                min[i] = Math.min(min[i], max[i-1]*nums[i]);
            }
            result = Math.max(result, max[i]);
        }
        
        return result;
    }
}
