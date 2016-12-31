public class Gray_code {
	/*******
	 * 当两个数互为格雷码，则XOR之后结果为七个0和一个1
	 * 
	 * */
	
	
	public static int grayCheck(byte term1, byte term2) {
		byte result = (byte) (term1 ^ term2);
		
		for (int i = 0; i <= 7; i++) {
			byte tmp = (byte) (1 << i);
			
			if (tmp == result) {
				return 1;
			}
		}
		
		return 0;
	}

	
	
	
	
	public int grayCheck2(byte term1, byte term2) {
		byte x = (byte) (term1 ^ term2);
		int total = 0;

		while (x != 0) {
			x = (byte) (x & (x - 1));
			total++;
		}

		return total == 1 ? 1 : 0;
	}
}
