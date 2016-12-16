public class Q000_largestSubsequency {
	public static void main(String[] args) {
		int[] a = { -2, 5, 1, 0, 2, -6, 7, -3 };
		int[] out = maxSubArray(a);
		System.out.println(out[0] + ":" + out[1] + ":" + out[2]);
	}

	public static int[] maxSubArray(int[] A) {
		int res[] = {0, 0, 0};
		if (A.length == 0)
			return res;
		int n = A.length;
		int global_front = 0, global_back = 0;
		int local_front = 0, local_end = 0;
		int[] global = new int[n];
		int[] local = new int[n];
		global[0] = A[0];
		local[0] = A[0];
		
		for (int i = 1; i < n; i++) {
			if(local[i-1] > 0){           //
				local[i] = local[i-1] + A[i];
				local_end = i;
			}
			else{
				local[i] = A[i];
				local_front = local_end = i;
			}
			if(local[i] > global[i-1]){
				global[i] = local[i];
				global_front = local_front;
				global_back = local_end;
			}
			else{
				global[i] = global[i-1];
			}
			// local[i] = Integer.max(local[i-1]+A[i], A[i]);
			// global[i] = Integer.max(local[i], global[i-1]);
		}
		res[0] = global[n - 1];
		res[1] = global_front+1;
		res[2] = global_back+1;
		return res;
	}
}
