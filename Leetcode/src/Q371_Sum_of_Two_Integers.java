
public class Q371_Sum_of_Two_Integers {
	// by Jackie
	public int getSum(int a, int b) {
        long sum = 0;
        int flag = 0;
        int digit = 0;
        
        for(int i = 0; i < 32; i++){
            int num1 = (a & (1 << i)) == 0 ? 0 : 1;
            int num2 = (b & (1 << i)) == 0 ? 0 : 1;
            
            digit = num1 + num2 + flag;
            
            if(num1 == 1 && num2 == 1){
            	digit = flag;
            	flag = 1;
            } else if(num1 == 1 || num2 == 1){
            	digit = 1 - flag;
            } else {
            	digit = flag;
            	flag = 0;
            }

            sum |= (digit << i);
        }
        
        if(sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE){
            return 0;
        } else {
            return (int) sum;
        }
    }
	
	
	
	public static void main(String[] args){
		Q371_Sum_of_Two_Integers t = new Q371_Sum_of_Two_Integers();
		System.out.println(t.getSum(5, 6));
	}
}
