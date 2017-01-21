public class Find_Duplicate_Number_More_Than_1_Time {
	public int findDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return -1;
        }
        
        int faster = nums[nums[0]];
        int slower = nums[0];
        
        while (faster != slower) {
            faster = nums[nums[faster]];
            slower = nums[slower];
        }
        
        faster = 0;
        
        while (faster != slower) {
            faster = nums[faster];
            slower = nums[slower];
        }
        
        return faster;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**************************** main function ************************************/
	
	public static void main(String[] arge) {
		Find_Duplicate_Number_More_Than_1_Time t = new Find_Duplicate_Number_More_Than_1_Time();
		int[] nums = {1,2,3,4,5,3,3,3};		
		System.out.println(t.findDuplicate(nums));
	}
}
