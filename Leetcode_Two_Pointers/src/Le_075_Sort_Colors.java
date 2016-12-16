/*****
 * 
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
 
 * 
 * 
 * 
 **/


public class Le_075_Sort_Colors {
	// solution 1: using count sort, time O(n), space O(n)
	public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ;
        }
        
        countSort(nums, 2);  
    }
    
    public void countSort(int[] nums, int range) {
        int[] countArray = new int[range + 1];
        int[] tempArray = new int[nums.length];
        
        for (int num : nums){
			countArray[num]++;
		}
        
        for(int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i-1];
        }
        
        for(int num : nums) {
            int pos = countArray[num] - 1;
            tempArray[pos] = num;
            countArray[num]--;
        }
        
        System.arraycopy(tempArray, 0, nums, 0, nums.length);
    }
    
    
	// solution 2: trick method, time O(1);
	public void sortColors2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ;
        }
        
        int[] count = new int[3];
        
        for(int num : nums) {
            count[num]++;
        }
        
        int index = 0;
        
        for(int i = 0; i < count[0]; i++) {
            nums[index + i] = 0;
        }
        
        index += count[0];
        
        for(int i = 0; i < count[1]; i++) {
            nums[index + i] = 1;
        }
        
        index += count[1];
        
        for(int i = 0; i < count[2]; i++) {
            nums[index + i] = 2;
        }
    }
	
	// solution 3: can use to sort class, time O(n), space O(1) 
	public void sortColors3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ;
        }
        
        int index0 = 0, index2 = nums.length - 1;
        int currentIndex = 0;
        
        while(currentIndex <= index2) {
            if(nums[currentIndex] == 0) {
                swap(nums, currentIndex++, index0++);
            } else if(nums[currentIndex] == 1) {
                currentIndex++;
            } else {
                swap(nums, currentIndex, index2--);
            }
        }
    }
    
    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    
   
    
    
    /*** main function ***/
	
	public static void main(String[] args){
		Le_075_Sort_Colors t = new Le_075_Sort_Colors();
		int[] array = {2,1,0,2,0,1,1,2,1,0,2};
		t.sortColors(array);
		
		for(int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + ", ");
		}
			
	}
}
