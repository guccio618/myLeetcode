
public class Q031_Partition_Array {
	// by Jackie, O(n)
	public int partitionArray(int[] nums, int k) {
	    //write your code here
	    if(nums == null || nums.length == 0){
	        return 0;
	    }
	    int left = 0, right = nums.length - 1;
	    while(left < right){
	        while(left < nums.length && nums[left] < k){
	            left++;
	        }
	        while(right >= 0 && nums[right] >= k){
	            right--;
	        }
	        if(left < right){
	            int temp = nums[left];
	            nums[left] = nums[right];
	            nums[right] = temp;
	        }
	    }
	    return left;
    }
	
	
	public static void main(String[] args){
		Q031_Partition_Array t = new Q031_Partition_Array();
		int[] nums = {7,7,9,8,6,6,8,7,9,8,6,6};
		System.out.println(t.partitionArray(nums, 10));
	}
}
