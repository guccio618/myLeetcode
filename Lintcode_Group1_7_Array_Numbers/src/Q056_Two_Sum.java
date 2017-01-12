import java.util.HashMap;


public class Q056_Two_Sum {
	// by Jackie
	public int[] twoSum(int[] numbers, int target) {
        // write your code here
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
}
