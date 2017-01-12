import java.util.HashSet;
import java.util.Set;

/********
 * 
Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

Could you do this in O(n) runtime?

Example:

Input: [3, 10, 5, 25, 2, 8]

Output: 28

Explanation: The maximum result is 5 ^ 25 = 28.

 * 
 * */

public class Q421_Maximum_XOR_of_Two_Numbers_in_an_Array {   
	// solution 1: using trie
    public int findMaximumXOR(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
     
        Trie root = new Trie();
        int max = Integer.MIN_VALUE;
        
        for(int num: nums) {
            Trie node = root;
            
            for(int i = 31; i >= 0; i--) {   // 必须从31开始 ！！！ most significant bit should be stored firstly 
                int digit = (num >>> i) & 1;
                
                if(node.children[digit] == null) {
                    node.children[digit] = new Trie();
                }
                
                node = node.children[digit];
            }
        }
       
        // travel the array and choose a number, and then try to find the other number in the array which will make the maximum XOR value
        // start from most significant bit to the least significant bit of each number, that is from 31 to 0: 
        // (1). if we find the opposite value of current digit is non-null, that means we find the number which will make the maximum XOR value with the current number 
        // 		so we need to focus on that number.
        // (2). if we find the opposite value of current digit is null, that means we don't find the number, 
        //		so we just need to stay on current number and move on to next least significant bit.
        for(int num: nums) {      
            Trie node = root;
            int curSum = 0;
            
            for(int i = 31; i >= 0; i--) {   
                int digit = (num >>> i) & 1;  // each time, using each bit of current number as reference
                
                if(node.children[1 - digit] != null) {  
                    curSum += (1 << i);
                    node = node.children[1 - digit];
                }else {
                    node = node.children[digit];
                }
            }
            
            max = Math.max(curSum, max);
        }
        
        return max;
    }
    
    class Trie {
        Trie[] children;
        public Trie() {
            children = new Trie[2];
        }
    }
    
    
    
    // solution 2: using hashset
    public int findMaximumXOR2(int[] nums) {
        int max = 0;
        int flag = 0;
        
        // from left to right
        for (int i=31; i>=0; i--) {
            Set<Integer> prefixSet = new HashSet();
            // flag : 11110000
            flag = flag | (1<<i);
            for (int num : nums) {
                prefixSet.add(num & flag);
            }

            // tmp, max: 10101000000, add more 1 
            int tmp = max | (1<<i);
            for (int prefix : prefixSet) {
                // 利用了 ^ 的 a ^ b = c，则 b ^ c = a
                if (prefixSet.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}
