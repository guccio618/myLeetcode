public class Q201_Bitwise_AND_of_Numbers_Range {
	// by other
	public int rangeBitwiseAnd(int m, int n) {
		if(m == 0){
            return 0;
        }
        
        int moveBit = 1;
        
        while(m != n){
            m >>= 1;
            n >>= 1;
            moveBit <<= 1;
        }
        
        return m * moveBit;
	}

	public static void main(String[] args) {
		Q201_Bitwise_AND_of_Numbers_Range t = new Q201_Bitwise_AND_of_Numbers_Range();
		System.out.println(t.rangeBitwiseAnd(5, 9));
	}
}
