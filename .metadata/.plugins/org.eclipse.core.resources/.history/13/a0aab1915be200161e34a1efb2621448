import java.util.HashSet;
import java.util.Set;


public class Q041_First_Missing_Positive {
	/*************************************************/
	//by ninechapter using counting sort
	public int firstMissingPositive(int[] nums) {
		if (nums == null) {
			return 1;
		}

		for (int i = 0; i < nums.length; i++) {
			while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != (i + 1) && nums[i] != nums[nums[i] - 1]) {				
				int tmp = nums[nums[i] - 1];   // 3,4,-1,1
				nums[nums[i] - 1] = nums[i];
				nums[i] = tmp;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}

		return nums.length + 1;
    }
	
	
	
	/*************************************************/
	// by Jackie using hashset
	public int firstMissingPositive2(int[] nums) {
		if(nums == null || nums.length == 0){
            return 1;
        }
        
        Set<Integer> set = new HashSet<Integer>();
        int maxBound = 1;
        
        for(int num : nums){
            set.add(num);
            maxBound = Math.max(maxBound, num);
        }
        
        for(int i = 1; i <= maxBound; i++){
            if(!set.contains(i)){
                return i;
            }
        }
        
        return maxBound + 1;
    }
	
	
	
	/*************************************************/
	// by Jackie using hashset
	public int firstMissingPositive3(int[] nums) {
        if (nums == null) {
			return 1;
		}

		for (int i = 0; i < nums.length; i++) {
			while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != (i + 1)) {
				int tmp = nums[nums[i] - 1]; // 3,4,-1,1
				if (tmp == nums[i]) {
					break;
				}
				nums[nums[i] - 1] = nums[i];
				nums[i] = tmp;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}

		return nums.length + 1;
    }
	
	public static void main(String[] args){
		Q041_First_Missing_Positive test = new Q041_First_Missing_Positive();
//		int[] array = {3,4,-1,1};
		int[] array = {2, 1};
		System.out.println(test.firstMissingPositive(array));
	} 
}
