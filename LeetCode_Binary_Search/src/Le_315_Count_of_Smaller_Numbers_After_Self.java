import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Le_315_Count_of_Smaller_Numbers_After_Self {
	public List<Integer> countSmaller(int[] nums) {
		if(nums == null || nums.length == 0){
			return new ArrayList<Integer>();
		}
		
		Integer[] ans = new Integer[nums.length];
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = nums.length - 1; i >= 0; --i){
			int pos = findPos(nums[i], list);
			ans[i] = pos;
			list.add(pos, nums[i]);
		}
		return Arrays.asList(ans);
	}
	
	public int findPos(int target, ArrayList<Integer> list){
		if(list.size() == 0){
			return 0;
		} else if(target <= list.get(0)){
			return 0;
		} else if(target > list.get(list.size() - 1)){
			return list.size();
		}
		
		int left = 0, right = list.size() - 1;
		while(left + 1 < right){
			int mid = left + (right - left) / 2;
			int num = list.get(mid);
			if(num < target){
				left = mid;
			} else {
				right = mid;
			}
		}
		
		if(list.get(left) >= target){
			return left;
		} else {
			return right;
		} 
	}
}
