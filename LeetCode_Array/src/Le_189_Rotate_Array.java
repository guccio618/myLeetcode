/*******************************************************************
 * Rotate an array of n elements to the right by k steps. For example, with n =
 * 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 *******************************************************************/

public class Le_189_Rotate_Array {
	// solution 1: right rotate, using reverse, time O(2n);
	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k <= 0) {
			return;
		}

		k %= nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	public void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

	
	
	// solution 2: right rotate, using swap, time O(n);
	public void rotate2(int[] nums, int k) {
		if (nums == null || nums.length <= 1 || k <= 0) {
			return;
		}

		int len = nums.length;
		k = k % len;
		int steps = gcd(k, len);

		for (int i = len - 1; i >= len - steps; i--) {
			int faster = (i - k >= 0) ? i - k : len + (i - k);
			int slower = i;
			int temp = nums[i];

			while (faster != i) {
				nums[slower] = nums[faster];
				slower = faster;
				faster = (faster - k >= 0) ? faster - k : len + (faster - k);
			}

			nums[slower] = temp;
		}
	}

	public int gcd(int a, int b) {
		return (a % b == 0) ? b : gcd(b, a % b);
	}

	
	
	// solution 3: left rotate, using swap, time O(n);
	public void rotate3(int[] nums, int k) {
		if (nums == null || nums.length <= 1 || k <= 0) {
			return;
		}

		int len = nums.length;
		k = k % len;
		int steps = gcd(k, len);

		for (int i = 0; i < steps; i++) {
			int faster = (i + k) % len;
			int slower = i;
			int temp = nums[i];

			while (faster != i) {
				nums[slower] = nums[faster];
				slower = faster;
				faster = (faster + k) % len;
			}

			nums[slower] = temp;
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	/**************************** main function **********************************/
	
	// /*****************************************************/
	// // by other, faster but not in place
	// public void rotate(int[] nums, int k) {
	// int n = nums.length;
	// int[] newList = new int[n];
	// if (n > 1) {
	// k = k % n;
	// System.arraycopy(nums, n - k, newList, 0, k);
	// System.arraycopy(nums, 0, newList, k, n - k);
	// System.arraycopy(newList, 0, nums, 0, n);
	// }
	// }

	// /*****************************************************/
	// // by other, in place and O(1)
	// public void rotate2(int[] nums, int k) {
	// if(nums == null || k == 0) return;
	// int len = nums.length;
	// k %= len;
	// int d = gcd(k, len);
	//
	// System.out.println("d = " + d);
	//
	// System.out.println("d = " + d);
	//
	// for(int i = 0; i < d; ++i){
	// int record = nums[i];
	// int idx = i + k;
	// idx %= len;
	//
	// System.out.println("1: idx = " + idx);
	// print(nums);
	//
	// while(idx != i){
	// int temp = record;
	// record = nums[idx];
	// nums[idx] = temp;
	// idx += k;
	// idx %= len;
	//
	// System.out.println("2: idx = " + idx);
	// print(nums);
	//
	// }
	// int temp = record;
	// record = nums[idx];
	// nums[idx] = temp;
	// }
	// }

	// public int gcd(int a, int b) {
	// if(a % b == 0) return b;
	// else return gcd(b, a % b);
	// }

	public void print(int[] array) {
		for (int i = 0; i < array.length; ++i)
			System.out.print(array[i] + ", ");
		System.out.println();
	}

	public static void main(String[] args) {
		Le_189_Rotate_Array t = new Le_189_Rotate_Array();
		int[] nums = {1,2,3,4,5,6,7};
//		int[] nums = { 1, 2 };
		t.rotate3(nums, 3);
		t.print(nums);
	}

}
