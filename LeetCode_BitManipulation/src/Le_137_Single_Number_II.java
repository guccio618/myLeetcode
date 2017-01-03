
public class Le_137_Single_Number_II {
	public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int[] bits = new int[32];
        int n = nums.length;
        int result = 0;
        
        for(int i = 0; i < 32; i++){
            for(int j = 0; j < n; j++){
                bits[i] += (nums[j] >> i) & 1;
            }
            bits[i] %= 3;
            result |= (bits[i] << i);
        }
        
        return result;
    }
}
