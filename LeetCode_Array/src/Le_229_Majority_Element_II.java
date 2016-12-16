import java.util.ArrayList;
import java.util.List;


public class Le_229_Majority_Element_II {
	public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return ans;
        }
        
        int[] x = new int[2];
        int count1 = 0, count2 = 0;
        int n = nums.length;
        
        for(int i = 0; i < n; i++){
            if(x[0] == nums[i]){
                count1++;
            } else if(x[1] == nums[i]){
                count2++;
            } else if(count1 == 0){
                x[0] = nums[i];
                count1 = 1;
            } else if(count2 == 0){
                x[1] = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        
        for(int i = 0; i < n; i++){
            if(nums[i] == x[0]){
                count1++;
            }
            if(nums[i] == x[1]){
                count2++;
            }
        }
        
        if(count1 > n / 3){
            ans.add(x[0]);
        }
        if(count2 > n / 3 && !ans.contains(x[1])){
            ans.add(x[1]);
        }
        
        return ans;
    }
}
