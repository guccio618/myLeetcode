
public class Lecture3_Data_Structure_II_04_Heapify {
	public void heapify(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int len = nums.length;
        for(int i = len / 2 - 1; i >= 0; --i){
            heapify(nums, i, len);
        }
    }
    
    public void heapify(int[] nums, int i, int max){
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int smallest = i;
        
        if(left < max && nums[left] < nums[smallest]){
            smallest = left;
        }
        if(right < max && nums[right] < nums[smallest]){
            smallest = right;
        }
        
        if(smallest != i){
            int temp = nums[i];
            nums[i] = nums[smallest];
            nums[smallest] = temp;
            heapify(nums, smallest, max);
        }
    }
}
