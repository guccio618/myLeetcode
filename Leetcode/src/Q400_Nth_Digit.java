
public class Q400_Nth_Digit {
	public int findNthDigit(int n) {
		if(n < 10){
			return n;
		}
		
        long base = 9;
        int bit = 1;
        int range = 1;
        
        while(n > base * bit){
        	n -= base * bit;
        	base *= 10;
        	bit++;
        	range *= 10;
        }
        
        int curNum = range + (n - 1) / bit;
        int index =  (n - 1) % bit;
        char[] letters = Integer.toString(curNum).toCharArray();
        return letters[index] - '0';
    }
	
	
	public static void main(String[] args){
		Q400_Nth_Digit t = new Q400_Nth_Digit();
		System.out.println(t.findNthDigit(2147483647));
	}
	
	
	// 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23
}
