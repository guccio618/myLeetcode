import java.util.*;

public class Four_Integer {
	public int[] Solution(int A, int B, int C, int D) {
		int[] rvalue = new int[4];
		rvalue[0] = A;
		rvalue[1] = B;
		rvalue[2] = C;
		rvalue[3] = D;
		Arrays.sort(rvalue);
		swap(rvalue, 0, 1);
		swap(rvalue, 2, 3);
		swap(rvalue, 0, 3);
		return rvalue;
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
