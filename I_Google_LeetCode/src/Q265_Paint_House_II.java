import java.util.*;

/********
 * 
There are a row of n houses, each house can be painted with one of the k colors.
The cost of painting each house with a certain color is different. 
You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. 
For example, costs[0][0] is the cost of painting house 0 with color 0; 
costs[1][2] is the cost of painting house 1 with color 2, and so on... 
Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Follow up:
Could you solve it in O(nk) runtime?

 * 
 * */


public class Q265_Paint_House_II {
	// Time complexity is O(nklogk), space complexity is O(nk)
	public int minCostII_1(int[][] costs) {
		if (costs == null || costs.length == 0 || costs[0].length == 0) {
			return 0;
	    }
		
		int n = costs.length, k = costs[0].length;
        int[][] ans = new int[n][k];
        
        Queue<Node> maxHeap = new PriorityQueue<Node>(3, new Comparator<Node>(){
    		public int compare(Node n1, Node n2) {
    			return n2.cost - n1.cost;
    		}
    	});
        
        for(int i = 0; i < n; i++) {
        	Node prevFirstMin = null;
        	Node prevSecondMin = null;
        	
        	if(!maxHeap.isEmpty()) {
        		prevSecondMin = maxHeap.poll();
        		prevFirstMin = maxHeap.poll(); 
        	}
        	
        	for(int j = 0; j < k; j++) {
        		if(prevFirstMin == null) {
        			maxHeap.offer(new Node(costs[i][j], j));
        		} else if(j != prevFirstMin.index) {
        			maxHeap.offer(new Node(costs[i][j] + prevFirstMin.cost, j));
        		} else if(j == prevFirstMin.index) {
        			maxHeap.offer(new Node(costs[i][j] + prevSecondMin.cost, j));
        		}
        		
        		if(maxHeap.size() > 2) {
        			maxHeap.poll();
        		}
        	}
        }
        
        if(maxHeap.size() >= 2) {  // test case [[8]]
            maxHeap.poll();
        }
        
        return maxHeap.poll().cost;
	}
	
	class Node {
		int cost;
		int index;
		
		public Node(int cost, int index) {
			this.cost = cost;
			this.index = index;
		}
	}
	
		
	
	
	// Time complexity is O(nk), space complexity is O(nk)
	public int minCostII_2(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        
        int curFirstMinIndex = -1, curSecondMinIndex = -1;
        int prevFirstMinIndex = -1, prevSecondMinIndex = -1;
        int n = costs.length, k = costs[0].length;
        int[][] ans = new int[n][k];
        
        for(int i = 0; i < n; i++) {
            prevFirstMinIndex = curFirstMinIndex;
            prevSecondMinIndex = curSecondMinIndex;
            curFirstMinIndex = curSecondMinIndex = -1;
            
            for(int j = 0; j < k; j++) {
                if(j != prevFirstMinIndex) {
                    int curCost = prevFirstMinIndex == -1 ? 0 : ans[i - 1][prevFirstMinIndex];
                    ans[i][j] = curCost + costs[i][j];
                } else {
                    int curCost = prevSecondMinIndex == -1 ? 0 : ans[i - 1][prevSecondMinIndex];
                    ans[i][j] = curCost + costs[i][j];
                }
                
                if(curFirstMinIndex == -1 || ans[i][curFirstMinIndex] > ans[i][j]) {
                    curSecondMinIndex = curFirstMinIndex;
                    curFirstMinIndex = j;
                } else if(curSecondMinIndex == -1 || ans[i][curSecondMinIndex] > ans[i][j]) {
                    curSecondMinIndex = j;
                }
            }
        }
        
        return ans[n - 1][curFirstMinIndex];
    }
	
	
	// Time complexity is O(nk), space complexity is O(1)
	public int minCostII_3(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0){
            return 0;
        }
        
        int n = costs.length, k = costs[0].length;
        int curMin1 = -1, curMin2 = -1;
        
        for(int i = 0; i < n; i++){
            int lastMin1 = curMin1, lastMin2 = curMin2;
            curMin1 = curMin2 = -1;
            
            for(int j = 0; j < k; j++){
                if(j != lastMin1){
                    costs[i][j] += lastMin1 < 0 ? 0 : costs[i - 1][lastMin1];
                } else {
                    costs[i][j] += lastMin2 < 0 ? 0 : costs[i - 1][lastMin2];
                }
                
                if(curMin1 < 0 || costs[i][curMin1] > costs[i][j]){
                    curMin2 = curMin1;
                    curMin1 = j;
                } else if(curMin2 < 0 || costs[i][curMin2] > costs[i][j]){
                    curMin2 = j;
                }
            }
        }
        
        return costs[n - 1][curMin1];
    }
	
	
	
	
	
	
	
	
	
	
	/************************************************************************/
	public void print(int[][] nums){
		for(int i = 0; i < nums.length; i++){
			for(int j = 0; j < nums[i].length; j++){
				System.out.print(nums[i][j] + ", ");
			}
			System.out.println();
		}
	}
	
	
	
	public static void main(String[] args){
		Q265_Paint_House_II t = new Q265_Paint_House_II();
		int[][] costs = {
				{20,19,11,13,12,16,16,17,15,9,5,18},
				{3,8,15,17,19,8,18,3,11,6,7,12},
				{15,4,11,1,18,2,10,9,3,6,4,15}
		};
		
		System.out.println(t.minCostII_3(costs));
	}
	
	
//	[[20,19,11,13,12,16,16,17,15,9,5,18],[3,8,15,17,19,8,18,3,11,6,7,12],[15,4,11,1,18,2,10,9,3,6,4,15]]
}
