/******
 * 
Find the kth largest element in an unsorted array. 
Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.

 * 
 * */

public class Le_215_Kth_Largest_Element_in_an_Array {
	// using quickselect, time complexity is O(n)
	public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int left = 0, right = n - 1;
        
        while(left < right){       	      // 注意这里用的是 left < right
            int index = partition(nums, left, right);
            int count = index + 1;
            
            if(k > count){
                left = index + 1;         // 注意这里用的是left = index + 1，有偏移，防止死循环 ！！！
            } else if(k < count){
                right = index - 1;        // 注意这里用的是right = index - 1 ！！！
            } else {
                return nums[index];
            }
        }

        return nums[left];
    }
    
    public int partition(int[] nums, int left, int right){
    	if(left == right){
    		return nums[left];
    	}
    	
        int i = left;
        int pivot = nums[right];
        int temp = 0;
        
        for(int j = left; j < right; ++j){
            if(nums[j] >= pivot){
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
        
        temp = nums[i];
        nums[i] = nums[right];
        nums[right] = temp;
        return i;
    }
    
    
    
    
    
    
    
    /************************* main function ****************************/
    
    public static void main(String[] args){
    	Le_215_Kth_Largest_Element_in_an_Array t = new Le_215_Kth_Largest_Element_in_an_Array();
//    	int[] nums = {2,1};
    	int[] nums = {3,2,1,5,6,12,4};
    	System.out.println(t.findKthLargest(nums, 2));
    }
}
