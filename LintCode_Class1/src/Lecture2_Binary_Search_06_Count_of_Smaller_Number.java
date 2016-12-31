import java.util.ArrayList;
import java.util.Arrays;


public class Lecture2_Binary_Search_06_Count_of_Smaller_Number {
	public ArrayList<Integer> countOfSmallerNumber(int[] nums, int[] queries) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0 || queries == null || queries.length == 0){
            return res;
        }
        int qLen = queries.length; 
        Arrays.sort(nums);
        
        for(int i = 0; i < qLen; ++i){
            res.add(findPos(nums, queries[i]));
        }
        
        return res;
    }
	    
    public int findPos(int[] nums, int target){
        int left = 0, right = nums.length -1;
        int mid = 0;
        
        while(left + 1 < right){
            mid = left + (right - left) / 2;
            if(nums[mid] > target){
                right = mid;
            }
            else if(nums[mid] < target){
                left = mid;
            }
            else{
                right = mid;  // 当数组不止有一个target时，找最左边的边界，因此当找到一个target时，继续让right往左移
            }
        }
        
        if(nums[left] >= target){
            return left;
        }
        else if(nums[right] >= target){
        	return right;
        }
        else{
            return right + 1;
        }
    }

    
    
    /****************************************** main function *********************************************/
    public static void main(String[] args){
    	Lecture2_Binary_Search_06_Count_of_Smaller_Number t = new Lecture2_Binary_Search_06_Count_of_Smaller_Number();
    	int[] nums = {39,49,13,22,25,57,92,92,94,56,54,70,9,52,63,75,55,33,79,13,52,35,11,17,99,65,86,22,31,53,91,51,18,71,70,23,73,50,35,51,38,13,80,81,54,58,40,1,80,70,1,53,63,74,48,18,52,80,6,42};
    	int[] q = {3,83,39,95,28,59,6,74,29,61,48,52};
    	ArrayList<Integer> res = t.countOfSmallerNumber(nums, q);
    	for(int i = 0; i < res.size(); ++i){
    		System.out.print(res.get(i) + ", ");
    	}
    	
    }
}
