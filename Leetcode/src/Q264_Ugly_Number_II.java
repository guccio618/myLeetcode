public class Q264_Ugly_Number_II {
	/***************************************************/
	// by other
//	public int nthUglyNumber(int n) {
//		if (n <= 0)
//			return 0;
//		int T2 = 0, T3 = 0, T5 = 0;
//		int[] table = new int[n];
//		table[0] = 1;
//		int count = 1;
//		while (count < n) {
//			int next_val = Math.min(table[T2] * 2, Math.min(table[T3] * 3, table[T5] * 5));
//			table[count++] = next_val;
//			if (table[T2] * 2 == next_val)
//				T2++;
//			if (table[T3] * 3 == next_val)
//				T3++;
//			if (table[T5] * 5 == next_val)
//				T5++;
//		}
//		return table[n - 1];
//	}
	
	// 三指针，类似merge sort的思想， nice
	public int nthUglyNumber(int n) {
        if(n <= 0){
            return 0;
        } else if(n <= 5){
            return n;
        }
        
        int[] dp = new int[n];
        dp[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int currentIndex = 1;
        int currentValue = 0; 
        
        while(currentIndex < n){
            currentValue = Math.min(dp[index2] * 2, Math.min(dp[index3] * 3, dp[index5] * 5));
            dp[currentIndex++] = currentValue;
            
            if(dp[index2] * 2 == currentValue){
                index2++;
            }
            if(dp[index3] * 3 == currentValue){   // 这里不能用else， 因为ugly[index2 = 3] * 2和 ugly[index3 = 2] * 3时，
                index3++;                         // index2和index3两个都需要移动
            }
            if(dp[index5] * 5 == currentValue){
                index5++;
            }
        }
        
        return dp[n - 1];
    }
	
	
	public static void main(String[] args){
		Q264_Ugly_Number_II t = new Q264_Ugly_Number_II();
		System.out.println(t.nthUglyNumber(6));
	}
}
