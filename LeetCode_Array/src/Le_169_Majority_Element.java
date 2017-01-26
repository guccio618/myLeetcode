import java.util.Arrays;
/********
 * 
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 * */

public class Le_169_Majority_Element {
	// test case:
    // 		nums is empty
    // 		does not contain major element
	
	// solution 1: time complexity is O(n);
	public int majorityElement(int[] nums) {
		if(nums == null || nums.length == 0){
            return 0;
        }
        
        int len = nums.length;
        int recordNum = nums[0];
        int count = 0;
        
        for(int i = 0; i < len; i++){
            if(recordNum == nums[i]){
                count++;
            } else {
                count--;
            }
            
            if(count == 0){
                recordNum = nums[i];
                count++;
            }
        }
        
        return recordNum;
    }
	
	
	// solution 2: using sort, time complexity is O(nlogn)
	public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    
	
	
	
	
	
	
	
	
	/************************** main function ********************************/
	
    public static void main(String[] args){
    	Le_169_Majority_Element t = new Le_169_Majority_Element();
    	int[] array = {3,6,1,2,7,3,3,3,3};
    	System.out.println(t.majorityElement(array));
    }
}
