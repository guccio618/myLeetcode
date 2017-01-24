public class Q029_Divide_Two_Integers {	
	// by other
	public int divide(int dividend, int divisor) {
		if (dividend == Integer.MIN_VALUE && divisor == -1){
			return Integer.MAX_VALUE;
		}

		long divd = Math.abs((long) dividend);
		long divs = Math.abs((long) divisor);

		int ret = 0;
		while (divd >= divs) {
			int counter = 0;
			
			while (divd >= (divs << counter)) { // keep multiply by 2 until divs > divd
				counter++;
			}
			
			counter--;                // rollback counter so that (divs<<counter) <= divd
			ret += 1 << counter;      // quotient
			divd -= divs << counter;
		}

		if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)){
			return ret;
		} else{
			return -ret;
		}
	}
	
	
	
	// by Jackie
		public int divide2(int dividend, int divisor) {
	        if(dividend == 0){
	            return 0;
	        } else if(divisor == 0){
	            return Integer.MAX_VALUE;
	        } else if(divisor == 1){
	        	return dividend;
	        } else if (dividend == Integer.MIN_VALUE && divisor == -1){
				return Integer.MAX_VALUE;
			}
	        
	        long new_dividend = Math.abs((long) dividend);
	        long new_divisor = Math.abs((long) divisor);
	        int flag = 1;
	        
	        if(dividend < 0 || divisor < 0){
	            if((long) dividend * divisor < 0){
	                flag = -1;
	            }
	        }
	        
	        if(new_dividend < new_divisor){
	            return 0;
	        } else if(new_dividend == new_divisor){
	            return flag;
	        }
	        
	        long count = 1;
	        long tempNum = new_divisor;
	        long ans = 0;
	        
	        while(tempNum < new_dividend){
	        	count <<= 1;
	            tempNum <<= 1;
	        }
	        
	        long left = count / 2, right = count;
	        while(left + 1 < right){
	            long mid = left + (right - left) / 2;
	            long product = mid * new_divisor;
	            if(product < new_dividend){
	                left = mid;
	            } else if(product > new_dividend){
	                right = mid;
	            } else {
	            	ans = mid;
	            	break;
	            }
	        }
	        
	        if(right * new_divisor <= new_dividend){
	        	ans = right;
	        } else {
	        	ans = left;
	        }
	        
	        ans = ans * flag;
	    	if(ans > Integer.MAX_VALUE){
	    		return Integer.MAX_VALUE;
	    	} else if(ans < Integer.MIN_VALUE) {
	    		return Integer.MIN_VALUE;
	    	} else {
	    		return (int) ans;
	    	}
		}
		
		
		

	public static void main(String[] args) {
		Q029_Divide_Two_Integers t = new Q029_Divide_Two_Integers();
		System.out.println(t.divide(-2147483648, -1));
//		System.out.println(t.divide(-1010369383, -2147483648));
	}
}
