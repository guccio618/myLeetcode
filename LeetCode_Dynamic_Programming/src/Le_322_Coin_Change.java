import java.util.*;
/*****
 * 
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.

 * 
 * */

public class Le_322_Coin_Change {
	public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount <= 0) {
            return 0;
        }
        
        int[] ways = new int[amount+1];
        ways[0] = 0;
        
        for(int i = 1; i <= amount; i++) {
            ways[i] = Integer.MAX_VALUE;
            
            for(int coin : coins) {
                if(i >= coin && ways[i-coin] < Integer.MAX_VALUE) {
                    ways[i] = Math.min(ways[i], ways[i-coin] + 1);
                }
            }
        }
        
        return (ways[amount] == Integer.MAX_VALUE) ? -1 : ways[amount];
    }
	
	
	// follow up, find out one fewest solution of coin change
	public List<Integer> coinChange_followUp(int[] coins, int amount) {
		List<Integer> ans = new LinkedList<Integer>();
		
		if(coins == null || coins.length == 0 || amount <= 0) {
            return ans;
        }
        
        Pair[] ways = new Pair[amount+1];
        ways[0] = new Pair(0, -1, 0);
        
        for(int i = 1; i <= amount; i++) {
            for(int coin : coins) {
                if(i >= coin && ways[i-coin] != null) {
                	if(ways[i] == null) {
                		ways[i] = new Pair(ways[i-coin].coinNum + 1, i - coin, coin);
                	} else {
                		if(ways[i].coinNum > ways[i-coin].coinNum + 1) {
                			ways[i].coinNum = ways[i-coin].coinNum + 1;
                			ways[i].preIndex = i - coin;
                			ways[i].lastAddCoin = coin;
                		}
                	}
                }
            }
        }
        
        Pair node = ways[amount];        
        while(node != null && node.preIndex != -1) {
        	ans.add(node.lastAddCoin);
        	node = ways[node.preIndex];
        }
        
        return ans;
	}
	
	class Pair {
		int coinNum;
		int preIndex;
		int lastAddCoin;
		
		public Pair(int coinNum, int preIndex, int lastAddCoin) {
			this.coinNum = coinNum;
			this.preIndex = preIndex;
			this.lastAddCoin = lastAddCoin;
		}
	}
	
	
	
	
	
	
	/*****************************************/
	public void print(long[] array){
		for(int i = 0; i < array.length; ++i)
			System.out.print(array[i] + ", ");
		System.out.println();
	}
	
	
	
	public static void main(String[] args){
		Le_322_Coin_Change t = new Le_322_Coin_Change();
		int[] coins = {1, 2, 5};
		int amount = 11;
		System.out.println(t.coinChange(coins, amount));
		
		List<Integer> ans = t.coinChange_followUp(coins, amount);
		
		for(int coin : ans) {
			System.out.print(coin + " ");
		}
	}
}
