import java.util.ArrayList;
import java.util.Arrays;


public class Lecture7_Array_Number_13_4Sum {
	/************************************************************************
	 * Using pointer, 可以优化为哈西表折半查找法
	 * 
	 ************************************************************************/
	
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);

		for (int i = 0; i < num.length - 3; i++) {
			if (i != 0 && num[i] == num[i - 1]) {
				continue;
			}

			for (int j = i + 1; j < num.length - 2; j++) {
				if (j != i + 1 && num[j] == num[j - 1])
					continue;

				int left = j + 1;
				int right = num.length - 1;
				while (left < right) {
					int sum = num[i] + num[j] + num[left] + num[right];
					if (sum < target) {
						left++;
					} else if (sum > target) {
						right--;
					} else {
						ArrayList<Integer> tmp = new ArrayList<Integer>();
						tmp.add(num[i]);
						tmp.add(num[j]);
						tmp.add(num[left]);
						tmp.add(num[right]);
						rst.add(tmp);
						left++;
						right--;
						while (left < right && num[left] == num[left - 1]) {
							left++;
						}
						while (left < right && num[right] == num[right + 1]) {
							right--;
						}
					}
				}
			}
		}

		return rst;
	}
	
	
	
	
	/************************************************************************
	 * Using recursive
	 * 
	 ************************************************************************/
	
	public ArrayList<ArrayList<Integer>> fourSum2(int[] numbers, int target) {
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
