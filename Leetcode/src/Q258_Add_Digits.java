
public class Q258_Add_Digits {
	/********************************/
	// by Jackie
	public int addDigits(int num) {
		while (num >= 10) {
			num = num / 10 + num % 10;
		}
		return num;
	}
	
	
		
	/********************************/
	// by other
	public int addDigits2(int num) {
		return (num-1) % 9 + 1;
	}
	
	
	
	/********************************/
	// by Jackie
	public int addDigits3(int num) {
        while(num >= 10){
            num = num / 10 + num % 10;
        }
        return num;
    }
	
	
	
	/********************************/
	// by Jackie
		public int addDigits4(int num) {
	        if(num / 10 == 0){
	            return num;
	        }
	        
	        int sum = 0;
	        
	        do{
	        	sum = 0;
	            while(num > 0){
	                sum += num % 10;
	                num /= 10;
	            }
	            num = sum;
	        } while(sum / 10 > 0);
	        
	        return sum;
	    }
	
		
		
	/***************** main function ***************/	
		
	public static void main(String[] args){
		Q258_Add_Digits t = new Q258_Add_Digits();
		System.out.println(t.addDigits(38));
	}
}
