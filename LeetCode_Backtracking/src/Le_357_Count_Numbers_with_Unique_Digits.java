
public class Le_357_Count_Numbers_with_Unique_Digits {
	public int countNumbersWithUniqueDigits(int n) {
		if(n < 0){
            return 0;
        } else if(n == 0){
            return 1;
        }
		
        n = Math.min(n, 10);
		int ans = 10;
		int preSum = 9;  // 当n大于2时，第一位就不可以取0，这样算无效数字 ！！！
        
        for(int i = 1; i < n; i++){
            preSum *= 10 - i;
            ans += preSum;
        }
        
        return ans;
    }
	
	
	public static void main(String[] args){
		Le_357_Count_Numbers_with_Unique_Digits t = new Le_357_Count_Numbers_with_Unique_Digits();
		System.out.println(t.countNumbersWithUniqueDigits(2));
	}
}
