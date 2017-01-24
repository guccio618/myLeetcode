/*******
 * 
Given a non-empty array of integers, return the third maximum number in this array. 
If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.

 * 
 * */

public class Q414_Third_Maximum_Number {
	// naive method is using sort, and time is O(nlogn)
	
	// this method: time is O(n), space is O(1)
	public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        long[] max = new long[3];           // long型 ！！！
        max[0] = max[1] = max[2] = Long.MIN_VALUE;
        
        for (int num : nums) {
            if ((long) num >= max[0]) {     // 这里有等号 ！！！
                if ((long) num > max[0]) {
                    max[2] = max[1];
                    max[1] = max[0];
                    max[0] = (long) num;
                }
            } else if ((long) num >= max[1]) {
                if ((long) num > max[1]) {
                    max[2] = max[1];
                    max[1] = (long) num;
                }
            } else if ((long) num >= max[2]) {
                max[2] = (long) num;
            }
        }
        
        if (max[2] == Long.MIN_VALUE) {
            return (int) max[0];
        } else {
            return (int) max[2];
        }
    }
}
