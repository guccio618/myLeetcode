
public class Q082_Single_Number {
	// by Jackie
	public int singleNumber(int[] A) {
		if (A.length == 0) {
			return 0;
		}

		int n = A[0];
		for(int i = 1; i < A.length; i++) {
			n = n ^ A[i];
		}

		return n;
	}
}
