import java.util.*;

public class Q18_1_Find_Double_In_Set {
	public double findDoubleInSet(double[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		int len = nums.length;
		int maxLen = 1;
		double ans = 0;
		Arrays.sort(nums);
		
		for(int faster = 0, slower = 0; faster < len; faster++) {			
			while(nums[faster] - nums[slower] >= 1) {
				slower++;
			}
			
			if(maxLen < faster - slower + 1) {
				maxLen = faster - slower + 1;
				ans = nums[slower];
			}
		}
		
		return ans;
	}
	
	
	
	
	
	
	
	
	
	
	/****************************** main function ***************************************/
	
	public static void main(String[] args) {
		Q18_1_Find_Double_In_Set t = new Q18_1_Find_Double_In_Set();
		double[] nums = {2.7, 0.23, 8.32, 9.65, -6.55, 1.55, 1.98, 7.11, 0.49, 2.75, 2.95, -96.023, 0.14, 8.60};
		System.out.println(t.findDoubleInSet(nums));
	}
}
