

import java.util.ArrayList;
import java.util.List;
/******************************************************************
 * lower -> nums[0],  nums[i] -> nums[i + 1], nums[n - 1] -> upper
 * 
 ******************************************************************/

public class Le_163_Missing_Ranges {
	// by other, very faster
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<String>();
        if(upper < lower){
            return ans;
        }
        
        int len = nums.length;
        int nextNum = lower;
        
        for(int i = 0; i < len; i++){
            if(nums[i] < nextNum){
                continue;
            } else if(nums[i] == nextNum){
                nextNum++;
                continue;
            } else {
                ans.add(getStr(nextNum, nums[i] - 1));
                nextNum = nums[i] + 1;
            }
        }
        
        if(nextNum <= upper){
            ans.add(getStr(nextNum, upper));
        }
        
        return ans;
    }
    
    public String getStr(int num1, int num2){
        if(num1 == num2){
            return Integer.toString(num1);
        } else {
            return String.format("%d->%d", num1, num2);
        }
    }
	
    
    
    // by Jackie, too complex
	public List<String> findMissingRanges2(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<String>();
        int startValue = 0, endValue = 0;
        int end = 0;
        int n = nums.length;
        
        if(nums == null || nums.length == 0 || lower > upper){     
            startValue = lower;
            endValue = upper;
            StringBuffer builder = new StringBuffer();
            if(startValue == endValue){
                builder.append(startValue);
            } else {
                builder.append(startValue).append("->").append(endValue);
            }
            ans.add(builder.toString());
            return ans;
        }

        if(lower < nums[0]){
            startValue = lower;
            endValue = nums[0] - 1;
            StringBuffer builder = new StringBuffer();
            if(startValue == endValue){
                builder.append(startValue);
            } else {
                builder.append(startValue).append("->").append(endValue);
            }
            ans.add(builder.toString());
        }
        
        while(end < n - 1){
            while(end < n - 1 && nums[end] + 1 == nums[end + 1]){
                end++;
            }
            
            if(end < n - 1){
                startValue = nums[end] + 1;
                endValue = nums[end + 1] - 1;
                StringBuffer builder = new StringBuffer();
                if(startValue == endValue){
                    builder.append(startValue);
                } else {
                    builder.append(startValue).append("->").append(endValue);
                }
                ans.add(builder.toString());
                end++;
            }
        }
        
        if(upper > nums[n - 1]){
            startValue = nums[n - 1] + 1;
            endValue = upper;
            StringBuffer builder = new StringBuffer();
            if(startValue == endValue){
                builder.append(startValue);
            } else {
                builder.append(startValue).append("->").append(endValue);
            }
            ans.add(builder.toString());
        }
        
        return ans;
    }
    
    public void addToList(List<String> ans, int sValue, int eValue){
        StringBuffer builder = new StringBuffer();
        if(sValue == eValue){
            builder.append(sValue);
        } else {
            builder.append(sValue).append("->").append(eValue);
        }
        ans.add(builder.toString());
    }
}
