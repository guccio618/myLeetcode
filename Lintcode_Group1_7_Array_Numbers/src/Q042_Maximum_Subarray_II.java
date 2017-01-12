import java.util.ArrayList;


public class Q042_Maximum_Subarray_II {
	/**********************************************/
	// by Jackie
	public int maxTwoSubArrays(ArrayList<Integer> nums) {
        int size = nums.size();
        int[] left = new int[size];
        int[] right = new int[size];
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < size; i++){
            sum += nums.get(i);
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);    // 如果前i-1个小于等于0, sum清零，从i起重新再起一个subarray
            left[i] = max;
        }
        
        sum = 0;
        max = Integer.MIN_VALUE;
        for(int i = size - 1; i >= 0; i--){
            sum += nums.get(i);
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
            right[i] = max;
        }

        max = Integer.MIN_VALUE;
        for(int i = 0; i < size - 1; i++){
            max = Math.max(max, left[i] + right[i + 1]);
        }
        return max;
    }
	
	
	/**********************************************/
	// by ninechapter, nice!
	public int maxTwoSubArrays2(ArrayList<Integer> nums) {
        int size = nums.size();
        int[] left = new int[size];
        int[] right = new int[size];
        int sum = 0;
        int minSum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < size; i++){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            left[i] = max;
        }
        sum = 0;
        minSum = 0;
        max = Integer.MIN_VALUE;
        for(int i = size - 1; i >= 0; i--){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            right[i] = max;
        }
        
        max = Integer.MIN_VALUE;
        for(int i = 0; i < size - 1; i++){
            max = Math.max(max, left[i] + right[i + 1]);
        }
        return max;
    }
	
	
	public static void main(String[] args){
		Q042_Maximum_Subarray_II t = new Q042_Maximum_Subarray_II();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(-4);
		nums.add(5);
		nums.add(-4);
		nums.add(5);
		nums.add(-4);
		nums.add(5);
		nums.add(-4);
		nums.add(5);
		nums.add(-4);
		nums.add(5);
		nums.add(-4);
		nums.add(5);
		nums.add(-4);
		nums.add(5);
		nums.add(-4);
		nums.add(5);
		nums.add(-4);
		nums.add(5);
		nums.add(-1000);
		
//		nums.add(1);
//		nums.add(3);
//		nums.add(-1);
//		nums.add(2);
//		nums.add(-1);
//		nums.add(2);
		
		System.out.println(t.maxTwoSubArrays(nums));
	}
}
