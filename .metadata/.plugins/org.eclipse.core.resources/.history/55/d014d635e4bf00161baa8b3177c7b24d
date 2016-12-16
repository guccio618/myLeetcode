import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*****
 * 
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 * 
 * */


public class Q015_3Sum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return ans;
        }
        
        int len = nums.length;
        int left = 0, right = 0;
        Arrays.sort(nums);
        
        for(int i = 0; i < len - 2; i++){
            left = i + 1;
            right = len - 1;
            
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                
                if(sum > 0){
                    right--;
                } else if(sum < 0){
                    left++;
                } else {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);
                    
                    int leftNum = nums[left];
                    int rightNum = nums[right];
                    
                    while(left < right && nums[left] == leftNum){   // left 和 right 均要排除重复值 ！！！
                        left++;
                    }
                    
                    while(left < right && nums[right] == rightNum){
                        right--;
                    }
                }
            }
            
            while(i + 1 < len && nums[i] == nums[i + 1]){
                i++;
            }
        }
        
        return ans;
	}
	
	public static void main(String[] args){
		Q015_3Sum s = new Q015_3Sum();
		int[] array = {-2,0,1,1,2};
		List<List<Integer>> res = s.threeSum(array);
		for(int i = 0; i < res.size(); i++){
			for(int j = 0; j < res.get(i).size(); j++)
				System.out.print(res.get(i).get(j) + ", ");
			System.out.println();
		}
	}
}
