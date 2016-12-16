import java.util.Arrays;


public class Q169_Majority_Element {
	// by Jackie, time complexity is O(n);
	public int majorityElement(int[] nums) {
		if(nums == null || nums.length == 0){
            return 0;
        }
        
        int len = nums.length;
        int recordNum = nums[0];
        int count = 0;
        
        for(int i = 0; i < len; i++){
            if(recordNum == nums[i]){
                count++;
            } else {
                count--;
            }
            
            if(count == 0){
                recordNum = nums[i];
                count++;
            }
        }
        
        return recordNum;
    }
	
	
	// by Jackie, time complexity is O(nlogn)
	public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    
    public static void main(String[] args){
    	Q169_Majority_Element t = new Q169_Majority_Element();
    	int[] array = {3,6,1,2,7,3,3,3,3};
    	System.out.println(t.majorityElement(array));
    }
}
