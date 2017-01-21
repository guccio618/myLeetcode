import java.util.*;

public class Q12_1_Average_Double_Array {
	public double findAverageOfDoubleArray(double[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		} else if(nums.length == 1){
			return nums[0];
		}
		
		double sum = 0;
		int len = nums.length;
		Arrays.sort(nums);
		
		for(double num : nums) {		
			sum += num/len;
			System.out.println(sum);
		}
		
		return sum;
	}
	
	
	
	
	
	
	/***************************** main function ********************************/
	
	public static void main(String[] args) {
		Q12_1_Average_Double_Array t = new Q12_1_Average_Double_Array();
//		double[] nums = {1.0,2.0,3.0,4.0,5.0};
		double[] nums = {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, -4.0}; //, 1.0, 2.0};
		System.out.println((Double.MIN_VALUE));
		System.out.println((Double.MIN_VALUE - 1));
		System.out.println(t.findAverageOfDoubleArray(nums));
	}
}
