/*****
 *
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
	You must do this in-place without making a copy of the array.
	Minimize the total number of operations.
 *
 **/


public class Le_283_Move_Zeroes {
	public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) {
            return ;
        }
        
        int front = 0, back = 0;
        int len = nums.length;
        
        while(back < len && nums[back] != 0) {
            back++;
        }
        
        front = back;
        
        while(front < len && nums[front] == 0) {
            front++;
        }
        
        while(front < len) {
            if(nums[front] != 0) {
                nums[back++] = nums[front];    
            }
            
            front++;
        }
        
        while(back < len) {
            nums[back++] = 0;
        }
    }
	
	
	
	
	
	
	public static void main(String[] args){
		Le_283_Move_Zeroes test = new Le_283_Move_Zeroes();
		int[] array = {1, 0, 0};
		test.moveZeroes(array);
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + ", ");
		System.out.println();
	}
}
