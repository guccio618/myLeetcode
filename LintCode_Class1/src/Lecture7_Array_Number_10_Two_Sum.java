import java.util.Arrays;
import java.util.HashMap;


public class Lecture7_Array_Number_10_Two_Sum {
	/************************************************************************
	 * Using HashMap
	 * 
	 ************************************************************************/
	
	public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0, len = numbers.length; i < len; ++i){
            if(map.containsKey(target - numbers[i])){
                res[0] = map.get(target - numbers[i]) + 1;
                res[1] = i + 1;
                return res;
            }
            else{
                map.put(numbers[i], i);
            }
        }
        return res;
    }
	
	
	/************************************************************************
	 * Using pointer
	 * 
	 ************************************************************************/
	public int[] twoSum_pointer2(int[] numbers, int target) {
    	if(numbers == null || numbers.length < 2) {
    		return null;
    	}
        Arrays.sort(numbers);
        int left = 0;
        int right = numbers.length - 1;
        int[] rst = new int[2];
        
        while(left < right){
            int sum = numbers[left] +  numbers[right];
            if(sum == target){
                rst[0] = left + 1;
                rst[1] = right + 1;
                break;
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }
        return rst;
    }
}	
