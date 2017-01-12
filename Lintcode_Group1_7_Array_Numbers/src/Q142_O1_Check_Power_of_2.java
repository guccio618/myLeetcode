
public class Q142_O1_Check_Power_of_2 {
	public boolean checkPowerOf2(int n) {
        // write your code here
        if(n <= 0 || n == Integer.MIN_VALUE){
            return false;
        }
        int count = 0;
        for(int i = 0; i < 31; ++i){
            count += n & 1;
            n = n >> 1;
        }
        return (count == 1);
    }
	
	
	public static void main(String[] args){
		Q142_O1_Check_Power_of_2 t = new Q142_O1_Check_Power_of_2();
		System.out.println(t.checkPowerOf2(5));
	}
}
