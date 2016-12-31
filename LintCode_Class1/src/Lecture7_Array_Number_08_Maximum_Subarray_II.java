import java.util.ArrayList;


public class Lecture7_Array_Number_08_Maximum_Subarray_II {
	public int maxTwoSubArrays(ArrayList<Integer> nums) {
        if(nums == null || nums.size() == 0){
        	return 0;
        }
        int n = nums.size();
        int rightmax[] = new int[n]; 
        
        rightmax[n -1] = nums.get(n -1);
        int max = nums.get(n -1 );
        for (int i = n - 2; i >= 0; --i) {
        	max = Math.max(nums.get(i), nums.get(i) + max);
            rightmax[i] = Math.max(rightmax[i + 1], max);
        }
        
        // no need to store left max in an array
        int leftmax = nums.get(0);
        int res = leftmax + rightmax[1];
        
       
        for (int i = 1; i < n - 1; i++) {
        	leftmax = (leftmax > 0 ? leftmax : 0 ) + nums.get(i);
            res = Math.max(res, leftmax + rightmax[i  + 1]);
           
        }
        return res; 
    }
}
