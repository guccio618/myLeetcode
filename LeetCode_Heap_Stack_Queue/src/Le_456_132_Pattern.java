import java.util.*;
/*********
 * 
Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.

Note: n will be less than 15,000.

Example 1:
	Input: [1, 2, 3, 4]
	Output: False
	Explanation: There is no 132 pattern in the sequence.

Example 2:
	Input: [3, 1, 4, 2]
	Output: True
	Explanation: There is a 132 pattern in the sequence: [1, 4, 2].

Example 3:
	Input: [-1, 3, 2, 0]
	Output: True
	Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
	
 * 
 * */

public class Le_456_132_Pattern {
	// using stack to store the previous status, time is O(n), space is O(n)
	public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length <= 2) {
            return false;
        }
        
        Stack<Pair> stack = new Stack<>();
        
        for(int num : nums) {
            if(stack.isEmpty() || stack.peek().min > num) {
                stack.push(new Pair(num, num));
            } else if(stack.peek().min < num) {
                Pair p = stack.pop();
                
                if(num < p.max) {
                    return true;
                } else {
                    p.max = num;
                    
                    while(!stack.isEmpty() && stack.peek().max <= num) { // 这里有等号 ！！！
                        stack.pop();
                    }
                    
                    if(!stack.isEmpty() && stack.peek().min < num) {
                        return true;    
                    }
                    
                    stack.push(p);
                }
            }
        }
        
        return false;
    }
    
    class Pair {
        int max;
        int min;
        
        public Pair(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/************************** main function ******************************/
	
	public static void main(String[] args) {
		Le_456_132_Pattern t = new Le_456_132_Pattern();
		int[] nums = {1, 0, 1, -4, -3};
		System.out.println(t.find132pattern(nums));
	}
}
