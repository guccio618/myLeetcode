/******
 * 
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num,
calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). 
But can you do it in linear time O(n) /possibly in a single pass?

Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount 
in c++ or in any other language.

 * 
 * */


public class Le_338_Counting_Bits {
	public int[] countBits(int num) {
        if(num < 0) {
            return new int[0];
        } 
        
        int[] ans = new int[num + 1];
        ans[0] = 0;
        int size = 1;
        
        while(size <= num) {
            for(int i = 0; i < size && size + i <= num; i++) {
                ans[size+i] = ans[i] + 1; 
            }
            size *= 2;
        }
        
        return ans;
    }
	
	
	
	
	
	/***** main function *****/
	public static void main(String[] args){
		Le_338_Counting_Bits t = new Le_338_Counting_Bits();
		int[] ways = t.countBits(8);
		
		for(int i = 0; i < ways.length; ++i){
			System.out.print(ways[i] + ", ");
		}
	}
}
