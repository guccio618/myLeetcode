/****
 * 
Given a sorted array of integers nums and integer values a, b and c. Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.

The returned array must be in sorted order.

Expected time complexity: O(n)

Example:
	nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,
	Result: [3, 9, 15, 33]

	nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5
	Result: [-23, -5, 1, 7]
 * 
 * */


public class Le_360_Sort_Transformed_Array {
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		// using merge sort, time is O(n)
		if(nums == null || nums.length == 0){
	    	return new int[0];
	    }
		
		int len = nums.length;
		int index = (a >= 0) ? len - 1 : 0;
		int[] ans = new int[len];
		int left = 0, right = len - 1;
		
		while(left <= right){
			int num1 = getResult(nums[left], a, b, c);
			int num2 = getResult(nums[right], a, b, c);
			
			if(a >= 0){
				if(num1 > num2){
					ans[index--] = num1;
					left++;
				} else {
					ans[index--] = num2;
					right--;
				}
			} else {
				if(num1 > num2){
					ans[index++] = num2;
					right--;
				} else {
					ans[index++] = num1;
					left++;
				}
			}
		}
		
		return ans;
	}

	public int getResult(int x, int a, int b, int c){
		return a * x * x + b * x + c;
	}
	
	
	
	
    
	
	
	
    /****************************** main function ***************************************/ 
    
    public static void main(String[] args){
    	Le_360_Sort_Transformed_Array t = new Le_360_Sort_Transformed_Array();
    	int[] nums = {-4, -2, 2, 4};
    	int a = -1;
    	int b = 3;
    	int c = 5;
    	
    	int[] ans = t.sortTransformedArray(nums, a, b, c);
    	
    	for(int i = 0; i < ans.length; i++){
    		System.out.print(ans[i] + ", ");
    	}
    }
}
