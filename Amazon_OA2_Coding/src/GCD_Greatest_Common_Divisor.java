public class GCD_Greatest_Common_Divisor {
	public int Solution(int[] array) {
		if (array == null || array.length == 1){
			return 0;
		}
		
		int gcd = array[0];
		
		for (int i = 1; i < array.length; i++) {
			gcd = findGcd(gcd, array[i]);
		}
		
		return gcd;
	}

	private int findGcd(int num1, int num2) {
		if (num1 == 0 || num2 == 0){         //注意这里为0时需要退出 ！！！
			return 0;
		}
		
		while (num1 != 0 && num2 != 0) {
			if (num2 > num1) {               // 注意大小需要交换 ！！！
				int swapNum = num2;
				num2 = num1;
				num1 = swapNum;
			}
			
			int temp = num1 % num2;
			num1 = num2;
			num2 = temp;
		}
		
		return num1 + num2;
	}
	
	
	
	
	
	public static void main(String[] args){
		GCD_Greatest_Common_Divisor t = new GCD_Greatest_Common_Divisor();
		int[] array = {5, 15};
		System.out.println(t.Solution(array));
	}
}
