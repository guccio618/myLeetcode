import java.util.Arrays;
/*******
 * 
Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 * 
 * */

public class Q280_Wiggle_Sort {
	// solution 1: using sort, time complexity O(nlogn), space O(1)
    public void wiggleSort2(int[] nums) {
        if(nums == null || nums.length <= 1){
            return ;
        }
        
        int len = nums.length;
        Arrays.sort(nums);
        int index = 1;
        
        while(index + 1 < len){
            int temp = nums[index];
            nums[index] = nums[index + 1];
            nums[index + 1] = temp;
            index += 2;
        }
    }
	
    
    
    
    
    
	// solution 2: time is O(n), space is O(1)
	public void wiggleSort(int[] nums) {
		if(nums == null || nums.length <= 1) {
            return;
        }
        
        int len = nums.length;
        
        for(int i = 0; i < len - 1; i++) {
            if( (i % 2 == 0 && nums[i] > nums[i + 1]) || (i % 2 == 1 && nums[i] < nums[i + 1]) ) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
            } 
        }
    }

    
    
    
    
    
    
   
    
    
    
    
    
    
    
    
    
    
    /**************************************************/
    // by Jackie, space O(n)
    public void wiggleSort3(int[] nums) {
        if(nums == null || nums.length == 0){
            return ;
        }
        
        int n = nums.length;
        int[] newNums = new int[n];
        int head = 0;
        int nextHead = n % 2 == 0 ? n / 2 : n / 2 + 1;
        Arrays.sort(nums);
        
        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                newNums[i] = nums[head++];
            } else {
                newNums[i] = nums[nextHead++];
            }
        }
        
        for(int i = 0; i < n; i++){
            nums[i] = newNums[i];
        }
    }
}
