
public class Lecture2_Binary_Search_13_Find_Peak_Element {
	/************************************************************************************
	 * Binary Search
	 * 		分类讨论
	 * 		(1). 先判断是升序还是降序的情况;
	 * 		(2). 对于升序的情况，峰值在右边，整体应该右移，因此start = mid,
	 * 			 对于降序的情况，峰值在左边，整体应该左移，因此end = mid;
	 * 		
	 ************************************************************************************/
	
	public int findPeak(int[] nums) {
        int start = 1, end = nums.length-2; // 1.答案在之间，2.不会出界 
        while(start + 1 <  end) {
            int mid = (start + end) / 2;
            if(nums[mid] < nums[mid - 1]) {       // 降序，峰值在左边
                end = mid;
            } 
            else if(nums[mid] < nums[mid + 1]) {  // 升序，峰值在右边
                start = mid;
            } 
            else {
                end = mid;
            }
        }
        
        if(nums[start] < nums[end]) {
            return end;
        } 
        else { 
            return start;
        }
    }
}
