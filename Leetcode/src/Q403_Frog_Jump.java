import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*****
 * 
A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.

If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.

Note:

The number of stones is ≥ 2 and is < 1,100.
Each stone's position will be a non-negative integer < 231.
The first stone's position is always 0.
Example 1:

[0,1,3,5,6,8,12,17]

There are a total of 8 stones.
The first stone at the 0th unit, second stone at the 1st unit,
third stone at the 3rd unit, and so on...
The last stone at the 17th unit.

Return true. The frog can jump to the last stone by jumping 
1 unit to the 2nd stone, then 2 units to the 3rd stone, then 
2 units to the 4th stone, then 3 units to the 6th stone, 
4 units to the 7th stone, and 5 units to the 8th stone.
Example 2:

[0,1,2,3,4,8,9,11]

Return false. There is no way to jump to the last stone as 
the gap between the 5th and 6th stone is too large.

*
* */

public class Q403_Frog_Jump {
	public boolean canCross(int[] stones) {
        if (stones.length < 1 || stones[0] != 0){
        	return false;
        }
        
        int len = stones.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        for (int s : stones){
        	map.put(s, new HashSet<Integer>());
        }
        
        for (int stone : stones) {
            Set<Integer> jSet = map.get(stone);
            
            // Initial condition
            if (stone == 0) {
                jSet.add(0);
                
                if (map.containsKey(1)){
                	map.get(1).add(1);
                }
                continue;
            }
            
            // For other stones
            for (int prevJump : jSet) {
                int curJump = prevJump - 1;
                int nextStone = stone + curJump;
                
                // Previous jump - 1
                if (nextStone != stone && map.containsKey(nextStone)) {
                	map.get(nextStone).add(curJump);
                }
                
                // Previous jump
                curJump++; 
                nextStone = stone + curJump;
                
                if (nextStone != stone && map.containsKey(nextStone)) {
                	map.get(nextStone).add(curJump);
                }
                
                // Previous jump + 1
                curJump++; 
                nextStone = stone + curJump;
                
                if (nextStone != stone && map.containsKey(nextStone)) {
                	map.get(nextStone).add(curJump);
                }
            }
        }
        
        return !map.get(stones[len - 1]).isEmpty();
	}
	
	
	
	
	/*******/
	public boolean canCross2(int[] stones) {
        if(stones == null || stones.length <= 1){
        	return true;
        } else if(stones.length == 2){
        	return stones[1] == 1;
        }
        
        int len = stones.length;
        Set<Integer>[] jump = new Set[len];
        
        for(int i = 0; i < len; i++){
        	jump[i] = new HashSet<Integer>();
        }
        
        jump[1].add(1);
        
        for(int i = 2; i < len; i++){
        	for(int j = i - 1; j > 0; j--){        		
        		for(int prevJump : jump[j]){
        			int curJump = stones[i] - stones[j];
        			
        			if(curJump == prevJump){
        				jump[i].add(prevJump);
        			} else if(curJump == prevJump + 1){
        				jump[i].add(prevJump + 1);
        			} else if(curJump == prevJump - 1){
        				jump[i].add(prevJump - 1);
        			}
        		} 
        	}
        }
        
        return jump[len - 1].size() != 0; 
	}
	
//	public boolean canCross(int[] stones) {
//        if(stones == null || stones.length == 0){
//        	return true;
//        }
//        
//        int len = stones.length;
//        boolean[] canReach = new boolean[len];
//        canReach[0] = true;
//        int currentStep = 1;
//        
//        for(int i = 0; i < len; i++){
//        	if(canReach[i] == true){
//        		int j = i + 1;
//            	
//            	while(j < len){
//            		int diff = stones[j] - stones[i];
//            		
//            		if(diff == currentStep + 1 || diff == currentStep - 1){
//            			canReach[j] = true;
//            			j++;
//            		} else if(diff > currentStep + 1){
//            			break;
//            		}
//            	}
//        	}
//        }
//        
//        return canReach[len - 1];
//    }
	
	
	public static void main(String[] args){
		Q403_Frog_Jump t = new Q403_Frog_Jump();
		int[] stones = {0,1,3,5,6,8,12,17};
		int[] stones2 = {0,1,2,3,4,8,9,11};
		
		System.out.println(t.canCross(stones));
		System.out.println(t.canCross(stones2));
	}
}
