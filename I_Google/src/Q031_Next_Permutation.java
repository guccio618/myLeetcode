import java.util.ArrayList;

/******
 * 
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

*
*
**/

public class Q031_Next_Permutation {
	/***************************************************************
	 * 如输入：1 4 6 5 3 2
	 * step1：从右往左找到第一个破坏升序(非严格)的元素，此例中为4.记下标为 i
     * step2: 依然从右往左,找到第一个大于4的元素，此例中5，交换4和5.
     * step3：从i+1到最右端，逆置。6 4 3 2 to 2 3 4 6
	 * 
	 ***************************************************************/

	public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ;
        }
        
        int len = nums.length;
        int index1 = len - 2;
        int index2 = len - 1;
        
        while (index1 >= 0 && nums[index1] >= nums[index1 + 1]) {   // Find 1st id that breaks descending order, contains "=" !!!
            index1--;
        }
        
        if (index1 >= 0) {                                          // If not entirely descending  注意必需 i >= 0 ！！!
        	while(index2 >= 0 && nums[index2] <= nums[index1]){     // Find rightmost first larger number        
                index2--;
            }
            
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
        
        reverseArray(nums, index1 + 1, len - 1);
    }
    
    public void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
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
