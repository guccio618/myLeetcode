import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Q384_Shuffle_an_Array {
	// by other
	private int[] nums;
    private java.util.Random rand;

    public Q384_Shuffle_an_Array(int[] nums) {
    	this.nums = nums;
        rand = new java.util.Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(nums == null){
            return null;
        }
        
        int[] ans = nums.clone();
        
        for(int i = 1; i < nums.length; i++){
		    int j = rand.nextInt(i + 1);
		    swap(ans, i, j);
	    }
	    
	    return ans;
    }
    
    public void swap(int[] ans, int i, int j){
        int temp = ans[i];
        ans[i] = ans[j];
        ans[j] = temp;
    }
    
    public static void main(String[] args){
    	int[] nums = {1, 2, 3};
    	Q384_Shuffle_an_Array t = new Q384_Shuffle_an_Array(nums);
    	int[] ans = t.shuffle();
    	
    	for(int num : ans){
    		System.out.print(num + ", ");
    	}
    	
    	System.out.println();
    	
    	t.reset();
    	
    	int[] ans2 = t.shuffle();
    	
    	for(int num : ans2){
    		System.out.print(num + ", ");
    	}
    	
    	System.out.println();
    }
}
