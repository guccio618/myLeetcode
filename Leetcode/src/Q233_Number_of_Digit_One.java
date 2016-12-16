
public class Q233_Number_of_Digit_One {
	public int countDigitOne(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        long base = 1, res = 0, last = 0;
        while(n >= base){
            long index = ((long) n / base) % 10;
            long remain = n - (n / base) * base;
            if(index > 1){
                res = res + index * last + base;
            }else if(index == 1){
                res = res + index * last + remain + 1;
            }else{
                res = res + index * last;
            }
            last = last * 10 + base;
            base = base * 10;
            System.out.println(last + ", " + base);
        }
        return (int)res;
	}
	
	public int countDigitOne_1(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        int count = 0;
        int cur_bit = 0;
        long high_bits = 0;
        long low_bits = 0;
        long factor = 1;
        
        while(n / factor != 0){
        	high_bits = n / (factor * 10);
        	low_bits = n - (n / factor) * factor;
        	cur_bit = (int)(n / factor - high_bits * 10);
        	
        	if(cur_bit < 1)
        		count += (int) (high_bits) * factor;
        	else if(cur_bit == 1)
        		count += (int) (high_bits *factor + low_bits + 1);
        	else
        		count += (int) (high_bits + 1) * factor;
        	factor *= 10;
        }
        return count;
	}
	
	public static void main(String[] args){
		Q233_Number_of_Digit_One n = new Q233_Number_of_Digit_One();
		System.out.println(n.countDigitOne_1(13));
	}
}
