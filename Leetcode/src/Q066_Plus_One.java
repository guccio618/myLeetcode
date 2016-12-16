
public class Q066_Plus_One {
	public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0){
            return digits;
        }
        
        int flag = 0;
        int n = digits.length;
        
        for(int i = n - 1; i >= 0; --i){
            if(i == n - 1){
                digits[i] += 1;
            }
            digits[i] = digits[i] + flag;
            flag = digits[i] / 10;
            digits[i] %= 10;
        }
        
        if(flag == 1){
            int[] ans = new int[n + 1];
            for(int i = n - 1; i >= 0; --i){
                ans[i + 1] = digits[i];
            }
            ans[0] = 1;
            return ans;
        } else {
            return digits;
        }
    }
	
	
	public static void main(String[] args){
		Q066_Plus_One t = new Q066_Plus_One();
		int[] digits = {9};
		int[] ans = t.plusOne(digits);
		
		for(int i = 0; i < ans.length; ++i){
			System.out.print(ans[i]);
		}
	}
}
