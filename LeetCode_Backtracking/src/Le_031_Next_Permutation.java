import java.util.ArrayList;


public class Le_031_Next_Permutation {
	/***************************************************************
	 * 如输入：1 4 6 5 3 2
	 * step1：从右往左找到第一个破坏升序(非严格)的元素，此例中为4.记下标为 i
     * step2: 依然从右往左,找到第一个大于4的元素，此例中5，交换4和5.
     * step3：从i+1到最右端，逆置。6 4 3 2 to 2 3 4 6
	 * 
	 ***************************************************************/
	// by other
	public void nextPermutation(int[] nums) {
	    int i = nums.length - 2;
	    while(i >= 0 && nums[i] >= nums[i + 1]){      // Find 1st id i that breaks descending order， 有等于号 ！！！
	    	i--;
	    }

	    int j = nums.length - 1;
	    if(i >= 0) {                                 // If not entirely descending  注意必需 i >= 0 ！！！
	        while(nums[j] <= nums[i]) {               // Find rightmost first larger number j
	        	j--;         
	        }
	        swap(nums, i, j);                        // Switch i and j
	    }

	    reverse(nums, i + 1, nums.length - 1);       // Reverse the descending sequence
	}

	public void swap(int[] nums, int i, int j) {
	    int tmp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = tmp;
	}

	public void reverse(int[] nums, int i, int j) {
	    while(i < j) {
	        swap(nums, i, j);
	        i++; j--;
	    }
	}
	
	
	/***************************************************************
	 * 如输入：1, 3, 2, 3
	 * step1：从右往左找到第一个破坏降序(非严格)的元素，此例中为3.记下标为 i
     * step2: 当前3的位置开始,找到第一个大于等于3的元素，此例中为3，记录其前1一个
     * 		  元素，此例中为2，交换3和2.
     * step3：从i+1到最右端，逆置。3，3 逆序后为3，3。 最后答案为1 2 3 3
	 * 
	 ***************************************************************/
	// previous permutation
	public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {  
	    int peakInd = nums.size()-1;  
	    while (peakInd > 0 && nums.get(peakInd-1) <= nums.get(peakInd)) {  
	        peakInd--;  
	    }  
	    peakInd--;  
	    if (peakInd >= 0) {          // 需要注意peekInd >= 0
	        int swapInd = peakInd+1;  
	        while (swapInd < nums.size() && nums.get(swapInd) < nums.get(peakInd)) {  
	            swapInd++;  
	        }  
	        swapInd--;  
	        int tmp = nums.get(swapInd);  
	        nums.set(swapInd, nums.get(peakInd));  
	        nums.set(peakInd, tmp);  
	    }  
	    int left = peakInd+1;  
	    int right = nums.size()-1;  
	    while (left < right) {  
	        int tmp = nums.get(left);  
	        nums.set(left, nums.get(right));  
	        nums.set(right, tmp);  
	        left++;  
	        right--;  
	    }  
	    return nums;  
	}  
}
