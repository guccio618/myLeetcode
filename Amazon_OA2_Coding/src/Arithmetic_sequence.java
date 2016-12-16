public class Arithmetic_sequence {
	// Time: O(n), Space: O(1)
	public static int getLAS(int[] A) {
		if (A.length < 3){
			return 0;
		}
		
		int res = 0;
		int diff = Integer.MIN_VALUE;
		int count = 0;
		int start = 0;
		
		for (int i = 1; i < A.length; i++) {
			int curDiff = A[i] - A[i - 1];
			
			if (diff == curDiff) {
				count += i - start - 1 > 0 ? i - start - 1 : 0;
			} else {
				start = i - 1;
				diff = curDiff;
				res += count;
				count = 0;
			}
		}
		
		res += count;     // 注意这里还要再加一次 ！！！
		return res;
	}
}
