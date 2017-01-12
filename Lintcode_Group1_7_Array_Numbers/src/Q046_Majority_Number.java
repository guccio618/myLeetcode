import java.util.ArrayList;


public class Q046_Majority_Number {
	// by Jackie
	public int majorityNumber(ArrayList<Integer> nums) {
        if(nums == null || nums.size() == 0){
            return -1;
        }
        
        int count = 0, candidate = -1, len = nums.size();
        for (int i = 0; i < nums.size(); i++) {
            if (count == 0) {
                candidate = nums.get(i);
                count = 1;
            } else if (candidate == nums.get(i)) {
                count++;
            } else {
                count--;
            }
        }
        
        count = 0;
        for(int i = 0; i < len; i++){
            if(nums.get(i) == candidate){
                count++;
            }
        }
        
        if(count > len / 2){
            return candidate;
        } else{
            return -1;
        }
    }
	
	// 也可以用另一个方法： Arrays.sort(nums), 然后选取nums[len/2+1]; O(n*logn)
}
