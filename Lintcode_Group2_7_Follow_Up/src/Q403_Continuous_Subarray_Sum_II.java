import java.util.ArrayList;


public class Q403_Continuous_Subarray_Sum_II {
	public ArrayList<Integer> continuousSubarraySumII(int[] nums) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return ans;
        } else if(nums.length == 1){
            ans.add(0);
            ans.add(0);
            return ans;
        }
        
        int n = nums.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int localStart = 0, localEnd = 0;
        int globalStart = 0, globalEnd = 0;
        boolean positiveFlag = true;
        boolean secondRoundFlag = false;
        int index = 0;
        
        while(localStart + 1 <= localEnd){
        	System.out.println("in here");
        	sum += nums[index % n];
        	if(max < sum){
        		max = sum;
        		localEnd = index % n;
    			globalStart = localStart;
    			globalEnd = localEnd;
        	}
        	
        	if(sum < 0){
        		if(secondRoundFlag == true){
        			break;
        		} else{
        			sum = 0;
        			positiveFlag = false;
        			localStart = index + 1;
        		}
        	}
        	
        	if(++index >= n){
        		if(positiveFlag == true){
        			break;
        		}
        		secondRoundFlag = true;
        	}
        }
        
        ans.add(globalStart);
        ans.add(globalEnd);
        return ans;
    }
	
	
	
	public static void main(String[] args){
		Q403_Continuous_Subarray_Sum_II t = new Q403_Continuous_Subarray_Sum_II();
		int[] nums = {2,-1,-2,-3,-100,1,2,3,100};
		ArrayList<Integer> ans = t.continuousSubarraySumII(nums);
		
		for(int i = 0; i < ans.size(); ++i){
			System.out.print(ans.get(i) + ", ");
		}
	}
	
}
