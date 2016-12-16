
public class Q190_Reverse_Bits {
	/***************************************************/
	// by other
	public int reverseBits(int n) {
        int rlt = 0; 
        for(int i = 32 ; i > 0 ; i--){
            rlt += ( ( (n << (i-1)) >>> 31 ) << (i-1) );  // “>>>” 无符号右移
        }
        return rlt;
    }
	
	
	
	/***************************************************/
	// by Jackie
	public int reverseBits2(int n) {
        int sum = 0;
        
        for(int i = 0; i < 32; i++){
            if(((n >> i) & 1) == 1){
                sum |= (1 << (31 - i));
            }
        }
        
        return sum;
    }
}
