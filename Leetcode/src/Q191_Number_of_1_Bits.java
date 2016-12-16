
public class Q191_Number_of_1_Bits {
	/****************************************************/
	// by Jackie
	public int hammingWeight(int n) {
		int count = 0;
        
        while(n != 0){    // 不能用n > 0来判断，当n < 0时会有bug
            count += (n & 1);
            n >>>= 1;     // ">>>" 无符号移位处理, 不同于">>"
        }
        
        return count;
    }
	
	public static void main(String[] args){
		Q191_Number_of_1_Bits t = new Q191_Number_of_1_Bits();
		System.out.println(t.hammingWeight(2147483647));
	}
}
