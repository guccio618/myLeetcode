/*****
 * 
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Now your job is to find the total Hamming distance between all pairs of the given numbers.

Example:
Input: 4, 14, 2

Output: 6

Explanation: 
	In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
	showing the four bits relevant in this case). So the answer will be:
	HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.

Note:
	Elements of the given array are in the range of 0 to 10^9
	Length of the array will not exceed 10^4.

 * 
 * */


public class Q477_Total_Hamming_Distance {
	// naive method, time is O(n^2)
	public int totalHammingDistance(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return 0;
        }
        
        int len = nums.length;
        int ans = 0;
        
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                int result = nums[i] ^ nums[j];
                int count = 0;
                
                while(result != 0) {
                    count += (result & 1);
                    result >>= 1;
                }
                
                ans += count;
            }
        }
        
        return ans;
    }
	
	
	
	
	// follow up: time is O(n)
	public int totalHammingDistance2(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return 0;
        }
     
        int len = nums.length;
        int ans = 0;   
        
        for(int i = 0; i < 32; i++) {
            int count = 0;
            
            for(int j = 0; j < len; j++) {
                count += (nums[j] >> i) & 1;
            }
            
            ans += count * (len - count);
        }
        
        return ans;
    }
}
