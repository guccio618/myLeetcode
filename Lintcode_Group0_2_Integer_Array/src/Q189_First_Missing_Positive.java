import java.util.Arrays;


public class Q189_First_Missing_Positive {
	// by Jackie
	public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 1;
        }   
        Arrays.sort(nums);
        int back = nums[0];
        int front = back + 1;
        int count = 0;
        
        if(back > 1){
            return back - 1;
        }
        
        while(count < nums.length - 1){             
            if(front != nums[count + 1]){
                if(front > 0){
                    return front;
                } 
            } 
            
            count++;
            back = nums[count];
            front = back + 1;
            
            while(count + 1 < nums.length - 1 && nums[count] == nums[count + 1]){
            	count++;
            	back = nums[count];
                front = back + 1;
            }
        }
        
        while(front <= 0){
            front++;
        }
        
        return front;
    }
	
	
	
	public static void main(String[] args){
		Q189_First_Missing_Positive t = new Q189_First_Missing_Positive();
		int[] nums = {2,2,4,0,1,3,3,3,4,3};
		System.out.println(t.firstMissingPositive(nums));
	}
}
