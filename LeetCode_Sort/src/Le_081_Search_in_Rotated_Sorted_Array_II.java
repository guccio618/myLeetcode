
public class Le_081_Search_in_Rotated_Sorted_Array_II {
	public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return false;
        }
        
        int n = nums.length;
        int left = 0, right = n - 1;
        
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(target == nums[mid]){
                return true;
            } else if(nums[mid] > nums[left] || nums[mid] > nums[right]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid;
                } else {
                    left = mid;
                }
        
            } else if(nums[mid] < nums[left] || nums[mid] < nums[right]){
                if(target <= nums[right] && target > nums[mid]){
                    left = mid;
                } else {
                    right = mid;
                }
            } else {
                right--;
            }
        }
        
        if(nums[left] == target || nums[right] == target){
            return true;
        }
        
        return false;
    }
	
	public static void main(String[] args){
		String str = " ";
        String[] array = str.split("\\s{1,}");
		System.out.println(array.length);
        for(int i = 0; i < array.length; i++){
        	System.out.println(array[i]);
        }
        System.out.println();
	}
}
