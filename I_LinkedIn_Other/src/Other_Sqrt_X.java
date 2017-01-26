public class Other_Sqrt_X {
	public double sqrtX(double x, double precision) {
		double left = 1;
		double right = x;
		double mid = 0;
		double lastMid = Double.MAX_VALUE;

		while (left < right && Math.abs(lastMid - mid) > precision) {
			lastMid = mid;
			mid = left + (right - left) / 2;

			if (mid * mid == x) {
				return mid;
			} else if (Math.abs(left - right) <= precision) {
				return mid;
			} else if (mid * mid > x) {
				right = mid;
			} else {
				left = mid;
			}
		}
		
		return mid;
	}
	
	
	
	public static void main(String[] args) {
		Other_Sqrt_X t = new Other_Sqrt_X();
		System.out.println(t.sqrtX(64, 1));
	}
}
