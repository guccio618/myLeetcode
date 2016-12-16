/****
 * 
There are n coins with different value in a line. Two players take turns to take one or two coins from left side until there are no more coins left. The player who take the coins with the most value wins.

Could you please decide the first player will win or lose?

Example
	Given values array A = [1,2,2], return true.

	Given A = [1,2,4], return false.
	
 * 
 * */

public class Li_395_Coins_in_a_Line_II {
	/************************************************************************
	 * 此题分类讨论：
	 * 	getValue[i]表示还剩下i个时，选手1可以获取的最大分数，分4种情况：
	 * 		(1). 选手1先取1个， 选手2再取1个
	 * 		(2). 选手1先取1个， 选手2再取2个
	 * 		(3). 选手1先取2个， 选手2再取1个
	 * 		(4). 选手1先取2个， 选手2再取2个
	 *  
	 ************************************************************************/
	
	public boolean firstWillWin(int[] values) {
        if(values == null || values.length == 0){
            return false;
        } else if(values.length <= 2){
            return true;
        } else if(values.length == 3){
            return (values[0] + values[1] > values[2]);
        }
        
        int n = values.length;
        int sum = 0;
        for(int i = 0; i < n; ++i){
        	sum += values[i];
        }
        
        int[] getValue = new int[n + 1];
        getValue[0] = 0;
        getValue[1] = values[n - 1];     // 因为是从左往右拿，因此，当剩下最后一个coin时，其在values里的index应为 n-1 !!!
        getValue[2] = values[n - 1] + values[n - 2];
        getValue[3] = values[n - 2] + values[n - 3];
        
        for(int i = 4; i <= n; ++i){     // 注意是 values[n - i + 1] !!!
        	getValue[i] = Math.max(Math.min(getValue[i - 2], getValue[i - 3]) + values[n - i], Math.min(getValue[i - 3], getValue[i - 4]) + values[n - i] + values[n - i + 1]);
        }
        
        return getValue[n] * 2 > sum;
    }
}
