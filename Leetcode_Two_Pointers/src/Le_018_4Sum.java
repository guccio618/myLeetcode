import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/********
 * 
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

 * 
 * */

public class Le_018_4Sum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
		
        if(nums == null || nums.length == 0) {
        	return res;
        }
        
        int len = nums.length;
        Arrays.sort(nums);
        
        for(int i = 0; i < len-3; ++i){
            for(int j = i+1; j < len-2; ++j){
                int front = j+1, back = len-1, sum = 0;
                
                while(front < back){                	
                    sum = nums[i] + nums[j] + nums[front] + nums[back];
                    
                    if(sum > target) {
                    	back--;
                    } else if(sum < target) {
                    	front++;
                    } else{
                        LinkedList<Integer> list = new LinkedList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[front]);
                        list.add(nums[back]);
                        res.add(new LinkedList<Integer>(list));
                        
                        int num1 = nums[front], num2 = nums[back];
                        
                        while(front < back && nums[front] == num1) {   // reduce duplicate
                        	front++;
                        }                                                                       
                    	while(front < back && nums[back] == num2) {     // reduce duplicate
                    		back--;     
                    	}
                    }
                }
                
                while(j+1 < len-2 && nums[j] == nums[j+1]) {                    // reduce duplicate
                	j++;  
                }
            }
            
            while(i+1 < len-3 && nums[i] == nums[i+1]) {                        // reduce duplicate
            	i++;      
            }
        }
        
        return res;
    }
	
	
	
	
	
	
	
	
	
	/*********************************** main function ****************************************/
	
	public static void main(String[] args){
		Le_018_4Sum t = new Le_018_4Sum();
//		int[] nums = {-1,-1,-1,1,1,1,1};
		int[] nums = {-1,0,-5,-2,-2,-4,0,1,-2};
		List<List<Integer>> res = t.fourSum(nums, -9);
		for(int i = 0; i < res.size(); ++i)
			System.out.print(res.get(i) + ", ");
		System.out.println();
	}
}
