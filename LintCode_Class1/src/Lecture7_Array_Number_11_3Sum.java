import java.util.ArrayList;
import java.util.Arrays;

public class Lecture7_Array_Number_11_3Sum {
	/************************************************************************
	 * Using pointer
	 * 
	 ************************************************************************/

	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length < 3) {
			return rst;
		}
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			if (i != 0 && num[i] == num[i - 1]) {
				continue; // to skip duplicate numbers; e.g [0,0,0,0]
			}

			int left = i + 1;
			int right = num.length - 1;
			while (left < right) {
				int sum = num[left] + num[right] + num[i];
				if (sum == 0) {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(num[i]);
					tmp.add(num[left]);
					tmp.add(num[right]);
					rst.add(tmp);
					left++;
					right--;
					while (left < right && num[left] == num[left - 1]) { // to skip duplicates
						left++;
					}
					while (left < right && num[right] == num[right + 1]) { // to skip duplicates
						right--;
					}
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		return rst;
	}

	
	
	/************************************************************************
	 * Using recursive
	 * 
	 ************************************************************************/
	
	public ArrayList<ArrayList<Integer>> threeSum2(int[] numbers) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (numbers == null || numbers.length == 0) {
			return res;
		}
		int len = numbers.length;
		Arrays.sort(numbers);

		ArrayList<Integer> list = new ArrayList<Integer>();
		helper(numbers, 0, 0, res, list);
		return res;
	}

	public void helper(int[] numbers, int pos, int sum,
			ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list) {
		if (list.size() == 3) {
			if (sum == 0) {
				res.add(new ArrayList<Integer>(list));
			}
			return;
		}

		for (int i = pos; i < numbers.length; ++i) {
			if (i != pos && numbers[i] == numbers[i - 1]) {
				continue;
			}
			list.add(numbers[i]);
			helper(numbers, i + 1, sum + numbers[i], res, list);
			list.remove(list.size() - 1);
		}
	}
}
