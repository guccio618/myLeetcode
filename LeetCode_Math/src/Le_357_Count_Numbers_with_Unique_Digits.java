/*****
 * 
Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:
	Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, 
	excluding [11,22,33,44,55,66,77,88,99])
	
 * 
 * */

public class Le_357_Count_Numbers_with_Unique_Digits {
	public int countNumbersWithUniqueDigits(int n) {
        if(n < 0 || n > 10) {
            return 0;
        } else if(n == 0) {
            return 1;
        }
        
        int ans = 10;
        int preStatus = 9;   // 当n大于2时，第一位就不可以取0，这样算无效数字 ！！！
        
        for(int i = 1; i < n; i++) {
            preStatus *= (10 - i);
            ans += preStatus;
        }
        
        return ans;
    }
	
	
	
	
	
	
	
	
	/*************************** main function ***************************************/
	
	public static void main(String[] args){
		Le_357_Count_Numbers_with_Unique_Digits t = new Le_357_Count_Numbers_with_Unique_Digits();
		System.out.println(t.countNumbersWithUniqueDigits(2));
	}
}
