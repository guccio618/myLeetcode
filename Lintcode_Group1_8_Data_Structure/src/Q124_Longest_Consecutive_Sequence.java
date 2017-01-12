import java.util.Arrays;
import java.util.HashMap;


public class Q124_Longest_Consecutive_Sequence {
	/****************************************************/
	// by Jackie	
	public int longestConsecutive(int[] num) {
		if(num == null || num.length == 0){
			return 0;
		}
		
		int maxLong = 1;
		int count = 1;
		Arrays.sort(num);

		for(int i = 1; i < num.length; ++i){
			if(num[i] == num[i - 1]){
				continue;
			}
			if(num[i] == num[i - 1] + 1){
				count++;
			} else{
				maxLong = Math.max(maxLong, count);
				count = 1;
			}
		}
		
		return Math.max(maxLong, count);
	}
	
	
	
	/****************************************************/
	// by other
	public int longest2Consecutive(int[] num) {
		if (num == null || num.length == 0) {
			return 0;
		}
		HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
		int maxLong = 1;
		int temp = 0, currentMaxLong = 0;
		for (int i : num)
			myMap.put(i, 0);

		for (int i : num) {
			if (myMap.get(i) == 1){       // 已访问过
				continue;
			}
			temp = i;
			currentMaxLong = 1;
			while (myMap.containsKey(temp + 1)) {   // 找右边上界
				currentMaxLong++;
				temp++;
				myMap.put(temp, 1);
			}

			temp = i;
			while (myMap.containsKey(temp - 1)) {   // 找左边下届
				currentMaxLong++;
				temp--;
				myMap.put(temp, 1);
			}

			maxLong = Math.max(currentMaxLong, maxLong);
		}
		return maxLong;
	}
	
	
		
	/**************************** main function ***************************/
	
	public static void main(String[] args){
		Q124_Longest_Consecutive_Sequence t = new Q124_Longest_Consecutive_Sequence();
		int[] num = {9,1,4,7,3,-1,0,5,8,-1,6};
		System.out.println(t.longestConsecutive(num));
	}
}
