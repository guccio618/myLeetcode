import java.util.ArrayList;


public class Q007_Reverse_Integer {
	public int reverse(int x) {
        int flag = x > 0 ? 1 : -1;
        x = Math.abs(x);
        long sum = 0;
        
        while(x > 0){
            int digit = x % 10;
            x /= 10;
            sum = sum * 10 + digit;
        }
        
        sum *= flag;
        
        if(sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE){
            return 0;
        } else {
            return (int) sum;
        }
    }
	
	
	
	/*****************************************************/
	// by Jackie, test cast: -2147483648	
	public int reverse2(int x) {
        if(x == 0){
            return x;
        }
        long num = x;   // 必须用一个long先把x转化为long型，防止转化过程中溢出
        boolean negativeFlag = false;
        if(num < 0){
            negativeFlag = true;
            num = -num;
        } 
        
        String str = Long.toString(num);
        char[] array = str.toCharArray();
        
        int left = 0, right = array.length - 1;
        while(left < right){
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
        
        String newStr = new String(array);
        long sum = Long.parseLong(newStr);

        if(sum > Integer.MAX_VALUE){
            return 0;
        }
        if(negativeFlag == true){
            return -(int) sum;
        } else {
            return (int) sum;
        }
	}
        
	
	
	
        
    /*****************************************************/
    // by Jackie, test cast: -2147483648	
	public int reverse3(int x) {
        if(x > -10 && x < 10) return x;
        if(x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE) return 0;
        int negative_flag = 1;
        if(x < 0) {
            negative_flag = -1;
            x = -x;
        }
        long sum = x % 10;
        x /= 10; 
        System.out.println("sum = " + sum + ", x = " + x);
        while(x > 0){
            sum = sum * 10 + x % 10;
            if(sum >= Integer.MAX_VALUE)
            	return 0;
            x /= 10;
            System.out.println("1: sum = " + sum + ", x = " + x);
        }
        System.out.println("2: sum = " + sum + ", x = " + x);
        
        return (int)(sum *= negative_flag);
    }

	
	
	
	public static void main(String[] args){
		Q007_Reverse_Integer test = new Q007_Reverse_Integer();
		System.out.println(test.reverse2(-2147483648));
//		System.out.println(test.reverse2(1534236469));
	}
}
