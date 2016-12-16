import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Q018_4Sum {
	// by Jackie
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(nums == null || nums.length == 0) return res;
        int len = nums.length;
        Arrays.sort(nums);
        
        for(int i = 0; i < len-3; ++i){
            for(int j = i+1; j < len-2; ++j){
                int front = j+1, back = len-1, sum = 0;
                while(front < back){                	
                    sum = nums[i] + nums[j] + nums[front] + nums[back];
                    if(sum > target) back--;
                    else if(sum < target) front++;
                    else{
                        LinkedList<Integer> temp = new LinkedList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[front]);
                        temp.add(nums[back]);
                        res.add(new LinkedList<Integer>(temp));
                        while(front < back && nums[front] == nums[front+1]) front++;  // reduce duplicate
                        front++;                                                      // 移除重复之后，再front++一次       
                    	while(front < back && nums[back] == nums[back-1]) back--;     // reduce duplicate
                    	back--;                                                       // 移除重复之后，再back--一次     
                    }
                }
                while(j+1 < len-2 && nums[j] == nums[j+1]) j++;  // reduce duplicate
            }
            while(i+1 < len-3 && nums[i] == nums[i+1]) i++;      // reduce duplicate
        }
        return res;
    }
	
	
	public static void main(String[] args){
		Q018_4Sum t = new Q018_4Sum();
//		int[] nums = {-1,-1,-1,1,1,1,1};
		int[] nums = {-1,0,-5,-2,-2,-4,0,1,-2};
		List<List<Integer>> res = t.fourSum(nums, -9);
		for(int i = 0; i < res.size(); ++i)
			System.out.print(res.get(i) + ", ");
		System.out.println();
	}
}
