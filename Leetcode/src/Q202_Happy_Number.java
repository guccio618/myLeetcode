import java.util.HashSet;
import java.util.Set;


public class Q202_Happy_Number {
	/******************************************************/
	// by other, faster
	public boolean isHappy(int n) {
        int[] map = new int[1000];
        while(n != 1) {
            n = getSum(n);
            map[n]++;
            if (map[n] > 1)
                return false;
        }
        return true;
    }

    public int getSum(int num) {
        char[] temp = (num + "").toCharArray();
        int sum = 0;
        for (int i = 0; i < temp.length; i++) {
            sum += ((temp[i] - '0') * (temp[i] - '0'));
        }
        return sum;
    }
    
    
    
    /******************************************************/
	// by Jackie     
    public boolean isHappy2(int n) {
        if(n <= 0){
            return false;
        }
        
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(n);
        
        while(n != 1){
            int sum = 0;
            int a = 0;
            while(n > 0){
                a = n % 10;
                sum += a * a;
                n /= 10;
            }
            
            if(set.contains(sum)){
                return false;
            }
            
            set.add(sum);
            n = sum;
        }
        
        return true;
    }
    
    
    
    /******************************************************/
	// by Jackie 
    public boolean isHappy3(int n) {
        if(n == 0){
            return false;
        } 
        
        n = Math.abs(n);
        Set<Integer> visited = new HashSet<Integer>();
        visited.add(n);
        
        while(n != 1){
            int num = getNextInteger(n);
            
            if(num == -1){
            	System.out.println("1");
                return false;
            } else if(visited.contains(num)){
            	System.out.println("2: " + num);
                return false;
            } else {
                n = num;
                visited.add(num);
            }
        }
        
        return true;
    }
    
    public int getNextInteger(int n){
        long sum = 0;
        
        while(n > 0){
            int digit = n % 10;
            n /= 10;
            sum += digit * digit;
            
            if(sum > Integer.MAX_VALUE){
                return -1;
            }
        }
        
        return (int) sum;
    }
    
    
    public static void main(String[] args){
    	Q202_Happy_Number t = new Q202_Happy_Number();
    	System.out.println(t.isHappy3(7));
    }
}
