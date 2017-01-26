
public class Other_10_to_2 {
	// num is negative
	public String tranfer(int num) throws Exception{
		if(num <= 0) {
			return "";
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(num > 0) {
			int digit = num % 2;
			num /= 2;
			sb.insert(0, digit);
		}
		
		return sb.toString();
	}
	
//	class myException extends Exception {
//		public myException(String str) {
//			super(str);
//		}
//	}
	
	public static void main(String[] args) throws Exception {
		Other_10_to_2 t = new Other_10_to_2();		
		System.out.println(t.tranfer(10));
	}
}
