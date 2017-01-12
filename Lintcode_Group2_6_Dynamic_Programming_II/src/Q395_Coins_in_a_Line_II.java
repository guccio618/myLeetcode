
public class Q395_Coins_in_a_Line_II {
	/***************************************************/
	// by Jackie 
	public boolean firstWillWin(int[] values) {
        if(values == null || values.length == 0){
            return false;
        } else if(values.length <= 2){
            return true;
        }
        
        int len = values.length;
        int[] sum = new int[len];
        sum[len - 1] = values[len - 1];
        
        for(int i = len - 2; i >= 0; --i){
            sum[i] = sum[i + 1] + values[i];
        }
        
        int[] dp = new int[len];
        dp[len - 1] = values[len - 1];
        dp[len - 2] = values[len - 1] + values[len - 2];
        
        for(int i = len - 3; i >= 0; --i){
            dp[i] = sum[i] - Math.min(dp[i + 1], dp[i + 2]);
        }
        
        return 2 * dp[0] > sum[0];
    }
	
	
		
	/***************************************************/
	// by ninechapter using memory search
	public boolean firstWillWin2(int[] values) {
        int []dp = new int[values.length + 1];
        boolean []flag =new boolean[values.length + 1];
        int sum = 0;
        for(int now : values) 
            sum += now;
        int num = MemorySearch(values.length, dp, flag, values);
        
        return sum < 2*num;
    }
    int MemorySearch(int n, int []dp, boolean []flag, int []values) { 
        if(flag[n] == true)
            return dp[n];
        flag[n] = true;
        if(n == 0)  {
            dp[n] = 0;  
        } else if(n == 1) {
            dp[n] = values[values.length-1];
        } else if(n == 2) {
            dp[n] = values[values.length-1] + values[values.length-2]; 
        } else if(n == 3){
            dp[n] = values[values.length-2] + values[values.length-3]; 
        } else {
            dp[n] = Math.max(
                Math.min(MemorySearch(n-2, dp, flag,values) , MemorySearch(n-3, dp, flag, values)) + values[values.length-n],
                Math.min(MemorySearch(n-3, dp, flag, values), MemorySearch(n-4, dp, flag, values)) + values[values.length-n] + values[values.length - n + 1]
                );
        }
    
        return dp[n];
    }
	
	
	
	public static void main(String[] args){
		Q395_Coins_in_a_Line_II t = new Q395_Coins_in_a_Line_II();
		int[] values = {16,27,25,23,25,16,12,9,1,2,7,20,19,23,16,0,6,22,16,11,8,27,9,2,20,2,13,7,25,29,12,12,18,29,27,13,16,1,22,9,3,21,29,14,7,8,14,5,0,23,16,1,20};
//		int[] values = {16,27,25,23,25,16,12,9,1,2,7,20,19,23,16};
		System.out.println(t.firstWillWin(values));
		System.out.println(t.firstWillWin2(values));
	}
}
