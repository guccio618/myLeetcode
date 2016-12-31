import java.util.Arrays;


public class Lecture4_Two_Pointers_02_Triangle_Count {
	public int triangleCount(int nums[]) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        int left = 0, right = 0;
        
        for(int pos = nums.length - 1; pos > 1; --pos){
            left = 0;
            right = pos - 1;
            while(left < right){
                if(nums[left] + nums[right] > nums[pos]){
                    res += right - left;
                    right--;
                } else{
                    left++;
                }
            }
        }
        
        return res;
    }
}
