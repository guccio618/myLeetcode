/******
 * 
Assume you have an array of length n initialized with all 0's and are given k update operations.

Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.

Return the modified array after all k operations were executed.

Example:

Given:

    length = 5,
    updates = [
        [1,  3,  2],
        [2,  4,  3],
        [0,  2, -2]
    ]

Output:

    [-2, 0, 3, 5, 3]
Explanation:

Initial state:
[ 0, 0, 0, 0, 0 ]

After applying operation [1, 3, 2]:
[ 0, 2, 2, 2, 0 ]

After applying operation [2, 4, 3]:
[ 0, 2, 5, 5, 3 ]

After applying operation [0, 2, -2]:
[-2, 0, 3, 5, 3 ]

 * 
 * */


public class Q370_Range_Addition {
	/**************************************************************************
	 * (1). 此题只需要纪录起始index和结尾的index， 
	 * (3). 每次update，在startIndex处加上inc, 在endIndex+1 处加上 inc表示还原。
	 * (2). 对求得的数组累加求和，结果即为所求。
	 * 
	 **************************************************************************/
	
	// time complexity O(k + n), space O(1)
	public int[] getModifiedArray(int length, int[][] updates) {
        if(updates == null || updates.length == 0 || updates[0].length == 0){
            return new int[length];
        }
        
        int[] ans = new int[length];
        
        for(int[] update : updates){
            int startIndex = update[0];
            int endIndex = update[1];
            int inc = update[2];
            
            ans[startIndex] += inc;
            if(endIndex + 1 < length){
                ans[endIndex + 1] -= inc;
            } 
        }
        
        for(int i = 1; i < length; i++){
            ans[i] = ans[i - 1] + ans[i];
        }
        
        return ans;
    }
}
