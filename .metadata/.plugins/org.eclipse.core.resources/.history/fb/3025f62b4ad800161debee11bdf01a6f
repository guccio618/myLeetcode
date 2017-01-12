
public class Q397_Integer_Replacement {
	public int integerReplacement(int n) {
        if(n <= 0){
			return 0;
		} else if(n == Integer.MAX_VALUE){
			return 32;
		}
		
		int count = 0;
		
		while(n > 1 && (n & 1) == 0){
			n >>= 1;
			count++;
		}
			
		if(n > 1){
			count++;
			
			if(n == Integer.MAX_VALUE){
				count += integerReplacement(n - 1);
			} else {
				int num1 = integerReplacement(n + 1);
				int num2 = integerReplacement(n - 1);
				count += Math.min(num1, num2);
			}			
		}
		
		return count;
    }
}
