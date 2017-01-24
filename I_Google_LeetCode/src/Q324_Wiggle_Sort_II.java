import java.util.Arrays;
/*******
 * 
Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example:
	(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
	(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

Note:
	You may assume all input has valid answer.

Follow Up:
	Can you do it in O(n) time and/or in-place with O(1) extra space?
	
 * 
 * 
 * */

public class Q324_Wiggle_Sort_II {	
	// solution 1: 
	public void wiggleSort(int[] nums) {
		if(nums == null || nums.length == 0) {
			return;
		}
		
        int len = (nums.length % 2 == 0) ? nums.length/2 : nums.length/2+1;
        Arrays.sort(nums);
        int[] arraySmall = new int[len];
        int[] arrayLarge = new int[nums.length-len];
        
        for(int i = 0, n = nums.length, len1 = arraySmall.length; i < n; ++i){
            if(i <= len1-1) {
                arraySmall[i] = nums[i];
            } else {
                arrayLarge[i-len1] = nums[i];
            }
        }
        
        int flag = 0;
        int x = 0, y = 0;
        
        for(int i = 0, n = nums.length; i < n; ++i){
            if(flag++ % 2 == 0) {
                nums[i] = arraySmall[x++];
            } else {
                nums[i] = arrayLarge[y++];
            }
        }
        
        return;
    }
	
	
	// solution 2: time is O(nlogn)
	public void wiggleSort2(int[] nums) {
		if(nums == null || nums.length == 0){
            return ;
        }
        
        int len = nums.length;
        Arrays.sort(nums);
        int mid = (len % 2 == 0) ? len / 2 - 1 : len / 2;
        int index = 0;
        int[] temp = new int[len];
        
        for(int i = 0; i <= mid; i++){
            temp[index] = nums[mid - i];
            
            if(index + 1 < len){
                temp[index + 1] = nums[len - 1 - i];
            }
            
            index += 2;
        }
        
        System.arraycopy(temp, 0, nums, 0, len);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/********************************************************/

	// 1 2 3 4 5 6 -7- 8 9 10 11 12 13
	// 13 2 3 4 5 6 7 8 9 10 11 12 1
		
	public void wiggleSort3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ;
        }
        
        int len = nums.length;
        nums = radixSort(nums);
        int mid = len % 2 == 0 ? len / 2 - 1 : len / 2;
        int index = 0;
        int[] tempArray = new int[len];
        
        print(nums);
        
        for (int i = 0; i <= mid; i++) {
            tempArray[index] = nums[mid - i];
            
            if (index + 1 < len) {
                tempArray[index + 1] = nums[len - 1 - i];
            }
            
            index += 2;
        }
        
        print(nums);
        print(tempArray);
        
        System.arraycopy(tempArray, 0, nums, 0, len);
    }
    
    public int[] radixSort(int[] nums) {
        int radix = 10;
        int len = nums.length;
        int divide = 1;
        
        for(int i = 0; i < 32; i++) {
            int[] tempArray = new int[len];
            int[] count = new int[32];
            
            for(int j = 0; j < len; j++) {
                int value = (nums[j] / divide) % radix;
                count[value]++;
            }
            
            for(int j = 1; j < radix; j++) {
                count[j] += count[j - 1];
            }
            
            for(int j = len - 1; j >= 0; j--) {
                int value = (nums[j] / divide) % radix;
                int pos = count[value] - 1;
                tempArray[pos] = nums[j];
                count[value]--;
            }
            
            divide *= radix;
            nums = tempArray;
        }
        
        return nums;
    }
    
    public void print(int[] nums) {
    	for(int num : nums) {
    		System.out.print(num + ", ");
    	}
    	System.out.println();
    }
    
    
    
    public static void main(String[] args){
		Q324_Wiggle_Sort_II t = new Q324_Wiggle_Sort_II();
		int[] nums = {1,1,1,5,4,6};
		t.wiggleSort3(nums);
		for(int i = 0; i < nums.length; ++i){
			System.out.print(nums[i] + ", ");
		}		
	}
}	
