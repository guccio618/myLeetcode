import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Q128_Longest_Consecutive_Sequence {
	//by other, O(n)
	public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Set<Integer> set = new HashSet<>();
        int maxLen = 0;
        
        for (int num : nums) {
            set.add(num);
        }
        
        for (int i = 0; i < nums.length; i++) {
            int left = nums[i] - 1;
            int right = nums[i] + 1;
            
            while (set.contains(left)) {
                set.remove(left);
                left--;
            }
            
            while (set.contains(right)) {
                set.remove(right);
                right++;
            }
            
            maxLen = Math.max(maxLen, right - left - 1);
        }
        
        return maxLen;
    }
	
	
	
	
	//by ninechapter but not O(n)
	public int longestConsecutive2(int[] nums) {
        HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        int maxLong = 1;
        int temp = 0, currentMaxLong = 0;
        for(int i : nums)
            myMap.put(i, 0);
        
        for(int i : nums){
            if(myMap.get(i) == 1) continue;
            temp = i;
            currentMaxLong = 1;
            while(myMap.containsKey(temp + 1)){
                currentMaxLong++;
                temp++;
                myMap.put(temp, 1);
            }
            
            temp = i;
            while(myMap.containsKey(temp - 1)){
                currentMaxLong++;
                temp--;
                myMap.put(temp, 1);
            }
            
            maxLong = Math.max(currentMaxLong, maxLong);
        }
        return maxLong;
    }
}
