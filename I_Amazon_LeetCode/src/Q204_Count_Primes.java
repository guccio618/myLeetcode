/******
 * 
Description:

Count the number of prime numbers less than a non-negative number, n.
 * 
 * */

public class Q204_Count_Primes {
	public int countPrimes(int n) {
        if(n <= 2){
            return 0;
        }
        
        boolean[] flag = new boolean[n + 1];
        double len = Math.sqrt(n);
        int count = 1;
        
        for(int i = 3; i <= len; i += 2){
            for(int j = i * i; j < n; j += i << 1){
                flag[j] = true;
            }
        }
        
        for(int i = 3; i < n; i += 2){
            if(flag[i] == false){
                count++;
            }
        }
        
        return count;
    }
}
