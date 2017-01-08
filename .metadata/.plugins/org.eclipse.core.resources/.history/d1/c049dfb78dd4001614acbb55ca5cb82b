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
    public int findMaximumXOR(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
     
        Trie root = new Trie();
        int max = Integer.MIN_VALUE;
        
        for(int num: nums) {
            Trie node = root;
            
            for(int i = 31; i >= 0; i--) {   // 必须从31开始 ！！！
                int digit = (num >>> i) & 1;
                
                if(node.children[digit] == null) {
                    node.children[digit] = new Trie();
                }
                
                node = node.children[digit];
            }
        }
       
        for(int num: nums) {
            Trie node = root;
            int curSum = 0;
            
            for(int i = 31; i >= 0; i--) {
                int digit = (num >>> i) & 1;
                
                if(node.children[digit ^ 1] != null) {
                    curSum += (1 << i);
                    node = node.children[digit ^ 1];
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
}
