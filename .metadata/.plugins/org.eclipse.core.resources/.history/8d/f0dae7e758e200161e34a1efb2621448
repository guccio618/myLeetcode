
public class Q034_Search_for_a_Range {
	//by jackie
	public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
           int[] res = {-1, -1};
           return res;
        }
        if(target > nums[nums.length-1] || target < nums[0]) {
           int[] res = {-1, -1};
           return res;
        }
        return findTarget(target, 0, nums.length-1, nums);
    }
    
    public int[] findTarget(int target, int start, int end, int[] array){
        if(start > end) {
            int[] res = {-1, -1};
            return res;
        }
        int mid = (start+end)/2;
        int midValue = array[mid];
        if(midValue > target)
            return findTarget(target, start, mid-1, array);           
        else if(midValue == target){
    		int i = mid, j = mid;
        	if(mid > 0 && array[mid-1] == target){
            	while(i >= 0 && array[i] == target) i--;
            	i++;
        	}
        	if(mid < array.length-1 && array[mid+1] == target){
        		while(j < array.length && array[j] == target) j++;
        		j--;
        	}
        	int[] res = {i, j};
        	return res;       	
        }
        else
            return findTarget(target, mid+1, end, array);
    }
    
    public static void main(String[] args){
    	Q034_Search_for_a_Range test = new Q034_Search_for_a_Range();
    	int target = 4;
    	int[] array = {1, 5};
    	int[] res = test.searchRange(array, target);
    	for(int i = 0; i < 2; ++i)
    		System.out.println(res[i]);
    }
}
