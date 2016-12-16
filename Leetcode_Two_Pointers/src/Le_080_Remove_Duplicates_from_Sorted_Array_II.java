/*****
 * 
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
	Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 
It doesn't matter what you leave beyond the new length.
 * 
 * */


public class Le_080_Remove_Duplicates_from_Sorted_Array_II {
	// using two pointers, time O(n)
	public int removeDuplicates(int[] nums) {
        if(nums == null) {
            return 0;
        } else if(nums.length <= 2) {
            return nums.length;
        }
        
        int front = 1, back = 0;    // 这里front和back需要错开 ！！！
        int count = 1;
        int len = nums.length;
        
        while(front < len) {
            if(nums[front] == nums[back]) {
                if(count == 1) {
                    count++;
                    nums[++back] = nums[front];
                }
            } else {
                count = 1;
                nums[++back] = nums[front];
            }
            
            front++;
        }
        
        return back + 1;
    }
	
	
	
	
	
	public static void main(String[] args){
		Le_080_Remove_Duplicates_from_Sorted_Array_II t = new Le_080_Remove_Duplicates_from_Sorted_Array_II();
		int[] nums = {1,1,1,2,2,3};
		System.out.println(t.removeDuplicates(nums));
		for(int i = 0; i < nums.length; ++i)
			System.out.print(nums[i] + ", ");
	}
}
