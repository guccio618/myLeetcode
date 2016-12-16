import java.util.Arrays;

public class Q313_Super_Ugly_Number {
	// by other
	public int nthSuperUglyNumber(int n, int[] primes) {
		int len = primes.length;
		int[] index = new int[len];
		Arrays.fill(index, 1);
		int[] factor = new int[len];
		for (int i = 0; i < len; i++)
			factor[i] = primes[i];

		int ugly[] = new int[n];
		ugly[0] = 1;
		for (int i = 1; i < n; i++) {
			int min = findMin(factor);
			ugly[i] = min;
			for (int j = 0; j < len; j++) {
				if (min == factor[j]) {
					factor[j] = primes[j] * ugly[index[j]++];
				}
			}
		}
		return ugly[n - 1];
	}

	public int findMin(int[] a) {
		int min = a[0];
		for (int i = 1; i < a.length; i++)
			min = Math.min(min, a[i]);
		return min;
	}
}
