
/*********
 * 
 * Implement int sqrt(int x). Compute and return the square root of x.
 * 
 */

public class Le_069_Sqrt_x {
	/************************************************
	 * 二分法，查找一个mid,使得mid * mid 大于或等于x
	 * 
	 ************************************************/

	int mySqrt(int x) {
		if (x <= 0) {
			return 0;
		} else if (x <= 3) {
			return 1;
		}

		long left = 1, right = x;

		while (left + 1 < right) {
			long mid = left + (right - left) / 2;
			long product = mid * mid;

			if (product < x) {
				left = mid;
			} else if (product > x) {
				right = mid;
			} else {
				return (int) mid;
			}
		}

		if (right * right <= x) {
			return (int) right;
		} else {
			return (int) left;
		}
	}

	
	
	
	
	
	
	
	
	
	/******************************** main function *******************************/

	public static void main(String[] args) {
		Le_069_Sqrt_x t = new Le_069_Sqrt_x();
		System.out.println(t.mySqrt(2147395599));
	}
}
