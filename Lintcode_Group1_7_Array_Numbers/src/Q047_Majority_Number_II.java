import java.util.ArrayList;


public class Q047_Majority_Number_II {
	// by ninechapter
	public int majorityNumber(ArrayList<Integer> nums) {
        if(nums == null || nums.size() == 0){
            return -1;
        }
        int count1 = 0, count2 = 0;
        int candidate1 = -1, candidate2 = -1;
        int len = nums.size();
        int n = 0;
        
        for(int i = 0; i < len; ++i){
            n = nums.get(i);
            if(candidate1 == n){
                count1++;
            } else if(candidate2 == n){
                count2++;
            } else if(count1 == 0){
                candidate1 = n;
                count1 = 1;
            } else if(count2 == 0){
                candidate2 = n;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        
        count1 = count2 = 0;
        for(int i = 0; i < len; ++i){
            n = nums.get(i);
            if(candidate1 == n){
                count1++;
            } else if(candidate2 == n){
                count2++;
            }
        }
        
        if(count1 > count2){
            if(count1 > len / 3){
                return candidate1;
            }
            else{
                return -1;
            }
        } else{
            if(count2 > len / 3){
                return candidate2;
            }
            else{
                return -1;
            }
        }
    }
}
