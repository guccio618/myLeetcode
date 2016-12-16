
public class Q050_Pow_x_n {
	public double myPow(double x, int n) {
		if(n == 0 || x == 1){
            return 1;
        } else if(x == -1){
            return ((long) n % 2 == 1) ? -1 : 1;
        } else if(x == 0 || n >= Integer.MAX_VALUE || n <= Integer.MIN_VALUE){  // 这里有等号 ！！！
            return 0;
        } 
        
        int flag_x = 1;
        if(x < 0 && n % 2 == 1){     // flag_x表示是否最后有负号，不仅考虑x < 0,同时要考虑n % 2 == 1
            flag_x = -1;
            x = -x;
        }
        int flag_n = n < 0 ? -1 : 1;
        n = n < 0 ? -n : n;
        double sum = 1;
        
        while(n > 1){               // 注意这里是 n > 1, 保留一个x ！！！
            if(n % 2 == 1){
                sum *= x;
            }
            x = x * x;
            n = n / 2;
        }
        
        sum = sum * x * flag_x;     // 添加入符号
        if(flag_n < 0){
            return 1 / sum; 
        } else {
            return sum;
        }
    }
	
	
	public static void main(String[] args){
		Q050_Pow_x_n t = new Q050_Pow_x_n();
		System.out.println(t.myPow(-1, Integer.MAX_VALUE)); // test case: (-1, Integer.MAX_VALUE), (1, Integer.MAX_VALUE         )
	}
}
