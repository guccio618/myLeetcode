import java.util.ArrayList;
import java.util.Arrays;


public class Q058_4Sum {
	// by Jackie
	public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(numbers == null || numbers.length == 0){
            return res;
        }
        Arrays.sort(numbers);
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(numbers, 0, target, list, res);
        return res;
    }

    public void helper(int[] numbers, int pos, int target, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res){
        if(list.size() == 4){
            if(target == 0){
                res.add(new ArrayList<Integer>(list));
            }
            return;
        }

        for(int i = pos; i < numbers.length; ++i){
            if(i != pos && numbers[i - 1] == numbers[i]){
                continue;
            }
            list.add(numbers[i]);
            helper(numbers, i + 1, target - numbers[i], list, res);
            list.remove(list.size() - 1);
        }
    }    
}
