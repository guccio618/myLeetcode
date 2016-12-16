/***
 * 
Given n items with size Ai, an integer m denotes the size of a backpack. 
How full you can fill this backpack?

Example:
	If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5], 
	so that the max size we can fill this backpack is 10. If the backpack size is 12. we can select [2, 3, 7] 
	so that we can fulfill the backpack.

You function should return the max size we can fill in the given backpack.
 * 
 **/


public class Li_092_Backpack {
	/************************************************************************
	 * Statement:  dp[i][j]: 前i个item是否可以填满j体积的背包
	 * Function:   dp[i][j] = dp[i - 1][j] || dp[i - 1][j - item[i]]
	 * 			   也许前i - 1个item已经将j体积的背包填满。
	 * Initial:    dp[i][0] = true;
	 * Answer:     寻找为true时的最大capacity
	 * 
	 * 可空间优化
	 *  
	 ************************************************************************/
	
	// 滚动数组空间优化过之后, space O(n)
	public int backPack(int capacity, int[] Item) {
	    if(capacity <= 0 || Item == null || Item.length == 0){
	        return 0;
	    }
	    
	    int maxCapacity = 0;
	    int n = Item.length;
	    boolean[][] dp = new boolean[2][capacity + 1];
	    dp[0][0] = true;     // 初始状态均一致，为true，所以考虑可以用滚动数组进行优化
	    dp[1][0] = true;
	    
	    for(int i = 1; i <= n; ++i){
	        for(int j = 1; j <= capacity; ++j){
	            dp[i % 2][j] = dp[(i - 1) % 2][j];
	            if(j >= Item[i - 1]){
	                dp[i % 2][j] = dp[i % 2][j] || dp[(i - 1) % 2][j - Item[i - 1]];
	            }
	            if(dp[i % 2][j] == true){
	                maxCapacity = Math.max(maxCapacity, j);
	            }
	        }
	    }
	    
	    return maxCapacity;
    }
	
	
	
	/******************************************************/
	// 未进行过空间优化, space O(n^2)
	public int backPack2(int capacity, int[] Item) {
	    if(capacity <= 0 || Item == null || Item.length == 0){
	        return 0;
	    }
        
        int n = Item.length;
        boolean[][] dp = new boolean[n + 1][capacity + 1];
        int ans = 0;
        
        for(int i = 0; i <= n; ++i){
            dp[i][0] = true;
        }
        
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= capacity; ++j){
                dp[i][j] = dp[i - 1][j];
                if(j >= Item[i - 1]){
                    dp[i][j] |= dp[i - 1][j - Item[i - 1]];
                }
                if(dp[i][j] == true){
                    ans = Math.max(ans, j);
                }
            }
        }
        
        return ans;
    }
	
	
	
	public int halfOfArray(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		} else if(nums .length == 1){
			return nums[0];
		}
		
		int sum = nums[0];
		int n = nums.length;
		
		for(int i = 1; i < n; ++i){
			sum += nums[i];
		}
		
		sum /= 2;
		boolean[][] dp = new boolean[n + 1][sum + 1];
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i <= n; ++i){
			dp[i][0] = true;
		}
		
		for(int i = 1; i <= n; ++i){
			for(int j = 1; j <= sum; ++j){
				dp[i][j] = dp[i - 1][j];
				if(j >= nums[i - 1]){
					dp[i][j] |= dp[i - 1][j - nums[i - 1]];
				}
				if(dp[i][j] == true){
					max = Math.max(max, j);
				}
			}
		}
		
		return max;
	}
	
	
	
	public static void main(String[] args){
		Li_092_Backpack t = new Li_092_Backpack();
		int[] nums = {1,24,5,6,9};
		System.out.println(t.halfOfArray(nums));
	}
}
