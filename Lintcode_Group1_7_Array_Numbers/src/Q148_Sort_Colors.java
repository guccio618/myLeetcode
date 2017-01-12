
public class Q148_Sort_Colors {
	// by Jackie using quicksort
	public void sortColors(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return ;
        }
        quickSort(nums, 0, nums.length - 1);
    }
    
    public void quickSort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int i = left, j = right;
        double pivot = (nums[left] + nums[right]) / 2.0;
        while(i < j){
            while(i < right && nums[i] < pivot){
                i++;
            }
            while(j > left && nums[j] >= pivot){
                j--;
            }
            if(i < j){
                int temp = nums[i];
                nums[i] = nums[j]; 
                nums[j] = temp;
            }
        }
        if(j > left){
            quickSort(nums, left, j);
        }
        if(j + 1 < right){
            quickSort(nums, j + 1, right);
        }
    }
}
