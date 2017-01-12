import java.util.Arrays;


public class Q172_Remove_Element {
	// by Jackie
	public int removeElement(int[] nums, int elem) {
		if(nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        if(elem < nums[0] || elem > nums[nums.length - 1]){
            return nums.length;
        }
        
        int leftBound = 0, rightBound = 0;
        int left = 0, right = nums.length - 1;
        
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(elem > nums[mid]){
                left = mid;
            } else{
                right = mid;
            }
        }
        if(nums[left] == elem){
            leftBound = left;
        } else if(nums[right] == elem){
            leftBound = right;
        } else{
            return nums.length;
        }
        
        left = leftBound;
        right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(elem >= nums[mid]){
                left = mid;
            } else{
                right = mid;
            }
        }
        rightBound = (nums[right] == elem) ? right : left;
        
        int res = rightBound - leftBound + 1;
        
        for(int i = rightBound + 1; i < nums.length; ++i){
            nums[i - res] = nums[i]; 
        }
        
        return nums.length - res;
    }
	
	
	
	public static void main(String[] args){
		Q172_Remove_Element t = new Q172_Remove_Element();
		int[] nums = {7,25,21,2,20,7,24,9,24,24,6,22,5,1,26,17,18,29,25,9,8,27,6,26,8,5,27,5,0,29,26,29,24,18,23,14,25,17,15,20,11,22,4,17,15,0,26,3,21,21,12,0,10,10,26,19,15,23,16,7,14,12,7,8,0,0,14,26,18,22,8,21,6,12,0,21,4,26,16,26,18,21};
		
		int n = t.removeElement(nums, 26);
		System.out.println("n = " + n);
		
		for(int i = 0; i < n; ++i){
			System.out.print(nums[i] + ", ");
		}
	}
}
